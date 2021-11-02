package game.entity.enemy;

import game.entity.GraphicEnemy;
import game.labyrinth.Zone;

public class PinkEnemy extends Enemy {

	public PinkEnemy(Zone zone) {
		super (zone);
		this.graphic = new GraphicEnemy(zone.getLabyrinth().getImageFactory().getPinkEnemyImages());
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
