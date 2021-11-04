package game.entity.visitor;

import game.entity.enemy.Enemy;
import game.entity.prize.Prize;

public class PlayerVisitor extends Visitor{
	
	@Override
	public void visit(Enemy enemy) {
		enemy.collideWithPlayer();
	}
	
	@Override
	public void visit(Prize prize) {
		prize.triggerEffect();
	}
	
}
