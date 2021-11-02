package game.entity;

import javax.swing.ImageIcon;

public class GraphicCharacter extends GraphicEntity{
	/**
	 * Serial por defecto.
	 */
	private static final long serialVersionUID = 1L;
	protected ImageIcon movingUpImage;
	protected ImageIcon movingDownImage;
	protected ImageIcon movingLeftImage;
	protected ImageIcon movingRightImage;
	
	public GraphicCharacter(ImageIcon[] images) {
		//TODO imp
		movingUpImage 		= images[0];
		movingRightImage 	= images[1];
		movingDownImage 	= images[2];
		movingLeftImage 	= images[3];
	}

	public void setMovingUp() {
		this.setIcon(movingUpImage);
		this.repaint();
	}

	public void setMovingDown() {
		this.setIcon(movingDownImage);
		this.repaint();
	}

	public void setMovingLeft() {
		this.setIcon(movingLeftImage);
		this.repaint();
	}

	public void setMovingRight() {
		this.setIcon(movingRightImage);
		this.repaint();
	}
}
