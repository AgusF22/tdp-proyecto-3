package game.labyrinth;

import game.entity.Entity;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import exceptions.NullZoneException;

public class Zone {
	//TODO documentar
	
	protected Labyrinth labyrinth;
	protected ZoneType type;
	
	protected List<Entity> entities;
	
	protected int x;
	protected int y;
	
	/**
	 * Crea una nueva zona.
	 * @param lab laberinto asociado a esta zona. 
	 * @param x coordenada x de la zona.
	 * @param y coordenada y de la zona.
	 * @param type tipo de la zona.
	 */
	public Zone(Labyrinth lab, int x, int y, ZoneType type) {
		labyrinth = lab; 
		this.x = x;
		this.y = y;
		this.type = type;
		entities = new LinkedList<>();
	}
	
	/**
	 * @return el tipo de la zona que recibe el mensaje.
	 */
	public ZoneType getType() {
		return type;
	}
	
	/**
	 * @return coordenada x de la zona.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return coordenada y de la zona.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @return coleccion iterable de las entidades de la zona.
	 */
	public Iterable<Entity> zoneEntities() {
		return new ArrayList<>(entities);
	}
	
	/**
	 * Remueve la entidad pasada por parametro de la lista de entidades de la zona, si es que está.
	 * @param entity la entidad que se quiere remover.
	 */
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}
	
	/**
	 * Agrega la entidad pasada por parametro a la lista de entidades de la zona.
	 * @param entity la entidad que se quiere agregar.
	 */
	public void addEntity(Entity entity) {	 //TODO Excepcion? 
		entities.add(entity);
	}
	
	/**
	 * @return el laberinto asociado a esata zona.
	 */
	public Labyrinth getLabyrinth() {
		return labyrinth;
	}
	
	/**
	 * TODO ...
	 * @param direction
	 * @return
	 */
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
		
		try {
			return labyrinth.getZone(adjacentX, adjacentY);
		} catch (NullZoneException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
