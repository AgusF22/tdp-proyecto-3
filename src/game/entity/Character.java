package game.entity;

import game.labyrinth.Zone;

public abstract class Character extends Entity {

	protected final float MOVEMENT_SPEED;
	protected float speedMultiplier;
	
	protected Character(Zone zone, float movSpeed) {
		super(zone);
		this.MOVEMENT_SPEED = movSpeed;
	}
	
	public abstract void move();
	
	public void setSpeed(float multiplier) {
		speedMultiplier = multiplier;
	}
	
}
