package game.labyrinth;

import game.Game;
import game.entity.player.Player;
import game.entity.prize.Dot;

public class ConcreteLabyrinth2  extends Labyrinth {
	
	public ConcreteLabyrinth2(Game game) {
		super(game);
		
		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth2Image());
		
		ZoneType[][] matrix = new ZoneMatrixBuilder()
		
		.setSpawn(14, 16)										// Set zona SPAWN.
		
		.setDungeon(10, 12, 18, 12)								// Set zonas DUNGEON.
		.setDungeon(10, 13, 18, 13)
		.setDungeon(10, 14, 18, 14)
		.setDungeon(10, 15, 18, 15)

		.setDungeon(10, 16, 13, 16)
		.setDungeon(15, 16, 18, 16)
		
		
		.setPath(1, 1, 12, 1)									// Set PATH
		.setPath(16, 1, 27, 1)
		
		.setPath(1, 2, 1, 7)
		.setPath(27, 2, 27, 7)
		
		.setPath(1, 8, 5, 8)
		.setPath(23, 8, 27, 8)
		
		.setPath(6, 2, 6, 4)
		.setPath(22, 2, 22, 4)
		
		.setPath(12, 2, 12, 4)
		.setPath(16, 2, 16, 4)

		.setPath(2, 5, 26, 5)
		
		.setPath(6, 6, 6, 26)
		.setPath(22, 6, 22, 26)

		.setPath(9, 6, 9, 8)
		.setPath(19, 6, 19, 8)
		
		.setPath(10, 8, 12, 8)
		.setPath(16, 8, 18, 8)
		
		.setPath(12, 9, 12, 10)
		.setPath(16, 9, 16, 10)
		
		.setPath(1, 14, 5, 14)
		.setPath(23, 14, 27, 14)
		
		.setPath(7, 14, 8, 14)
		.setPath(20, 14, 21, 14)
		
		.setPath(9, 11, 19, 11)
		.setPath(9, 18, 18, 17)
		
		.setPath(9, 12, 9, 19)
		.setPath(19, 12, 19, 19)
		
		.setPath(1, 20, 5, 20)
		.setPath(23, 20, 27, 20)
		
		.setPath(7, 20, 12, 20)
		.setPath(16, 20, 21, 20)
		
		.setPath(1, 21, 1, 23)
		.setPath(27, 21, 27, 23)
		
		.setPath(2, 23, 3, 23)
		.setPath(25, 23, 26, 23)
		
		.setPath(3, 24, 3, 25)
		.setPath(25, 24, 25, 25)
		
		.setPath(1, 26, 5, 26)
		.setPath(23, 26, 27, 26)
		
		.setPath(1, 27, 1, 29)
		.setPath(27, 27, 27, 29)
		
		.setPath(12, 21, 12, 22)
		.setPath(16, 21, 16, 21)
		
		.setPath(7, 23, 21, 23)
		
		.setPath(9, 24, 9, 26)
		.setPath(19, 24, 19, 26)
		
		.setPath(10, 26, 12, 26)
		.setPath(16, 26, 18, 26)
		
		.setPath(12, 27, 12, 28)
		.setPath(16, 27, 16, 28)
		
		.setPath(2, 29, 26, 29)
		
		.build();
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				zones[x][y] = new Zone(this, x, y, matrix[x][y]);
			}
		}
		
		this.setEntity();
	}
	
	private void setEntity() {

		zones[14][23].addEntity(Player.getInstance());				// TODO Set Player
		Player.getInstance().setZone(zones[14][23]);
        Player.getInstance().getGraphic().addToGUI(game.getGUI());
		//TODO enemies

		// ***Set Prize***
		//TODO  Set Fruits
		//TODO  Set PowerPellet
		//TODO  Set Potions

		for (int x = 0; x < zones.length; x++) {					//	  Set dots
			for(int y = 0; y < zones[0].length; y++) {				// Si es camino y no hay entidades, add dot
				if ((zones[x][y].getType() == ZoneType.PATH) && (zones[x][y].entities.isEmpty())) {
					new Dot(zones[x][y]);
					doCount++;
				}
			}
		}														
	}
	
	public Labyrinth nextLabyrinth() {
		return new ConcreteLabyrinth3(game);
	}

}
