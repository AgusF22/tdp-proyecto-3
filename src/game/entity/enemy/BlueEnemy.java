package game.entity.enemy;

import game.Direction;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Labyrinth;
import game.labyrinth.Zone;

public class BlueEnemy extends Enemy {
	
	protected RedEnemy red;

	public BlueEnemy(Zone zone, RedEnemy red) {
		super (zone, 0.1f);
		this.graphic = new GraphicEnemy(this, this.getLabyrinth().getImageFactory().getBlueEnemyImages());
		this.red = red;
	}

	@Override
	public Direction calculateChasePath() {
		Player player = Player.getInstance();
		
		float targetX = player.getX() * 2 - red.getX();
		float targetY = player.getY() * 2 + red.getY();
		
		targetX = limitToLabyrinthWidth(targetX);
		targetY = limitToLabyrinthWidth(targetY);
		
		return bestAproachPath(this.getLabyrinth().getZone(targetX, targetY));
	}
	
	protected int limitToLabyrinthHeight(float yParam) {
		float toReturn;
		if (yParam < 0) {
			toReturn = 0;
		} else if ( yParam > Labyrinth.HEIGHT - 1) {
			toReturn = Labyrinth.HEIGHT - 1;
		} else {
			toReturn = yParam;
		}
		return (int) toReturn;
	}
	
	protected int limitToLabyrinthWidth(float xParam) {
		float toReturn;
		if (xParam < 0) {
			toReturn = 0;
		} else if ( xParam > Labyrinth.WIDTH - 1) {
			toReturn = Labyrinth.WIDTH - 1;
		} else {
			toReturn = xParam;
		}
		return (int) toReturn;
	}

}
