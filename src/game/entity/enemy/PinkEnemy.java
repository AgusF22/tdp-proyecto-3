package game.entity.enemy;

import exceptions.InvalidZoneException;
import game.Game;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Direction;
import game.labyrinth.LabyrinthCursor;
import game.labyrinth.Zone;

/**
 * Modela un enemigo de tipo rosa.
 * Este enemigo intenta emboscar al jugador adelantandose a sus movimientos.
 */
public class PinkEnemy extends Enemy {

	/**
	 * Crea un nuevo enemigo rosa.
	 * @param zone La zona en la que se encontrara el nuevo enemigo.
	 */
	public PinkEnemy(Zone zone) {
		super (zone, 0.1f);
		this.graphic = new GraphicEnemy(this, this.getLabyrinth().getImageFactory().getPinkEnemyImages());
		addToGUI();
		spawnDelay = 10 * Game.CYCLES_PER_SECOND;
		state = new StartingState(this, 10 * Game.CYCLES_PER_SECOND);
	}

	/**
	 * {@inheritDoc}
	 * El objetivo del enemigo rosa es la proxima interseccion por la que pasara el jugador si este continua por el camino actual.
	 */
	@Override
	protected Direction calculateChasePath() {
		Player player = Player.getInstance();
		Zone playerZone;
		try {
			playerZone = this.getLabyrinth().getZone(player.getX(), player.getY());
			Direction playerDirection = player.getMovementDirection();

			LabyrinthCursor cursor = new LabyrinthCursor(playerZone, playerDirection);

			cursor.nextZone();
			while (!cursor.isInIntersection()) {
				cursor.nextZone();
			}

			return bestAproachPath(cursor.getZone());
		} catch (InvalidZoneException e) {
			e.printStackTrace();
		}
		return null;
	}

}
