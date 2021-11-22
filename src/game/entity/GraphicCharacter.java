package game.entity;

import javax.swing.Icon;
import javax.swing.JLabel;

import game.labyrinth.Direction;

/**
 * Modela un personaje grafico.
 */
public abstract class GraphicCharacter extends GraphicEntity{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Arreglo con imagenes de movimiento hacia arriba, derecha, abajo, e izquierda, en las posiciones 0, 1, 2, y 3 respectivamente.
	 */
	protected final transient Icon[] movingImages;
	
	protected transient JLabel speedImageLabel;
	
	/**
	 * Crea un nuevo personaje grafico.
	 * @param entity La entidad asociada a esta entidad grafica.
	 * @param images Arreglo de imagenes para el nuevo personaje grafico.
	 */
	protected GraphicCharacter(Entity entity, Icon[] images) {
		super(entity);
		
		movingImages = new Icon[4];
		movingImages[0] = images[0];
		movingImages[1] = images[1];
		movingImages[2] = images[2];
		movingImages[3] = images[3];
		
		this.setIcon(movingImages[3]);
		this.setSize(images[0].getIconWidth(), images[0].getIconHeight());

		speedImageLabel = new JLabel(images[4]);
		speedImageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
		
		depth = 1;
	}
	
	@Override
	public void updateImage() {
		Direction dir = entity.getMovementDirection();
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
	}
	
	/**
	 * Setea la direccion de este personaje grafico de acuerdo al valor dado.
	 * @param index Un valor entero que codifica una direccion como sigue: 1 = arriba; 2 = derecha; 3 = abajo; 4 = izquierda.
	 */
	protected void setMoveDirection(int index) {
		this.setIcon(movingImages[index]);
	}
	
	@Override
	public void setSpeedEffect(boolean speed) {
		if (speed) {
			this.add(speedImageLabel);
		} else {
			this.remove(speedImageLabel);
		}
	}

}
