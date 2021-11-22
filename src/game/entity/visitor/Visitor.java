package game.entity.visitor;

import game.entity.enemy.Enemy;
import game.entity.player.Player;
import game.entity.prize.Prize;
import game.entity.timedentity.Bomb;
import game.entity.timedentity.Explosion;

/**
 * Modela un visitor.
 */
public interface Visitor {
	
	/**
	 * Visita un jugador.
	 * @param player Un jugador.
	 */
	public default void visit(Player player) {
		// metodo vacio
	}
	
	/**
	 * Visita un enemigo.
	 * @param enemy Un enemigo.
	 */
	public default void visit(Enemy enemy) {
		// metodo vacio
	}
	
	/**
	 * Visita un premio.
	 * @param prize Un premio.
	 */
	public default void visit(Prize prize) {
		// metodo vacio
	}
	
	/**
	 * Visita una bomba.
	 * @param bomb Una bomba.
	 */
	public default void visit(Bomb bomb) {
		// metodo vacio
	}
	
	/**
	 * Visita una explosion.
	 * @param explosion Una explosion.
	 */
	public default void visit(Explosion explosion) {
		// metodo vacio
	}
	
}
