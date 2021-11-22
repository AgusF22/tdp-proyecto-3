package game.labyrinth;

import java.util.HashSet;
import java.util.Set;

import data.LabyrinthLoader;
import exceptions.DataLoadException;
import exceptions.InvalidZoneException;
import game.Game;
import game.entity.Entity;
import game.entity.enemy.BlueEnemy;
import game.entity.enemy.OrangeEnemy;
import game.entity.enemy.PinkEnemy;
import game.entity.enemy.RedEnemy;
import game.entity.prize.*;
import gui.GamePanel;
import imagefactories.ImageFactory;

/**
 * Modela un laberinto abstracto.
 */
public abstract class Labyrinth {
	
	public static final int WIDTH = 29;
	public static final int HEIGHT = 31;
	
	protected Zone playerSpawn;
	protected Zone enemySpawn;
	protected int dotCount;
	protected Game game;
	protected Zone[][] zones;
	
	/**
	 * Crea un nuevo laberinto.
	 * @param game Juego asociado al nuevo laberinto.
	 */
	protected Labyrinth(Game game) {
		this.game = game;
		zones = new Zone[WIDTH][HEIGHT];
	}
	
	/**
	 * Setea el camino del laberinto.
	 * @param path direccion del camino concreto.
	 * @throws DataLoadException Si ocurre un error al cargar el layout del laberinto.
	 */
	protected void setLabyrinth(String path) throws DataLoadException {
		LabyrinthLoader labLoader = new LabyrinthLoader(path);
		ZoneType[][] matrix = labLoader.load();
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				zones[x][y] = new Zone(this, x, y, matrix[x][y]);
				if(matrix[x][y] == ZoneType.SPAWN) {
					enemySpawn = zones[x][y];
				}
			}
		}
	}
	
	/**
	 * Crea y setea todas las entidades del laberinto.
	 */
	protected abstract void setEntities();
	
	/**
	 * Agrega el jugador al laberinto.
	 */
	public abstract void addPlayer();
	
	/**
	 * Setea a los enemigos en el laberinto.
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
	 * @param posX Coordenada x de la zona.
	 * @param posY Coordenada y de la zona.
	 */
	protected void addFruit1(int posX, int posY) {
		new ConcreteFruit1(zones[posX][posY]);
	}
	
	/**
	 * Agrega una fruta 2 en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX Coordenada x de la zona.
	 * @param posY Coordenada y de la zona.
	 */
	protected void addFruit2(int posX, int posY) {
		new ConcreteFruit2(zones[posX][posY]);
	}
	
	/**
	 * Agrega una fruta 3 en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX Coordenada x de la zona.
	 * @param posY Coordenada y de la zona.
	 */
	protected void addFruit3(int posX, int posY) {
		new ConcreteFruit3(zones[posX][posY]);
	}
	
	/**
	 * Agrega un power pellet en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX Coordenada x de la zona.
	 * @param posY Coordenada y de la zona.
	 */
	protected void addPowerPellet(int posX, int posY) {
		new PowerPellet(zones[posX][posY]);
	}
	
	/**
	 * Agrega una pocion de velocidad en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX Coordenada x de la zona.
	 * @param posY Coordenada y de la zona.
	 */
	protected void addPotionSpeed(int posX, int posY) {
		new PotionSpeed(zones[posX][posY]);
	}
	
	/**
	 * Agrega una pocion de armadura en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX Coordenada x de la zona.
	 * @param posY Coordenada y de la zona.
	 */
	protected void addPotionShield(int posX, int posY) {
		new PotionShield(zones[posX][posY]);
	}
	
	/**
	 * Agrega una pocion de bomba en la zona correspondiente a las coordenadas pasadas por parametro.
	 * @param posX Coordenada x de la zona.
	 * @param posY Coordenada y de la zona.
	 */
	protected void addPotionBomb(int posX, int posY) {
		new PotionBomb(zones[posX][posY]);
	}
	
	/**
	 * Setea los dots en el laberinto.
	 */
	public synchronized void fillWithDots() {
		for (int x = 0; x < zones.length; x++) {
			for(int y = 0; y < zones[0].length; y++) {						// Si es camino y no hay entidades, add dot
				if ((zones[x][y].getType() == ZoneType.PATH)
							&& (zones[x][y].entities.isEmpty())) {
					new Dot(zones[x][y]);
					dotCount++;
				}
			}
		}
	}
	
	/**
	 * Remueve todas las entidades graficas de las entidades del laberinto.
	 */
	public void clearEntities() {
		for (Entity e : entities()) {
			e.getGraphic().delete();
		}
	}
	
	/**
	 * Retorna el proximo laberinto.
	 * @return El proximo laberinto, null si este es el ultimo laberinto.
	 * @throws DataLoadException Si ocurre un error durante la carga del proximo laberinto.
	 */
	public abstract Labyrinth nextLabyrinth() throws DataLoadException;
	
	/**
	 * Devuelve una coleccion iterable con todas las entidades de este laberinto.
	 * @return Una coleccion iterable con todas las entidades de este laberinto.
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
	 * Retorna la zona de este laberinto que se encuentra en las coordenadas dadas.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 * @return La zona de este laberinto que se encuentra en las coordenadas dadas.
	 * @throws InvalidZoneException Si las coordenadas pasadas como parametro no corresponden a una zona valida.
	 */
	public Zone getZone(float x, float y) throws InvalidZoneException {
		int xInt = Math.round(x);
		int yInt = Math.round(y);
		
		if(xInt < 0 || WIDTH <= xInt || yInt < 0 || HEIGHT <= yInt) {
			throw new InvalidZoneException("Error: se intento acceder a una zona fuera de los limites del laberinto");
		}
		
		return zones[xInt][yInt];
	}
	
	/**
	 * Retorna la zona en la que spawnean los enemigos.
	 * @return La zona en la que spawnean los enemigos.
	 */
	public Zone getEnemySpawn() {
		return enemySpawn;
	}
	
	/**
	 * Retorna la zona en la que spawnea el jugador.
	 * @return La zona en la que spawnea el jugador.
	 */
	public Zone getPlayerSpawn() {
		return playerSpawn;
	}
	
	/**
	 * Retorna la fabrica de imagenes del juago.
	 * @return La fabrica de imagenes del juago.
	 */
	public ImageFactory getImageFactory() {
		return game.getImageFactory();
	}
	
	/**
	 * Retorna la gui del juego.
	 * @return La gui asociada al juego.
	 */
	public GamePanel getGUI() {
		return game.getGUI();
	}
	
	/**
	 * Incremente los puntos del juego.
	 * @param p Cantidad de puntos a incrementar.
	 */	
	public void addPoints(int p) {
		game.addPoints(p);
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
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * Notifica el fin del juego.
	 */
	public void endGame() {
		game.endGame();
	}
	
}
