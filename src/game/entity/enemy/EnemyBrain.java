package game.entity.enemy;

import java.util.ArrayList;
import java.util.List;

import game.Game;

/**
 * Clase que controla a los enemigos.
 */
public class EnemyBrain implements Runnable {
	
	protected List<Enemy> enemies;
	
	/**
	 * Crea un nuevo enemy brain.
	 */
	public EnemyBrain() {
		enemies = new ArrayList<>(4);
	}
	
	/**
	 * Avisa a todos los enemigos de este controlador que se muevan.
	 */
	public void moveEnemies() {
		enemies.forEach(Enemy::move);
	}
	
	/**
	 * Agrega un enemigo a este controlador.
	 * @param enemy Un enemigo.
	 */
	public void addEnemy(Enemy enemy) {
		if (enemy != null) {
			enemies.add(enemy);
		}
	}
	
	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			moveEnemies();
			try {
				Thread.sleep(1000 / Game.CYCLES_PER_SECOND);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}
	
}
