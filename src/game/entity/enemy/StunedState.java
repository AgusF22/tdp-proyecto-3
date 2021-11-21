package game.entity.enemy;

import game.Game;
import game.labyrinth.Direction;

/**
 * Clase que modela el comportamiento de un enemigo que se encuentra en estado aturdido.
 */
public class StunedState extends EnemyState{
	
	protected int stunTime;

	/**
	 * Crea un nuevo estado aturdido.
	 * @param enemy El enemigo que se encontrara en este estado.
	 */
	protected StunedState(Enemy enemy) {
		super(enemy);

		contextEnemy.getGraphic().setVisible(true);
		contextEnemy.getGraphic().setFleeing(false);
		contextEnemy.getGraphic().setStunEffect(true);
		
		stunTime = 1 * Game.CYCLES_PER_SECOND;
	}

	/**
	 * {@inheritDoc}
	 * En estado aturdido, el enemigo no se mueve y cambia de estado despues de cierta cantidad de llamadas a este metodo.
	 */
	@Override
	public void move() {
		if (--stunTime == 0) {
			contextEnemy.getGraphic().setStunEffect(false);
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

	/**
	 * {@inheritDoc}
	 * El estado aturdido nunca esta bloqueado.
	 */
	@Override
	public boolean locked() {
		return false;
	}

}
