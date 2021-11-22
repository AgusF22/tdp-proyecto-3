package game.entity.visitor;

import game.entity.Entity;
import game.entity.enemy.Enemy;
import game.entity.player.Player;

public class ExplosionVisitor extends Visitor {

	protected boolean playerVisited = false;
	
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

	@Override
	public void visit(Enemy enemy) {
		enemy.kill();
	}
	
}
