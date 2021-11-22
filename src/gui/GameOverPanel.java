package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.PlayerScore;
import data.StatsData;
import data.TopPlayersRegistry;

import java.io.IOException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Modela el panel de fin del juego.
 */
public abstract class GameOverPanel extends GUIPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected int finalScore;
	protected JLabel fondo;
	protected JLabel winLose;
	protected JLabel score;
	
	private JTextField name;
	private Font smallPanelFont;
	private Font bigPanelFont;
	
	/**
	 * Crea un nuevo panel de fin del juego.
	 * @param gui La gui en la que se encontrara este panel.
	 * @param finalScore El puntaje del juego al terminar.
	 */
	protected GameOverPanel(GUI gui, int finalScore) {
		super(gui);
		this.finalScore = finalScore;
		
		setLayout(null);
		setSize(guiPanelWidth, guiPanelHeight);
		
		smallPanelFont = new Font(fuente, Font.BOLD, scaleHeight / 2);
		bigPanelFont = new Font(fuente, Font.BOLD, scaleHeight);
		
		crearBotones();
		crearLabels();
		crearCampoDeTexto();
		crearFondo();
		
	}
	
	/**
	 * Crea los botones del panel.
	 */
	private void crearBotones() {
		int btnXPos = (guiPanelWidth - scaleWidth * 2) / 2;
		int btnWidth = scaleWidth * 2;
		int btnHeight = scaleHeight;
		
		JButton btnMenu		= new JButton("MENU");
		JButton btnRestart	= new JButton("RESTART");
		JButton btnExit		= new JButton("EXIT");

		btnMenu.addActionListener(e -> backToMenu());
		btnRestart.addActionListener(e -> restartGame());
		btnExit.addActionListener(e -> exitGame());
		
		btnMenu.setFont(smallPanelFont);
		btnRestart.setFont(smallPanelFont);
		btnExit.setFont(smallPanelFont);
		
		btnMenu.setBounds	(btnXPos, (guiPanelHeight / 2) + (scaleHeight * 06) / 5, btnWidth, btnHeight);
		btnRestart.setBounds(btnXPos, (guiPanelHeight / 2) + (scaleHeight * 12) / 5, btnWidth, btnHeight);
		btnExit.setBounds	(btnXPos, (guiPanelHeight / 2) + (scaleHeight * 18) / 5, btnWidth, btnHeight);
		
		add(btnMenu);
		add(btnRestart);
		add(btnExit);
		
	}
	
	/**
	 * Crea los labels del panel.
	 */
	private void crearLabels() {
		JLabel yourName;
		Color color = new Color(0, 0, 100);
		
		winLose = new JLabel("");
		score = new JLabel(" SCORE: " + finalScore);
		yourName = new JLabel("YOUR NAME: ");
		
		winLose.setFont(bigPanelFont);
		score.setFont(bigPanelFont);
		yourName.setFont(bigPanelFont);
		
		winLose.setHorizontalAlignment(SwingConstants.CENTER);
		yourName.setHorizontalAlignment(SwingConstants.RIGHT);
		
		winLose.setBounds(0, 0, guiPanelWidth, 2 * scaleHeight);
		score.setBounds((guiPanelWidth - scaleWidth * 3), 4 * scaleHeight, scaleWidth * 3, scaleHeight);
		yourName.setBounds(0, 4 * scaleHeight, scaleWidth * 3, scaleHeight);
		
		score.setForeground(color);
		yourName.setForeground(color);
		
		add(winLose);
		add(score);
		add(yourName);
	}
	
	/**
	 * Crea el campo de texto del panel.
	 */
	private void crearCampoDeTexto() {
		name = new JTextField();
		name.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
			
		});
		name.setFont(bigPanelFont);
		name.setBounds((guiPanelWidth - scaleWidth * 2) / 2, 4 * scaleHeight, scaleWidth * 2, scaleHeight);
		name.setText("PLAYER");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		add(name);
	}
	
	/**
	 * Crea el fondo del panel.
	 */
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, guiPanelWidth, guiPanelHeight);
		fondo.setIcon(frame.getImageFactory().getGameOverBgImage());
		add(fondo);
	}
	
	/**
	 * Guarda el puntaje y devuelve la gui al menu principal.
	 */
	protected void backToMenu() {
		saveScore();
		frame.setPanel(new StartPanel(frame));
	}
	
	/**
	 * Guarda el puntaje y reinicia el juego.
	 */
	protected void restartGame() {
		saveScore();
		frame.setPanel(new GamePanel(frame));
	}
	
	/**
	 * Guarda el puntaje y cierra el juego.
	 */
	protected void exitGame() {
		saveScore();
		System.exit(0);
	}
	
	/**
	 * Guarda el puntaje obtenido.
	 */
	protected void saveScore() {
		TopPlayersRegistry registro;
		StatsData sd;
		
		if(name.getText().equals("")) {
			name.setText("NONE");
		}
		
		try {
			sd = new StatsData();
			registro = sd.load();
			registro.addPlayer(new PlayerScore(name.getText(), finalScore));
			sd.save(registro);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
