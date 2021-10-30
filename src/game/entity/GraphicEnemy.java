package game.entity;

import javax.swing.ImageIcon;

public class GraphicEnemy extends GraphicCharacter{
	/**
	 * Serial Por defecto.
	 */
	private static final long serialVersionUID = 1L;
	//TODO aca no se si hereda los atributos de GraphicCharacter
	protected boolean fleeing;
	protected ImageIcon fleeingUpImage;
	protected ImageIcon fleeingDownImage;
	protected ImageIcon fleeingLeftImage;
	protected ImageIcon fleeingRightImage;
	
	public GraphicEnemy(ImageIcon[] images) {
		super(null);
		// TODO imp
	}
	
	public void setMovingUp() {
		//TODO imp
	}

	public void setMovingDown() {
		//TODO imp
	}

	public void setMovingLeft() {
		//TODO imp
	}

	public void setMovingRight() {
		//TODO imp
	}
	
	public void setFleeing(boolean fleeing) {
		this.fleeing = fleeing;
	}
}
