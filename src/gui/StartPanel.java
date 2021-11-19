package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import data.PlayerScore;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class StartPanel extends GUIPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected JLabel fondo;
	
	public StartPanel(GUI gui) {
		super(gui);
		setLayout(null);
		setSize(width, height);
		
		crearBotones();
		crearBotonesBasura(); //TODO basura borrar luego de probar cosas
		crearFondo();
	}
	
	private void crearBotonesBasura() { //TODO metodo basura, luego borrar
		Random rnd = new Random();
		JButton btnPerder = new JButton("PERDER");
		btnPerder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setPanel(new LosePanel(frame, (rnd.nextInt()%10000)+10000));
			}
		});
		btnPerder.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnPerder.setBounds((width - scaleWidth), height/2 + scaleHeight + scaleHeight/5, scaleWidth, scaleHeight);
		add(btnPerder);
		
		JButton btnGanar = new JButton("GANAR");
		btnGanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setPanel(new WinPanel(frame, (rnd.nextInt()%10000)+10000));
			}
		});
		btnGanar.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnGanar.setBounds((width - scaleWidth), height/2 + 2*scaleHeight + 2*scaleHeight/5, scaleWidth, scaleHeight);
		add(btnGanar);
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
		btnPlay.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*6)/5, scaleWidth*2, scaleHeight);
		add(btnPlay);
		
		JButton btnScores = new JButton("SCORES");
		btnScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewStats();
			}
		});
		btnScores.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnScores.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*12)/5, scaleWidth*2, scaleHeight);
		add(btnScores);
		
		JButton btnControls = new JButton("CONTROLS");
		btnControls.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlsGame();
			}
		});
		btnControls.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnControls.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*18)/5, scaleWidth*2, scaleHeight);
		add(btnControls);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitGame();
			}
		});
		btnExit.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnExit.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*24)/5, scaleWidth*2, scaleHeight);
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
	 * Termina la ejecucion del juego.
	 */
	public void exitGame() {
		System.exit(0);
	}
}
