package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class Dot extends Prize {
	public Dot(Zone zone) {
		this.zone = zone;
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getDotImage());
		x = zone.getX();
		y = zone.getY();
		zone.addEntity(this);
	}
	
	public void triggerEffect() {
		//TODO imp
	}
}
