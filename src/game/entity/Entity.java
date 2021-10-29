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
	
	public abstract void move();
	
	protected abstract void accept(Visitor visitor);
	
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
