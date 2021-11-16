package game.entity.visitor;

import game.entity.enemy.Enemy;
import game.entity.player.Player;
import game.entity.prize.Prize;
import game.entity.timedentity.Bomb;
import game.entity.timedentity.Explosion;

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
	
	public void visit(Bomb bomb) {
		// metodo vacio
	}
	
	public void visit(Explosion explosion) {
		// metodo vacio
	}
	
}
