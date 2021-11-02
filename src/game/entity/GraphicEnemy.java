package game.entity;

import javax.swing.ImageIcon;

public class GraphicEnemy extends GraphicCharacter{

	private static final long serialVersionUID = 1L;

	protected ImageIcon fleeingUpImage;
	protected ImageIcon fleeingDownImage;
	protected ImageIcon fleeingLeftImage;
	protected ImageIcon fleeingRightImage;

	protected boolean fleeing;
	
	public GraphicEnemy(ImageIcon[] images) {
		super(images);
		fleeingUpImage 		= images[4];
		fleeingRightImage 	= images[5];
		fleeingDownImage 	= images[6];
		fleeingLeftImage 	= images[7];
	}
	
	public void setMovingUp() {
		if (fleeing) {
			this.setIcon(fleeingUpImage);
		} else {
			this.setIcon(movingUpImage);
		}
		this.repaint();
	}

	public void setMovingDown() {
		if (fleeing) {
			this.setIcon(fleeingDownImage);
		} else {
			this.setIcon(movingDownImage);
		}
		this.repaint();
	}

	public void setMovingLeft() {
		if (fleeing) {
			this.setIcon(fleeingLeftImage);
		} else {
			this.setIcon(movingLeftImage);
		}
		this.repaint();
	}

	public void setMovingRight() {
		if (fleeing) {
			this.setIcon(fleeingRightImage);
		} else {
			this.setIcon(movingRightImage);
		}
		this.repaint();
	}
	
	public void setFleeing(boolean fleeing) {
		this.fleeing = fleeing;
	}
}
