package game.entity.player;

import game.labyrinth.ZoneType;
import imageFactories.ConcreteImageFactory;
import game.entity.Entity;
import game.entity.GraphicCharacter;
import game.entity.Visitor;

public class Player extends Entity{
	protected Direction movementDirection;
	protected static Player instance;
	protected GraphicCharacter graphic;
	
	private Player() {
		movementDirection = Direction.LEFT;
		//TODO setear imagen.
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
					//TODO setear que imagen se mueva para arriba
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
					//TODO setear que imagen se mueva para derecha
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
					//TODO setear que imagen se mueva para abajo
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
					//TODO setear que imagen se mueva para izquierda
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
	
}
