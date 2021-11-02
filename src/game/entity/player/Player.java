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
	}
	
	
	// FIXME REVISAR!!! complejidad ciclomatica MUY alta, dividir en metodos auxiliares -AF 
	/**
	 * Mueve el personaje hacia una direccion
	 */
	public void move() {
		if (attemptingMovement != movementDirection && attemptingMovement != null) {											// Chequeamos que se intenta mover a otro lado
			if (attemptingMovement == oppositeDirection(movementDirection)) {													// Si se quiere mover en la posicion contraria se puede en cualquier caso
				movementDirection = attemptingMovement;							//TODO ?Deberia tambien setear attempt en nulo		
			}
			else if (isWhole(x) && isWhole(y)){																					// Si se quiere mover a otra posicion necesita esta en el centro de una zona
				switch (attemptingMovement) {														
				case UP:
					if (zone.getLabyrinth().getZone(x, y + DISTANCE_ZONE).getType() == ZoneType.PATH) {
						movementDirection = attemptingMovement;
						attemptingMovement = null;
					}
					break;
				case RIGHT:
					if (zone.getLabyrinth().getZone(x + DISTANCE_ZONE, y).getType() == ZoneType.PATH) {
						movementDirection = attemptingMovement;
						attemptingMovement = null;
					}
					break;
				case DOWN:
					if (zone.getLabyrinth().getZone(x, y - DISTANCE_ZONE).getType() == ZoneType.PATH) {
						movementDirection = attemptingMovement;
						attemptingMovement = null;
					}
					break;
				case LEFT:
					if (zone.getLabyrinth().getZone(x - DISTANCE_ZONE, y).getType() == ZoneType.PATH) {
						movementDirection = attemptingMovement;
						attemptingMovement = null;
					}
					break;
				}
			}
		}
		
		switch (movementDirection) { //TODO revisar como pide las zonas porque hay error al pasar la mitad, puede cambiarse el redondeo por truncamiento
		case UP:
			if (zone.getLabyrinth().getZone(x, y + DISTANCE_ZONE).getType() == ZoneType.PATH) {										// Solo se puede mover a caminos
				((GraphicCharacter) graphic).setMovingUp();
				y += MOVEMENT_LENGTH;
				graphic.update(x,y);																					// Actualizamos la grafica
				if (isWhole(y)) {																						// Si la posicion luego de moverse es entera entonces se encuentra en el centro de una nueva zona.
					zone.getLabyrinth().getZone(x, y + (DISTANCE_ZONE - MOVEMENT_LENGTH)).addEntity(this);							// Se agrega a la zona que sigue
					zone.removeEntity(this);																			// Se remueve de la que estaba
					zone.getLabyrinth().getZone(x, y + (DISTANCE_ZONE - MOVEMENT_LENGTH));									// Cambia en que zona se encuentra
				}	
				//TODO medir colision en la nueva zona
			}
			break;
		case RIGHT:
			if (zone.getLabyrinth().getZone(x + DISTANCE_ZONE, y).getType() == ZoneType.PATH) {
				((GraphicCharacter) graphic).setMovingRight();
				x += MOVEMENT_LENGTH;
				graphic.update(x,y);
				if (isWhole(x)) {
					zone.getLabyrinth().getZone(x + (DISTANCE_ZONE - MOVEMENT_LENGTH), y).addEntity(this);
					zone.removeEntity(this);
					zone.getLabyrinth().getZone(x + (DISTANCE_ZONE - MOVEMENT_LENGTH), y);
				}	
				//TODO medir colision en la nueva zona
			}
			break;
		case DOWN:
			if (zone.getLabyrinth().getZone(x, y - DISTANCE_ZONE).getType() == ZoneType.PATH) {
				((GraphicCharacter) graphic).setMovingDown();
				y -= MOVEMENT_LENGTH;
				graphic.update(x,y);
				if (isWhole(y)) {
					zone.getLabyrinth().getZone(x, y - (DISTANCE_ZONE - MOVEMENT_LENGTH)).addEntity(this);
					zone.removeEntity(this);
					zone.getLabyrinth().getZone(x, y - (DISTANCE_ZONE - MOVEMENT_LENGTH));
				}			
				//TODO medir colision en la nueva zona
			}
			break;
		case LEFT:
			if (zone.getLabyrinth().getZone(x - DISTANCE_ZONE, y).getType() == ZoneType.PATH) {
				((GraphicCharacter) graphic).setMovingLeft();
				x -= MOVEMENT_LENGTH;
				graphic.update(x,y);
				if (isWhole(x)) {
					zone.getLabyrinth().getZone(x - (DISTANCE_ZONE - MOVEMENT_LENGTH), y).addEntity(this);
					zone.removeEntity(this);
					zone.getLabyrinth().getZone(x - (DISTANCE_ZONE - MOVEMENT_LENGTH), y);
				}	
				//TODO medir colision en la nueva zona
			}
		}
		
	}
	
	/**
	 * Chequea si el numero pasado por parametro es entero
	 * @param x Float 
	 * @return True si es entero , false sino.
	 */
	private boolean isWhole (float x) {
		return (x == Math.round(x));
	}
	
	private Direction oppositeDirection(Direction dir) {
		Direction opposite = null;
		switch (dir) {
		case UP:
			opposite = Direction.DOWN;
			break;
		case RIGHT:
			opposite = Direction.LEFT;
			break;
		case DOWN:
			opposite = Direction.UP;
			break;
		case LEFT:
			opposite = Direction.RIGHT;
			break;
		}
		
		return opposite;
	}
	
	/**
	 * Evalua si el jugador puede moverse en la direccion pasada, si puede se la asigna
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
