package game.entity;

import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

public abstract class Entity {
	
	protected Zone zone;
	protected GraphicEntity graphic;
	protected float x;
	protected float y;
	
	/**
	 * Construye una nueva entidad ubicada en la coordenada (0, 0), asignandole una zona pasada como parametro.
	 * @param zone Una zona.
	 */
	protected Entity(Zone zone) {
		this.zone = zone;
		x = 0f;
		y = 0f;
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
	 * Setea las coordenadas de esta entidad, cambiando de zona en caso de ser necesario.
	 * @param x Nueva coordenada x.
	 * @param y Nueva coordenada y.
	 */
	public void setCoordinates(float x, float y) {
		this.x = x;
		this.y = y;
		zone = zone.getLabyrinth().getZone(x, y);
	}
	
	/**
	 * Retorna la grafica asociada a la entidad
	 * @return Entidad grafica asociada
	 */
	public GraphicEntity getGraphic() {
		return graphic;
	}
}
