package game.entity;

import javax.swing.Icon;

public class GraphicPlayer extends GraphicCharacter {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Arreglo con imagenes de velocidad hacia arriba, derecha, abajo, e izquierda, en las posiciones 0, 1, 2, y 3 respectivamente.
	 */
	protected transient Icon[] speedImages;
	
	/**
	 * Arreglo con imagenes de escudo aturdido hacia arriba, derecha, abajo, e izquierda, en las posiciones 0, 1, 2, y 3 respectivamente.
	 */
	protected transient Icon[] shieldImages;
	
	protected boolean hasSpeed;
	protected boolean hasShield;

	public GraphicPlayer(Entity entity, Icon[] images) {
		super(entity, images);
		
		speedImages = new Icon[4];
		shieldImages = new Icon[4];
		
		speedImages[0] = images[4];
		speedImages[1] = images[5];
		speedImages[2] = images[6];
		speedImages[3] = images[7];
		
		shieldImages[0] = images[8];
		shieldImages[1] = images[9];
		shieldImages[2] = images[10];
		shieldImages[3] = images[11];
	}
	
	@Override
	protected void setMoveDirection(int index) {
		if (hasSpeed) {
			setIcon(speedImages[index]);
		} else if (hasShield) {
			setIcon(shieldImages[index]);
		} else {
			super.setMoveDirection(index);
		}
	}

	public void setSpeedEffect(boolean speed) {
		hasSpeed = speed;
	}

	public void setShieldEffect(boolean shield) {
		hasShield = shield;
	}

}
