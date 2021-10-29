package game.entity.prize;

import game.entity.Entity;
import game.entity.Visitor;
import game.entity.enemy.Enemy;
import game.entity.player.Player;

public abstract class Prize extends Entity{
	protected Prize() {
		//TODO imp
	}
	
	public void move() {
		//TODO imp
	}
	
	public void accept(Visitor visitor) {
		//TODO imp
	}
	
	public void affect(Enemy enemy) {
		//TODO imp
	}
	
	public void affect(Player player) {
		//TODO imp
	}
}
