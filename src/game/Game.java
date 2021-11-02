package game;

import game.entity.enemy.EnemyBrain;
import game.entity.player.Direction;
import game.entity.player.Player;
import game.labyrinth.ConcreteLabyrinth1;
import game.labyrinth.Labyrinth;
import gui.GUI;
import gui.GamePanel;
import imageFactories.ImageFactory;

public class Game implements Subscriber{
	protected int points;
	protected GamePanel gui;
	protected ImageFactory imageFactory;
	protected Labyrinth labyrinth;
	protected EnemyBrain enemyBrain;
	
	public Game(GamePanel gui,ImageFactory factory) {
		this.gui = gui;
		points = 0;
		imageFactory = factory;
		labyrinth = new ConcreteLabyrinth1(this);
		enemyBrain = new EnemyBrain();
		EndGamePublisher.getInstance().subscribe(this);
	}
	
	/**
	 * Mueve al personaje principal a arriba.
	 */
	public void moveUp() {
		Player.getInstance().attemptMovement(Direction.UP);
	}
	
	/**
	 * Mueve al personaje principal a la derecha.
	 */
	public void moveRight() {
		Player.getInstance().attemptMovement(Direction.RIGHT);
	}
	
	/**
	 * Mueve al personaje principal a abajo.
	 */
	public void moveDown() {
		Player.getInstance().attemptMovement(Direction.DOWN);
	}
	
	/**
	 * Mueve al personaje principal a la izquierda.
	 */
	public void moveLeft() {
		Player.getInstance().attemptMovement(Direction.LEFT);
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
		gui.updatePoints();
	}
	
	/**
	 * Termina el juego. TODO Mejorar
	 */
	public void endGame() {
		//TODO implementar
		gui.loseGame();
	}
	
	/**
	 * Gana el juego TODO mejorar
	 */
	public void winLevel() {
		//TODO implementar
		labyrinth = labyrinth.nextLabyrinth();
	}
	
	/**
	 * Retorna el constructor del dominio grafico que se utiliza en el juego
	 * @return ImageFactory
	 */
	public ImageFactory getImageFactory() {
		return imageFactory;
	}
	
	/**
	 * Updatea TODO mejorar
	 */
	public void update() {
		//TODO implementar
		endGame(); // TODO el observer solo notifica cuando un enemigo toco a un jugador?
	}
}
