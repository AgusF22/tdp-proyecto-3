package game.entity.player;

import game.labyrinth.Direction;
import game.labyrinth.Zone;
import game.labyrinth.ZoneType;
import exceptions.InvalidZoneException;
import game.Game;
import game.entity.Entity;
import game.entity.Character;
import game.entity.GraphicPlayer;
import game.entity.timedentity.Bomb;
import game.entity.visitor.PlayerVisitor;
import game.entity.visitor.Visitor;

/**
 * Clase que modela al jugador.
 */
public final class Player extends Character{
				
	private static final int MAX_BOMBS = 2;
	private static final int DEFAULT_BOMBS = 1;
	private static final int DEFAULT_LIVES = 3;
	
	protected static Player instance;
	
	protected Direction attemptingMovement;
	protected int attemptedMoveTimer;
	
	protected boolean hasShield;
	protected int shieldEffectTimer;
	protected int bombs;
	protected int lives;
	
	/**
	 * Crea una nueva instancia de Player.
	 */
	private Player() {
		super(null, 0.1f);
		attemptingMovement = null;
		hasShield = false;
		shieldEffectTimer = 0;
		bombs = DEFAULT_BOMBS;
		lives = DEFAULT_LIVES;
	}
	
	/**
	 * Retorna la instancia de player.
	 * @return La instancia de player.
	 */
	public static Player getInstance() {
		if(instance == null) 						//Si no se creo una instancia, la crea
			instance = new Player();
		return instance;
	}
	
	/**
	 * Setea la zona donde se encuentra el jugador.
	 * @param zone Nueva zona a setear.
	 */
	public void setZone(Zone zone) throws InvalidZoneException {
		if (zone == null) {
			throw new InvalidZoneException("Intenta setear una zona nula en player");
		}
		this.zone = zone;
		zone.addEntity(this);
		x = zone.getX();
		y = zone.getY();
		graphic = new GraphicPlayer(this, getLabyrinth().getImageFactory().getPlayerImages());
		addToGUI();
		zone.getLabyrinth().getGUI().updateLives(lives);
		zone.getLabyrinth().getGUI().updateBombs(bombs);
	}
	
	/**
	 * Colisiona al jugador con todas las entidades que se encuentran en su zona.
	 */
	public void collide() {
		Visitor v = new PlayerVisitor();
		for (Entity e : zone.zoneEntities()) {
			e.accept(v);						
		}
	}
	
