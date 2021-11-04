package game.entity.visitor;

import game.entity.enemy.Enemy;

public class PowerPelletVisitor extends Visitor{
	
	@Override
	public void visit(Enemy enemy) {
		enemy.setFleeing();
	}
	
}
