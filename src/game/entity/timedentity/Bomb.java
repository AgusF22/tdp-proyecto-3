package game.entity.timedentity;

import java.util.ArrayList;
import java.util.List;

import game.Direction;
import game.Game;
import game.entity.Entity;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

public class Bomb extends Entity implements Runnable {

	protected int time;
	protected boolean exploded;
	protected List<Explosion> explosion;
	
	protected Thread bombThread;
	
	protected Bomb(Zone zone) {
		super(zone);
		time = 4 * Game.CYCLES_PER_SECOND;
		exploded = false;
		explosion = new ArrayList<>();
	}
	
	protected void startCountdown() {
		time--;
	}
	
	protected void explode() {
		// TODO imp
	}
	
	protected void endExplosion() {
		for (Explosion e : explosion) {
			e.remove();
		}
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			
		}
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
