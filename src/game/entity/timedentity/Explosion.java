package game.entity.timedentity;

import game.entity.Entity;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

public class Explosion extends Entity {

	protected Explosion(Zone zone) {
		super(zone);
		// TODO Auto-generated constructor stub
	}

	protected void remove() {
		// TODO imp
	}
	
	protected void collide() {
		
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub	
	}
}
