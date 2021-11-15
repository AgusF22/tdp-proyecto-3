package game.entity.enemy;

import game.EndGamePublisher;
import game.entity.player.Player;

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
		Player.getInstance().getGraphic().delete();
		EndGamePublisher.getInstance().notifySubscribers();
	}

}
