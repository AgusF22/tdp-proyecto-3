package game.entity.enemy;

import game.Direction;
import game.entity.player.Player;

public class ChasingState extends EnemyState {

	public ChasingState(Enemy enemy) {
		//TODO imp
		super(enemy);
	}
	
	public void move() {
		contextEnemy.move(contextEnemy.getSpeed());
	}
	
	@Override
	public Direction nextMoveDirection() {
		return contextEnemy.calculateChasePath();
	}
	
	public void collideWithPlayer() {
		Player player = Player.getInstance();
		if (player.hasShield()) {
			contextEnemy.changeState(new StunedState(contextEnemy));
			player.removeShield();
		} else {
			System.out.println("*********************************************************************************");
			System.out.println("********************************* GAME OVER *************************************");
			System.out.println("*********************************************************************************");
		}
	}

}
