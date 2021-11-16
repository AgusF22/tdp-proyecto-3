package game.labyrinth;

import data.LabyrinthLoader;
import exceptions.DataLoadException;
import game.Game;
import game.entity.Entity;
import game.entity.enemy.BlueEnemy;
import game.entity.enemy.OrangeEnemy;
import game.entity.enemy.PinkEnemy;
import game.entity.enemy.RedEnemy;
import game.entity.prize.ConcreteFruit1;
import game.entity.prize.ConcreteFruit2;
import game.entity.prize.PotionShield;
import game.entity.prize.PotionSpeed;
import game.entity.prize.PowerPellet;

public abstract class LabyrinthAux extends Labyrinth {

	protected LabyrinthAux(Game game) {
		super(game);
		// TODO Auto-generated constructor stub
	}
	
	public void setLabyrinth(String path) throws DataLoadException {
		LabyrinthLoader labLoader = new LabyrinthLoader(path);
		ZoneType[][] matrix = labLoader.load();
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				zones[x][y] = new Zone(this, x, y, matrix[x][y]);
				
				if(matrix[x][y] == ZoneType.SPAWN) {					//seteo atributo spawn
					spawn = zones[x][y];
				}
			}
		}
	}
	
	public void setEnemies() {
		Zone posSpawn = this.getSpawn();									// ***Set Enemy***
		
		RedEnemy    red 	= new RedEnemy		(posSpawn);
		BlueEnemy   blue 	= new BlueEnemy		(posSpawn, red);
		OrangeEnemy orange 	= new OrangeEnemy	(posSpawn);
		PinkEnemy   pink 	= new PinkEnemy		(posSpawn);
		
		red		.getGraphic().addToGUI(game.getGUI());
		blue	.getGraphic().addToGUI(game.getGUI());
		orange	.getGraphic().addToGUI(game.getGUI());
		pink	.getGraphic().addToGUI(game.getGUI());
		
		game.getEnemyBrain().addEnemy(red);
		game.getEnemyBrain().addEnemy(blue);
		game.getEnemyBrain().addEnemy(orange);
		game.getEnemyBrain().addEnemy(pink);
	}

	/**
	 * 
	 * @param posX
	 * @param posY
	 */
	public void addFruit1(int posX, int posY) {
		Entity fruit = new ConcreteFruit1(zones[posX][posY]);
		fruit.getGraphic().addToGUI(game.getGUI());
	}
	
	/**
	 * 
	 * @param posX
	 * @param posY
	 */
	public void addFruit2(int posX, int posY) {
		Entity fruit = new ConcreteFruit2(zones[posX][posY]);
		fruit.getGraphic().addToGUI(game.getGUI());
	}
	
	public void addPowerPellet(int posX, int posY) {
		Entity powerPellet = new PowerPellet(zones[posX][posY]);
		powerPellet.getGraphic().addToGUI(game.getGUI());
	}
	
	public void addPotionSpeed(int posX, int posY) {
		Entity potionSpeed = new PotionSpeed(zones[posX][posY]);
		potionSpeed.getGraphic().addToGUI(game.getGUI());
	}
	
	public void addPotionShield(int posX, int posY) {
		Entity potionShield = new PotionShield(zones[posX][posY]);
		potionShield.getGraphic().addToGUI(game.getGUI());
	}
	
	@Override
	public Labyrinth nextLabyrinth() throws DataLoadException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPlayer() {
		// TODO Auto-generated method stub
		
	}
}
