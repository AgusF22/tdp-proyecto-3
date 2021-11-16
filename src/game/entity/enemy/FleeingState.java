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
		context.addSpeedMultiplier(0.5f);
		context.turnAround();
		((GraphicEnemy) context.getGraphic()).setFleeing(true);
	}
	
	@Override
	public void move() {
		context.move(context.getSpeedMultiplier() * context.getMovementSpeed());
		if (--fleeTimer == 0) {
			changeToChase();
		}
	}
	
	protected void changeToChase() {
		((GraphicEnemy) context.getGraphic()).setFleeing(false);
		context.changeState(new ChasingState(context));
	}
	
	@Override
	public Direction nextMoveDirection() {
		Player player = Player.getInstance();
		float playerX = player.getX();
		float playerY = player.getY();
		return context.bestFleePath(context.getZone().getLabyrinth().getZone(playerX, playerY));
	}
	
	@Override
	public void collideWithPlayer() {
		context.changeState(new RespawningState(context));
		context.getZone().getLabyrinth().addPoints(200);
		((GraphicEnemy) context.getGraphic()).setFleeing(false);
	}
	
}
