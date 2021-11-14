package game.entity.player;

import game.labyrinth.Zone;
import game.labyrinth.ZoneType;
import exceptions.NullZoneException;
import game.Direction;
import game.entity.Entity;
import game.entity.Character;
import game.entity.GraphicCharacter;
import game.entity.visitor.PlayerVisitor;
import game.entity.visitor.Visitor;

public final class Player extends Character{
	
	protected Direction attemptingMovement;					
	protected static Player instance;
	protected boolean hasShield;
	
	/**
	 * Crea una nueva instancia de Player.
	 */
	private Player() {
		super(null, 0.1f);
		attemptingMovement = null;
		hasShield = false;
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
	 * Setea la zona donde se encuentra el jugador
	 * @param zone Nueva zona a setear
	 */
	public void setZone(Zone zone) throws NullZoneException{
		if (zone == null) {
			throw new NullZoneException("Intenta setear una zona nula en player");
		}
		this.zone = zone;
		zone.addEntity(this);
		zone.update();
		x = zone.getX();
		y = zone.getY();
		setGraphic();
	}
	
	/**
	 * Crea y asigna la entidad grafica del personaje
	 */
	private void setGraphic() {
		graphic = new GraphicCharacter(this, zone.getLabyrinth().getImageFactory().getPlayerImages());
	}
	
	/**
	 * Intena mover al personaje por cada invocacion
	 */
	public void move() {
		if (attemptingMovement == movementDirection.getOpposite()) {		//Siempre puede cambiar a su direccino opuesta
			movementDirection = attemptingMovement;
			graphic.updateImage();	
		}
		move(speedMultiplier * movementSpeed);				
		collide();
	}
	
	/**
	 * Mueve al jugador las unidades pasadas por parametro en una direccion
	 * @param n Float unidades a mover
	 */
	protected void move(float n) {
		
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
	
	/**
	 * Evalua y actualiza la direccion del personaje
	 */
	protected void updateMovementDirection() {
		if (attemptingMovement != null && zone.getAdjacent(attemptingMovement).getType() == ZoneType.PATH) {	//Evaluamos si tiene sentido un cambio de direccion
			movementDirection = attemptingMovement;
			graphic.updateImage();
		}
	}
	
	/**
	 * Consulta cuando esta en el centro de una zona si puede moverse
	 * @return True si puede, false sino
	 */
	protected boolean canMove() {
		return zone.getAdjacent(movementDirection).getType() == ZoneType.PATH;
	}

	/**
	 * Asigna una nueva direccion a la que intentar moverse
	 * 
	 * @param dir Direccion a intentar moverse
	 */
	public void attemptMovement(Direction dir) {
		attemptingMovement = dir;
	}
	
	/**
	 * Colisiona al jugador con todas las entidades que se encuentran en su zona.
	 */
	public void collide() {
		Visitor v = new PlayerVisitor();
		for (Entity e : zone.zoneEntities()) {
			e.accept(v);						
		}
		zone.update();
	}
	
	/**
	 * Acepta un visitor.
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	/**
	 * Setea el estado de escudo segundo lo pasado por parametro
	 * @param shield Boolean , true si tiene escudo, false sino
	 */
	public void setShield(boolean shield) {
		hasShield = shield;
	}
	
	/**
	 * Consulta si el personaje tiene escudo
	 * @return True si tiene, no sino tiene
	 */
	public boolean hasShield() {
		return hasShield;
	} 
}
