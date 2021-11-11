package game.entity.prize;

import game.labyrinth.Zone;

/**
 * Modela una fruta del juego.
 */
public abstract class Fruit extends Prize {
	
	/**
	 * Crea una nueva instancia de fruta.
	 * @param zone Una zona.
	 */
	protected Fruit(Zone zone) {
		super(zone);
	}
	
}
