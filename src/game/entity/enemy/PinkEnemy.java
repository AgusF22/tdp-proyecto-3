package game.entity.enemy;

import game.Game;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Direction;
import game.labyrinth.LabyrinthCursor;
import game.labyrinth.Zone;

public class PinkEnemy extends Enemy {

	public PinkEnemy(Zone zone) {
		super (zone, 0.1f);
		this.graphic = new GraphicEnemy(this, this.getLabyrinth().getImageFactory().getPinkEnemyImages());
		state = new StartingState(this, 10 * Game.CYCLES_PER_SECOND);
	}

	@Override
	public Direction calculateChasePath() {
		Player player = Player.getInstance();
		Zone playerZone = this.getLabyrinth().getZone(player.getX(), player.getY());
		Direction playerDirection = player.getMovementDirection();
		
		LabyrinthCursor cursor = new LabyrinthCursor(playerZone, playerDirection);
		
		cursor.nextZone();
		while (!cursor.isInIntersection()) {
			cursor.nextZone();
		}
		
		return bestAproachPath(cursor.getZone());
	}

}
