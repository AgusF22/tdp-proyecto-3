package game.entity.prize;

import game.labyrinth.Zone;

/**
 * Modela una fruta del juego.
 */
public abstract class Fruit extends Prize {
	
	/**
	 * Crea una nueva instancia de fruta.
	 * @param zone  La zona en la que se encontrara la nueva fruta.
	 */
	protected Fruit(Zone zone) {
		super(zone);
	}
	
}
