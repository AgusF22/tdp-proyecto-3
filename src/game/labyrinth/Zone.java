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
	
	public void removeEntity(Entity entity) { //TODO Excepcion? ::: No, si la entidad no esta remove de list no hace nada y no hay problema -AF
		this.entities.remove(entity);
	}
	
	public void addEntity(Entity entity) {	 //TODO Excepcion? 
		this.entities.add(entity);
	}
	
	public Labyrinth getLabyrinth() {
		return labyrinth;
	}
	
	public Zone getAdjacent(Direction direction) {
		int x = this.x;
		int y = this.y;
		switch(direction) {
		case DOWN:
			y++;
			break;
		case LEFT:
			x--;
			break;
		case RIGHT:
			x++;
			break;
		case UP:
			y--;
			break;
		}
		return labyrinth.getZone(x, y);
	}
	
}
