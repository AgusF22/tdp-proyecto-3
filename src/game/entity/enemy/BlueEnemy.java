package game.entity.enemy;

import exceptions.NullZoneException;
import game.Game;
import game.entity.GraphicEnemy;
import game.entity.player.Player;
import game.labyrinth.Direction;
import game.labyrinth.Labyrinth;
import game.labyrinth.Zone;

/**
 * Modela un enemigo de tipo azul.
 * Este enemigo colabora con un enemigo de tipo rojo para atrapar al jugador.
 */
public class BlueEnemy extends Enemy {
	
	protected RedEnemy red;

	/**
	 * Crea un nuevo enemigo azul.
	 * @param zone La zona en la que se encontrara el nuevo enemigo.
	 * @param red El enemigo rojo con el que el enemigo azul creado colaborara.
	 */
	public BlueEnemy(Zone zone, RedEnemy red) {
		super (zone, 0.1f);
		this.red = red;
		this.graphic = new GraphicEnemy(this, this.getLabyrinth().getImageFactory().getBlueEnemyImages());
		addToGUI();
		spawnDelay = 3 * Game.CYCLES_PER_SECOND;
		state = new StartingState(this, 3 * Game.CYCLES_PER_SECOND);
	}

	/**
	 * {@inheritDoc}
	 * El objetivo del enemigo azul es el punto B, extremo del vector BJ, donde J es el punto en el que se encuentra el jugador, y 
	 * BJ tiene igual direccion y sentido opuesto al vector AJ, donde A es el punto en el que se encuentra el enemigo rojo.
	 */
	@Override
	protected Direction calculateChasePath() {
		Player player = Player.getInstance();
		
		float targetX = player.getX() * 2 - red.getX();
		float targetY = player.getY() * 2 + red.getY();
		
		targetX = limitToLabyrinthWidth(targetX);
		targetY = limitToLabyrinthWidth(targetY);
		
		try {
			return bestAproachPath(this.getLabyrinth().getZone(targetX, targetY));
		} catch (NullZoneException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Retorna el valor entero i que se encuantra a menor distancia del parametro dado, tal que i esta dentro de los limites de la altura del laberinto.
	 * @param yParam La coordenada a restringir a la altura del laberinto.
	 * @return El valor entero a menor distancia del parametro dado, restringido a la altura del laberinto.
	 */
	protected int limitToLabyrinthHeight(float yParam) {
		float toReturn;
		if (yParam < 0) {
			toReturn = 0;
		} else if ( yParam > Labyrinth.HEIGHT - 1) {
			toReturn = Labyrinth.HEIGHT - 1;
		} else {
			toReturn = yParam;
		}
		return (int) toReturn;
	}
	
	/**
	 * Retorna el valor entero i que se encuantra a menor distancia del parametro dado, tal que i esta dentro de los limites de la anchura del laberinto.
	 * @param xParam La coordenada a restringir a la anchura del laberinto.
	 * @return El valor entero a menor distancia del parametro dado, restringido a la anchura del laberinto.
	 */
	protected int limitToLabyrinthWidth(float xParam) {
		float toReturn;
		if (xParam < 0) {
			toReturn = 0;
		} else if ( xParam > Labyrinth.WIDTH - 1) {
			toReturn = Labyrinth.WIDTH - 1;
		} else {
			toReturn = xParam;
		}
		return (int) toReturn;
	}

}
