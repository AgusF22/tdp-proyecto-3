package game.entity.prize;

import game.labyrinth.Zone;

/**
 * Modela una pocion.
 */
public abstract class Potion extends Prize {
	
	/**
	 * Crea una nueva pocion.
	 * @param  La zona en la que se encontrara la nueva pocion.
	 */
	protected Potion(Zone zone) {
		super(zone);
	}
	
}
