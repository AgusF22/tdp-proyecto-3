package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class Dot extends Prize {
	
	public Dot(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getDotImage());
	}
	
	public void triggerEffect() {
		zone.getLabyrinth().addPoints(10);
		beConsumed();
	}
	
}
