package game.entity.visitor;

import game.entity.enemy.Enemy;
import game.entity.player.Player;
import game.entity.timedentity.Bomb;

/**
 * Modela un visitor de reaparicion.
 */
public class RespawnVisitor implements Visitor {

	/**
	 * {@inheritDoc}
	 * Si el jugador tiene vidas, las reduce y lo respawnea. Si no, termina el juego.
	 */
	@Override
	public void visit(Player player) {
		if (player.getLives() > 1) {
			player.respawn();
			player.reduceLives(1);
		} else {
			player.getLabyrinth().endGame();
		}
	}
	
	/**
	 * {@inheritDoc}
	 * Respawnea al enemigo.
	 */
	@Override
	public void visit(Enemy enemy) {
		enemy.respawn();
	}
	
	/**
	 * {@inheritDoc}
	 * Borra la bomba.
	 */
	@Override
	public void visit(Bomb bomb) {
		bomb.delete();
	}
	
}
