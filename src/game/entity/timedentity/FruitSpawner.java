package game.entity.timedentity;

import game.entity.prize.Fruit;
import game.labyrinth.Zone;

public abstract class FruitSpawner extends TimedEntity {
	
	protected Fruit fruit;

	protected FruitSpawner(Zone zone) {
		super(zone);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void reduceCountdown() {
		super.reduceCountdown();;
		// TODO imp
	}
	
	protected void addFruit() {
		// TODO imp
	}
	
	protected void removeFruit() {
		// TODO imp
	}
	
	protected void remove() {
		// TODO imp
	}

}
