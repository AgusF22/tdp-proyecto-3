package game.entity;

import javax.swing.Icon;

public class GraphicPrize extends GraphicEntity{
	
	private static final long serialVersionUID = 1L;

	public GraphicPrize(Entity entity, Icon image) {
		super(entity);
		this.setIcon(image);
		this.setSize(image.getIconWidth(), image.getIconHeight());
	}

	@Override
	public void updateImage() {
		// metodo vacio
	}
	
	@Override
	@Deprecated
	public void setVisible(boolean visible) {
		// TODO documentar
	}

	@Override
	@Deprecated
	public void setSpeedEffect(boolean speed) {
		// TODO documentar
	}

	@Override
	@Deprecated
	public void setStunEffect(boolean stuned) {
		// TODO documentar
	}

	@Override
	@Deprecated
	public void setShieldEffect(boolean shield) {
		// TODO documentar
	}

	@Override
	@Deprecated
	public void setFleeing(boolean fleeing) {
		// TODO documentar
	}
}
