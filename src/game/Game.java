package game;

import exceptions.DataLoadException;
import game.entity.enemy.EnemyBrain;
import game.entity.player.Player;
import game.labyrinth.ConcreteLabyrinth1;
import game.labyrinth.Direction;
import game.labyrinth.Labyrinth;
import gui.GamePanel;
import imagefactories.ImageFactory;

/**
 * Modela el juego.
 */
public class Game implements Runnable {
	
	public static final int CYCLES_PER_SECOND = 60;
	
	protected int points;
	protected GamePanel gui;
	protected ImageFactory imageFactory;
	protected Labyrinth labyrinth;
	protected EnemyBrain enemyBrain;
	
	protected Thread gameThread;
	protected Thread brainThread;
	
	/**
	 * Construye una nueva instancia del juego.
	 * @param gui Interfaz grafica a asociar al juego.
	 * @throws DataLoadException Si ocurre un error al cargar el primer nivel del juego.
	 */
	public Game(GamePanel gui) throws DataLoadException {
		this.gui = gui;
		points = 0;
		imageFactory = gui.getImageFactory();
		
		enemyBrain = new EnemyBrain();
		
		labyrinth = new ConcreteLabyrinth1(this);
		labyrinth.addPlayer();
		
		gameThread = new Thread(this);
		brainThread = new Thread(enemyBrain);
	}
	
	/**
	 * Mueve al jugador hacia arriba.
	 */
	public void moveUp() {
		Player.getInstance().attemptMovement(Direction.UP);
	}
	
	/**
	 * Mueve al jugador hacia la derecha.
	 */
	public void moveRight() {
		Player.getInstance().attemptMovement(Direction.RIGHT);
	}
	
	/**
	 * Mueve al jugador hacia abajo.
	 */
	public void moveDown() {
		Player.getInstance().attemptMovement(Direction.DOWN);
	}
	
	/**
	 * Mueve al jugador hacia la izquierda.
	 */
	public void moveLeft() {
		Player.getInstance().attemptMovement(Direction.LEFT);
	}
	
	/**
	 * Hace que el jugador ponga una bomba.
	 */
	public void placeBomb() {
		Player.getInstance().placeBomb();
	}

	/**
	 * Retorna la fabrica de imagenes que se utiliza en el juego.
	 * @return Una fabrica de imagenes.
	 */
	public ImageFactory getImageFactory() {
		return gui.getImageFactory();
	}
	
	/**
	 * Retorna la gui asociada al juego.
	 * @return La gui asociada al juego.
	 */
	public GamePanel getGUI() {
		return gui;
	}
	
	/**
	 * Retorna el EnemyBrian asociado al juego.
	 * @return El EnemyBrian asociado al juego.
	 */
	public EnemyBrain getEnemyBrain() {
		return enemyBrain;
	}
	
	/**
	 * Devuelve los puntos acumulados.
	 * @return Los puntos acumulados.
	 */
	public int getPoints() {
		return points;
	}
	
	/**
	 * Incrementa el puntaje en la cantidad pasada como parametro.
	 * @param p Cantidad a incrementar.
	 */
	public void addPoints(int p) {
		this.points += p;
		gui.updatePoints();
	}
	
	/**
	 * Termina el juego.
	 */
	public void endGame() {
		Player.getInstance().resetState();
		if (labyrinth == null) {
			gui.winGame();
		} else {
			gui.loseGame();
		}
		stop();
	}
	
	/**
	 * Gana el nivel.
	 * @throws DataLoadException Si ocurre un error al cargar el siguiente nivel.
	 */
	public void winLevel() throws DataLoadException {
		labyrinth.clearEntities();
		resetBrain();
		labyrinth = labyrinth.nextLabyrinth();
		
		if (labyrinth != null) {
			labyrinth.addPlayer();
			labyrinth.fillWithDots();
			brainThread.start();
			Player.getInstance().resetEffects();
		} else {
			endGame();
		}
	}
	
	/**
	 * Reinicia el controlador de los enemigos.
	 */
	protected void resetBrain() {
		brainThread.interrupt();
		enemyBrain = new EnemyBrain();
		brainThread = new Thread(enemyBrain);
	}
	
	
	/**
	 * Inicia los hilos del juego.
	 */
	public void start() {
		gameThread.start();
		brainThread.start();
	}
	
	/**
	 * Interrumpe los hilos del juego.
	 */
	public void stop() {
		gameThread.interrupt();
		brainThread.interrupt();
	}
	
	@Override
	public void run() {
		while(!Thread.currentThread().isInterrupted()) {

			Player.getInstance().move();

			if(labyrinth == null) {
				stop();
				break;
			}

			try {
				Thread.sleep(1000 / CYCLES_PER_SECOND);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();	
			}
			
		}
	}
}
