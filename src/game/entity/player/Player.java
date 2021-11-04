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
	
	protected Direction movementDirection;
	protected Direction attemptingMovement;
	protected static Player instance;
	
	private Zone previousZone;								//Zona por al que acaba de pasear, util para move()
	
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
		graphic = new GraphicCharacter(this, zone.getLabyrinth().getImageFactory().getPlayerImages());
	}
	
	
	// FIXME sigue siendo alta (8) -AF  
	// Actualizado nuevamente el metodo, la funcionalidad sigue estado igual hasta donde testee -NF
	
	/**
	 * Mueve el personaje hacia una direccion
	 */
	public synchronized void move() {
		if (canChangeDirection()) {
			changeDirection();
		}
		if (comingBack() || zone.getAdjacent(movementDirection).getType() == ZoneType.PATH) {
			updateCoords();
			if (isInZoneCenter()) {
				changeZones();
			}
		}
	}
	
	/**
	 * Cambia zonas dependiendo si esta volviendo a donde estaba o quiere ir a otra zona
	 */
	private void changeZones() {
		if (previousZone == zone) {																					//No cambia su zona si estaba volviendo
			previousZone = null;																							
		} else {
			setNewZone(zone.getAdjacent(movementDirection));														// Cambia su zona si no estaba volviendo
		}
	}
	
	/**
	 * Consulta si esta volviendo el personaje
	 * @return True si esta regresando a su zona, false sino
	 */
	private boolean comingBack() {
		return (zone == previousZone);
	}
	
	/**
	 * Evalua si el personaje esta en posicion de poder cambiar de direccion
	 * @return True si se puede, false sino
	 */
	private boolean canChangeDirection() {
		boolean toReturn = false;
		if (attemptingMovement != movementDirection && attemptingMovement!= null) {									// Evalua si quiere cambiarse de direccion
			if (isInZoneCenter() && zone.getAdjacent(attemptingMovement).getType() == ZoneType.PATH) {				// Puede en una interseccion
				toReturn = true;
			} else {
				if ((attemptingMovement == movementDirection.getOpposite())) {										// Puede volver donde estaba
					toReturn = true;
					previousZone = (previousZone == null) ? zone : null;
				}
			}
		}
		return toReturn;
	}
	
	/**
	 * Cambia la direccion del personaje
	 */
	private void changeDirection() {
		movementDirection = attemptingMovement;
		attemptingMovement = null;
		updateMovementDirection();
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
				y -= MOVEMENT_LENGTH;
				break;
			case RIGHT:
				x += MOVEMENT_LENGTH;
				break;
			case DOWN:
				y += MOVEMENT_LENGTH;
				break;
			case LEFT:
				x -= MOVEMENT_LENGTH;
				break;
		}
		x = Math.round(x * 10f) / 10f;
		y = Math.round(y * 10f) / 10f;
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
			//TODO medir colision en nueva zona
			collide();
		}
	}
	
	/**
	 * Evalua si el personaje se encuentra en el centro de una zona
	 * @return true si esta en el centro, false sino
	 */
	private boolean isInZoneCenter () {
		return (x == (int) x && y == (int) y);							//Si los numeros son enteros esta en el centro de una zona
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
