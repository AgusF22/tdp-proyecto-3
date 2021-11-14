package game.entity.enemy;

import game.Direction;
import game.entity.GraphicEnemy;
import game.labyrinth.Zone;

public class OrangeEnemy extends Enemy {

	public OrangeEnemy(Zone zone) {
		super (zone);
		this.graphic = new GraphicEnemy(this, zone.getLabyrinth().getImageFactory().getOrangeEnemyImages());
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
