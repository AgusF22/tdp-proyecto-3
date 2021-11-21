package game.entity.prize;

import game.entity.GraphicPrize;
import game.entity.player.Player;
import game.labyrinth.Zone;

/**
 * Modela una pocion de bomba.
 */
public class PotionBomb extends Potion {

	/**
	 * Crea una nueva pocion de bomba.
	 * @param zone  La zona en la que se encontrara la nueva pocion.
	 */
	protected PotionBomb(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getPotion3());
	}

	/**
	 * {@inheritDoc}
	 * La pocion de bomba le añade una bomba adicional al jugador.
	 */
	@Override
	public void triggerEffect() {
		Player.getInstance().addBomb();
		beConsumed();
	}

}
