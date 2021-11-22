package game.entity.visitor;

import game.entity.enemy.Enemy;

/**
 * Modela un visitor de power pellet.
 */
public class PowerPelletVisitor extends Visitor{
	
	/**
	 * {@inheritDoc}
	 * Pasa al enemigo a estado de huida.
	 */
	@Override
	public void visit(Enemy enemy) {
		enemy.setFleeing();
	}
	
}
