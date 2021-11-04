package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class ConcreteFruit2 extends Fruit {
	
	public ConcreteFruit2(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getFruit2Image());
	}
	
	public void triggerEffect() {
		//TODO imp
	}
	
}
