package game.entity;

import javax.swing.Icon;

public class GraphicEnemy extends GraphicCharacter{

	private static final long serialVersionUID = 1L;

	protected transient Icon fleeingUpImage;
	protected transient Icon fleeingDownImage;
	protected transient Icon fleeingLeftImage;
	protected transient Icon fleeingRightImage;
	protected transient Icon stunEffect;

	protected boolean fleeing;
	
	public GraphicEnemy(Entity entity, Icon[] images) {
		super(entity, images);
		
		fleeingUpImage 		= images[4];
		fleeingRightImage 	= images[5];
		fleeingDownImage 	= images[6];
		fleeingLeftImage 	= images[7];
		
		stunEffect			= images[8];
	}
	
	@Override
	public void setMovingUp() {
		if (fleeing) {
			this.setIcon(fleeingUpImage);
		} else {
			this.setIcon(movingUpImage);
		}
		this.repaint();
	}

	@Override
	public void setMovingDown() {
		if (fleeing) {
			this.setIcon(fleeingDownImage);
		} else {
			this.setIcon(movingDownImage);
		}
		this.repaint();
	}

	@Override
	public void setMovingLeft() {
		if (fleeing) {
			this.setIcon(fleeingLeftImage);
		} else {
			this.setIcon(movingLeftImage);
		}
		this.repaint();
	}

	@Override
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
	
	@Override
	public void setVisible(boolean visible) {
		// TODO imp
	}
	
	public void addStunEffect() {
		// TODO imp
	}
	
	public void removeStunEffect() {
		// TODO imp
	}
	
}
