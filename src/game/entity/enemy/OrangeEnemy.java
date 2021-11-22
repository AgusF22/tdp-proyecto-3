package game.entity.enemy;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;
import static java.lang.Math.toIntExact;

import exceptions.InvalidZoneException;
import game.Game;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Direction;
import game.labyrinth.Zone;

/**
 * Modela un enemigo de tipo naranja.
 * Este enemigo persigue o escapa del jugador segun su distancia al mismo.
 */
public class OrangeEnemy extends Enemy {

	/**
	 * Crea un nuevo enemigo naranja.
	 * @param zone La zona en la que se encontrara el nuevo enemigo.
	 */
	public OrangeEnemy(Zone zone) {
		super (zone, 0.08f);
		this.graphic = new GraphicEnemy(this, this.getLabyrinth().getImageFactory().getOrangeEnemyImages());
		addToGUI();
		spawnDelay = 6 * Game.CYCLES_PER_SECOND;
		state = new StartingState(this, spawnDelay);
	}

	/**
	 * {@inheritDoc}
	 * El objetivo del enemigo naranja es el jugador, si se encuantra a una distancia mayor o igual a 16, o escapar del jugador, si se encuantra a 
	 * una distancia menor a 16.
	 */
	@Override
	protected Direction calculateChasePath() {
		Player player = Player.getInstance();
		float playerX = player.getX();
		float playerY = player.getY();
		Zone playerZone;
		
		try {
			playerZone = this.getLabyrinth().getZone(playerX, playerY);
			Direction toReturn;
		
			int distance = toIntExact(round(sqrt(
					pow((double) playerZone.getX() - zone.getX(), 2) +
					pow((double) playerZone.getY() - zone.getY(), 2))));
			
			if (distance >= 16) {
				toReturn = bestAproachPath(playerZone);
			} else {
				toReturn = bestFleePath(playerZone);
			}
			return toReturn;
		} catch (InvalidZoneException e) {
			e.printStackTrace();
		}
		return null;
	}

}
