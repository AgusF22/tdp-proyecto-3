package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import audio.MusicPlayer;

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
		agregarControlMusica();
	}
	/**
	 * Devuelve la gui que contiene a este panel.
	 * @return La gui que contiene a este panel.
	 */
	public GUI getGUI() {
		return frame;
	}
	
	/**
	 * Agrega funcionalidad a la tecla "m" para poder detener/iniciar la musica.
	 */
	private void agregarControlMusica() {
		Action music = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				MusicPlayer musicPlayer = frame.getMusicPlayer();
				if (musicPlayer.isPlaying()) {
					musicPlayer.stop();
				} else {
					musicPlayer.start();
				}
			}
		};
		
		final String musica= "musica";
		
		InputMap iMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		iMap.put(KeyStroke.getKeyStroke("M"), musica);
		
		getActionMap().put(musica, music);
	}
}
