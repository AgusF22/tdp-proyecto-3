package gui;

import javax.swing.JPanel;

/**
 * Modela el panel abstracto a ser mostrado por la gui principal.
 */
public abstract class GUIPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected GUI frame;
	protected String fuente;
	protected int width;
	protected int height;
	
	/**
	 * Crea un nuevo panel de gui.
	 * @param gui La gui en la que se encontrara este panel.
	 */
	protected GUIPanel(GUI gui) {
		frame = gui;
		fuente = frame.fuente;
		width = frame.currentScreenWidth;
		height = frame.currentScreenHeight;
	}
	
	/**
	 * Devuelve la gui que contiene a este panel.
	 * @return La gui que contiene a este panel.
	 */
	public GUI getGUI() {
		return frame;
	}
}
