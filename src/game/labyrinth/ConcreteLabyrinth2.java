package game.labyrinth;

import data.LabyrinthLoader;
import exceptions.DataLoadException;
import exceptions.NullZoneException;
import game.Direction;
import game.Game;
import game.entity.Entity;
import game.entity.enemy.BlueEnemy;
import game.entity.enemy.OrangeEnemy;
import game.entity.enemy.PinkEnemy;
import game.entity.enemy.RedEnemy;
import game.entity.player.Player;
import game.entity.prize.ConcreteFruit1;
import game.entity.prize.ConcretePotion1;
import game.entity.prize.ConcretePotion2;
import game.entity.prize.PowerPellet;

public class ConcreteLabyrinth2  extends Labyrinth {
	
	/**
	 * Crea una instancia concreta del laberinto 2.
	 * @param game asociado a este laberinto.
	 * @throws DataLoadException 
	 */
	public ConcreteLabyrinth2(Game game) throws DataLoadException {
		super(game);
		
		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth2Image(),
								game.getImageFactory().getLabyrinth2bgImage());
		
		LabyrinthLoader labLoader = new LabyrinthLoader("src/res/xml/labyrinth2.xml");
		
		ZoneType[][] matrix = labLoader.load();
		
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				zones[x][y] = new Zone(this, x, y, matrix[x][y]);		//seteo atributo spawn
				
				if(matrix[x][y] == ZoneType.SPAWN) {
					spawn = zones[x][y];
				}
			}
		}
		
		this.setEntity();
	}
	
	/**
	 * Crea y setea en el mapa a todas las entidades del laberinto 2.
	 */
	private void setEntity() {
		
		//TODO descomentar para setear enemigos
		Zone posSpawn = this.getSpawn();						// ***Set Enemy***
		
		Entity red = new RedEnemy(posSpawn);
		red.getGraphic().addToGUI(game.getGUI());

		Entity blue = new BlueEnemy(posSpawn, (RedEnemy) red);
		blue.getGraphic().addToGUI(game.getGUI());
		
		Entity orange = new OrangeEnemy(posSpawn);
		orange.getGraphic().addToGUI(game.getGUI());
		
		Entity pink = new PinkEnemy(posSpawn);
		pink.getGraphic().addToGUI(game.getGUI());
									

        Entity fruit = new ConcreteFruit1(zones[14][17]);			// ***Set Prize***
        fruit.getGraphic().addToGUI(game.getGUI());
        
        Entity powerPellet1 = new PowerPellet(zones[1][1]);
        powerPellet1.getGraphic().addToGUI(game.getGUI());
        Entity powerPellet2 = new PowerPellet(zones[27][1]);
        powerPellet2.getGraphic().addToGUI(game.getGUI());
        Entity powerPellet3 = new PowerPellet(zones[1][29]);
        powerPellet3.getGraphic().addToGUI(game.getGUI());
        Entity powerPellet4 = new PowerPellet(zones[27][29]);
        powerPellet4.getGraphic().addToGUI(game.getGUI());
        
        Entity potion1 = new ConcretePotion1(zones[6][14]);
        potion1.getGraphic().addToGUI(game.getGUI());
        Entity potion2 = new ConcretePotion2(zones[22][14]);
        potion2.getGraphic().addToGUI(game.getGUI());													
	}
	
	/**
	 * @return el siguiente laberinto concreto, si no existe retorna null.
	 * @throws DataLoadException 
	 */
	public Labyrinth nextLabyrinth() throws DataLoadException {
		return new ConcreteLabyrinth3(game);
	}

	@Override
	public void addPlayer() {
		Player player = Player.getInstance();
		player.getGraphic().delete();
        zones[14][23].addEntity(player);							// ***Set Player***
		try {
			player.setZone(zones[14][23]);
		} catch (NullZoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.attemptMovement(Direction.LEFT);
		player.getGraphic().addToGUI(game.getGUI());
	}

}
