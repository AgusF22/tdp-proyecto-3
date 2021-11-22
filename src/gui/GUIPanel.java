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
 * Modela el panel abstracto de la gui.
 */
public abstract class GUIPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected GUI frame;
	protected String fuente;
	protected int guiPanelWidth;
	protected int guiPanelHeight;
	protected int scaleWidth = guiPanelWidth / 4;
	protected int scaleHeight = guiPanelHeight / 15;
	
	/**
	 * Crea un nuevo panel de gui.
	 * @param gui La gui en la que se encontrara este panel.
	 */
	protected GUIPanel(GUI gui) {
		frame = gui;
		fuente = GUI.FONT;
		guiPanelWidth = frame.currentScreenWidth;
		guiPanelHeight = frame.currentScreenHeight;
		scaleWidth = guiPanelWidth/8;
		scaleHeight = guiPanelHeight/16;
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
				if (musicPlayer != null) {
					if (musicPlayer.isPlaying()) {
						musicPlayer.stop();
					} else {
						musicPlayer.start();
					}
				}
			}
		};
		
		final String musica = "musica";
		
		InputMap iMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		iMap.put(KeyStroke.getKeyStroke("M"), musica);
		
		getActionMap().put(musica, music);
	}
	
}
