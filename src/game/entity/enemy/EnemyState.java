package game.entity.enemy;

public abstract class EnemyState {
	protected Enemy context;
	
	protected EnemyState(Enemy enemy) {
		//TODO imp
	}
	
	public abstract void move();
	
	public abstract void beCollidedByPlayer();
}
