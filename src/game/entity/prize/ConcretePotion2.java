package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class ConcretePotion2 extends Potion {
	public ConcretePotion2(Zone zone) {
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getPotion1());
		//TODO imp
	}
	
	public void triggerEffect() {
		//TODO imp
	}
}
