package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class PowerPellet extends Prize {
	public PowerPellet(Zone zone) {
		this.zone = zone;
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getPowerPelletImage());
		x = zone.getX();
		y = zone.getY();
		zone.addEntity(this);
	}
	
	public void triggerEffect() {
		//TODO imp
	}
}
