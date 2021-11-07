package game.entity.enemy;

/**
 * Clase que modela el estado de un enemigo que se encuentra aturdido.
 */
public class StunedState extends EnemyState{
	
	protected int stunTime;

	/**
	 * Crea un nuevo estado para un enemigo aturdido.
	 * @param enemy El enemigo que tendra este estado.
	 */
	protected StunedState(Enemy enemy) {
		super(enemy);
		stunTime = 30;
	}

	/**
	 * {@inheritDoc}
	 * En estado aturdido, el enemigo no se mueve y cambia de estado despues de cierta cantidad de llamadas a este metodo.
	 */
	@Override
	public void move() {
		stunTime--;
		if (stunTime >= 0) {
			context.changeState(new ChasingState(context));
		}
	}

	/**
	 * {@inheritDoc}
	 * En estado aturdido, la colision no hace nada.
	 */
	@Override
	public void collideWithPlayer() {
		// metodo vacio
	}

}
