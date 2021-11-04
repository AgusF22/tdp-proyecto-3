package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class ConcretePotion1 extends Potion {
	
	public ConcretePotion1(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getPotion1());
	}
	
	public void triggerEffect() {
		//TODO imp
	}
	
}
