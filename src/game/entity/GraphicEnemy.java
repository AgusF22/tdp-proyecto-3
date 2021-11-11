package game.entity;

import javax.swing.Icon;

public class GraphicEnemy extends GraphicCharacter{

	private static final long serialVersionUID = 1L;

	/**
	 * Arreglo con imagenes de escape hacia arriba, derecha, abajo, e izquierda, en las posiciones 0, 1, 2, y 3 respectivamente.
	 */
	protected transient Icon[] fleeingImages;
	
	/**
	 * Arreglo con imagenes de enemigo aturdido hacia arriba, derecha, abajo, e izquierda, en las posiciones 0, 1, 2, y 3 respectivamente.
	 */
	protected transient Icon[] stunedImages;
	
	protected boolean fleeing;
	protected boolean stuned;
	
	public GraphicEnemy(Entity entity, Icon[] images) {
		super(entity, images);
		
		fleeingImages = new Icon[4];
		stunedImages = new Icon[4];
		
		fleeingImages[0] = images[4];
		fleeingImages[1] = images[5];
		fleeingImages[2] = images[6];
		fleeingImages[3] = images[7];
		
		stunedImages[0] = images[8];
		stunedImages[1] = images[9];
		stunedImages[2] = images[10];
		stunedImages[3] = images[11];
	}
	
	protected void setMoveDirection(int index) {
		if (stuned) {
			setIcon(stunedImages[index]);
		} else if (fleeing) {
			setIcon(fleeingImages[index]);
		} else {
			super.setMoveDirection(index);
		}
	}
	
	public void setFleeing(boolean fleeing) {
		this.fleeing = fleeing;
	}
	
	public void setStunEffect(boolean stuned) {
		this.stuned = stuned;
	}
	
	@Override
	public void setVisible(boolean visible) {
		this.setVisible(visible);
	}
	
}
