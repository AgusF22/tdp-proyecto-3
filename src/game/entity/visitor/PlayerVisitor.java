package game.entity.visitor;

import game.entity.enemy.Enemy;
import game.entity.prize.Prize;

/**
 * Modela un visitor de jugador.
 */
public class PlayerVisitor implements Visitor{
	
	/**
	 * {@inheritDoc}
	 * Hace que el enemigo colisione con el jugador.
	 */
	@Override
	public void visit(Enemy enemy) {
		enemy.collideWithPlayer();
	}
	
	/**
	 * {@inheritDoc}
	 * Dispara el efecto del premio.
	 */
	@Override
	public void visit(Prize prize) {
		prize.triggerEffect();
	}
	
}
