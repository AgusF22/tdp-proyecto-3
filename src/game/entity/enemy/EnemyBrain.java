package game.entity.enemy;

import java.util.LinkedList;
import java.util.List;

/**
 * Clase EnemyBrain
 * Avisa las acciones a hacer de los enemigos que controla
 */
public class EnemyBrain {
	
	protected List<Enemy> enemies;
	
	public EnemyBrain() {
		//TODO imp
		enemies = new LinkedList<>();
	}
	
	
	/**
	 * Avisa a todos los enemigos en su control que se muevan
	 */
	public void moveEnemies() {
		//TODO imp
	}
	
	/**
	 * Agrega un enemigo al control de EnemyBrain
	 * @param enemy Enemy
	 */
	public void addEnemy(Enemy enemy) {
		//TODO imp
		if (enemy != null) {
			enemies.add(enemy);
		}
	}
	
	public void run() {
		//TODO imp
	}
}
