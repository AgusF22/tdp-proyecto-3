package game.labyrinth;

import game.entity.Entity;

import java.util.LinkedList;
import java.util.List;

public class Zone {
	//TODO documentar
	
	protected Labyrinth labyrinth;
	protected ZoneType type;
	protected List<Entity> entities; //TODO cambiar coleccion
	protected int x;
	protected int y;
	
	public Zone(int x, int y, ZoneType type) {
		this.x = x;
		this.y = y;
		this.type = type;
		entities = new LinkedList<>();
	}
	
	public ZoneType getType() {
		return type;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void removeDot() {
		//TODO imp
	}
	
	public Iterable zoneEntities() {
		return entities;
	}
	
	public void removeEntity(Entity entities) {
		
	}
	
	public void addEntity(Entity entity) {
		
	}
	
	/**
	 * Consulta la zona correspondiente a las coordenadas
	 * @param x Float
	 * @param y Float
	 * @return Zone
	 */
	public Zone getZone(Float x, Float y) {
		//TODO imp , recordar que tiene que redondear los numeros es su responsabilidad.
		return null;
	}
}
