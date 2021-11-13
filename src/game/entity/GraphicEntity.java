package game.entity;

import javax.swing.JLabel;

import game.entity.player.Player;
import gui.GamePanel;

public abstract class GraphicEntity extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected transient Entity entity;
	protected GamePanel panel;

	protected GraphicEntity(Entity entity) {
		super();
		this.entity = entity;
	}
	
	public void updatePosition() {
		panel.updateLabel(this, entity.getX(), entity.getY());
	}
	
	public abstract void updateImage();
	
	public void delete() {
		System.out.println("Panel es nulo = " + (panel == null));
		System.out.println("entity = player: " + (entity == Player.getInstance()));
		panel.removeLabel(this);
	}
	
	public void addToGUI(GamePanel gui) {
		this.panel = gui;
		panel.addLabel(this);
		this.updatePosition();
	}
}
