package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class ConcretePotion2 extends Potion {
	public ConcretePotion2(Zone zone) {
		this.zone = zone;
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getPotion1());
		x = zone.getX();
		y = zone.getY();
		zone.addEntity(this);
	}
	
	public void triggerEffect() {
		//TODO imp
	}
}
