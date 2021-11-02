package game.entity.visitor;

import game.entity.enemy.Enemy;
import game.entity.player.Player;
import game.entity.prize.Prize;

public abstract class Visitor {
	
	public void visit(Player player) {
		// metodo vacio
	}
	
	public void visit(Enemy enemy) {
		// metodo vacio
	}
	
	public void visit(Prize prize) {
		// metodo vacio
	}
	
}