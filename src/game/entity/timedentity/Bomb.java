package game.entity.timedentity;

import game.entity.Entity;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

public class Bomb extends Entity {

	protected int time;
	protected boolean exploded;
	protected Explosion[][] explosion;
	
	protected Bomb(Zone zone) {
		super(zone);
		// TODO Auto-generated constructor stub
	}
	
	public void reduceCountdown() {
		time--;
	}
	
	protected void explode() {
		// TODO imp
	}
	
	protected void endExplosion() {
	
	}
	
	public void run() {
		
	}

	@Override
	public void accept(Visitor visitor) {
		// TODO Auto-generated method stub
		
	}
}
