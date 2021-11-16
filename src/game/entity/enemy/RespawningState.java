package game.entity.enemy;

import static java.lang.Math.*;

import game.Direction;
import game.Game;
import game.entity.GraphicEnemy;
import game.labyrinth.Zone;

public class RespawningState extends EnemyState {

	protected int respawnTimer;
	
	public RespawningState(Enemy enemy) {
		super(enemy);
		respawnTimer = getStateDuration();
		Zone spawn = context.getZone().getLabyrinth().getSpawn();
		context.setCoordinates(spawn.getX(), spawn.getY());
		((GraphicEnemy) context.getGraphic()).setVisible(false);
	}
	
	protected int getStateDuration() {
		Zone spawn = context.getZone().getLabyrinth().getSpawn();
		int distance = toIntExact(round(sqrt(
				pow((double) spawn.getX() - context.getZone().getX(), 2) +
				pow((double) spawn.getY() - context.getZone().getY(), 2))));
		
		System.out.println("distance = " + distance);
		return round(distance * 0.2f * Game.CYCLES_PER_SECOND);
	}
	
	public void move() {
		if (--respawnTimer == 0) {
			context.changeState(new ChasingState(context));
			((GraphicEnemy) context.getGraphic()).setVisible(true);
		}
	}
	
	@Override
	public Direction nextMoveDirection() {
		return null;
	}
	
	public void collideWithPlayer() {
		// metodo vacio
	}

}
