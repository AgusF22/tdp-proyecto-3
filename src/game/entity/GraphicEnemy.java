package game.entity;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 * Modela un enemigo grafico.
 */
public class GraphicEnemy extends GraphicCharacter{
	
	private static final long serialVersionUID = 1L;

	/**
	 * Arreglo con imagenes de escape hacia arriba, derecha, abajo, e izquierda, en las posiciones 0, 1, 2, y 3 respectivamente.
	 */
	protected transient Icon[] fleeingImages;
	
	protected transient JLabel stunedImageLabel;
	
	protected boolean fleeing;
	protected boolean stuned;
	
	/**
	 * Crea un nuevo enemigo grafico.
	 * @param entity La entidad asociada a esta entidad grafica.
	 * @param images Arreglo de imagenes para el nuevo enemigo grafico.
	 */
	public GraphicEnemy(Entity entity, Icon[] images) {
		super(entity, images);
		
		fleeingImages = new Icon[4];
		
		fleeingImages[0] = images[5];
		fleeingImages[1] = images[6];
		fleeingImages[2] = images[7];
		fleeingImages[3] = images[8];
		
		stunedImageLabel = new JLabel(images[9]);
		stunedImageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
	}
	
	@Override
	protected void setMoveDirection(int index) {
		if (fleeing) {
			setIcon(fleeingImages[index]);
		} else {
			super.setMoveDirection(index);
		}
	}
	
	@Override
	public void setFleeing(boolean fleeing) {
		this.fleeing = fleeing;
		updateImage();
	}
	
	@Override
	public void setStunEffect(boolean stuned) {
		if (stuned) {
			this.add(stunedImageLabel);
		} else {
			this.remove(stunedImageLabel);
		}
	}

	/**
	 * {@inheritDoc}
	 * Un enemigo nuna tiene escudo, por lo que este metodo no hace nada.
	 */
	@Override
	public void setShieldEffect(boolean shield) {
		// metodo vacio
	}
	
}
