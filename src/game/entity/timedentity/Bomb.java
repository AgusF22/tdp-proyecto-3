package game.entity.timedentity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import game.Game;
import game.entity.Entity;
import game.entity.GraphicStaticEntity;
import game.entity.player.Player;
import game.entity.visitor.ExplosionVisitor;
import game.entity.visitor.Visitor;
import game.labyrinth.Direction;
import game.labyrinth.LabyrinthCursor;
import game.labyrinth.Zone;

public class Bomb extends Entity implements Runnable {

	protected int time;
	protected boolean exploded;
	protected List<Explosion> explosions;
	
	protected ExplosionVisitor visitor;
	
	protected Thread bombThread;
	
	public Bomb(Zone zone) {
		super(zone);
		graphic = new GraphicStaticEntity(this, getLabyrinth().getImageFactory().getBombImage());
		addToGUI();
		time = 2 * Game.CYCLES_PER_SECOND;
		exploded = false;
		explosions = new ArrayList<>();
		visitor = new ExplosionVisitor();
		startCountdown();
	}
	
	protected void startCountdown() {
		bombThread = new Thread(this);
		bombThread.start();
	}
	
	protected void explode() {
		LabyrinthCursor cursor = new LabyrinthCursor(zone, Direction.UP);
		LabyrinthCursor newCursor;
		exploded = true;
		
		addExplosion(zone);
		
		for (Direction d : Direction.values()) {
			newCursor = cursor.sendCloneTo(d);
			if (newCursor != null) {
				explode(newCursor, 2);
			}
		}
		
		time = Math.round(0.4f * Game.CYCLES_PER_SECOND);
		graphic.delete();
	}
	
	protected void explode(LabyrinthCursor cursor, int power) {
		Set<Direction> directions;
		LabyrinthCursor newCursor;
		if (power > 0) {
			addExplosion(cursor.getZone());
			if (cursor.isInIntersection()) {
				directions = EnumSet.complementOf(
						EnumSet.of(cursor.getDirection().getOpposite()));
				
				for (Direction d : directions) {
					newCursor = cursor.sendCloneTo(d);
					if (newCursor != null) {
						explode(newCursor, power - 1);
					}
				}
				
			} else {
				cursor.nextZone();
				explode(cursor, power - 1);
			}
		}
	}
	
	protected void addExplosion(Zone zoneParam) {
		Explosion expl = new Explosion(zoneParam, this);
		zoneParam.addEntity(expl);
		explosions.add(expl);
	}
	
	protected void endExplosion() {
		for (Explosion e : explosions) {
			e.remove();
		}
		zone.removeEntity(this);
		bombThread.interrupt();
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			
//			System.out.println("Player coords = (" + Player.getInstance().getX() + ", " + Player.getInstance().getY() + ")");
//			System.out.println("Player zone x = " + Player.getInstance().getZone().getX());
//			System.out.println("Player zone y = " + Player.getInstance().getZone().getY());
			
			for(Entity e : Player.getInstance().getLabyrinth().getPlayerSpawn().zoneEntities()) {
				if(e == Player.getInstance()) {
					System.out.println("Player is in spawn");
				}
			}
			
			if (--time <= 0) {
				if (!exploded) {
					explode();
				} else {
					endExplosion();
				}
			} else {
				if (exploded) {
					explosions.forEach(Explosion::collide);
				}
			}
			
			try {
				Thread.sleep(1000 / Game.CYCLES_PER_SECOND);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
			
		}
	}
	
	public void delete() {
		zone.removeEntity(this);
		graphic.delete();
		for (Explosion e : explosions) {
			e.remove();
		}
		System.out.println("delete called");
		bombThread.interrupt();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
