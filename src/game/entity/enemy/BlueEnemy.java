package game.entity.enemy;

import game.Direction;
import game.entity.GraphicEnemy;
import game.labyrinth.Zone;

public class BlueEnemy extends Enemy {
	
	protected RedEnemy red;

	public BlueEnemy(Zone zone, RedEnemy red) {
		super (zone);
		this.graphic = new GraphicEnemy(this, zone.getLabyrinth().getImageFactory().getBlueEnemyImages());
		this.red = red;
	}
	
	@Override
	public void move() {
		//TODO imp
	}

	@Override
	public Direction calculateChasePath() {
		return null;
		// TODO imp
	}

}
