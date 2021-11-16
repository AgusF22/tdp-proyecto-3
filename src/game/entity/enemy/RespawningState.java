package game.entity.enemy;

import static java.lang.Math.*;

import game.Game;
import game.entity.GraphicEnemy;
import game.labyrinth.Direction;
import game.labyrinth.Zone;

public class RespawningState extends EnemyState {

	protected int respawnTimer;
	
	public RespawningState(Enemy enemy) {
		super(enemy);
		respawnTimer = getStateDuration();
		Zone spawn = contextEnemy.getLabyrinth().getSpawn();
		contextEnemy.setCoordinates(spawn.getX(), spawn.getY());
		((GraphicEnemy) contextEnemy.getGraphic()).setVisible(false);
	}
	
	protected int getStateDuration() {
		Zone spawn = contextEnemy.getLabyrinth().getSpawn();
		int distance = toIntExact(round(sqrt(
				pow((double) spawn.getX() - contextEnemy.getZone().getX(), 2) +
				pow((double) spawn.getY() - contextEnemy.getZone().getY(), 2))));
		
		System.out.println("distance = " + distance);
		return round(distance * 0.2f * Game.CYCLES_PER_SECOND);
	}
	
	public void move() {
		if (--respawnTimer <= 0) {
			contextEnemy.changeState(new ChasingState(contextEnemy));
			((GraphicEnemy) contextEnemy.getGraphic()).setVisible(true);
		}
	}
	
	@Override
	public Direction nextMoveDirection() {
		return null;
	}
	
	public void collideWithPlayer() {
		// metodo vacio
	}

	@Override
	public boolean locked() {
		return true;
	}

}
