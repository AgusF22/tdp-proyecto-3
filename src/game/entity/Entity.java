package game.entity;

import game.labyrinth.Zone;

public abstract class Entity {
	protected Zone zone;
	protected GraphicEntity graphic;
	protected float x;
	protected float y;
	
	protected Entity() {
		//TODO imp
	}
	
	public void move() {
		//TODO imp
	}
	
	protected void accept(Visitor visitor) {
		//TODO imp
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setCoordinates(float x, float y) {
		this.x = x;
		this.y = y;
	}
}
