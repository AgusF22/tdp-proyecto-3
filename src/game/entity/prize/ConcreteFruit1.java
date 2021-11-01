package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class ConcreteFruit1 extends Fruit{
	public ConcreteFruit1(Zone zone) {
		super();
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getFruit1Image());
	}
	
	public void triggerEffect() {
		//TODO imp
	}
}
