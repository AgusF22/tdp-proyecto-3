package game.entity.timedentity;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import game.Game;
import game.entity.Entity;
import game.entity.GraphicStaticEntity;
import game.entity.visitor.ExplosionVisitor;
import game.entity.visitor.Visitor;
import game.labyrinth.Direction;
import game.labyrinth.LabyrinthCursor;
import game.labyrinth.Zone;

/**
 * Modela una bomba.
 */
public class Bomb extends Entity implements Runnable {

	protected int time;
	protected boolean exploded;
	protected List<Explosion> explosions;
	
	protected ExplosionVisitor visitor;
	
	protected Thread bombThread;
	
	/**
	 * Cra una nueva bomba.
	 * @param zone La zona en la que se encontrara la nueva bomba.
	 */
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
	
	/**
	 * Inicia el hilo que controla esta bomba.
	 */
	protected void startCountdown() {
		bombThread = new Thread(this);
		bombThread.start();
	}
	
	/**
	 * Explota esta bomba, creando explosiones en todos los caminos que se encuentren a una cierta distancia.
	 */
	protected void explode() {
		LabyrinthCursor cursor = new LabyrinthCursor(zone, Direction.UP);
		LabyrinthCursor newCursor;
		exploded = true;
		
		addExplosion(zone);
		
		for (Direction d : Direction.values()) {
			newCursor = cursor.sendCloneTo(d);
			if (newCursor != null) {
				explode(newCursor, 6);
			}
		}
		
		time = Math.round(0.4f * Game.CYCLES_PER_SECOND);
		graphic.delete();
	}
	
	/**
	 * Añade explosiones recursivamente alrededor de esta bomba.
	 * @param cursor Un cursor de laberinto, usado para recorrer los caminos.
	 * @param power La fuerza de la explosion, es decir, la cantidad de caminos que se expandira.
	 */
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
	
	/**
	 * Añade una explosion a la zona pasada como parametro.
	 * @param zoneParam La zona en la que se añadira la explosion.
	 */
	protected void addExplosion(Zone zoneParam) {
		Explosion expl = new Explosion(zoneParam, this);
		zoneParam.addEntity(expl);
		explosions.add(expl);
	}
	
	/**
	 * Termina la explosion de esta bomba, interrumpiendo su hilo.
	 */
	protected void endExplosion() {
		for (Explosion e : explosions) {
			e.remove();
		}
		zone.removeEntity(this);
		bombThread.interrupt();
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			
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
	
	/**
	 * Borra esta bomba, sus explosiones, e interrumpe su hilo.
	 */
	public void delete() {
		zone.removeEntity(this);
		graphic.delete();
		for (Explosion e : explosions) {
			e.remove();
		}
		bombThread.interrupt();
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	/**
	 * Devuelve el visitor de explosion de esta bomba. A ser usado por sus explosiones.
	 * @return El visitor de explosion de esta bomba.
	 */
	protected ExplosionVisitor getExplosionVisitor() {
		return visitor;
	}
	
}
