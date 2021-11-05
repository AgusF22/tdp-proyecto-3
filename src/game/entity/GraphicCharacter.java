package game.entity;

import javax.swing.Icon;

public class GraphicCharacter extends GraphicEntity{
	
	private static final long serialVersionUID = 1L;
	
	protected final transient Icon movingUpImage;
	protected final transient Icon movingDownImage;
	protected final transient Icon movingLeftImage;
	protected final transient Icon movingRightImage;
	
	public GraphicCharacter(Entity entity, Icon[] images) {
		super(entity);
		movingUpImage 		= images[0];
		movingRightImage 	= images[1];
		movingDownImage 	= images[2];
		movingLeftImage 	= images[3];
		this.setIcon(movingDownImage);
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
