package game.entity;

import game.Direction;
import game.labyrinth.Zone;

public abstract class Character extends Entity {

	protected final float MOVEMENT_SPEED = 0.1f;
	protected float speedMultiplier;
	protected Direction movementDirection;
	
	protected Character(Zone zone) {
		super(zone);
		movementDirection = Direction.LEFT;
	}
	
	public abstract void move();
	
	public void setSpeed(float multiplier) {
		speedMultiplier = multiplier;
	}
	
}
