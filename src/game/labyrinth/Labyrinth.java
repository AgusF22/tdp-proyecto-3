package game.labyrinth;

import java.util.HashSet;
import java.util.Set;
import game.Game;
import game.entity.Entity;
import imagefactories.ImageFactory;

public abstract class Labyrinth {
	//TODO documentar
	
	public final static int WIDTH = 29;
	public final static int HEIGHT = 31;
	
	protected int doCount;
	protected Game game;
	protected Zone[][] zones;
	
	/**
	 * Crear un nuevo labyrinth.
	 * @param game asociado a este laberinto.
	 */
	protected Labyrinth(Game game) {
		this.game = game;
		zones = new Zone[WIDTH][HEIGHT];
	}
	
	/**
	 * @return true si quedan dots en el laberinto, false en caso contrario.
	 */
	public boolean dotsRemain() {
		return doCount != 0;
	}
	
	/**
	 * Finaliza el juego.
	 */
	public void endGame() {
		game.endGame();
	}
	
	/**
	 * @return el siguiente laberinto.
	 */
	public abstract Labyrinth nextLabyrinth();
	
	/**
	 * Notifica al juego para que incremente los puntos.
	 * @param p cantidad de puntos a incrementar.
	 */
	public void addPoints(int p) {
		game.addPoints(p);
	}
	
	/**
	 * Devuelve un iterable con todas las entidades.
	 * @return un iterable.
	 */
	public Iterable<Entity> entities() {
		Set<Entity> entities = new HashSet<>();
		Iterable<Entity> listEntities;
		
		for (int i = 0; i < zones.length; i++) {										// Recorre todas las zonas del laberinto
			for (int j = 0; j < zones[0].length; j++) {
				listEntities = zones[i][j].zoneEntities();								// Le pide a la zona todas sus entidades
				listEntities.forEach(entities::add);							// Agrega las entidades de la zona en la Set entities
			}
		}
		return entities;
	}
	
	/**
	 * @param x coordenada eje x.
	 * @param y coordenada eje y.
	 * @return la zona cuyas cordenadas a las pasadas por parametro.
	 */
	public Zone getZone(float x, float y) {
		int xInt = Math.round(x);									// Si la parte decimal del n�mero es menor que la mitad,
		int yInt = Math.round(y);									// redondear hacia abajo. En caso de que sea la mitad o mayor,
																	// redondea hacia arriba.
		
		// TODO if(zones[xInt][yInt] == null) excepcion zona invalida 
		return zones[xInt][yInt];
	}
	
	/**
	 * Decrementa en uno los dots actuales del laberinto. 
	 */
	public void removeDot() {
		doCount--;
	}
	
	/**
	 * Retorna el constructor del dominio grafico que se utiliza en el juego
	 * @return ImageFactory.
	 */
	public ImageFactory getImageFactory() {
		return game.getImageFactory();
	}
}
