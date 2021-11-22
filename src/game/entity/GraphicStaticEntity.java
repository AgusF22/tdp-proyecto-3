package game.entity;

import javax.swing.Icon;

public class GraphicStaticEntity extends GraphicEntity{
	
	private static final long serialVersionUID = 1L;

	public GraphicStaticEntity(Entity entity, Icon image) {
		super(entity);
		this.setIcon(image);
		this.setSize(image.getIconWidth(), image.getIconHeight());
		depth = 0;
	}

	@Override
	/**
	 * Nunca actualiza su grafica una vez establecida
	 */
	public void updateImage() {
		// metodo vacio 
	}
	
	@Override
	@Deprecated
	public void setVisible(boolean visible) {
		// TODO documentar
	}

	@Override
	@Deprecated/**
	 * {@inheritDoc}
	 * Nunca puede aumentar su velocidad una entidad estacionaria
	 */
	public void setSpeedEffect(boolean speed) {
	}

	@Override
	@Deprecated/**
	 * {@inheritDoc}
	 * Nunca puede aturdise una entidad estacionaria
	 */
	public void setStunEffect(boolean stuned) {
	}

	@Override
	@Deprecated/**
	 * {@inheritDoc}
	 * Nunca tiene escudo una entidad estacionaria
	 */
	public void setShieldEffect(boolean shield) {
	}

	@Override
	@Deprecated
	/**
	 * {@inheritDoc}
	 * Nunca intenta escapar una entidad estacionaria
	 */
	public void setFleeing(boolean fleeing) {
	}
}
