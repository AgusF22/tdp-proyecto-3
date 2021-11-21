package game.entity.prize;

import game.entity.GraphicStaticEntity;
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
	public PotionBomb(Zone zone) {
		super(zone);
		graphic = new GraphicStaticEntity(this, zone.getLabyrinth().getImageFactory().getPotion3());
		addToGUI();
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
