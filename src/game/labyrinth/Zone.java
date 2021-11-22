package game.labyrinth;

import game.entity.Entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import exceptions.InvalidZoneException;

/**
 * Modela una zona del laberinto.
 */
public class Zone {
	
	protected Labyrinth labyrinth;
	protected ZoneType type;
	
	protected Set<Entity> entities;
	
	protected int x;
	protected int y;
	
	/**
	 * Crea una nueva zona.
	 * @param lab El laberinto a asociar a esta zona. 
	 * @param x Coordenada x para la nueva zona.
	 * @param y Coordenada y para la nueva zona.
	 * @param type Tipo de la nueva zona.
	 */
	public Zone(Labyrinth lab, int x, int y, ZoneType type) {
		labyrinth = lab; 
		this.x = x;
		this.y = y;
		this.type = type;
		entities = new HashSet<>();
	}
	
	/**
	 * Retorna el tipo de esta zona.
	 * @return el tipo de esta zona.
	 */
	public ZoneType getType() {
		return type;
	}
	
	/**
	 * Retorna la coordenada x de esta zona.
	 * @return La coordenada x de esta zona.
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Retorna la coordenada y de esta zona.
	 * @return La coordenada y de esta zona.
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Retorna una coleccion iterable con las entidades de esta zona.
	 * @return Coleccion iterable con las entidades de esta zona.
	 */
	public Iterable<Entity> zoneEntities() {
		return new ArrayList<>(entities);
	}
	
	/**
	 * Remueve la entidad pasada como parametro de la lista de entidades de la zona.
	 * @param entity La entidad a remover.
	 */
	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}
	
	/**
	 * Agrega la entidad pasada por parametro a la lista de entidades de la zona.
	 * @param entity la entidad que se quiere agregar.
	 */
	public void addEntity(Entity entity) {
		entities.add(entity);
	}
	
	/**
	 * Retorna el laberinto en el que se encuentra esta zona.
	 * @return El laberinto en el que se encuentra esta zona.
	 */
	public Labyrinth getLabyrinth() {
		return labyrinth;
	}
	
	/**
	 * Retorna la zona adjacente a esta en la direccion indicada.
	 * @param direction Una direccion.
	 * @return La zona adjacente a esta en la direccion indicada, nulo si se sale de los limites del laberinto.
	 */
	public Zone getAdjacent(Direction direction) {
		Zone toReturn = null;
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
			toReturn = labyrinth.getZone(adjacentX, adjacentY);
		} catch (InvalidZoneException e) {
			e.printStackTrace();
		}
		
		return toReturn;
	}
	
}
