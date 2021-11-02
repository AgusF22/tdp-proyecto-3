package game;

/**
 * Modela una direccion.
 */
public enum Direction {
	
	UP		("DOWN"	),
	DOWN	("UP"	),
	RIGHT	("LEFT"	),
	LEFT	("RIGHT");
	
	private String opposite;
	
	/**
	 * Crea una nueva instancia de direccion.
	 * @param opposite La direccion opuesta a la nueva direccion.
	 */
	private Direction(String opposite) {
		this.opposite = opposite;
	}
	
	/**
	 * Retorna la direccion opuesta a esta direccion.
	 * @return La direccion opuesta a esta direccion.
	 */
	public Direction getOpposite() {
		return Direction.valueOf(opposite);
	}
	
}
