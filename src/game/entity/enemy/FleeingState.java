package game.entity.enemy;

import exceptions.InvalidZoneException;
import game.Game;
import game.entity.player.Player;
import game.labyrinth.Direction;

/**
 * Clase que modela el comportamiento de un enemigo que se encuentra en estado de huida.
 */
public class FleeingState extends EnemyState {
	
	protected static final int FLEEING_DURATION = 5 * Game.CYCLES_PER_SECOND;
	protected int fleeTimer;
	
	/**
	 * Crea un nuevo estado de huida.
	 * @param enemy El enemigo que se encontrara en este estado.
	 */
	public FleeingState(Enemy enemy) {
		super(enemy);
		fleeTimer = FLEEING_DURATION;
		contextEnemy.addSpeedMultiplier(0.5f);
		contextEnemy.turnAround();
		
		contextEnemy.getGraphic().setVisible(true);
		contextEnemy.getGraphic().setFleeing(true);
		contextEnemy.getGraphic().setStunEffect(false);
	}
	
	/**
	 * {@inheritDoc}
	 * En estado de huida, el enemigo se mueve normalmente.
	 */
	@Override
	public void move() {
		contextEnemy.move(contextEnemy.getSpeed());
		if (--fleeTimer == 0) {
			contextEnemy.changeState(new ChasingState(contextEnemy));
		}
	}
	
	/**
	 * {@inheritDoc}
	 *  En estado de huida, el enemigo se mueve en la mejor direccion para alejarse del jugador.
	 */
	@Override
	public Direction nextMoveDirection() {
		Player player = Player.getInstance();
		float playerX = player.getX();
		float playerY = player.getY();
		try {
			return contextEnemy.bestFleePath(contextEnemy.getLabyrinth().getZone(playerX, playerY));
		} catch (InvalidZoneException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 *  En estado de huida, la colision hace que el enemigo sea comido por el jugador.
	 */
	@Override
	public void collideWithPlayer() {
		contextEnemy.changeState(new RespawningState(contextEnemy));
		contextEnemy.getLabyrinth().addPoints(200);
	}

	/**
	 * {@inheritDoc}
	 * El estado de huida nunca esta bloqueado.
	 */
	@Override
	public boolean locked() {
		return false;
	}
	
}
