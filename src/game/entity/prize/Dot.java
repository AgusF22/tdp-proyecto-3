package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class Dot extends Prize {
	public Dot(Zone zone) {
		graphic = new GraphicPrize(zone.getLabyrinth().getImageFactory().getDotImage());
	}
	
	public void triggerEffect() {
		//TODO imp
	}
}
