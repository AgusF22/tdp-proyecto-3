package game.entity.prize;

import game.entity.GraphicStaticEntity;
import game.labyrinth.Zone;

/**
 * Modela un dot, un tipo de premio.
 */
public class Dot extends Prize {
	
	/**
	 * Crea un nuevo dot.
	 * @param zone La zona en la que se encontrara el nuevo dot.
	 */
	public Dot(Zone zone) {
		super(zone);
		graphic = new GraphicStaticEntity(this, getLabyrinth().getImageFactory().getDotImage());
		addToGUI();
	}
	
	/**
	 * {@inheritDoc}
	 * El dot añade una pequeña cantidad de puntos al jugador.
	 */
	@Override
	public void triggerEffect() {
		zone.getLabyrinth().addPoints(10);
		beConsumed();
	}
	
	@Override
	protected void beConsumed() {
		super.beConsumed();
		zone.getLabyrinth().removeDot();
	}
	
}
