package game.entity.prize;

import game.entity.Entity;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

public abstract class Prize extends Entity{
	
	/**
	 * Crea un nuevo premio.
	 * @param zone La zona en la que se encontrara el nuevo premio.
	 */
	protected Prize(Zone zone) {
		super(zone);
		zone.addEntity(this);
	}
	
	/**
	 * Acepta un visitor
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	/**
	 * Dispara el efecto de este premio.
	 */
	public abstract void triggerEffect();
	
	/**
	 * Remueve la grafica y se remueve de la lista de entidades
	 */
	protected void beConsumed() {
		zone.removeEntity(this);
		graphic.delete();
	}
}
