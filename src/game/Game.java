package game;

import game.labyrinth.Labyrinth;
import gui.GUI;
import imageFactories.ImageFactory;

public class Game implements Subscriber{
	protected int points;
	protected GUI gui;
	protected ImageFactory imageFactory;
	protected Labyrinth labyrinth;
	
	public Game(ImageFactory factory) {
		//TODO implementar
	}
	
	/**
	 * Mueve al personaje principal a arriba.
	 */
	public void moveUp() {
		//TODO implementar
	}
	
	/**
	 * Mueve al personaje principal a abajo.
	 */
	public void moveDown() {
		//TODO implementar
	}
	
	/**
	 * Mueve al personaje principal a la derecha.
	 */
	public void moveRight() {
		//TODO implementar
	}
	
	/**
	 * Mueve al personaje principal a la izquierda.
	 */
	public void moveLeft() {
		//TODO implementar
	}
	
	/**
	 * Devuelve los puntos acumulados.
	 * @return un entero que representa los puntos.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Incrementa el puntaje con la cantidad p.
	 * @param p cantidad a incrementar.
	 */
	public void addPoints(int p) {
		this.points += p;
	}
	
	/**
	 * Termina el juego. TODO Mejorar
	 */
	public void endGame() {
		//TODO implementar
	}
	
	/**
	 * Gana el juego TODO mejorar
	 */
	public void winGame() {
		//TODO implementar
	}
	
	/**
	 * Updatea TODO mejorar
	 */
	public void update() {
		//TODO implementar
	}
}
