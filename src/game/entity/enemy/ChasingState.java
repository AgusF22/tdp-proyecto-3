package game.entity.enemy;

import game.entity.Entity;
import game.entity.player.Player;
import game.entity.visitor.RespawnVisitor;
import game.entity.visitor.Visitor;
import game.labyrinth.Direction;

/**
 * Clase que modela el comportamiento de un enemigo que se encuentra en estado de persecucion.
 */
public class ChasingState extends EnemyState {

	/**
	 * Crea un nuevo estado de persecucion.
	 * @param enemy El enemigo que se encontrara en este estado.
	 */
	public ChasingState(Enemy enemy) {
		super(enemy);
		
		contextEnemy.getGraphic().setVisible(true);
		contextEnemy.getGraphic().setFleeing(false);
		contextEnemy.getGraphic().setStunEffect(false);
	}
	
	/**
	 * {@inheritDoc}
	 * En estado de persecucion, el enemigo se mueve normalmente.
	 */
	@Override
	public void move() {
		contextEnemy.move(contextEnemy.getSpeed());
	}
	
	/**
	 * {@inheritDoc}
	 * En estado de persecucion, la direccion de movimiento depende del comportamiento de cada enemigo.
	 */
	@Override
	public Direction nextMoveDirection() {
		return contextEnemy.calculateChasePath();
	}
	
	/**
	 * {@inheritDoc}
	 * En estado de persecucion, la colision con el jugador provoca la perdida de una vida, o bien el aturdimiento del enemigo si el jugador tiene un escudo.
	 */
	@Override
	public void collideWithPlayer() {
		Player player = Player.getInstance();
		if (player.hasShield()) {
			contextEnemy.changeState(new StunedState(contextEnemy));
			player.useShield();
		} else {
			Visitor v = new RespawnVisitor();
			for (Entity e : contextEnemy.getLabyrinth().entities()) {
				e.accept(v);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 * El estado de persecucion nunca esta bloqueado.
	 */
	@Override
	public boolean locked() {
		return false;
	}

}
