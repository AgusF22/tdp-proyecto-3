package game.entity;

import game.entity.enemy.Enemy;
import game.entity.player.Player;
import game.entity.prize.Prize;

public abstract class Visitor {
	public void visit(Player player) {
		//TODO imp
	}
	
	public void visit(Enemy enemy) {
		//TODO imp
	}
	
	public void visit(Prize prize) {
		//TODO imp
	}
}
