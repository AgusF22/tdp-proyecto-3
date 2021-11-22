package game.labyrinth;

/**
 * Clase que permite crear matrices de tipos de zonas. A ser utilizada para facilitar la creacion de laberintos.
 */
public class ZoneMatrixBuilder {
	
	private ZoneType[][] matrix;
	
	/**
	 * Crea un nuevo builder de matriz de tipos de zona.
	 */
	public ZoneMatrixBuilder() {
		matrix = new ZoneType[Labyrinth.WIDTH][Labyrinth.HEIGHT];
		
		for (int x = 0; x < matrix.length; x++) {
			for (int y = 0; y < matrix[0].length; y++) {
				matrix[x][y] = ZoneType.WALL;
			}
		}
	}
	
	/**
	 * Añade un tipo spawn en la coordenada dada.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 * @return Este builder.
	 */
	public ZoneMatrixBuilder setSpawn(int x, int y) {
		matrix[x][y] = ZoneType.SPAWN;
		return this;
	}
	
	/**
	 * Añade tipos path en el area rectangular delimitada por dos puntos.
	 * @param x1 Coordenada x del primer punto.
	 * @param y1 Coordenada y del primer punto.
	 * @param x2 Coordenada x del segundo punto.
	 * @param y2 Coordenada y del segundo punto.
	 * @return Este builder.
	 */
	public ZoneMatrixBuilder setPath(int x1, int y1, int x2, int y2) {
		int[] coords = {x1, y1, x2, y2};
		reorder(coords);
		for (int x = coords[0]; x <= coords[2]; x++) {
			for (int y = coords[1]; y <= coords[3]; y++) {
				if (matrix[x][y] == ZoneType.WALL) {
					matrix[x][y] = ZoneType.PATH;
				}
			}
		}
		return this;
	}
	
	/**
	 * Añade tipos dungeon en el area rectangular delimitada por dos puntos.
	 * @param x1 Coordenada x del primer punto.
	 * @param y1 Coordenada y del primer punto.
	 * @param x2 Coordenada x del segundo punto.
	 * @param y2 Coordenada y del segundo punto.
	 * @return Este builder.
	 */
	public ZoneMatrixBuilder setDungeon(int x1, int y1, int x2, int y2) {
		int[] coords = {x1, y1, x2, y2};
		reorder(coords);
		for (int x = coords[0]; x <= coords[2]; x++) {
			for (int y = coords[1]; y <= coords[3]; y++) {
				if (matrix[x][y] == ZoneType.WALL) {
					matrix[x][y] = ZoneType.DUNGEON;
				}
			}
		}
		return this;
	}
	
	/**
	 * Recibe un arreglo de coordenadas de la forma {x1, y1, x2, y2} y lo reordena de forma que x1 <= x2 y y1 <= y2.
	 * @param coords Un arreglo de coordenadas de la forma {x1, y1, x2, y2}.
	 */
	public void reorder(int[] coords) {
		int aux;
		if (coords[0] > coords[2]) {
			aux = coords[0];
			coords[0] = coords[2];
			coords[2] = aux;
		}
		if (coords[1] > coords[3]) {
			aux = coords[1];
			coords[1] = coords[3];
			coords[3] = aux;
		}
	}
	
	/**
	 * Construye y devuelve la matriz de tipos de zona.
	 * @return La matriz de tipos de zona.
	 */
	public ZoneType[][] build() {
		ZoneType[][] toReturn = new ZoneType[matrix.length][];
		int subArrLen = matrix[0].length;
		ZoneType[] auxArr;
		
		for (int i = 0; i < matrix.length; i++) {
			toReturn[i] = new ZoneType[subArrLen];
			auxArr = matrix[i];
			System.arraycopy(auxArr, 0, toReturn[i], 0, subArrLen);
		}
	
		return toReturn;
	}
	
}
