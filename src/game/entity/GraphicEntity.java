package game.entity;

import javax.swing.JLabel;

import gui.GamePanel;

public abstract class GraphicEntity extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected transient Entity entity;
	protected GamePanel panel;

	protected GraphicEntity(Entity entity) {
		super();
		this.entity = entity;
	}
	
	public void updatePosition(float x, float y) {
		panel.updateLabel(this, x, y);
	}
	
	public abstract void updateImage();
	
	public void delete() {
		panel.removeLabel(this);
	}
	
	public void addToGUI(GamePanel gui) {
		this.panel = gui;
		panel.addLabel(this);
	}
	
}
