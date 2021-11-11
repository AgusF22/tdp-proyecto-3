package game.entity;

import javax.swing.Icon;

public class GraphicPrize extends GraphicEntity{
	
	private static final long serialVersionUID = 1L;

	public GraphicPrize(Entity entity, Icon image) {
		super(entity);
		this.setIcon(image);
	}

	@Override
	public void updateImage() {
		// metodo vacio
	}
}
