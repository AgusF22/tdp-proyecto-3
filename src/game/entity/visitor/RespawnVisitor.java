package game.entity.visitor;

import game.entity.enemy.Enemy;
import game.entity.player.Player;
import game.entity.timedentity.Bomb;

public class RespawnVisitor extends Visitor {

	public void visit(Player player) {
		if (player.getLives() > 1) {
			player.respawn();
			player.reduceLives(1);
		} else {
			player.getLabyrinth().endGame();
		}
	}
	
	public void visit(Enemy enemy) {
		enemy.respawn();
	}
	
	public void visit(Bomb bomb) {
		bomb.delete();
	}
	
}
