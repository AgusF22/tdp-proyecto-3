package game.entity;

import game.Direction;
import game.labyrinth.Zone;

public abstract class Character extends Entity {

	protected final float movementSpeed;
	protected float speedMultiplier;
	protected Direction movementDirection;
	
	protected Character(Zone zone, float movementSpeed) {
		super(zone);
		this.movementSpeed = movementSpeed;
		speedMultiplier = 1;
		movementDirection = Direction.LEFT;
	}
	
	public abstract void move();
	
	public void setSpeed(float multiplier) {
		speedMultiplier = multiplier;
	}
	
	public Direction getMovementDirection() {
		return movementDirection;
	}
	
}
