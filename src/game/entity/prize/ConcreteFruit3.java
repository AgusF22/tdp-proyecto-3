package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class ConcreteFruit3 extends Fruit{
	public ConcreteFruit3(Zone zone) {
		super();
		this.zone = zone;
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getFruit3Image());
		x = zone.getX();
		y = zone.getY();
		zone.addEntity(this);
	}

	public void triggerEffect() {
		//TODO imp
	}
}
