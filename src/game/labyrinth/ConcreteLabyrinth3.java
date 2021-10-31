package game.labyrinth;

import game.Game;

public class ConcreteLabyrinth3  extends Labyrinth {
	
	ZoneMatrixBuilder matrix;
	
	public ConcreteLabyrinth3(Game game) {
		super(game);
		matrix = new ZoneMatrixBuilder();
		
		//matrix.setSpawn(, );
		
	}
	
	public Labyrinth nextLabyrinth() {
		return null;
	}
}
