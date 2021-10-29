package game.entity.player;

import game.entity.Entity;
import game.entity.Visitor;

public class Player extends Entity{
	protected MovementDirection movementDirection;
	protected Player instance;
	
	private Player() {
		//TODO imp
	}
	
	public Player getInstance() {
		//TODO imp
		return null;
	}
	
	public void move() {
		//TODO imp
	}
	
	public void collide() {
		//TODO imp
	}
	
	public void accept(Visitor visitor) {
		//TODO imp
	}
}
