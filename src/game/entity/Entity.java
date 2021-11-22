package game.entity;

import exceptions.InvalidZoneException;
import game.entity.visitor.Visitor;
import game.labyrinth.Direction;
import game.labyrinth.Labyrinth;
import game.labyrinth.Zone;

/**
 * Modela una entidad del juego.
 */
public abstract class Entity {
	
	protected Zone zone;
	protected GraphicEntity graphic;
	protected float x;
	protected float y;
	
	/**
	 * Construye una nueva entidad, asignandole una zona pasada como parametro.
	 * @param zone La zona en la que se encontrara la nueva entidad.
	 */
	protected Entity(Zone zone) {
		this.zone = zone;
		if (zone != null) {		
			zone.addEntity(this);
			x = zone.getX();
			y = zone.getY();
		}
	}
	
	/**
	 * Añade a la gui la entidad grafica de esta entidad.
	 */
	protected void addToGUI() {
		graphic.addToGUI(getLabyrinth().getGUI());
	}
	
	/**
	 * Acepta un visitor.
	 * @param visitor Un visitor.
	 */
	public abstract void accept(Visitor visitor);
	
	/**
	 * Retorna la coordenada x de esta entidad.
	 * @return La coordenada x de esta entidad.
	 */
	public float getX() {
		return x;
	}
	
	/**
	 * Retorna la coordenada y de esta entidad.
	 * @return La coordenada y de esta entidad.
	 */
	public float getY() {
		return y;
	}
	
	/**
	 * Retorna la zona en la que se encuentra esta entidad.
	 * @return La zona en la que se encuentra esta entidad.
	 */
	public Zone getZone() {
		return zone;
	}
	
	/**
	 * Retorna el laberinto en el que se encuentra esta entidad.
	 * @return El laberinto en el que se encuentra esta entidad.
	 */
	public Labyrinth getLabyrinth() {
		return zone.getLabyrinth();
	}
	
	/**
	 * Setea las coordenadas de esta entidad, cambiando de zona en caso de ser necesario.
	 * @param x Nueva coordenada x.
	 * @param y Nueva coordenada y.
	 */
	public void setCoordinates(float x, float y) {
		try {
			Zone newZone = getLabyrinth().getZone(x, y);
			this.x = x;
			this.y = y;
			if (zone != newZone) {
				zone.removeEntity(this);
				zone = newZone;
				zone.addEntity(this);
			}
		} catch(InvalidZoneException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Retorna la grafica asociada a esta entidad.
	 * @return La grafica asociada a esta entidad.
	 */
	public GraphicEntity getGraphic() {
		return graphic;
	}
	
	/**
	 * Consulta la direccion de movimiento de la entidad.
	 * @return null, ya que la entidad no se mueve.
	 */
	public Direction getMovementDirection() {
		return null;
	}
}
