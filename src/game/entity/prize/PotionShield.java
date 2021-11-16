package game.entity.prize;

import game.entity.GraphicPrize;
import game.entity.player.Player;
import game.labyrinth.Zone;

public class PotionShield extends Potion {
	
	public PotionShield(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getPotion2());
	}
	
	public void triggerEffect() {
		//TODO imp
		Player.getInstance().addSpeedMultiplier(2);
		beConsumed();
	}
	
}
