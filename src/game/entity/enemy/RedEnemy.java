package game.entity.enemy;

import game.entity.GraphicEnemy;
import game.labyrinth.Zone;

public class RedEnemy extends Enemy {

	public RedEnemy(Zone zone) {
		super (zone);
		this.graphic = new GraphicEnemy(zone.getLabyrinth().getImageFactory().getRedEnemyImages());
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
