package game.entity.enemy;

import game.Direction;
import game.entity.player.Player;

public class ChasingState extends EnemyState {

	public ChasingState(Enemy enemy) {
		//TODO imp
		super(enemy);
	}
	
	public void move() {
		context.move(context.getSpeedMultiplier() * context.getMovementSpeed());
	}
	
	@Override
	public Direction nextMoveDirection() {
		return context.calculateChasePath();
	}
	
	public void collideWithPlayer() {
		Player player = Player.getInstance();
		if (player.hasShield()) {
			context.changeState(new StunedState(context));
			player.removeShield();
		} else {
			System.out.println("*********************************************************************************");
			System.out.println("********************************* GAME OVER *************************************");
			System.out.println("*********************************************************************************");
		}
	}

}
