package game.entity.visitor;

import game.entity.enemy.Enemy;
import game.entity.player.Player;

public class RespawnVisitor extends Visitor {

	public void visit(Player player) {
		if (player.getLives() > 1) {
			player.respawn();
			player.reduceLives(1);
		} else {
			
		}
	}
	
	public void visit(Enemy enemy) {
		enemy.respawn();
	}
	
}
