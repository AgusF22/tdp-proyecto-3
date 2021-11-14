package game;

import exceptions.DataLoadException;
import game.entity.enemy.EnemyBrain;
import game.entity.player.Player;
import game.labyrinth.ConcreteLabyrinth1;
import game.labyrinth.Labyrinth;
import gui.GamePanel;
import imagefactories.ImageFactory;

public class Game implements Subscriber, Runnable {
	
	public static final int CYCLES_PER_SECOND = 60;
	
	protected int points;
	protected GamePanel gui;
	protected ImageFactory imageFactory;
	protected Labyrinth labyrinth;
	protected EnemyBrain enemyBrain;
	
	protected Thread gameThread;
	protected Thread brainThread;
	
	/**
	 * Construye una nueva instancia de Game.
	 * @param gui interfaz grafica asociada al juego.
	 * @throws DataLoadException 
	 */
	public Game(GamePanel gui) throws DataLoadException {
		this.gui = gui;
		points = 0;
		imageFactory = gui.getImageFactory();
		
		labyrinth = new ConcreteLabyrinth1(this);
		labyrinth.addPlayer();
		labyrinth.fillWithDots();
		
		enemyBrain = new EnemyBrain();
		EndGamePublisher.getInstance().subscribe(this);
	}
	
	/**
	 * Mueve al personaje principal hacia arriba.
	 */
	public void moveUp() {
		Player.getInstance().attemptMovement(Direction.UP);
	}
	
	/**
	 * Mueve al personaje principal hacia la derecha.
	 */
	public void moveRight() {
		Player.getInstance().attemptMovement(Direction.RIGHT);
	}
	
	/**
	 * Mueve al personaje principal hacia abajo.
	 */
	public void moveDown() {
		Player.getInstance().attemptMovement(Direction.DOWN);
	}
	
	/**
	 * Mueve al personaje principal hacia la izquierda.
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
	 * Termina el juego.
	 */
	public void endGame() {
		if (labyrinth == null) {
			gui.winGame();
		} else {
			gui.loseGame();
		}
	}
	
	/**
	 * Gana el nivel.
	 * @throws DataLoadException 
	 */
	public void winLevel() throws DataLoadException {
		labyrinth = labyrinth.nextLabyrinth();
		if (labyrinth != null) {
			System.out.println("add player");
			labyrinth.addPlayer();
			System.out.println("fill with dots");
			labyrinth.fillWithDots();
		} else {
			endGame();
		}
	}
	
	/**
	 * Retorna la fabrica de imagenes que se utiliza en el juego.
	 * @return Una fabrica de imagenes.
	 */
	public ImageFactory getImageFactory() {
		return gui.getImageFactory();
	}
	
	@Override
	public void update() {
		stop();
		endGame();
	}
	
	public GamePanel getGUI() {
		return gui;
	}
	
	/**
	 * Retorna el EnemyBrian asociado al juego
	 * @return EnemyBrain si existe uno, null si no existe
	 */
	public EnemyBrain getEnemyBrain() {
		return enemyBrain;
	}
	
	public void start() {
		gameThread = new Thread(this);
		brainThread = new Thread(enemyBrain);
		gameThread.start();
		brainThread.start();
	}
	
	public void stop() {
		gameThread.interrupt();
		brainThread.interrupt();
	}
	
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {
			synchronized (this) {

				Player.getInstance().move();
				
				if(labyrinth == null) {
					stop();
					break;
				}

				try {
					Thread.sleep(1000 / CYCLES_PER_SECOND);
				} catch (InterruptedException e) {
					Thread.currentThread().interrupt();
					return;
				}
			}
		}
	}
}
