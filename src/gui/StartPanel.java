package gui;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		setSize(width, height);
		
		crearBotones();
		crearFondo();
	}
	
	/**
	 * Crea el fondo de este panel.
	 */
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, width, height);
		fondo.setIcon(frame.getImageFactory().getStartBgImage());
		add(fondo);
	}
	
	/**
	 * Crea los botones de este panel.
	 */
	private void crearBotones() {
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		btnPlay.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnPlay.setBounds((width - scaleWidth*2) / 2,
						  height/2 + (scaleHeight*6)/5,
						  scaleWidth*2, scaleHeight);
		add(btnPlay);
		
		JButton btnScores = new JButton("SCORES");
		btnScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewStats();
			}
		});
		btnScores.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnScores.setBounds((width - scaleWidth*2) / 2,
							height/2 + (scaleHeight*12)/5,
							scaleWidth*2, scaleHeight);
		add(btnScores);
		
		JButton btnControls = new JButton("CONTROLS");
		btnControls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlsGame();
			}
		});
		btnControls.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnControls.setBounds((width - scaleWidth*2) / 2,
							  height/2 + (scaleHeight*18)/5,
							  scaleWidth*2, scaleHeight);
		add(btnControls);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitGame();
			}
		});
		btnExit.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnExit.setBounds((width - scaleWidth*2) / 2,
						  height/2 + (scaleHeight*24)/5,
						  scaleWidth*2, scaleHeight);
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
