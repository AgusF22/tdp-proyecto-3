package game.entity;

import javax.swing.JLabel;

import gui.GamePanel;

public abstract class GraphicEntity extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected GamePanel panel;		// TODO decidir como llegar al panel -AF

	protected GraphicEntity() {
		super();
//		panel.addLabel(this);		TODO descomentar cuando exista el panel -AF
	}
	
	public void update(float x, float y) {
		panel.updateLabel(this, x, y);
	}
	
	public void delete() {
		panel.removeLabel(this);
	}
}
