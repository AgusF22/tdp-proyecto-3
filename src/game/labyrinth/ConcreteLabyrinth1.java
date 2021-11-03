package game.labyrinth;

import game.Game;
import game.entity.Entity;
import game.entity.player.Player;
import game.entity.prize.Dot;

public class ConcreteLabyrinth1 extends Labyrinth {
	
	public ConcreteLabyrinth1(Game game) {
		super(game);
		
		ZoneType matrix[][] = new ZoneMatrixBuilder()		// FIXME mover los corchetes a la declaracion de tipo -AF
		
		.setSpawn(16, 14)										// Set zona SPAWN.
		
		.setDungeon(10, 12, 18, 12)
		.setDungeon(10, 13, 18, 13)								// Set zonas DUNGEON.
		.setDungeon(10, 14, 18, 14)
		.setDungeon(11, 15, 18, 15)
		
		.setDungeon(11, 16, 13, 16)
		.setDungeon(13, 16, 18, 16)
		
		
		.setPath(1, 1, 1, 12)									// Set zonas PATH.
		.setPath(1, 16, 1, 27)
		
		.setPath(2, 12, 4, 12)									// Set zonas PATH.
		.setPath(2, 16, 4, 16)
		
		.setPath(2, 1, 14, 1)
		.setPath(2, 27, 14, 27)
		
		.setPath(14, 2, 14, 8)
		.setPath(20, 14, 26, 14)
		
		.setPath(5, 6, 5, 22)
		.setPath(23, 6, 23, 22)
		
		.setPath(6, 6, 13, 6)
		.setPath(15, 6, 22, 6)
		
		.setPath(6, 22, 13, 22)
		.setPath(15, 22, 22, 22)
		
		.setPath(20, 1, 20, 5)
		.setPath(20, 23, 20, 27)
		
		.setPath(21, 1, 29, 1)
		.setPath(21, 27, 29, 27)
		
		.setPath(24, 12, 28, 12)
		.setPath(24, 16, 28, 16)
		
		.setPath(11, 9, 11, 19)
		.setPath(17, 9, 17, 19)
		
		.setPath(12, 9, 16, 9)
		.setPath(12, 19, 16, 19)
		
		.setPath(6, 14, 10, 14)
		.setPath(18, 14, 22, 14) 
		
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
		
		@SuppressWarnings("unused")			// FIXME WHY?!?!?! revisar -AF
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
		return new ConcreteLabyrinth2(game);
	}
}
