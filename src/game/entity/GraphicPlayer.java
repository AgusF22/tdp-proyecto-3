package game.entity;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Modela un jugador grafico.
 */
public class GraphicPlayer extends GraphicCharacter {
	
	private static final long serialVersionUID = 1L;
	
	protected transient JLabel shieldImageLabel;

	/**
	 * Crea un nuevo jugador grafico.
	 * @param entity La entidad asociada a esta entidad grafica.
	 * @param images Arreglo de imagenes para el nuevo jugador grafico.
	 */
	public GraphicPlayer(Entity entity, Icon[] images) {
		super(entity, images);
		
		shieldImageLabel = new JLabel(images[5]);
		shieldImageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
	}

	@Override
	public void setShieldEffect(boolean shield) {
		if (shield) {
			this.add(shieldImageLabel);
		} else {
			this.remove(shieldImageLabel);
		}
	}

	/**
	 * {@inheritDoc}
	 * Un jugador nunca es aturdido, por lo que este metodo no hace nada.
	 */
	@Override
	public void setStunEffect(boolean stuned) {
		// metodo vacio
	}

	/**
	 * {@inheritDoc}
	 * Un jugador nunca tiene efecto de huida, por lo que este metodo no hace nada.
	 */
	@Override
	public void setFleeing(boolean fleeing) {
		// metodo vacio
	}

}
