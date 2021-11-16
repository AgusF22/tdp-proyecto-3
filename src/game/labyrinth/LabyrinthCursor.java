package game.labyrinth;

import java.util.EnumSet;

/**
 * Tipo de dato que brinda funcionalidad para recorrer un laberinto.
 */
public class LabyrinthCursor {

	protected Zone zone;
	protected Direction direction;
	
	/**
	 * Crea una nueva instancia de cursor.
	 * @param zone Una zona.
	 * @param direction Una direccion.
	 */
	public LabyrinthCursor(Zone zone, Direction direction) {
		this.zone = zone;
		this.direction = direction;
	}
	
	/**
	 * Retorna la zona en la que se encuentra este cursor.
	 * @return La zona en la que se encuentra este cursor.
	 */
	public Zone getZone() {
		return zone;
	}
	
	/**
	 * Retorna la direccion en la que apunta este cursor.
	 * @return La direccion en la que apunta este cursor.
	 */
	public Direction getDirection() {
		return direction;
	}
	
	/**
	 * Mueve este cursor para que apunte a la siguiente zona, de acuerdo a la direccion actual.
	 */
	public void nextZone() {
		if(zone.getAdjacent(direction).getType() != ZoneType.WALL) {
			zone = zone.getAdjacent(direction);
		} else {
			if(zone.getAdjacent(direction.getCWDirection())
					.getType() != ZoneType.WALL) {
				zone = zone.getAdjacent(direction.getCWDirection());
				direction = direction.getCWDirection();
			} else {
				zone = zone.getAdjacent(direction.getCCWDirection());
				direction = direction.getCCWDirection();
			}
		}
	}
	
	/**
	 * Clona este cursor, le asigna una nueva direccion, y lo mueve en dicha direccion.
	 * @param direction La direccion para el nuevo cursor.
	 * @return El nuevo cursor, movido una vez; nulo, si la direccion pasada lleva a una pared.
	 */
	public LabyrinthCursor sendCloneTo(Direction direction) {
		LabyrinthCursor clone = null;
		if (zone.getAdjacent(direction).getType() != ZoneType.WALL) {
			clone = new LabyrinthCursor(zone, direction);
			clone.nextZone();
		}
		return clone;
	}
	
	/**
	 * Comprueba si este cursor se encuentra en una zona interseccion, es decir, una zona adyacente a mas de 2 caminos.
	 * @return True si la zona a la que apunta este cursor es interseccion, false si no.
	 */
	public boolean isInIntersection() {
		int connections = 0;
		EnumSet<Direction> directions = EnumSet.complementOf(EnumSet.of(direction));
		for(Direction d : directions) {
			if(zone.getAdjacent(d).getType() != ZoneType.WALL) {
				connections++;
			}
		}
		return connections > 1;
	}
	
}
