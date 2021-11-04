package gui;

import javax.swing.JPanel;

public abstract class GUIPanel extends JPanel{
	
	protected GUI frame;
	
	public GUIPanel(GUI gui) {
		frame = gui;
	}
	
	public GUI getGUI() {
		return frame;
	}
}
