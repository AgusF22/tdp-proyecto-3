package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.PlayerScore;
import data.TopPlayersRegistry;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class GameOverPanel extends GUIPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected int finalScore;
	protected JLabel fondo;
	protected JLabel winLose;
	protected JLabel score;
	
	private JTextField name;
	
	protected GameOverPanel(GUI gui, int finalScore) {
		super(gui);
		this.finalScore = finalScore;
		
		setLayout(null);
		setSize(width, height);
		
		crearBotones();
		crearLabels();
		crearCampoDeTexto();
		crearFondo();
		
	}
	
	/**
	 * Crea el fondo del panel.
	 */
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, width, height);
		fondo.setIcon(frame.getImageFactory().getGameOverBgImage());
		add(fondo);
	}
	
	/**
	 * Crea y coloca el campo de texto del panel.
	 */
	private void crearCampoDeTexto() {
		name = new JTextField();
		name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText("");
			}
		});
		name.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		name.setBounds((width - scaleWidth*2)/2, 4*scaleHeight, scaleWidth*2, scaleHeight);
		name.setText("PLAYER");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		add(name);
	}
	
	/**
	 * Crea y coloca los labels del panel.
	 */
	private void crearLabels() {
		
		winLose = new JLabel("");
		winLose.setFont(new Font(fuente, Font.BOLD, 2*scaleHeight));
		winLose.setHorizontalAlignment(SwingConstants.CENTER);
		winLose.setBounds(0, 0, width, 2*scaleHeight);
		add(winLose);
		
		score = new JLabel("");
		score.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		score.setBounds((width - scaleWidth*3), 4*scaleHeight, scaleWidth*3, scaleHeight);
		score.setText(" SCORE: " + finalScore);
		add(score);
		
		JLabel yourName = new JLabel("YOUR NAME: ");
		yourName.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		yourName.setHorizontalAlignment(SwingConstants.RIGHT);
		yourName.setBounds(0, 4*scaleHeight, scaleWidth*3, scaleHeight);
		add(yourName);
	}

	/**
	 * Crea y coloca los botones del panel.
	 */
	private void crearBotones() {
		
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		btnMenu.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnMenu.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*6)/5, scaleWidth*2, scaleHeight);
		add(btnMenu);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restartGame();
			}
		});
		btnRestart.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnRestart.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*12)/5, scaleWidth*2, scaleHeight);
		add(btnRestart);
		
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitGame();
			}
		});
		btnExit.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnExit.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*18)/5, scaleWidth*2, scaleHeight);
		add(btnExit);
		
	}
	
	/**
	 * Guarda la partida y carga en la gui un nuevo panel de juego.
	 */
	protected void restartGame() {
		saveScore();
		frame.setPanel(new GamePanel(frame));
	}
	
	/**
	 * Guarda la partida y carga en la gui una nueva pantalla de inicio
	 */
	protected void backToMenu() {
		saveScore();
		frame.setPanel(new StartPanel(frame));
	}
	
	/**
	 * Guarda la partida y termina la ejecucion del juego.
	 */
	protected void exitGame() {
		saveScore();
		System.exit(0);
	}
	
	/**
	 * Guarda el puntaje obtenido.
	 */
	protected void saveScore() {
		if(name.getText().equals("")) {
			name.setText("NONE");
		}
		
		TopPlayersRegistry registro;
		try {
			registro = frame.getStatsData().load();
			registro.addPlayer(new PlayerScore(name.getText(), finalScore));
			frame.getStatsData().save(registro);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Detiene/inicia la musica.
	 */
	protected void musicOffPlay() {
		System.out.println("MUSICA OFF/PLAY implementar en GameOverPanel");
	}
}
