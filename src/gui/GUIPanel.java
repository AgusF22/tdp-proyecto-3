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
	protected int scaleWidth = width/4;
	protected int scaleHeight = height/15;
	
	/**
	 * Crea un nuevo panel de gui.
	 * @param gui La gui en la que se encontrara este panel.
	 */
	protected GUIPanel(GUI gui) {
		frame = gui;
		//fuente = frame.fuente; TODO descomentar y borrar abajo
		fuente = "Sans-Serif";
		//width = frame.currentScreenWidth; TODO descomentar y borrar abajo
		width = 1280;
		//height = frame.currentScreenHeight; TODO decomentar y borrar abajo
		height = 720;
		scaleWidth = width/8;
		scaleHeight = height/16;
	}
	
	/**
	 * Devuelve la gui que contiene a este panel.
	 * @return La gui que contiene a este panel.
	 */
	public GUI getGUI() {
		return frame;
	}
}
