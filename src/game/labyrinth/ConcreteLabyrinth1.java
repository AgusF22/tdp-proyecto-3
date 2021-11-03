package game.labyrinth;

import game.Game;
import game.entity.Entity;
import game.entity.player.Player;
import game.entity.prize.Dot;

public class ConcreteLabyrinth1 extends Labyrinth {
	
	public ConcreteLabyrinth1(Game game) {
		super(game);
		
		ZoneType[][] matrix = new ZoneMatrixBuilder()		// FIXME mover los corchetes a la declaracion de tipo -AF
		
		.setSpawn(14, 16)										// Set zona SPAWN.
		
		.setDungeon(12, 10, 12, 18)
		.setDungeon(13, 10, 13, 18)								// Set zonas DUNGEON.
		.setDungeon(14, 10, 14, 18)
		.setDungeon(15, 11, 15, 18)
		
		.setDungeon(16, 11, 16, 13)
		.setDungeon(16, 13, 16, 18)
		
		
		.setPath(1, 1, 12, 1)									// Set zonas PATH.
		.setPath(16, 1, 27, 1)
		//
		.setPath(12, 2, 12, 4)
		.setPath(16, 2, 16, 4)
		//
		.setPath(1, 2, 1, 14)
		.setPath(27, 2, 27, 14)
		//
		.setPath(2, 14, 8, 14)
		.setPath(14, 20, 14, 26)
		
		.setPath(6, 5, 22, 5)
		.setPath(6, 23, 22, 23)
		//
		.setPath(6, 6, 6, 13)
		.setPath(6, 15, 6, 22)
		//
		.setPath(22, 6, 2, 13)
		.setPath(22, 15, 22, 22)
		//
		.setPath(1, 20, 5, 20)
		.setPath(23, 20, 27, 20)
		//
		.setPath(1, 21, 1, 29)
		.setPath(27, 21, 27, 29)
		
		.setPath(12, 24, 12, 28)
		.setPath(16, 24, 16, 28)
		//
		.setPath(9, 11, 19, 11)
		.setPath(9, 17, 19, 17)
		//
		.setPath(9, 12, 9, 16)
		.setPath(19, 12, 19, 16)
		//
		.setPath(14, 6, 14, 10)
		.setPath(14, 18, 14, 22) 
		
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
		
		//TODO enemies
											
																	// ***Set Prize***
		//TODO  Set Fruits
		//TODO  Set PowerPellet
		//TODO  Set Potions
		
		Entity dot = null;
		for (int x = 0; x < zones.length; x++) {					//	  Set dots
			for(int y = 0; y < zones[0].length; y++) {				// Si es camino y no hay entidades, add dot
				if ((zones[x][y].getType() == ZoneType.PATH) && (zones[x][y].entities.isEmpty())) {
					dot = new Dot(zones[x][y]);
					doCount++;
				}
			}
		}														
	}
	
	public Labyrinth nextLabyrinth() {
		return new ConcreteLabyrinth2(game);
	}
}
