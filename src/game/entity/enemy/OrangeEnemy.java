package game.entity.enemy;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.Math.toIntExact;

import game.Direction;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Zone;

public class OrangeEnemy extends Enemy {

	public OrangeEnemy(Zone zone) {
		super (zone, 0.08f);
		this.graphic = new GraphicEnemy(this, zone.getLabyrinth().getImageFactory().getOrangeEnemyImages());
	}

	@Override
	public Direction calculateChasePath() {
		Player player = Player.getInstance();
		float playerX = player.getX();
		float playerY = player.getY();
		Zone playerZone = zone.getLabyrinth().getZone(playerX, playerY);
		Direction toReturn;
		
		int distance = toIntExact(round(sqrt(
				pow((double) playerZone.getX() - zone.getX(), 2) +
				pow((double) playerZone.getY() - zone.getY(), 2))));
		
		if (distance >= 16) {
			toReturn = bestAproachPath(playerZone);
		} else {
			toReturn = bestFleePath(playerZone);
		}
		
		return toReturn;
	}

}
