package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

public class PotionBomb  extends Potion {

	public PotionBomb(Zone zone) {
		super(zone);
		//TODO cambiar por getPotion3 cuando esté implementada.
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getPotion2());
	}

	@Override
	public void triggerEffect() {
		// TODO Auto-generated method stub
	}

}
