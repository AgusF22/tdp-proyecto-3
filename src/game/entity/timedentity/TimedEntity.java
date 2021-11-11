package game.entity.timedentity;

import game.entity.Entity;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

public class TimedEntity extends Entity{
	
	protected int time;

	protected TimedEntity(Zone zone) {
		super(zone);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub, añadir visit timedentity a visitor
	}
	
	public void reduceCountdown() {
		time--;
	}

}
