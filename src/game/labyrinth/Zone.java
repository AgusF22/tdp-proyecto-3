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
	
	public void removeDot() {
		labyrinth.doCount--;
	}
	
	public Iterable<Entity> zoneEntities() {
		return entities;
	}
	
	public void removeEntity(Entity entity) { //Excepcion?
		this.entities.remove(entity);
	}
	
	public void addEntity(Entity entity) { //Excepcion?
		this.entities.add(entity);
	}
	
	/**
	 * Consulta la zona correspondiente a las coordenadas
	 * @param x Float
	 * @param y Float
	 * @return Zone
	 */
	public Zone getZoneIn(Float x, Float y) {
		Zone zone;												// Si la parte decimal del número es menor que la mitad,
		int xInt = Math.round(x);								// redondear hacia abajo. En caso de que sea la mitad o mayor,
		int yInt = Math.round(y);								// redondea hacia arriba.
		
		if ((this.getX() == xInt) && (this.getY() == yInt)) {
			zone = this;
		}
		else {
			zone = labyrinth.getZone(xInt, yInt);
		}
			
		//TODO excepción si la zona no es valida.
		
		return zone;
	}
	
	public void addPoints(int p) {
		labyrinth.addPoints(p);
	}
	
	public ImageFactory getImageFactory() {
		return null;
	}
}
