package game.labyrinth;

public class ZoneMatrixBuilder {
	
	private ZoneType matrix[][];
	
	protected ZoneMatrixBuilder() {
		matrix = new ZoneType[Labyrinth.HEIGHT][Labyrinth.WIDTH];
	}
	
	protected ZoneMatrixBuilder setSpawn(int x, int y) {
		//TODO imp
		return this;
	}
	
	protected ZoneMatrixBuilder setPath(int x1, int y1, int x2, int y2) {
		//TODO imp
		return this;
	}
	
	protected ZoneMatrixBuilder setDungeon(int x1, int y1, int x2, int y2) {
		//TODO imp
		return this;
	}
	
	protected ZoneType[][] build() {
		//TODO imp
		return matrix;
	}
}
