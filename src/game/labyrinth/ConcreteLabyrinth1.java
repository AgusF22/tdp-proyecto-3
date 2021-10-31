package game.labyrinth;

import game.Game;

public class ConcreteLabyrinth1 extends Labyrinth {
	
	ZoneMatrixBuilder matrix;
	
	public ConcreteLabyrinth1(Game game) {
		super(game);
		matrix = new ZoneMatrixBuilder();
		
		matrix.setSpawn(14, 15);									// Set zona SPAWN.
		
		
		matrix.setDungeon(11, 13, 17, 13);							// Set zonas DUNGEON.
		matrix.setDungeon(11, 14, 17, 14);
		
		matrix.setDungeon(11, 15, 13, 15);
		matrix.setDungeon(15, 15, 17, 15);
		
		
		matrix.setPath(1, 1, 12, 1);								// Set zonas PATH.
		matrix.setPath(16, 1, 27, 1);
		
		matrix.setPath(2, 14, 8, 14);
		matrix.setPath(20, 14, 26, 14);
		
		matrix.setPath(6, 5, 18, 5);
		matrix.setPath(6, 23, 18, 23);
		
		matrix.setPath(6, 6, 6, 22);
		matrix.setPath(18, 6, 18, 22);
		
		matrix.setPath(2, 2, 2, 14);
		matrix.setPath(28, 1, 28, 14);
		
		matrix.setPath(1, 20, 6, 20);
		matrix.setPath(22, 20, 27, 20);
		
		matrix.setPath(1, 21, 1, 29);
		matrix.setPath(27, 21, 27, 29);
		
		matrix.setPath(12, 24, 12, 28);
		matrix.setPath(16, 24, 16, 28);
		
		matrix.setPath(9, 11, 19, 11);
		matrix.setPath(9, 17, 19, 17);
		
		matrix.setPath(9, 12, 9, 16);
		matrix.setPath(19, 12, 19, 16);
		
		matrix.setPath(2, 29, 26, 29);
		
	}
	
	public Labyrinth nextLabyrinth() {
		return new ConcreteLabyrinth2(game);
	}
}

