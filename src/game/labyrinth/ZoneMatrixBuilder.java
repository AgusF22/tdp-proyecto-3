package game.labyrinth;

public class ZoneMatrixBuilder {
	
	private ZoneType matrix[][];
	
	protected ZoneMatrixBuilder() {
		matrix = new ZoneType[1][1];
	}
	
	protected ZoneMatrixBuilder setSpawn(int x, int y) {
		return this;
	}
	
	protected ZoneMatrixBuilder setPath(int x1, int y1, int x2, int y2) {
		return this;
	}
	
	protected ZoneMatrixBuilder setDungeon(int x1, int y1, int x2, int y2) {
		return this;
	}
	
	protected ZoneType[][] build() {
		return matrix;
	}
}
