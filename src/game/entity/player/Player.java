package game.entity.player;

import game.labyrinth.Direction;
import game.labyrinth.Zone;
import game.labyrinth.ZoneType;
import exceptions.NullZoneException;
import game.Game;
import game.entity.Entity;
import game.entity.Character;
import game.entity.GraphicPlayer;
import game.entity.visitor.PlayerVisitor;
import game.entity.visitor.Visitor;

/**
 * Clase que modela al jugador.
 */
public final class Player extends Character{
				
	private static final int MAX_BOMBS = 2;

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
	}
	
	/**
	 * Retorna la instancia de player.
	 * @return La instancia de player.
	 */
	public static Player getInstance() {
		if(instance == null) 			//Si no se creo una instancia , la crea
			instance = new Player();
		return instance;
	}
	
	/**
	 * Setea la zona donde se encuentra el jugador.
	 * @param zone Nueva zona a setear.
	 */
	public void setZone(Zone zone) throws NullZoneException{
		if (zone == null) {
			throw new NullZoneException("Intenta setear una zona nula en player");
		}
		this.zone = zone;
		zone.addEntity(this);
		x = zone.getX();
		y = zone.getY();
		setGraphic();
	}
	
	/**
	 * Crea y asigna la entidad grafica de este jugador.
	 */
	private void setGraphic() {
		graphic = new GraphicPlayer(this, zone.getLabyrinth().getImageFactory().getPlayerImages());
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
	 * Actualiza el tiempo durante el cual el jugador intentara moverse en la ultima direccion dada.
	 * Cuando el tiempo llega a 0, el jugador deja de intentar cambiar su direccion.
	 */
	protected void updateAttemptedMovement() {
		if (attemptingMovement != null) {
			--attemptedMoveTimer;
			if (attemptedMoveTimer == 0) {
				attemptingMovement = null;
			}
		}
	}
	
	@Override
	protected void updateEffects() {
		super.updateEffects();
		if (shieldEffectTimer != 0) {
			--shieldEffectTimer;
			if (shieldEffectTimer == 0) {
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
	 * Le avisa al jugador que deje una bomba.
	 */
	public void placeBomb() {
		//TODO set bombs
	}
	
	/**
	 * Agrega una bomba al jugador.
	 */
	public void addBomb() {
		if (bombs < MAX_BOMBS) {
			bombs++;
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
		lives += n;
	}
	
}
