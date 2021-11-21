package game.labyrinth;

import java.util.HashSet;
import java.util.Set;

import data.LabyrinthLoader;
import exceptions.DataLoadException;
import exceptions.NullZoneException;
import game.Game;
import game.entity.Entity;
import game.entity.enemy.BlueEnemy;
import game.entity.enemy.OrangeEnemy;
import game.entity.enemy.PinkEnemy;
import game.entity.enemy.RedEnemy;
import game.entity.prize.ConcreteFruit1;
import game.entity.prize.ConcreteFruit2;
import game.entity.prize.Dot;
import game.entity.prize.PotionBomb;
import game.entity.prize.PotionShield;
import game.entity.prize.PotionSpeed;
import game.entity.prize.PowerPellet;
import gui.GamePanel;
import imagefactories.ImageFactory;

public abstract class Labyrinth {
	//TODO documentar
	
	public final static int WIDTH = 29;
	public final static int HEIGHT = 31;
	
	protected Zone playerSpawn;
	protected Zone enemySpawn;
	protected int dotCount;
	protected Game game;
	protected Zone[][] zones;
	
	//TODO falta agregar las zonas playerSpawn y los enemySpawn
	
	/**
	 * Crear un nuevo labyrinth.
	 * @param game asociado a este laberinto.
	 */
	protected Labyrinth(Game game) {
		this.game = game;
		zones = new Zone[WIDTH][HEIGHT];
	}
	
	/**
	 * @return el siguiente laberinto.
	 * @throws DataLoadException 
	 */
	public abstract Labyrinth nextLabyrinth() throws DataLoadException;
	
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
		Iterable<Entity> zoneEntities;
		
		for (int i = 0; i < zones.length; i++) {								// Recorre todas las zonas del laberinto
			for (int j = 0; j < zones[0].length; j++) {
				zoneEntities = zones[i][j].zoneEntities();						// Le pide a la zona todas sus entidades
				zoneEntities.forEach(entities::add);							// Agrega las entidades de la zona en la Set entities
			}
		}
		return entities;
	}
	
	/**
	 * @param x coordenada eje x.
	 * @param y coordenada eje y.
	 * @return la zona cuyas cordenadas a las pasadas por parametro.
	 * @throws NullZoneException si la zona es invalida
	 */
	public Zone getZone(float x, float y) throws NullZoneException {
		int xInt = Math.round(x);									// Si la parte decimal del número es menor que la mitad,
		int yInt = Math.round(y);									// redondear hacia abajo. En caso de que sea la mitad o mayor,
																	// redondea hacia arriba.
		
		if(zones[xInt][yInt] == null) throw new NullZoneException("Zona invalida.");
		
		return zones[xInt][yInt];
	}
	
	/**
	 * Decrementa en uno los dots actuales del laberinto. 
	 */
	public void removeDot() {
		dotCount--;
		if (dotCount <= 0) {
			try {
				game.winLevel();
			} catch (DataLoadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Retorna el constructor del dominio grafico que se utiliza en el juego
	 * @return ImageFactory.
	 */
	public ImageFactory getImageFactory() {
		return game.getImageFactory();
	}
	
	public Zone getEnemySpawn() {
		return enemySpawn;
	}
	
	public Zone getPlayerSpawn() {
		return playerSpawn;
	}
	
	
	/**
	 * Le quita a las entidades del laberinto su entidad grafica.
	 */
	public void clearEntities() {
		for (Entity e : entities()) {
			e.getGraphic().delete();
		}
	}
	
	/**
	 * Agrega el jugador al laberinto.
	 */
	public abstract void addPlayer();
	
	public void endGame() {
		game.endGame();
	}
	
	/**
	 * Setea los dots en el laberinto.
	 */
	public synchronized void fillWithDots() {
		for (int x = 0; x < zones.length; x++) {
			for(int y = 0; y < zones[0].length; y++) {				// Si es camino y no hay entidades, add dot
				if ((zones[x][y].getType() == ZoneType.PATH) && (zones[x][y].entities.isEmpty())) {
					new Dot(zones[x][y]);
					dotCount++;
				}
			}
		}
	}
	
	/**
	 * Setea el camino del laberinto.
	 * @param path direccion del camino concreto.
	 * @throws DataLoadException
	 */
	protected void setLabyrinth(String path) throws DataLoadException {
		LabyrinthLoader labLoader = new LabyrinthLoader(path);
		ZoneType[][] matrix = labLoader.load();
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				zones[x][y] = new Zone(this, x, y, matrix[x][y]);
				
				if(matrix[x][y] == ZoneType.SPAWN) {					//seteo atributo spawn
					enemySpawn = zones[x][y];
				}
			}
		}
	}
	
	/**
	 * Setea en el laberinto a los enemigos.
	 */
	protected void setEnemies() {
		Zone posSpawn = this.getEnemySpawn();
		
		RedEnemy    red 	= new RedEnemy		(posSpawn);
		BlueEnemy   blue 	= new BlueEnemy		(posSpawn, red);
		OrangeEnemy orange 	= new OrangeEnemy	(posSpawn);
		PinkEnemy   pink 	= new PinkEnemy		(posSpawn);
		
		game.getEnemyBrain().addEnemy(red);
		game.getEnemyBrain().addEnemy(blue);
		game.getEnemyBrain().addEnemy(orange);
		game.getEnemyBrain().addEnemy(pink);
	}

	/**
	 * Agrega una fruta 1 en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX coordenada x de la zona.
	 * @param posY coordenada y de la zona.
	 */
	protected void addFruit1(int posX, int posY) {
		new ConcreteFruit1(zones[posX][posY]);
	}
	
	/**
	 * Agrega una fruta 2 en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX coordenada x de la zona.
	 * @param posY coordenada y de la zona.
	 */
	protected void addFruit2(int posX, int posY) {
		new ConcreteFruit2(zones[posX][posY]);
	}
	
	/**
	 * Agrega un power pellet en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX coordenada x de la zona.
	 * @param posY coordenada y de la zona.
	 */
	protected void addPowerPellet(int posX, int posY) {
		new PowerPellet(zones[posX][posY]);
	}
	
	/**
	 * Agrega una pocion de velocidad en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX coordenada x de la zona.
	 * @param posY coordenada y de la zona.
	 */
	protected void addPotionSpeed(int posX, int posY) {
		new PotionSpeed(zones[posX][posY]);
	}
	
	/**
	 * Agrega una pocion de armadura en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX coordenada x de la zona.
	 * @param posY coordenada y de la zona.
	 */
	protected void addPotionShield(int posX, int posY) {
		new PotionShield(zones[posX][posY]);
	}
	
	/**
	 * Agrega una pocion de bomba en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX coordenada x de la zona.
	 * @param posY coordenada y de la zona.
	 */
	protected void addPotionBomb(int posX, int posY) {
		new PotionBomb(zones[posX][posY]);
	}
	
	/**
	 * @return la GUI asociada al juego.
	 */
	public GamePanel getGUI() {
		return game.getGUI();
	}
	
}
