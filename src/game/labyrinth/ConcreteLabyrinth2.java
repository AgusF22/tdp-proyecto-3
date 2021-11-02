package game.labyrinth;

import game.Game;
import game.entity.Entity;
import game.entity.player.Player;
import game.entity.prize.Dot;

public class ConcreteLabyrinth2  extends Labyrinth {
	
	ZoneMatrixBuilder matrix;
	
	public ConcreteLabyrinth2(Game game) {
		super(game);
		
		ZoneType matrix[][] = new ZoneMatrixBuilder()
		
		.setSpawn(16, 14)									// Set zona SPAWN.
		
		.setDungeon(12, 10, 12, 18)								// Set zonas DUNGEON.
		.setDungeon(13, 10, 13, 18)
		.setDungeon(14, 10, 14, 18)								// Set zonas DUNGEON.
		.setDungeon(15, 10, 15, 18)
		
		.setDungeon(16, 10, 16, 13)
		.setDungeon(16, 15, 16, 18)
		
		
		.setPath(1, 1, 1, 12)
		.setPath(1, 16, 1, 27)
		
		.setPath(2, 1, 7, 1)
		.setPath(2, 27, 7, 27)
		
		.setPath(8, 1, 8, 5)
		.setPath(8, 23, 8, 27)
		
		.setPath(2, 6, 4, 6)
		.setPath(2, 22, 4, 22)
		
		.setPath(2, 12, 4, 12)
		.setPath(2, 16, 4, 16)
		
		.setPath(5, 2, 5, 26)
		
		.setPath(6, 6, 26, 6)
		.setPath(6, 22, 26, 22)
		
		.setPath(6, 9, 8, 9)
		.setPath(6, 19, 8, 19)
		
		.setPath(8, 10, 8, 12)
		.setPath(8, 16, 8, 18)
		
		.setPath(9, 12, 10, 12)
		.setPath(9, 16, 10, 16)
		
		.setPath(14, 1, 14, 5)
		.setPath(14, 23, 14, 27)
		
		.setPath(14, 7, 14, 8)
		.setPath(14, 20, 14, 21)
		
		.setPath(11, 9, 11, 19)
		.setPath(18, 9, 17, 18)
		
		.setPath(12, 9, 19, 9)
		.setPath(12, 19, 19, 19)
		
		.setPath(20, 1, 20, 5)
		.setPath(20, 23, 20, 27)
		
		.setPath(20, 7, 20, 12)
		.setPath(20, 16, 20, 21)
		
		.setPath(1, 1, 1, 12)
		.setPath(1, 1, 1, 12)
		
		.setPath(21, 1, 23, 1)
		.setPath(21, 27, 23, 27)
		
		.setPath(23, 2, 23, 3)
		.setPath(23, 25, 23, 26)
		
		.setPath(24, 3, 25, 3)
		.setPath(24, 25, 25, 25)
		
		.setPath(26, 1, 26, 5)
		.setPath(26, 23, 26, 27)
		
		.setPath(27, 1, 29, 1)
		.setPath(27, 27, 29, 27)
		
		.setPath(21, 12, 22, 12)
		.setPath(21, 16, 21, 16)
		
		.setPath(23, 7, 23, 21)
		
		.setPath(24, 9, 26, 9)
		.setPath(24, 19, 26, 19)
		
		.setPath(26, 10, 26, 12)
		.setPath(26, 16, 26, 18)
		
		.setPath(27, 12, 28, 12)
		.setPath(27, 16, 28, 16)
		
		.setPath(29, 2, 29, 26)
		
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
		
		@SuppressWarnings("unused")
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
		return new ConcreteLabyrinth3(game);
	}

}
