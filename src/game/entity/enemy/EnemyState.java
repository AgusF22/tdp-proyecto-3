package game.entity.enemy;

public abstract class EnemyState {
	protected Enemy context;
	
	protected EnemyState(Enemy enemy) {
		this.context = enemy;
	}
	
	public abstract void move();
	
	public abstract void beCollidedByPlayer();
}
