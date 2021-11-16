package game.labyrinth;

import java.util.HashMap;
import java.util.Map;

/**
 * Modela una direccion.
 */
public enum Direction {
	
	UP		(0),
	RIGHT	(1),
	DOWN	(2),
	LEFT	(3);
	
	private static Map<Integer, Direction> map;
	private int id;
	
	static {
		map = new HashMap<>(4);
		for(Direction d : Direction.values()) {
			map.put(d.id, d);
		}
	}
	
	/**
	 * Crea una nueva instancia de direccion.
	 * @param opposite La direccion opuesta a la nueva direccion.
	 */
	private Direction(int id) {
		this.id = id;
	}
	
	/**
	 * Retorna la direccion opuesta a esta direccion.
	 * @return La direccion opuesta a esta direccion.
	 */
	public Direction getOpposite() {
		return map.get((this.id + 2) % 4);
	}
	
	/**
	 * Retorna la direccion que se encuantra 90 grados en sentido horario de esta direccion.
	 * @return La direccion que se encuantra 90 grados en sentido horario de esta direccion.
	 */
	public Direction getCWDirection() {
		return map.get((this.id + 1) % 4);
	}
	
	/**
	 * Returna la direccion que se encuantra 90 grados en sentido antihorario de esta direccion.
	 * @return La direccion que se encuantra 90 grados en sentido antihorario de esta direccion.
	 */
	public Direction getCCWDirection() {
		return map.get((this.id + 3) % 4);
	}
	
}
