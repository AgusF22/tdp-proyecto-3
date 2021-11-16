package game.labyrinth;

import data.LabyrinthLoader;
import exceptions.DataLoadException;
import exceptions.NullZoneException;
import game.Game;
import game.entity.Entity;
import game.entity.enemy.BlueEnemy;
import game.entity.enemy.Enemy;
import game.entity.enemy.OrangeEnemy;
import game.entity.enemy.PinkEnemy;
import game.entity.enemy.RedEnemy;
import game.entity.player.Player;
import game.entity.prize.ConcreteFruit1;
import game.entity.prize.ConcretePotion1;
import game.entity.prize.ConcretePotion2;
import game.entity.prize.PowerPellet;

public class ConcreteLabyrinth1 extends Labyrinth {
	
	/**
	 * Crea una instancia concreta del laberinto 1.
	 * @param game asociado a este laberinto.
	 * @throws DataLoadException 
	 */
	public ConcreteLabyrinth1(Game game) throws DataLoadException {
		super(game);
		
		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth1Image(),
								game.getImageFactory().getLabyrinth1bgImage());
		
		LabyrinthLoader labLoader = new LabyrinthLoader("src/res/xml/labyrinth1.xml");
		
		ZoneType[][] matrix = labLoader.load();
		
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				zones[x][y] = new Zone(this, x, y, matrix[x][y]);		//seteo atributo spawn
				
				if(matrix[x][y] == ZoneType.SPAWN) {
					spawn = zones[x][y];
				}
			}
		}
		
		//************************************
				// TODO ¡¡¡¡BORRAR!!!!
//				for (int y = 0; y < matrix[0].length; y++) {
//					for (int x = 0; x < matrix.length; x++) {
//						System.out.format("[%2d,%2d " + zones[x][y].getType().toString().charAt(0) + "]", x, y);
//					}
//					System.out.println();
//				}
				//************************************
		
		this.setEntity();
	}
	
	/**
	 * Crea y setea en el mapa a todas las entidades del laberinto 1.
	 */
	private void setEntity() {
		
		//TODO descomentar para setear enemigos
		Zone posSpawn = this.getSpawn();									// ***Set Enemy***
		
		Enemy red 		= new RedEnemy		(posSpawn);
		Enemy blue 		= new BlueEnemy		(posSpawn, (RedEnemy) red);
		Enemy orange 	= new OrangeEnemy	(posSpawn);
		Enemy pink 		= new PinkEnemy		(posSpawn);
		
		red		.getGraphic().addToGUI(game.getGUI());
		blue	.getGraphic().addToGUI(game.getGUI());
		orange	.getGraphic().addToGUI(game.getGUI());
		pink	.getGraphic().addToGUI(game.getGUI());
		
		game.getEnemyBrain().addEnemy(red);
		game.getEnemyBrain().addEnemy(blue);
		game.getEnemyBrain().addEnemy(orange);
		game.getEnemyBrain().addEnemy(pink);
		
																			// ***Set Prize***
        Entity fruit 		= new ConcreteFruit1	(zones[14][17]);
        Entity powerPellet1 = new PowerPellet		(zones[1][1]);
        Entity powerPellet2 = new PowerPellet		(zones[27][1]);
        Entity powerPellet3 = new PowerPellet		(zones[1][29]);
        Entity powerPellet4 = new PowerPellet		(zones[27][29]);
        Entity potion1 		= new ConcretePotion1	(zones[6][14]);
        Entity potion2 		= new ConcretePotion2	(zones[22][14]);
        
        fruit		.getGraphic().addToGUI(game.getGUI());
        powerPellet1.getGraphic().addToGUI(game.getGUI());
        powerPellet2.getGraphic().addToGUI(game.getGUI());
        powerPellet3.getGraphic().addToGUI(game.getGUI());
        powerPellet4.getGraphic().addToGUI(game.getGUI());
        potion1		.getGraphic().addToGUI(game.getGUI());
        potion2		.getGraphic().addToGUI(game.getGUI());									
	}
	
	/**
	 * @return el siguiente laberinto concreto, si no existe retorna null.
	 * @throws DataLoadException 
	 */
	public Labyrinth nextLabyrinth() throws DataLoadException {
		return new ConcreteLabyrinth2(game);
	}

	@Override
	public void addPlayer() {
		zones[14][23].addEntity(Player.getInstance());				// ***Set Player***
		
		try {
			Player.getInstance().setZone(zones[14][23]);
		} catch (NullZoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Player.getInstance().getGraphic().addToGUI(game.getGUI());
	}
}
