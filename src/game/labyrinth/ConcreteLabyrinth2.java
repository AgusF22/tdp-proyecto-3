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
		
		.setSpawn(14, 15)									// Set zona SPAWN.
		
		.setDungeon(11, 13, 17, 13)								// Set zonas DUNGEON.
		.setDungeon(11, 14, 17, 14)
		
		.setDungeon(11, 15, 13, 15)
		.setDungeon(15, 15, 17, 15)
		
		
		.setPath(1, 1, 12, 1)									// Set zonas PATH.
		.setPath(16, 1, 27, 1)
		
		.setPath(2, 14, 8, 14)
		.setPath(20, 14, 26, 14)
		
		.setPath(6, 5, 18, 5)
		.setPath(6, 23, 18, 23)
		
		.setPath(6, 6, 6, 22)
		.setPath(18, 6, 18, 22)
		
		.setPath(2, 2, 2, 14)
		.setPath(28, 1, 28, 14)
		
		.setPath(1, 20, 6, 20)
		.setPath(22, 20, 27, 20)
		
		.setPath(1, 21, 1, 29)
		.setPath(27, 21, 27, 29)
		
		.setPath(12, 24, 12, 28)
		.setPath(16, 24, 16, 28)
		
		.setPath(9, 11, 19, 11)
		.setPath(9, 17, 19, 17)
		
		.setPath(9, 12, 9, 16)
		.setPath(19, 12, 19, 16)
		
		.setPath(14, 6, 14, 9)
		.setPath(14, 18, 23, 16) 
		
		.setPath(2, 29, 26, 29)
		
		.build();
		
		
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				zones[i][j] = new Zone(this, i, j, matrix[i][j]);
			}
		}
		
		this.setEntity();
	}
	
	private void setEntity() {
		
		zones[1][1].addEntity(Player.getInstance());				// TODO Set Player
		
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
