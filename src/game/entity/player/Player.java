package game.entity.player;

import game.labyrinth.Zone;
import game.labyrinth.ZoneType;
import game.entity.Entity;
import game.entity.GraphicCharacter;
import game.entity.Visitor;

public class Player extends Entity{
	protected Direction movementDirection;
	protected Direction attemptMovement;
	protected static Player instance;
	
	private Player(Zone zone) {
		super();
		movementDirection = Direction.LEFT;
	}
	
	public static Player getInstance() {
		if(instance == null) 
			instance = new Player(null);
		return instance;
	}
	
	/**
	 * Setea la zona donde se encuentra el jugador
	 * @param zone Zone
	 */
	public void setZone(Zone zone) {
		this.zone = zone;
		this.setCoordinates(zone.getX(), zone.getX());
		setGraphic();
	}
	
	private void setGraphic() {
		graphic = new GraphicCharacter(zone.getImageFactory().getPlayerImages());
	}

	
	public void move() {
		
		if (attemptMovement != null && isWhole(x) && isWhole(y)) {			//Chequeamos que se intenta mover a otro lado y que este en el centro de una zona
			switch (attemptMovement) {														//Notese que sabemos que no es igual a movementDirection porque sino seria nula
			case UP:
				if (zone.getZoneIn(x, y + 1).getType() == ZoneType.PATH) {
					movementDirection = attemptMovement;
					attemptMovement = null;
				}
				break;
			case RIGHT:
				if (zone.getZoneIn(x + 1, y).getType() == ZoneType.PATH) {
					movementDirection = attemptMovement;
					attemptMovement = null;
				}
				break;
			case DOWN:
				if (zone.getZoneIn(x, y - 1).getType() == ZoneType.PATH) {
					movementDirection = attemptMovement;
					attemptMovement = null;
				}
				break;
			case LEFT:
				if (zone.getZoneIn(x - 1, y).getType() == ZoneType.PATH) {
					movementDirection = attemptMovement;
					attemptMovement = null;
				}
				break;
			}
		}
		
		switch (movementDirection) {
		case UP:
			if (zone.getZoneIn(x, y + 1).getType() == ZoneType.PATH) {
				((GraphicCharacter) graphic).setMovingUp();
				y += 0.1f;
				graphic.update(x,y);				// Actualizamos la grafica
				if (isWhole(y)) {					// Si la posicion luego de moverse es entera entonces se encuentra en el centro de una nueva zona.
					zone = zone.getZoneIn(x, y + 1);
				}	
				//TODO medir colision en la nueva zona
			}
			break;
		case RIGHT:
			if (zone.getZoneIn(x + 1, y).getType() == ZoneType.PATH) {
				((GraphicCharacter) graphic).setMovingRight();
				x += 0.1f;
				graphic.update(x,y);
				if (isWhole(x)) {
					zone = zone.getZoneIn(x + 1, y);
				}	
				//TODO medir colision en la nueva zona
			}
			break;
		case DOWN:
			if (zone.getZoneIn(x, y - 1).getType() == ZoneType.PATH) {
				((GraphicCharacter) graphic).setMovingDown();
				y -= 0.1f;
				graphic.update(x,y);
				if (isWhole(y)) {
					zone = zone.getZoneIn(x, y - 1);
				}			
				//TODO medir colision en la nueva zona
			}
			break;
		case LEFT:
			if (zone.getZoneIn(x - 1, y).getType() == ZoneType.PATH) {
				((GraphicCharacter) graphic).setMovingLeft();
				x -= 0.1f;
				graphic.update(x,y);
				if (isWhole(x)) {
					zone = zone.getZoneIn(x - 1, y);
				}	
				//TODO medir colision en la nueva zona
			}
		}
		
	}
	private boolean isWhole (float x) {
		return (x == Math.round(x));
	}
	
	/**
	 * Evalua si el jugador puede moverse en la direccion pasada, si puede se la asigna
	 * 
	 * @param dir Direction 
	 */
	public void attemptMovement(Direction dir) {
		attemptMovement = dir;
	}
	
	public void collide() {
		//TODO imp
	}
	
	public void accept(Visitor visitor) {
		//TODO imp
	}
}
