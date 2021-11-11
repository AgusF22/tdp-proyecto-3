package game.entity;

import javax.swing.Icon;

import game.Direction;

public class GraphicCharacter extends GraphicEntity{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Arreglo con imagenes de movimiento hacia arriba, derecha, abajo, e izquierda, en las posiciones 0, 1, 2, y 3 respectivamente.
	 */
	protected final transient Icon[] movingImages;
	
	public GraphicCharacter(Entity entity, Icon[] images) {
		super(entity);
		movingImages = new Icon[4];
		movingImages[0] = images[0];
		movingImages[1] = images[1];
		movingImages[2] = images[2];
		movingImages[3] = images[3];
		this.setIcon(movingImages[2]);
	}
	
	public void updateImage() {
		Direction dir = ((Character) entity).getMovementDirection();
		switch (dir) {
		case DOWN:
			setMoveDirection(2);
			break;
		case LEFT:
			setMoveDirection(3);
			break;
		case RIGHT:
			setMoveDirection(1);
			break;
		case UP:
			setMoveDirection(0);
			break;
		default:
			break;
		}
		this.repaint();
	}
	
	protected void setMoveDirection(int index) {
		this.setIcon(movingImages[index]);
	}
	
}
