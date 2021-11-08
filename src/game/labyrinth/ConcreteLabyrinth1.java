package game.labyrinth;

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
import game.entity.prize.Dot;
import game.entity.prize.PowerPellet;

public class ConcreteLabyrinth1 extends Labyrinth {
	
	/**
	 * Crea una instancia concreta del laberinto 1.
	 * @param game asociado a este laberinto.
	 */
	public ConcreteLabyrinth1(Game game) {
		super(game);
		
		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth1Image());
		
		ZoneType[][] matrix = new ZoneMatrixBuilder()
			
		.setSpawn(14, 16)										// Set zona SPAWN.
		
		.setDungeon(14, 11, 14, 11)								// Set zonas DUNGEON.
		.setDungeon(12, 10, 12, 18)
		.setDungeon(13, 10, 13, 18)
		.setDungeon(14, 10, 14, 18)
		.setDungeon(15, 11, 15, 18)
		
		.setDungeon(16, 11, 16, 13)
		.setDungeon(16, 13, 16, 18)
		
		.setPath(1, 1, 12, 1)									// Set zonas PATH.
		.setPath(16, 1, 27, 1)
		
		.setPath(12, 2, 12, 4)
		.setPath(16, 2, 16, 4)
		
		.setPath(1, 2, 1, 14)
		.setPath(27, 2, 27, 14)
		
		.setPath(2, 14, 8, 14)
		.setPath(14, 20, 14, 23)
		
		.setPath(6, 5, 22, 5)
		.setPath(6, 23, 22, 23)
		
		.setPath(6, 6, 6, 13)
		.setPath(6, 15, 6, 22)

		.setPath(22, 6, 22, 13)
		.setPath(22, 15, 22, 22)
		
		.setPath(1, 20, 5, 20)
		.setPath(23, 20, 27, 20)

		.setPath(1, 21, 1, 29)
		.setPath(27, 21, 27, 29)
		
		.setPath(12, 24, 12, 28)
		.setPath(16, 24, 16, 28)
		
		.setPath(9, 11, 19, 11)
		.setPath(9, 17, 19, 17)

		.setPath(9, 12, 9, 16)
		.setPath(19, 12, 19, 16)
		
		.setPath(14, 6, 14, 10)
		.setPath(14, 18, 14, 22) 
		
		.setPath(2, 29, 26, 29)
		.setPath(20, 14, 26, 14)
		
		.build();
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				zones[x][y] = new Zone(this, x, y, matrix[x][y]);
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
//		Entity red = new RedEnemy(zones[14][16]);					// ***Set Enemy***
//		red.getGraphic().addToGUI(game.getGUI());
//
//		Entity blue = new BlueEnemy(zones[14][16], (RedEnemy) red);
//		blue.getGraphic().addToGUI(game.getGUI());
//		
//		Entity orange = new OrangeEnemy(zones[14][16]);
//		orange.getGraphic().addToGUI(game.getGUI());
//		
//		Entity pink = new PinkEnemy(zones[14][16]);
//		pink.getGraphic().addToGUI(game.getGUI());
		
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
	 */
	public Labyrinth nextLabyrinth() {
		return new ConcreteLabyrinth2(game);
	}
}
