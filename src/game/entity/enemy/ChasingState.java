package game.entity.enemy;

public class ChasingState extends EnemyState {

	public ChasingState(Enemy enemy) {
		//TODO imp
		super(enemy);
	}
	
	public void move() {
		context.move(context.getSpeedMultiplier() * context.getMovementSpeed());
	}
	
	public void collideWithPlayer() {
		//TODO imp
	}

}
