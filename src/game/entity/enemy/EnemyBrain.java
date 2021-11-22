package game.entity.enemy;

import java.util.ArrayList;
import java.util.List;

import game.Game;

/**
 * Clase EnemyBrain
 * Avisa las acciones a hacer de los enemigos que controla
 */
public class EnemyBrain implements Runnable {
	
	protected List<Enemy> enemies;
	
	public EnemyBrain() {
		//TODO imp
		enemies = new ArrayList<>(4);
	}
	
	/**
	 * Avisa a todos los enemigos en su control que se muevan
	 */
	public void moveEnemies() {
		enemies.forEach(Enemy::move);
	}
	
	/**
	 * Agrega un enemigo al control de EnemyBrain
	 * @param enemy Enemy
	 */
	public void addEnemy(Enemy enemy) {
		if (enemy != null) {
			enemies.add(enemy);
		}
	}
	
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
//			moveEnemies(); TODO descomentar
			try {
				Thread.sleep(1000 / Game.CYCLES_PER_SECOND);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}
	
}
