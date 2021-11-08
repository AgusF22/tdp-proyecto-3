package game.labyrinth;

import game.Game;
import game.entity.Entity;
import game.entity.player.Player;
import game.entity.prize.ConcreteFruit2;
import game.entity.prize.ConcretePotion1;
import game.entity.prize.ConcretePotion2;
import game.entity.prize.Dot;
import game.entity.prize.PowerPellet;

public class ConcreteLabyrinth3  extends Labyrinth {
	
	/**
	 * Crea una instancia concreta del laberinto 3.
	 * @param game asociado a este laberinto.
	 */
	public ConcreteLabyrinth3(Game game) {
		super(game);

		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth3Image());
		
		ZoneType[][] matrix = new ZoneMatrixBuilder()

		.setSpawn(14, 16)										// Set zona SPAWN.

		.setDungeon(14, 11, 14, 11)								// Set zonas DUNGEON.
		.setDungeon(10, 12, 18, 12)
		.setDungeon(10, 13, 18, 13)
		.setDungeon(10, 14, 18, 14)
		.setDungeon(10, 15, 18, 15)
		
		.setDungeon(10, 16, 13, 16)
		.setDungeon(15, 16, 18, 16)
		
		.setPath(1, 1, 27, 1)									// Set PATH
		
		.setPath(1, 2, 1, 8)
		.setPath(27, 2, 27, 8)
		
		.setPath(6, 2, 6, 26)
		.setPath(22, 2, 22, 26)

		.setPath(2, 5, 5, 5)
		.setPath(23, 5, 26, 5)
		
		.setPath(2, 8, 5, 8)
		.setPath(23, 8, 26, 8)
		
		.setPath(14, 2, 14, 5)
		
		.setPath(7, 5, 21, 5)
		
		.setPath(9, 6, 9, 8)
		.setPath(19, 6, 19, 8)
		
		.setPath(10, 8, 18, 8)
		
		.setPath(1, 14, 5, 14)
		.setPath(23, 14, 27, 14)
		
		.setPath(7, 14, 8, 14)
		.setPath(20, 14, 21, 14)
		
		.setPath(9, 11, 19, 11)
		.setPath(10, 17, 18, 17)
		
		.setPath(9, 12, 9, 17)
		.setPath(19, 12, 19, 17)
		
		.setPath(12, 18, 12, 22)
		.setPath(16, 18, 16, 22)
		
		.setPath(1, 15, 1, 16)
		.setPath(27, 15, 27, 16)
		
		.setPath(2, 16, 3, 16)
		.setPath(25, 16, 26, 16)
		
		.setPath(3, 17, 3, 19)
		.setPath(25, 17, 25, 19)
		
		.setPath(2, 20, 5, 20)
		.setPath(23, 20, 26, 20)
		
		.setPath(1, 21, 2, 21)
		.setPath(26, 21, 27, 21)
		
		.setPath(1, 22, 1, 29)
		.setPath(27, 22, 27, 29)
		
		.setPath(2, 23, 5, 23)
		.setPath(23, 23, 26, 23)
		
		.setPath(2, 26, 5, 26)
		.setPath(23, 26, 26, 26)
		
		.setPath(7, 23, 21, 23)

		.setPath(2, 29, 8, 29)
		.setPath(20, 29, 26, 29)
		
		.setPath(9, 24, 9, 28)
		.setPath(19, 24, 19, 28)
		
		.setPath(10, 26, 18, 26)
		
		.build();
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				zones[x][y] = new Zone(this, x, y, matrix[x][y]);
			}
		}
		
		this.setEntity();
	}
	
	/**
	 * Crea y setea en el mapa a todas las entidades del laberinto 3.
	 */
	private void setEntity() {

		zones[14][23].addEntity(Player.getInstance());
		Player.getInstance().setZone(zones[14][23]);
        Player.getInstance().getGraphic().addToGUI(game.getGUI());

		//TODO descomentar para setear enemigos
//		Entity red = new RedEnemy(zones[14][16]);					// ***Set Enemy***
//		zones[14][16].addEntity(red);
//		red.getGraphic().addToGUI(game.getGUI());
//
//		Entity blue = new BlueEnemy(zones[14][16], (RedEnemy) red);
//		zones[14][16].addEntity(blue);
//		blue.getGraphic().addToGUI(game.getGUI());
//		
//		Entity orange = new OrangeEnemy(zones[14][16]);
//		zones[14][16].addEntity(orange);
//		orange.getGraphic().addToGUI(game.getGUI());
//		
//		Entity pink = new PinkEnemy(zones[14][16]);
//		zones[14][16].addEntity(pink);
//		pink.getGraphic().addToGUI(game.getGUI());

        Entity fruit = new ConcreteFruit2(zones[14][17]);			// ***Set Prize***
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

		for (int x = 0; x < zones.length; x++) {					// ***Set dots***
			for(int y = 0; y < zones[0].length; y++) {				// Si es camino y no hay entidades, add dot
				if ((zones[x][y].getType() == ZoneType.PATH) && (zones[x][y].entities.isEmpty())) {
					new Dot(zones[x][y]);
					doCount++;
				}
			}
		}
	}
	
	/**
	 * @return el siguiente laberinto concreto, si no existe retorna null.
	 */
	public Labyrinth nextLabyrinth() {
		return null;
	}
}
