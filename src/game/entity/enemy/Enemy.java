package game.entity.enemy;

import game.entity.Entity;

public abstract class Enemy extends Entity{
	protected EnemyState state;
	
	protected Enemy(EnemyState initialState) {
		//TODO imp
	}
	
	public abstract void move();
	
	public abstract void chase();
	
	public void accept() {
		//TODO imp
	}
	
	public void setFleeing() {
		//TODO imp
	}
	
	public void beCollidedByPlayer() {
		//TODO imp
	}
	
	protected void changeState(EnemyState state) {
		//TODO imp
	}
}
