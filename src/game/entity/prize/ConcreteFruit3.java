package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class ConcreteFruit3 extends Fruit {
	
	public ConcreteFruit3(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getFruit3Image());
	}

	public void triggerEffect() {
		zone.getLabyrinth().addPoints(5000);
		graphic.delete();
		zone.removeEntity(this);
	}
	
}
