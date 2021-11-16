package gui;

import java.awt.Color;

/**
 * Panel para mostrar que el juego termino y el jugador gano.
 */
public class WinPanel extends GameOverPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Crea un nuevo panel de juego ganado.
	 * @param gui La gui en la que se encontrara este panel.
	 * @param finalScore El puntaje obtenido durante el juego.
	 */
	public WinPanel(GUI gui, int finalScore) {
		super(gui, finalScore);
		winLose.setText("YOU WIN");
		winLose.setForeground(new Color(0, 100, 0));
	}
	
}
