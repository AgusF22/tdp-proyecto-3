package game.labyrinth;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import game.Game;
import game.entity.Entity;
import imageFactories.ImageFactory;

public abstract class Labyrinth {
	//TODO documentar
	
	protected int doCount;
	protected Game game;
	protected Set<Zone> zones;
	
	protected Labyrinth(Game game) {
		this.game = game;
	}
	
	/**
	 * @return true si quedan dots en el laberinto, false en caso contrario.
	 */
	public boolean dotsRemain() {
		return doCount != 0;
	}
	
	
	public void endGame() {
		game.endGame();
	}
	
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
		
		Iterator<Zone> itZones = zones.iterator();
		Iterator<Entity> itEntities;
		
		while (itZones.hasNext()) {													// Recorre todas las zonas del laberinto
			itEntities = itZones.next().zoneEntities().iterator();					// Le pide a la zona todas sus entidades
			while (itEntities.hasNext()) {											// Agrega las entidades de la zona en 
				entities.add(itEntities.next()); 									// el set entities.
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
		
		Iterator<Zone> itZones = zones.iterator();
		Zone zone = null;
		boolean exit = false;
		int xInt = Math.round(x);									// Si la parte decimal del número es menor que la mitad,
		int yInt = Math.round(y);									// redondear hacia abajo. En caso de que sea la mitad o mayor,
																	// redondea hacia arriba.
		while (itZones.hasNext() && !exit) {										
			zone = itZones.next();	
			if((zone.getX() == xInt) && (zone.getY() == yInt))
				exit = true;
		}
		
		// TODO if(zone == null) excepcion zona invalida 
		
		return zone;
	}
	
	public void removeDot() {
		doCount--;
	}
	
	public ImageFactory getImageFactory() {
		return game.getImageFactory();
	}
}
