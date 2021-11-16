package game.entity.enemy;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.Math.toIntExact;

import game.Game;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Direction;
import game.labyrinth.Zone;

public class OrangeEnemy extends Enemy {

	public OrangeEnemy(Zone zone) {
		super (zone, 0.08f);
		this.graphic = new GraphicEnemy(this, this.getLabyrinth().getImageFactory().getOrangeEnemyImages());
		state = new StartingState(this, 6 * Game.CYCLES_PER_SECOND);
	}

	@Override
	public Direction calculateChasePath() {
		Player player = Player.getInstance();
		float playerX = player.getX();
		float playerY = player.getY();
		Zone playerZone = this.getLabyrinth().getZone(playerX, playerY);
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
