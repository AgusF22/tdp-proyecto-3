package game.entity.prize;

import game.entity.GraphicPrize;
import game.entity.player.Player;
import game.labyrinth.Zone;

public class PotionSpeed extends Potion {
	
	public PotionSpeed(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getPotion1());
	}
	
	public void triggerEffect() {
		//TODO imp
		Player.getInstance().addShield();
		beConsumed();
	}
	
}
