package game.entity.enemy;

import game.entity.GraphicEnemy;
import game.labyrinth.Zone;

public class BlueEnemy extends Enemy {

	public BlueEnemy(Zone zone) {
		super (zone);
		this.graphic = new GraphicEnemy(this, zone.getLabyrinth().getImageFactory().getBlueEnemyImages());
	}
	
	@Override
	public void move() {
		//TODO imp
	}

	@Override
	public void calculateChasePath() {
		// TODO imp
	}

}
