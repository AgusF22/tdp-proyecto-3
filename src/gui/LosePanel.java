package gui;

import java.awt.Color;

/**
 * Modela el panel de fin del juego, para un juego que termino con el jugador perdiendo.
 */
public class LosePanel extends GameOverPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Crea un nuevo panel de juego perdido.
	 * @param gui La gui en la que se encontrara este panel.
	 * @param finalScore El puntaje del juego al terminar.
	 */
	public LosePanel(GUI gui, int finalScore) {
		super(gui, finalScore);
		winLose.setText("YOU LOSE");
		winLose.setForeground(new Color(100, 0, 0));
	}
	
}
