package game.entity.enemy;

import static java.lang.Math.*;

import game.Game;
import game.labyrinth.Direction;
import game.labyrinth.Zone;

/**
 * Clase que modela el comportamiento de un enemigo que se encuentra en estado de reaparicion.
 */
public class RespawningState extends EnemyState {

	protected int respawnTimer;
	
	/**
	 * Crea un nuevo estado de reaparicion.
	 * @param enemy El enemigo que se encontrara en este estado.
	 */
	public RespawningState(Enemy enemy) {
		super(enemy);
		respawnTimer = getStateDuration();
		Zone spawn = contextEnemy.getLabyrinth().getEnemySpawn();
		contextEnemy.setCoordinates(spawn.getX(), spawn.getY());
		
		contextEnemy.getGraphic().setVisible(false);
		contextEnemy.getGraphic().setFleeing(false);
		contextEnemy.getGraphic().setStunEffect(false);
		contextEnemy.getGraphic().updatePosition();
	}
	
	/**
	 * Calcula la duracion de este estado.
	 * @return La duracion de este estado.
	 */
	protected int getStateDuration() {
		Zone spawn = contextEnemy.getLabyrinth().getEnemySpawn();
		int distance = toIntExact(round(sqrt(
				pow((double) spawn.getX() - contextEnemy.getZone().getX(), 2) +
				pow((double) spawn.getY() - contextEnemy.getZone().getY(), 2))));
		
		return round(distance * 0.2f * Game.CYCLES_PER_SECOND);
	}
	
	/**
	 * {@inheritDoc}
	 * En estado de reaparicion, cada invocacion a este metodo reduce el contador hasta que el enemigo reaparezca.
	 */
	@Override
	public void move() {
		if (--respawnTimer <= 0) {
			contextEnemy.changeState(new ChasingState(contextEnemy));
		}
	}
	
	/**
	 * {@inheritDoc}
	 * En estado de reaparicion, el enemigo no se mueve, por lo que la direccion es nula.
	 */
	@Override
	public Direction nextMoveDirection() {
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 * En estado de reaparicion, la colision no hace nada.
	 */
	@Override
	public void collideWithPlayer() {
		// metodo vacio
	}

	/**
	 * {@inheritDoc}
	 * El estado de reaparicion esta siempre bloqueado.
	 */
	@Override
	public boolean locked() {
		return true;
	}

}
