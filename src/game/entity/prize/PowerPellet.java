package game.entity.prize;

import game.entity.Entity;
import game.entity.GraphicPrize;
import game.entity.visitor.PowerPelletVisitor;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

public class PowerPellet extends Prize {
	
	public PowerPellet(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getPowerPelletImage());
	}
	
	public void triggerEffect() {
		Visitor v = new PowerPelletVisitor();
		for (Entity e: zone.getLabyrinth().entities()) {
			e.accept(v);
		}
		beConsumed();
	}
	
}
