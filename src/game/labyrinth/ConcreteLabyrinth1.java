package game.labyrinth;

import game.Game;

public class ConcreteLabyrinth1 extends Labyrinth {
	
	ZoneMatrixBuilder matrix;
	
	public ConcreteLabyrinth1(Game game) {
		super(game);
		matrix = new ZoneMatrixBuilder();
		
		matrix.setSpawn(14, 15)									// Set zona SPAWN.
		
		
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
		
		.setPath(14, 6, 14, 9)//
		.setPath(14, 18, 23, 16) 
		
		.setPath(2, 29, 26, 29);
		
	}
	
	public Labyrinth nextLabyrinth() {
		return new ConcreteLabyrinth2(game);
	}
}

