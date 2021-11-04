package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class ConcretePotion2 extends Potion {
	
	public ConcretePotion2(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getPotion2());
	}
	
	public void triggerEffect() {
		//TODO imp
	}
	
}
