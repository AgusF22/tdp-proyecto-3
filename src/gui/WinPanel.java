package gui;

import java.awt.Color;

/**
 * Modela el panel de fin del juego, para un juego que termino con el jugador ganando.
 */
public class WinPanel extends GameOverPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Crea un nuevo panel de juego ganado.
	 * @param gui La gui en la que se encontrara este panel.
	 * @param finalScore El puntaje del juego al terminar.
	 */
	public WinPanel(GUI gui, int finalScore) {
		super(gui, finalScore);
		winLose.setText("YOU WIN");
		winLose.setForeground(new Color(0, 100, 0));
	}
	
}
