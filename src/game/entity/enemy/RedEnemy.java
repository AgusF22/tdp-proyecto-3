package game.entity.enemy;

import game.Direction;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Zone;

public class RedEnemy extends Enemy {

	public RedEnemy(Zone zone) {
		super (zone, 0.15f);
		this.graphic = new GraphicEnemy(this, zone.getLabyrinth().getImageFactory().getRedEnemyImages());
	}

	@Override
	public Direction calculateChasePath() {
		Player player = Player.getInstance();
		float playerX = player.getX();
		float playerY = player.getY();
		return bestAproachPath(zone.getLabyrinth().getZone(playerX, playerY));
	}
	
}
