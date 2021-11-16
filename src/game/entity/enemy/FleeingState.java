package game.entity.enemy;

import game.Direction;
import game.Game;
import game.entity.GraphicEnemy;
import game.entity.player.Player;

public class FleeingState extends EnemyState {
	
	protected static final int FLEEING_DURATION = 5 * Game.CYCLES_PER_SECOND;
	protected int fleeTimer;
	
	public FleeingState(Enemy enemy) {
		super(enemy);
		fleeTimer = FLEEING_DURATION;
		contextEnemy.addSpeedMultiplier(0.5f);
		contextEnemy.turnAround();
		((GraphicEnemy) contextEnemy.getGraphic()).setFleeing(true);
	}
	
	@Override
	public void move() {
		contextEnemy.move(contextEnemy.getSpeed());
		if (--fleeTimer == 0) {
			changeToChase();
		}
	}
	
	protected void changeToChase() {
		((GraphicEnemy) contextEnemy.getGraphic()).setFleeing(false);
		contextEnemy.changeState(new ChasingState(contextEnemy));
	}
	
	@Override
	public Direction nextMoveDirection() {
		Player player = Player.getInstance();
		float playerX = player.getX();
		float playerY = player.getY();
		return contextEnemy.bestFleePath(contextEnemy.getLabyrinth().getZone(playerX, playerY));
	}
	
	@Override
	public void collideWithPlayer() {
		contextEnemy.changeState(new RespawningState(contextEnemy));
		contextEnemy.getLabyrinth().addPoints(200);
		((GraphicEnemy) contextEnemy.getGraphic()).setFleeing(false);
	}
	
}
