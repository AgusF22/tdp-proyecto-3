package game.labyrinth;

import game.Game;

public abstract class Labyrinth {
	//TODO documentar
	
	protected int doCount;
	protected Game game;
	protected Zone[] zones; //TODO cambiar coleccion
	
	protected Labyrinth() {
		//TODO implementar
	}
	
	public boolean dotsRemain() {
		//TODO imp
		return false;
	}
	
	public void endGame() {
		//TODO imp
	}
	
	public Labyrinth nextLabyrinth() {
		//TODO imp
		return null;
	}
	
	public void addPoints(int p) {
		//TODO imp
	}
	
	/**
	 * Devuelve un iterable con todas las entidades.
	 * @return un iterable.
	 */
	public Iterable getEntities() {
		//TODO imp
		return null;
	}
	
	public Zone getZone(int x, int y) {
		//TODO imp
		return null;
	}
}
