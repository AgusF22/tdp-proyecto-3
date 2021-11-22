package game.entity;

import javax.swing.Icon;

/**
 * Modela una entidad grafica estatica.
 */
public class GraphicStaticEntity extends GraphicEntity{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Crea una nueva grafica de entidad estatica.
	 * @param entity La entidad asociada a esta entidad grafica.
	 * @param image Una imagen para la nueva entidad grafica.
	 */ 
	public GraphicStaticEntity(Entity entity, Icon image) {
		super(entity);
		this.setIcon(image);
		this.setSize(image.getIconWidth(), image.getIconHeight());
		depth = 0;
	}

	/**
	 * {@inheritDoc}
	 * Una entidad grafica estatica no actualiza su imagen, por lo que este metodo no hace nada.
	 */
	@Override
	public void updateImage() {
		// metodo vacio 
	}

	/**
	 * {@inheritDoc}
	 * Una entidad estatica no puede tener efectos, por lo que este metodo no hace nada.
	 */
	@Override
	public void setSpeedEffect(boolean speed) {
		// metodo vacio
	}

	/**
	 * {@inheritDoc}
	 * Una entidad estatica no puede tener efectos, por lo que este metodo no hace nada.
	 */
	@Override
	public void setStunEffect(boolean stuned) {
		// metodo vacio
	}

	/**
	 * {@inheritDoc}
	 * Una entidad estatica no puede tener efectos, por lo que este metodo no hace nada.
	 */
	@Override
	public void setShieldEffect(boolean shield) {
		// metodo vacio
	}

	/**
	 * {@inheritDoc}
	 * Una entidad estatica no puede tener efectos, por lo que este metodo no hace nada.
	 */
	@Override
	public void setFleeing(boolean fleeing) {
		// metodo vacio
	}
}
