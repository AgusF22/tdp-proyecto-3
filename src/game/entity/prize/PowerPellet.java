package game.entity.prize;

import game.entity.Entity;
import game.entity.GraphicStaticEntity;
import game.entity.visitor.PowerPelletVisitor;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

/**
 * Modela un power pellet.
 */
public class PowerPellet extends Prize {
	
	/**
	 * Crea un nuevo power pellet.
	 * @param zone La zona en la que se encontrara el nuevo power pellet.
	 */
	public PowerPellet(Zone zone) {
		super(zone);
		graphic = new GraphicStaticEntity(this, zone.getLabyrinth().getImageFactory().getPowerPelletImage());
		addToGUI();
	}
	
	/**
	 * {@inheritDoc}
	 * El power pellet permite que el jugador pueda comer a los enemigos durante un tiempo.
	 */
	@Override
	public void triggerEffect() {
		Visitor v = new PowerPelletVisitor();
		for (Entity e: zone.getLabyrinth().entities()) {
			e.accept(v);
		}
		beConsumed();
	}
	
}
