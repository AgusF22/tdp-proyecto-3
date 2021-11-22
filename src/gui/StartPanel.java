package gui;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

/**
 * Modela el panel del menu principal.
 */
public class StartPanel extends GUIPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected JLabel fondo;
	
	/**
	 * Crea un nuevo panel de menu principal.
	 * @param gui La gui en la que se encontrara este panel.
	 */
	public StartPanel(GUI gui) {
		super(gui);
		setLayout(null);
		setSize(guiPanelWidth, guiPanelHeight);
		
		crearBotones();
		crearFondo();
	}
	
	/**
	 * Crea el fondo de este panel.
	 */
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, guiPanelWidth, guiPanelHeight);
		fondo.setIcon(frame.getImageFactory().getStartBgImage());
		add(fondo);
	}
	
	/**
	 * Crea los botones de este panel.
	 */
	private void crearBotones() {
		Font font = new Font(fuente, Font.BOLD, scaleHeight / 2);
		int xPos = (guiPanelWidth - scaleWidth * 2) / 2;
		int btnWidht = scaleWidth * 2;
		int btnHeight = scaleHeight;
		
		JButton btnPlay = new JButton("PLAY");
		JButton btnScores = new JButton("SCORES");
		JButton btnControls = new JButton("CONTROLS");
		JButton btnExit = new JButton("EXIT");

		btnPlay.addActionListener(e -> startGame());
		btnScores.addActionListener(e -> viewStats());
		btnControls.addActionListener(e -> controlsGame());
		btnExit.addActionListener(e -> exitGame());
		
		btnPlay.setFont(font);
		btnScores.setFont(font);
		btnControls.setFont(font);
		btnExit.setFont(font);
		
		btnPlay.setBounds(xPos, guiPanelHeight / 2 +
					(scaleHeight * 6) / 5, btnWidht, btnHeight);
		btnScores.setBounds(xPos, guiPanelHeight / 2 +
					(scaleHeight * 12) / 5, btnWidht, btnHeight);
		btnControls.setBounds(xPos, guiPanelHeight / 2 +
					(scaleHeight * 18) / 5, btnWidht, btnHeight);
		btnExit.setBounds(xPos, guiPanelHeight / 2 +
					(scaleHeight * 24) / 5, btnWidht, btnHeight);

		add(btnPlay);
		add(btnScores);
		add(btnControls);
		add(btnExit);
	}
	
	/**
	 * Cambia la gui principal a la pantalla de controles.
	 */
	private void controlsGame() {
		frame.setPanel(new ControlsPanel(frame));
	}
	
	/**
	 * Cambia la gui principal a la pantalla del juego (Inicia el juego).
	 */
	public void startGame() {
		frame.setPanel(new GamePanel(frame));
	}
	
	/**
	 * Cambia la gui principal a la pantalla de stats.
	 */
	public void viewStats() {
		frame.setPanel(new StatsPanel(frame));
	}
	
	/**
	 * Cierra el juego.
	 */
	public void exitGame() {
		System.exit(0);
	}
}
