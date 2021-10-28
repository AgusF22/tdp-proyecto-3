package game.labyrinth;

import game.entity.Entity;

public class Zone {
	//TODO documentar
	
	protected Labyrinth labyrinth;
	protected ZoneType type;
	protected Entity[] entities; //TODO cambiar coleccion
	protected int x;
	protected int y;
	
	public Zone(int x, int y, ZoneType type) {
		this.x = x;
		this.y = y;
		this.type = type;
	}
	
	public ZoneType getType() {
		return type;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void removeDot() {
		//TODO imp
	}
}
