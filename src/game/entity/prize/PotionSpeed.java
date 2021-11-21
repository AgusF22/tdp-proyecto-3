package game.entity.prize;

import game.entity.GraphicPrize;
import game.entity.player.Player;
import game.labyrinth.Zone;

/**
 * Modela una pocion de velocidad.
 */
public class PotionSpeed extends Potion {
	
	/**
	 * Crea una nueva pocion de velocidad.
	 * @param zone  La zona en la que se encontrara la nueva pocion.
	 */
	public PotionSpeed(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getPotion1());
	}
	
	/**
	 * {@inheritDoc}
	 * La pocion de velocidad aumenta temporalmente la velocidad del jugador.
	 */
	@Override
	public void triggerEffect() {
		Player.getInstance().addShield();
		beConsumed();
	}
	
}
