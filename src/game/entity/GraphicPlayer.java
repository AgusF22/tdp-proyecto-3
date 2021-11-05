package game.entity;

import javax.swing.Icon;

public class GraphicPlayer extends GraphicCharacter {
	
	private static final long serialVersionUID = 1L;
	
	protected final transient Icon speedEffect;
	protected final transient Icon shieldEffect;

	public GraphicPlayer(Entity entity, Icon[] images) {
		super(entity, images);
		
		speedEffect 	= images[4];
		shieldEffect 	= images[5];
	}

	public void addSpeedEffect() {
		// TODO imp
	}

	public void removeSpeedEffect() {
		// TODO imp
	}

	public void addShieldEffect() {
		// TODO imp
	}

	public void removeShieldEffect() {
		// TODO imp
	}

}
