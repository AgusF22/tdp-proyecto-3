package gui;

/**
 * Panel para mostrar que el juego termino y el jugador perdio.
 */
public class LosePanel extends GameOverPanel {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Crea un nuevo panel de juego perdido.
	 * @param gui La gui en la que se encontrara este panel.
	 * @param finalScore El puntaje obtenido durante el juego.
	 */
	public LosePanel(GUI gui, int finalScore) {
		super(gui, finalScore);
		winLose.setText("YOU LOSE");
	}
	
}
