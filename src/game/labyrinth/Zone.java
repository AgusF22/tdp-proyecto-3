package game.labyrinth;

import game.Direction;
import game.entity.Entity;

import java.util.Collection;
import java.util.LinkedList;

public class Zone {
	//TODO documentar
	
	protected Labyrinth labyrinth;
	protected ZoneType type;
	protected Collection<Entity> entities;
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
	
	public void removeEntity(Entity entity) {
		this.entities.remove(entity);
	}
	
	public void addEntity(Entity entity) {	 //TODO Excepcion? 
		this.entities.add(entity);
	}
	
	public Labyrinth getLabyrinth() {
		return labyrinth;
	}
	
	public Zone getAdjacent(Direction direction) {
		int adjacentX = this.x;
		int adjacentY = this.y;
		switch(direction) {
		case DOWN:
			adjacentY++;
			break;
		case LEFT:
			adjacentX--;
			break;
		case RIGHT:
			adjacentX++;
			break;
		case UP:
			adjacentY--;
			break;
		}
		return labyrinth.getZone(adjacentX, adjacentY);
	}
	
}
