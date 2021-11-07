package gui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		
		int scaleWidth= width/4;
		int scaleHeight = height/15;
		
		crearBotones(scaleWidth, scaleHeight);
		crearLabels(scaleWidth, scaleHeight);
		crearCampoDeTexto(scaleWidth, scaleHeight);
		crearFondo();
		
	}
	
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, width, height);
		fondo.setIcon(frame.getImageFactory().getGameOverBgImage());
		add(fondo);
	}
	
	private void crearCampoDeTexto(int scaleWidth, int scaleHeight) {
		name = new JTextField();
		name.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		name.setBounds(width/3, 4*scaleHeight, width/3, scaleHeight);
		name.setText("PLAYER");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		add(name);
	}
	
	private void crearLabels(int scaleWidth, int scaleHeight) {
		
		winLose = new JLabel("");
		winLose.setFont(new Font(fuente, Font.BOLD, 2*scaleHeight));
		winLose.setHorizontalAlignment(SwingConstants.CENTER);
		winLose.setBounds(0, 0, width, 3*scaleHeight);
		add(winLose);
		
		score = new JLabel("");
		score.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		score.setHorizontalAlignment(SwingConstants.CENTER);
		score.setBounds(2*width/3, 4*scaleHeight, width/3, scaleHeight);
		score.setText("SCORE: " + finalScore);
		add(score);
		
		JLabel yourName = new JLabel("YOUR NAME:");
		yourName.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		yourName.setHorizontalAlignment(SwingConstants.CENTER);
		yourName.setBounds(0, 4*scaleHeight, width/3, scaleHeight);
		add(yourName);
	}

	private void crearBotones(int scaleWidth, int scaleHeight) {
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnRestart.setBounds((width - scaleWidth) / 2, height/2 + 2*scaleHeight + 2*scaleHeight/5, scaleWidth, scaleHeight);
		add(btnRestart);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnExit.setBounds((width - scaleWidth) / 2, height/2 + 3*scaleHeight + 3*scaleHeight/5, scaleWidth, scaleHeight);
		add(btnExit);
		
	}
	
	/**
	 * Devuelve la gui a la pantalla de inicio.
	 */
	public void backToMenu() {
		frame.setPanel(new StartPanel(frame));
	}
}
