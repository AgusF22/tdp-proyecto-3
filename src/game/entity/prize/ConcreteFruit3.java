package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

/**
 * Modela la fruta del tercer nivel.
 */
public class ConcreteFruit3 extends Fruit {
	
	/**
	 * Crea una nueva fruta 3.
	 * @param zone La zona en la que se encontrara la nueva fruta.
	 */
	public ConcreteFruit3(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getFruit3Image());
	}

	/**
	 * {@inheritDoc}
	 * La fruta 1 añade una gran cantidad de puntos.
	 */
	@Override
	public void triggerEffect() {
		zone.getLabyrinth().addPoints(5000);
		beConsumed();
	}
	
}
