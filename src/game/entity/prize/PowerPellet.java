package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class PowerPellet extends Prize {
	
	public PowerPellet(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getPowerPelletImage());
	}
	
	public void triggerEffect() {
		//TODO imp
	}
	
}
