package game.labyrinth;

import game.Game;

public class ConcreteLabyrinth2  extends Labyrinth {
	
	ZoneMatrixBuilder matrix;
	
	public ConcreteLabyrinth2(Game game) {
		super(game);
		matrix = new ZoneMatrixBuilder();
		
		//matrix.setSpawn(, );
		
	}
	
	public Labyrinth nextLabyrinth() {
		return new ConcreteLabyrinth3(game);
	}

}
