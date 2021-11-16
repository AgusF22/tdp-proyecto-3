package game.entity.enemy;

import game.Direction;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Zone;

public class PinkEnemy extends Enemy {

	public PinkEnemy(Zone zone) {
		super (zone, 0.1f);
		this.graphic = new GraphicEnemy(this, this.getLabyrinth().getImageFactory().getPinkEnemyImages());
	}

	@Override
	public Direction calculateChasePath() {
		Player player = Player.getInstance();
		Zone playerZone = this.getLabyrinth().getZone(player.getX(), player.getY());
		Direction playerDirection = player.getMovementDirection();
		
		Cursor cursor = new Cursor(playerZone, playerDirection);
		
		cursor.nextZone();
		while (!cursor.isInIntersection()) {
			cursor.nextZone();
		}
		
		return bestAproachPath(cursor.zone);
	}

}
