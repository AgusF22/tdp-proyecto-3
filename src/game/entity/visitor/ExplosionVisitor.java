package game.entity.visitor;

import game.entity.Entity;
import game.entity.enemy.Enemy;
import game.entity.player.Player;

/**
 * Modela un visitor de explosion.
 */
public class ExplosionVisitor implements Visitor {

	protected boolean playerVisited = false;
	
	/**
	 * {@inheritDoc}
	 * Si el jugador tiene escudo, lo consume, si no, activa el respawn.
	 */
	@Override
	public void visit(Player player) {
		if (!playerVisited) {
			if (player.hasShield()) {
				player.useShield();
			} else {
				Visitor v = new RespawnVisitor();
				for (Entity e : player.getLabyrinth().entities()) {
					e.accept(v);
				}
			}
			playerVisited = true;
		}
	}

	/**
	 * {@inheritDoc}
	 * Mata al enemigo.
	 */
	@Override
	public void visit(Enemy enemy) {
		enemy.kill();
	}
	
}
