package game.entity.enemy;

import game.Game;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Direction;
import game.labyrinth.Zone;

/**
 * Modela un enemigo de tipo rojo.
 * Este enemigo persigue al jugador directamente.
 */
public class RedEnemy extends Enemy {

	/**
	 * Crea un nuevo enemigo rojo.
	 * @param zone La zona en la que se encontrara el nuevo enemigo.
	 */
	public RedEnemy(Zone zone) {
		super (zone, 0.15f);
		this.graphic = new GraphicEnemy(this, this.getLabyrinth().getImageFactory().getRedEnemyImages());
		addToGUI();
		state = new StartingState(this, 1 * Game.CYCLES_PER_SECOND);
	}

	/**
	 * {@inheritDoc}
	 * El objetivo del enemigo rojo es el jugador.
	 */
	@Override
	protected Direction calculateChasePath() {
		Player player = Player.getInstance();
		float playerX = player.getX();
		float playerY = player.getY();
		return bestAproachPath(this.getLabyrinth().getZone(playerX, playerY));
	}
	
}