	@Override
	public void respawn() {
		Zone spawn = getLabyrinth().getPlayerSpawn();
		setCoordinates(spawn.getX(), spawn.getY());
		movementDirection = Direction.LEFT;
		graphic.updateImage();
		resetEffects();
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	@Override
	public void move() {
		updateAttemptedMovement();
		updateEffects();
		if (attemptingMovement == movementDirection.getOpposite()) {		//Siempre puede cambiar a su direccino opuesta
			movementDirection = attemptingMovement;
			graphic.updateImage();	
		}
		move(speedMultiplier * movementSpeed);				
		collide();
	}
	
	@Override
	public void move(float n) {
		float d = nextCenterDistance();
		boolean canMove = true;
		if (n < 0) {
			n = 0;
		}
		if (d == 1) {				//Si se encuentra a distancia 1 entonces esta en un centro, puede intentar cambiar de direccion
			updateMovementDirection();
			canMove = canMove();
		}
		if (canMove) {				
			if (d >= n) {			//Si esta a una distancia menor al centro se mueve a esa distancia
				updateLocation(n);
			} else {
				updateLocation(d);	//Si se quiere mover a una distancia mayor al proximo centro , se mueve al proximo centro
				move(n - d);
			}
		}
	}
	
	@Override
	protected void updateMovementDirection() {
		if (attemptingMovement != null && zone.getAdjacent(attemptingMovement).getType() == ZoneType.PATH) {	//Evaluamos si tiene sentido un cambio de direccion
			movementDirection = attemptingMovement;
			graphic.updateImage();
		}
	}
	
	@Override
	protected boolean canMove() {
		return zone.getAdjacent(movementDirection).getType() == ZoneType.PATH;
	}

	/**
	 * Avisa al jugador que debe intentar moverse en la direccion dada.
	 * @param dir Direccion en la cual el jugador intentara moverse.
	 */
	public void attemptMovement(Direction dir) {
		attemptingMovement = dir;
		attemptedMoveTimer = Game.CYCLES_PER_SECOND;
	}
	
	/**
	 * Le avisa al jugador que deje una bomba.
	 */
	public void placeBomb() {
		if (bombs > 0) {
			new Bomb(zone);
			setBombs(--bombs);
		}
	}
	
	/**
	 * Actualiza el tiempo durante el cual el jugador intentara moverse en la ultima direccion dada.
	 * Cuando el tiempo llega a 0, el jugador deja de intentar cambiar su direccion.
	 */
	protected void updateAttemptedMovement() {
		if (attemptingMovement != null) {
			--attemptedMoveTimer;
			if (attemptedMoveTimer <= 0) {
				attemptingMovement = null;
			}
		}
	}
	
	@Override
	protected void updateEffects() {
		super.updateEffects();
		if (shieldEffectTimer != 0) {
			--shieldEffectTimer;
			if (shieldEffectTimer <= 0) {
				removeShield();
			}
		}
	}
	
	/**
	 * Añade un efecto de escudo al jugador.
	 */
	public void addShield() {
		hasShield = true;
		shieldEffectTimer = 5 * Game.CYCLES_PER_SECOND;
		graphic.setShieldEffect(true);
	}
	
	/**
	 * Remueve el escudo de este jugador.
	 */
	protected void removeShield() {
		shieldEffectTimer = 0;
		hasShield = false;
		graphic.setShieldEffect(false);
	}
	
	/**
	 * Avisa al jugador que su escudo fue usado, reduciendo el tiempo restante del escudo a un valor minimo.
	 */
	public void useShield() {
		if (hasShield) {
			shieldEffectTimer = Math.round(0.5f * Game.CYCLES_PER_SECOND);
		}
	}
	
	/**
	 * Consulta si el personaje tiene escudo.
	 * @return True si tiene, false si no.
	 */
	public boolean hasShield() {
		return hasShield;
	} 
	
	/**
	 * Agrega una bomba al jugador.
	 */
	public void addBomb() {
		if (bombs < MAX_BOMBS) {
			setBombs(++bombs);
		}
	}
	
	/**
	 * Retorna las vidas actuales del jugador.
	 * @return Las vidas del jugador.
	 */
	public int getLives() {
		return lives;
	}
	
	/**
	 * Resta el valor pasado como parametro a las vidas actuales del jugador.
	 * @param n Cantidad de vidas a restar.
	 */
	public void reduceLives(int n) {
		setLives(lives - n);
	}
	
	/**
	 * Establece el personaje en su estado inicial.
	 */
	public void resetState() {
		setBombs(DEFAULT_BOMBS);
		setLives(DEFAULT_LIVES);
		resetEffects();
	}
	
	/**
	 * Remueve los efectos del Jugador.
	 */
	public void resetEffects() {
		removeShield();
		removeSpeedMultiplier();
	}

	/**
	 * Setea un nuevo valor a las bombas y notifica su actualizacion a la gui.
	 * @param b La nueva cantidad de bombas.
	 */
	private void setBombs(int b) {
		bombs = b;
		getLabyrinth().getGUI().updateBombs(bombs);
	}
	
	/**
	 * Setea un nuevo valor a las vidas y notifica su actualizacion a la gui.
	 * @param l La nueva cantidad de vidas.
	 */
	private void setLives(int l) {
		lives = l;
		getLabyrinth().getGUI().updateLives(lives);
	}
	
}
