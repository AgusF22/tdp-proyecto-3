package game.entity.visitor;

import game.entity.enemy.Enemy;
import game.entity.player.Player;

public class ExplosionVisitor extends Visitor {

	@Override
	public void visit(Player player) {
		// TODO imp
		System.out.println("ExplosionVisitor visit player");
	}
	
	@Override
	public void visit(Enemy enemy) {
		enemy.kill();
	}
	
}
