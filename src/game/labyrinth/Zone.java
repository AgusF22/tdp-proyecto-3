package game.labyrinth;

import game.entity.Entity;
import imageFactories.ImageFactory;

import java.util.LinkedList;
import java.util.List;

public class Zone {
	//TODO documentar
	
	protected Labyrinth labyrinth;
	protected ZoneType type;
	protected List<Entity> entities; //TODO cambiar coleccion
	protected int x;
	protected int y;
	
	public Zone(Labyrinth lab, int x, int y, ZoneType type) {
		labyrinth = lab; 
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
	
	public Iterable<Entity> zoneEntities() {
		return entities;
	}
	
	public void removeEntity(Entity entity) { //TODO Excepcion?
		this.entities.remove(entity);
	}
	
	public void addEntity(Entity entity) {	 //TODO Excepcion?
		this.entities.add(entity);
	}
	
	public Labyrinth getLabyrinth() {
		return labyrinth;
	}
}
