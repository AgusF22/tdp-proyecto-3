package game.entity.enemy;

/**
 * Clase que modela el comportamiento de un enemigo que se encuentra en estado inicial.
 */
public class StartingState extends RespawningState {

	/**
	 * Crea un nuevo estado inicial.
	 * @param enemy El enemigo que se encontrara en este estado.
	 */
	public StartingState(Enemy enemy, int duration) {
		super(enemy);
		this.respawnTimer = duration;
	}

}
