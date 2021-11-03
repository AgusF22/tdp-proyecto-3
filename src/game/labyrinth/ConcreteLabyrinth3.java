package game.labyrinth;

import game.Game;
import game.entity.Entity;
import game.entity.player.Player;
import game.entity.prize.Dot;

public class ConcreteLabyrinth3  extends Labyrinth {
	
	public ConcreteLabyrinth3(Game game) {
		super(game);
		
		ZoneType matrix[][] = new ZoneMatrixBuilder()
				
		.setSpawn(16, 14)										// Set zona SPAWN.
		
		.setDungeon(12, 10, 12, 18)								// Set zonas DUNGEON.
		.setDungeon(13, 10, 13, 18)
		.setDungeon(14, 10, 14, 18)
		.setDungeon(15, 10, 15, 18)
		
		.setDungeon(16, 10, 16, 13)
		.setDungeon(16, 15, 16, 18)
		
		
		.setPath(1, 1, 1, 27)									// Set PATH
		
		.setPath(2, 1, 8, 1)
		.setPath(2, 27, 8, 27)
		
		.setPath(2, 6, 26, 6)
		.setPath(2, 22, 26, 22)
		
		.setPath(5, 2, 5, 5)
		.setPath(5, 23, 5, 26)
		
		.setPath(8, 2, 8, 5)
		.setPath(8, 23, 8, 26)
		
		.setPath(2, 14, 5, 14)
		
		.setPath(5, 7, 5, 21)
		
		.setPath(6, 9, 8, 9)
		.setPath(6, 19, 8, 19)
		
		.setPath(8, 10, 8, 18)
		
		.setPath(14, 1, 14, 5)
		.setPath(14, 23, 14, 27)
		
		.setPath(14, 7, 14, 8)
		.setPath(14, 20, 14, 21)
		
		.setPath(11, 9, 11, 19)
		.setPath(17, 10, 17, 18)
		
		.setPath(12, 9, 17, 9)
		.setPath(12, 19, 17, 19)
		
		.setPath(18, 12, 22, 12)
		.setPath(18, 16, 22, 16)
		
		.setPath(15, 1, 16, 1)
		.setPath(15, 27, 16, 27)
		
		.setPath(16, 2, 16, 3)
		.setPath(16, 25, 16, 26)
		
		.setPath(17, 3, 19, 3)
		.setPath(17, 25, 19, 25)
		
		.setPath(20, 2, 20, 5)
		.setPath(20, 23, 20, 26)
		
		.setPath(21, 1, 21, 2)
		.setPath(21, 26, 21, 27)
		
		.setPath(22, 1, 29, 1)
		.setPath(22, 27, 29, 27)
		
		.setPath(23, 2, 23, 5)
		.setPath(23, 23, 23, 26)
		
		.setPath(26, 2, 26, 5)
		.setPath(26, 23, 26, 26)
		
		.setPath(1, 1, 1, 1)
		.setPath(1, 1, 1, 1)
		
		.setPath(23, 7, 23, 21)
		
		.setPath(29, 2, 29, 8)
		.setPath(29, 20, 29, 26)
		
		.setPath(24, 9, 28, 9)
		.setPath(24, 19, 28, 19)
		
		.setPath(26, 10, 26, 18)
		
		.build();
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				zones[i][j] = new Zone(this, i, j, matrix[i][j]);
			}
		}
		
		this.setEntity();
	}
	
	private void setEntity() {

		zones[23][14].addEntity(Player.getInstance());				// TODO Set Player

		//TODO enemies

		// ***Set Prize***
		//TODO  Set Fruits
		//TODO  Set PowerPellet
		//TODO  Set Potions

		Entity dot = null;
		for (int i = 0; i < zones.length; i++) {					//	  Set dots
			for(int j = 0; j < zones[0].length; j++) {				// Si es camino y no hay entidades, add dot
				if ((zones[i][j].getType() == ZoneType.PATH) && (zones[i][j].entities.isEmpty())) {
					dot = new Dot(zones[i][j]);
					doCount++;
				}
			}
		}														
	}
	
	
	public Labyrinth nextLabyrinth() {
		return null;
	}
}
