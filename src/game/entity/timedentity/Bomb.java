package game.entity.timedentity;

import game.labyrinth.Zone;

public class Bomb extends TimedEntity {

	protected Bomb(Zone zone) {
		super(zone);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void reduceCountdown() {
		super.reduceCountdown();;
		// TODO imp
	}
	
	protected void explode() {
		// TODO imp
	}

}
