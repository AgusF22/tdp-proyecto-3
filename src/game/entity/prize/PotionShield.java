package game.entity.prize;

import game.entity.GraphicStaticEntity;
import game.entity.player.Player;
import game.labyrinth.Zone;

/**
 * Modela una pocion de escudo.
 */
public class PotionShield extends Potion {
	
	/**
	 * Cre una nueva pocion de escudo.
	 * @param zone  La zona en la que se encontrara la nuev pocion.
	 */
	public PotionShield(Zone zone) {
		super(zone);
		graphic = new GraphicStaticEntity(this, zone.getLabyrinth().getImageFactory().getPotion2());
		addToGUI();
	}
	
	/**
	 * {@inheritDoc}
	 * La pocion de escudo añade al jugador el efecto escudo.
	 */
	@Override
	public void triggerEffect() {
		Player.getInstance().addSpeedMultiplier(2);
		beConsumed();
	}
	
}
