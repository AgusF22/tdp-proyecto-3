package game.entity.enemy;

public abstract class EnemyState {
	
	protected Enemy context;
	
	/**
	 * Crea un nuevo estado para el enemigo pasado como parametro.
	 * @param enemy Un enemigo.
	 */
	protected EnemyState(Enemy enemy) {
		this.context = enemy;
	}
	
	/**
	 * Mueve al enemigo que se encuentra en este estado.
	 */
	public abstract void move();
	
	/**
	 * Hace que el enemigo que se encuantra en este estado colisione con el jugador.
	 */
	public abstract void CollideWithPlayer();
	
}
