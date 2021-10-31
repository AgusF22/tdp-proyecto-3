package game.entity.player;

import game.labyrinth.Zone;
import game.labyrinth.ZoneType;
import game.entity.Entity;
import game.entity.GraphicCharacter;
import game.entity.Visitor;

public class Player extends Entity{
	protected Direction movementDirection;
	protected static Player instance;
	
	private Player() {
		super();
		movementDirection = Direction.LEFT;
	}
	
	public static Player getInstance() {
		if(instance == null) 
			instance = new Player();
		return instance;
	}
	
	public void move() {
		//TODO imp
		switch (movementDirection) {
		case UP:
			if (zone.getZone(x, y + 1).getType() == ZoneType.PATH) {
				((GraphicCharacter) graphic).setMovingUp();
				while (y < y + 1) {						// Aumentamos progresivamente la posiciones hasta llegar a la parte entera
					y += 0.1f;
					graphic.update(x,y);				// Actualizamos la grafica
				}
				zone = zone.getZone(x,y);				
				//TODO medir colision en la nueva zona
			}
			break;
		case RIGHT:
			if (zone.getZone(x + 1, y).getType() == ZoneType.PATH) {
				((GraphicCharacter) graphic).setMovingRight();
				while (y < y + 1) {
					y += 0.1f;
					graphic.update(x,y);
				}
				zone = zone.getZone(x,y);					
				//TODO medir colision en la nueva zona
			}
			break;
		case DOWN:
			if (zone.getZone(x, y - 1).getType() == ZoneType.PATH) {	
				((GraphicCharacter) graphic).setMovingDown();
				while (y < y + 1) {
					y += 0.1f;
					graphic.update(x,y);
				}
				zone = zone.getZone(x,y);					
				//TODO medir colision en la nueva zona
			}
			break;
		case LEFT:
			if (zone.getZone(x - 1, y).getType() == ZoneType.PATH) {
				((GraphicCharacter)	graphic).setMovingLeft();
				while (y < y + 1) {
					y += 0.1f;
					graphic.update(x,y);
				}
				zone = zone.getZone(x,y);						
				//TODO medir colision en la nueva zona
			}
			break;
			
		}
	}
	
	
	/**
	 * Evalua si el jugador puede moverse en la direccion pasada, si puede se la asigna
	 * 
	 * @param dir Direction 
	 */
	public void attemptMovement(Direction dir) {
		switch (dir) {
		case UP:
			if (zone.getZone(x, y + 1).getType() == ZoneType.PATH) {
				movementDirection = Direction.UP;
			}
			break;
		case RIGHT:
			if (zone.getZone(x + 1, y).getType() == ZoneType.PATH) {
				movementDirection = Direction.RIGHT;
			}
			break;
		case DOWN:
			if (zone.getZone(x, y - 1).getType() == ZoneType.PATH) {
				movementDirection = Direction.DOWN;
			}
			break;
		case LEFT:
			if (zone.getZone(x - 1, y).getType() == ZoneType.PATH) {
				movementDirection = Direction.LEFT;
			}
			break;
		}
	}
	
	public void collide() {
		//TODO imp
	}
	
	public void accept(Visitor visitor) {
		//TODO imp
	}
	
	/**
	 * Setea la zona donde se encuentra el jugador
	 * @param zone Zone
	 */
	public void setZone(Zone zone) {
		this.zone = zone;
		setGraphic();
		this.setCoordinates(zone.getX(), zone.getX());
	}
	
	private void setGraphic() {
		//graphic = new GraphicCharacter(zone.getImageFactory().getPlayerImages());
	}
	
}
