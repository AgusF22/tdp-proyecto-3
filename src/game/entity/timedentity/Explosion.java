package game.entity.timedentity;

import game.entity.Entity;
import game.entity.GraphicStaticEntity;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

public class Explosion extends Entity {
	
	protected Bomb bomb;

	protected Explosion(Zone zone, Bomb bomb) {
		super(zone);
		this.bomb = bomb;
		graphic = new GraphicStaticEntity(this, getLabyrinth().getImageFactory().getExplosionImage());
		addToGUI();
	}

	protected void remove() {
		zone.removeEntity(this);
		graphic.delete();
	}
	
	protected void collide() {
		Visitor v = bomb.visitor;
		for (Entity e : zone.zoneEntities()) {
			e.accept(v);					
		}
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
}
