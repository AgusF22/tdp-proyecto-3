package game.entity;

import javax.swing.Icon;
import javax.swing.JLabel;

public class GraphicPlayer extends GraphicCharacter {
	
	private static final long serialVersionUID = 1L;
	
	protected transient JLabel shieldImageLabel;

	public GraphicPlayer(Entity entity, Icon[] images) {
		super(entity, images);
		
		shieldImageLabel = new JLabel(images[5]);
		shieldImageLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
	}

	public void setShieldEffect(boolean shield) {
		if (shield) {
			this.add(shieldImageLabel);
		} else {
			this.remove(shieldImageLabel);
		}
	}

	@Override
	@Deprecated
	public void setVisible(boolean visible) {
		// TODO documentar
	}

	@Override
	@Deprecated
	public void setStunEffect(boolean stuned) {
		/// TODO documentar
	}

	@Override
	@Deprecated
	public void setFleeing(boolean fleeing) {
		// TODO documentar
	}

}
