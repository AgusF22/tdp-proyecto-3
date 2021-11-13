package game.labyrinth;

import data.LabyrinthLoader;
import exceptions.DataLoadException;
import game.Game;
import game.entity.Entity;
import game.entity.player.Player;
import game.entity.prize.ConcreteFruit1;
import game.entity.prize.ConcretePotion1;
import game.entity.prize.ConcretePotion2;
import game.entity.prize.Dot;
import game.entity.prize.PowerPellet;

public class ConcreteLabyrinth1 extends Labyrinth {
	
	/**
	 * Crea una instancia concreta del laberinto 1.
	 * @param game asociado a este laberinto.
	 * @throws DataLoadException 
	 */
	public ConcreteLabyrinth1(Game game) throws DataLoadException {
		super(game);
		
		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth1Image());
		
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
		for (int y = 0; y < matrix[0].length; y++) {
			for (int x = 0; x < matrix.length; x++) {
				System.out.print("[ "+zones[x][y].getType().toString().charAt(0)+" ] ");
			}
			System.out.println();
		}
		//************************************
		
		this.setEntity();
	}
	
	/**
	 * Crea y setea en el mapa a todas las entidades del laberinto 1.
	 */
	private void setEntity() {
		
		zones[14][23].addEntity(Player.getInstance());				// ***Set Player***
		Player.getInstance().setZone(zones[14][23]);
		Player.getInstance().getGraphic().addToGUI(game.getGUI());
		
									
		//TODO descomentar para setear enemigos
		Zone posSpawn = this.getSpawn();							// ***Set Enemy***
		
		Entity red = new RedEnemy(posSpawn);
		red.getGraphic().addToGUI(game.getGUI());

		Entity blue = new BlueEnemy(posSpawn, (RedEnemy) red);
		blue.getGraphic().addToGUI(game.getGUI());
		
		Entity orange = new OrangeEnemy(posSpawn);
		orange.getGraphic().addToGUI(game.getGUI());
		
		Entity pink = new PinkEnemy(posSpawn);
		pink.getGraphic().addToGUI(game.getGUI());
		
																	// ***Set Prize***
        Entity fruit = new ConcreteFruit1(zones[14][17]);
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
        
        
		Entity dot;													// ***Set dots***
		for (int x = 0; x < zones.length; x++) {
			for(int y = 0; y < zones[0].length; y++) {				// Si es camino y no hay entidades, add dot
				if ((zones[x][y].getType() == ZoneType.PATH) && (zones[x][y].entities.isEmpty())) {
					dot = new Dot(zones[x][y]);
					dot.getGraphic().addToGUI(game.getGUI());
					doCount++;
				}
			}
		}														
	}
	
	/**
	 * @return el siguiente laberinto concreto, si no existe retorna null.
	 * @throws DataLoadException 
	 */
	public Labyrinth nextLabyrinth() throws DataLoadException {
		return new ConcreteLabyrinth2(game);
	}
}
