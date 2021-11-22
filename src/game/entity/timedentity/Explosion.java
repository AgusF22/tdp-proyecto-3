package game.entity.timedentity;

import game.entity.Entity;
import game.entity.GraphicStaticEntity;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

/**
 * Modela una explosion.
 */
public class Explosion extends Entity {
	
	protected Bomb bomb;

	/**
	 * Crea una nueva explosion.
	 * @param zone La zona en la que se encontrara la nueva explosion.
	 * @param bomb
	 */
	protected Explosion(Zone zone, Bomb bomb) {
		super(zone);
		this.bomb = bomb;
		graphic = new GraphicStaticEntity(this, getLabyrinth().getImageFactory().getExplosionImage());
		addToGUI();
	}

	/**
	 * Remueve a esta explosion de su zona y borra su grafica.
	 */
	protected void remove() {
		zone.removeEntity(this);
		graphic.delete();
	}
	
	/**
	 * Colisiona a esta explosion con todas las entidades de la zona.
	 */
	protected void collide() {
		Visitor v = bomb.getExplosionVisitor();
		for (Entity e : zone.zoneEntities()) {
			e.accept(v);					
		}
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
