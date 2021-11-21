package game.entity.prize;

import game.entity.GraphicStaticEntity;
import game.labyrinth.Zone;

/**
 * Modela la fruta del segundo nivel.
 */
public class ConcreteFruit2 extends Fruit {
	
	/**
	 * Crea una nueva fruta 2.
	 * @param zone La zona en la que se encontrara la nueva fruta.
	 */
	public ConcreteFruit2(Zone zone) {
		super(zone);
		graphic = new GraphicStaticEntity(this, zone.getLabyrinth().getImageFactory().getFruit2Image());
		addToGUI();
	}
	
	/**
	 * {@inheritDoc}
	 * La fruta 1 añade una cantidad media de puntos.
	 */
	@Override
	public void triggerEffect() {
		zone.getLabyrinth().addPoints(1000);
		beConsumed();
	}
	
}
