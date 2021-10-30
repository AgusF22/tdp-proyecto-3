package game.entity.player;

import game.entity.Entity;
import game.entity.Visitor;

public class Player extends Entity{
	protected Direction movementDirection;
	protected static Player instance;
	
	private Player() {
		
	}
	
	public static Player getInstance() {
		if(instance == null) 
			instance = new Player();
		return instance;
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
