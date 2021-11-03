package game.entity.player;

import game.labyrinth.Zone;
import game.labyrinth.ZoneType;
import game.Direction;
import game.entity.Entity;
import game.entity.GraphicCharacter;
import game.entity.visitor.PlayerVisitor;
import game.entity.visitor.Visitor;

public class Player extends Entity{
	
	private static final float MOVEMENT_LENGTH = 0.1f;		// Distancia que puede recorrer el personaje en un movimiento
	private static final float DISTANCE_ZONE = 0.5f;		// Distancia hasta la proxima zona
	
	protected Direction movementDirection;
	protected Direction attemptingMovement;
	protected static Player instance;
	
	/**
	 * Crea una nueva instancia de Player.
	 */
	private Player() {
		super(null);
		movementDirection = Direction.LEFT;
		attemptingMovement = null;
	}
	
	/**
	 * Retorna la intancia de player.
	 * @return La intancia de player.
	 */
	public static Player getInstance() {
		if(instance == null) 
			instance = new Player();
		return instance;
	}
	
	/**
	 * Setea la zona donde se encuentra el jugador
	 * @param zone Zone
	 */
	public void setZone(Zone zone) {
		this.zone = zone;
		this.setCoordinates(zone.getX(), zone.getY());
		setGraphic();
	}
	
	/**
	 * Crea y asigna la entidad grafica del personaje
	 */
	private void setGraphic() {
		graphic = new GraphicCharacter(zone.getLabyrinth().getImageFactory().getPlayerImages());
		((GraphicCharacter) graphic).setMovingLeft();
	}
	
	
	// separe en submetodos , solo se quedo evaluar si se peude cambiar la direccion y moverse a de posicion -NF
	// FIXME sigue siendo alta (8) -AF
	
	/**
	 * Mueve el personaje hacia una direccion
	 */
	public void move() {
		//Intento de cambio de direccion
		if (attemptingMovement != movementDirection && attemptingMovement != null) {										// Chequeamos que se intenta mover a otro lado
			if (attemptingMovement == movementDirection.getOpposite()) {													// Si se quiere mover en la posicion contraria se puede en cualquier caso
				movementDirection = attemptingMovement;																		//TODO ?Deberia tambien setear attempt en nulo		
			}
			else if (isInZoneCenter() && zone.getAdjacent(attemptingMovement).getType() == ZoneType.PATH){					// Si quiere cambiar a una direccion perpendicular a la actual debe haber camino donde se quiere mover y estar en el centro de una zona
				movementDirection = attemptingMovement;
				updateMovementDirection();																					// Cambiamos la direccion de la grafica
				attemptingMovement = null;			
			}
		}	
		
		//Moverse en la direccion asignada
		if (zone.getAdjacent(movementDirection).getType() == ZoneType.PATH) {												// Solo se puede mover hacia un camino
			updateCoords();																									// Actualizamos la grafica al moverse
			if (isInZoneCenter()) {																							// Si esta en el centro al terminar de moverse
				setNewZone(zone.getAdjacent(movementDirection));
				//TODO medir colision en nueva zona
			}
		}
		
	}
	
	/**
	 * Actualiza la direccion de movimiento de la grafica
	 */
	private void updateMovementDirection() {
		switch (movementDirection){
		case UP:
			((GraphicCharacter) graphic).setMovingUp();
			break;
		case RIGHT:
			((GraphicCharacter) graphic).setMovingRight();
			break;
		case DOWN:
			((GraphicCharacter) graphic).setMovingDown();
			break;
		case LEFT:
			((GraphicCharacter) graphic).setMovingLeft();
			break;
		}
	}
	
	/**
	 * Actualiza las coordeandas del persona y de la grafica dependiendo de la direccion actual
	 */
	private void updateCoords() {
		switch (movementDirection){
			case UP:
				y += MOVEMENT_LENGTH;
				break;
			case RIGHT:
				x += MOVEMENT_LENGTH;
				break;
			case DOWN:
				y -= MOVEMENT_LENGTH;
				break;
			case LEFT:
				x -= MOVEMENT_LENGTH;
				break;
		}
		graphic.update(x,y);
	}
	
	/**
	 * Setea al player en una nueva zona
	 * 
	 * @param newZone Zone
	 */
	private void setNewZone(Zone newZone) {
		if (newZone != null) {
			zone.removeEntity(this);
			zone = newZone;
			zone.addEntity(this);
		}
	}
	
	/**
	 * Evalua si el personaje se encuentra en el centro de una zona
	 * @return true si esta en el centro, false sino
	 */
	private boolean isInZoneCenter () {
		return (x == Math.round(x) && y == Math.round(y));							//Si los numeros son enteros esta en el centro de una zona
	}
	
	
	/**
	 * Asigna una nueva direccion a la que intentar mover al jguador
	 * 
	 * @param dir Direction 
	 */
	public void attemptMovement(Direction dir) {
		attemptingMovement = dir;
	}
	
	/**
	 * Colisiona al jugador con todas las entidades que se encuantran en su zona.
	 */
	public void collide() {
		Visitor v = new PlayerVisitor();
		for (Entity e : zone.zoneEntities()) {
			e.accept(v);								// TODO cambiar condicion de colision a distancia (y actualizar javadoc posteriormente) -AF
		}
	}
	
	/**
	 * Acepta un visitor.
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
