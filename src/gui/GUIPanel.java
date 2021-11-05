package gui;

import javax.swing.JPanel;

public abstract class GUIPanel extends JPanel{
	
	protected GUI frame;
	protected String fuente;
	protected int width;
	protected int height;
	
	public GUIPanel(GUI gui) {
		frame = gui;
		fuente = frame.FUENTE;
		width = frame.CURRENT_SCREEN_WIDTH;
		height = frame.CURRENT_SCREEN_HEIGHT;
	}
	
	public GUI getGUI() {
		return frame;
	}
}
