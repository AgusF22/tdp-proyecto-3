package game.entity.enemy;

import game.Direction;
import game.Game;

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
		stunTime = 1 * Game.CYCLES_PER_SECOND;
	}

	/**
	 * {@inheritDoc}
	 * En estado aturdido, el enemigo no se mueve y cambia de estado despues de cierta cantidad de llamadas a este metodo.
	 */
	@Override
	public void move() {
		if (--stunTime == 0) {
			contextEnemy.changeState(new ChasingState(contextEnemy));
		}
	}
	
	/**
	 * {@inheritDoc}
	 * En estado aturdido, el enemigo no se mueve, por lo que la direccion es nula.
	 */
	@Override
	public Direction nextMoveDirection() {
		return null;
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
