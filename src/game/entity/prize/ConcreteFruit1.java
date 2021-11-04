package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class ConcreteFruit1 extends Fruit {
	
	public ConcreteFruit1(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getFruit1Image());
	}
	
	public void triggerEffect() {
		zone.getLabyrinth().addPoints(100);
		beConsumed();
	}
	
}
