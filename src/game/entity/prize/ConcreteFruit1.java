package game.entity.prize;

import game.entity.GraphicPrize;
import game.labyrinth.Zone;

/**
 * Modela la fruta del primer nivel.
 */
public class ConcreteFruit1 extends Fruit {
	
	/**
	 * Crea una nueva fruta 1.
	 * @param zone La zona en la que se encontrara la nueva fruta.
	 */
	public ConcreteFruit1(Zone zone) {
		super(zone);
		graphic = new GraphicPrize(this, zone.getLabyrinth().getImageFactory().getFruit1Image());
	}
	
	/**
	 * {@inheritDoc}
	 * La fruta 1 a�ade puntos.
	 */
	@Override
	public void triggerEffect() {
		zone.getLabyrinth().addPoints(100);
		beConsumed();
	}
	
}
