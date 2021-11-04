package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import imagefactories.ImageFactory;

public abstract class GameOverPanel extends GUIPanel{
	protected int finalScore;
	protected JLabel fondo = new JLabel("");
	protected int width;
	protected int height;
	protected String fuente;
	protected JLabel winLose;
	
	protected GameOverPanel(GUI gui) {
		super(gui);
		
		Icon iconoFondo = gui.getImageFactory().getGameOverBgImage();
		
		width = iconoFondo.getIconWidth();
		height = iconoFondo.getIconHeight();
		
		setLayout(null);
		setSize(width, height);
		
		fondo.setBounds(0, 0, width, height);
		fondo.setIcon(gui.getImageFactory().getGameOverBgImage());
		
		crearBotones();
		add(fondo);
		
	}
	
	private void crearBotones() {
		fuente = "SansSerif";
		
		int widthBotton = width/2;
		int heightBotton = height/10;
		
		winLose = new JLabel("");
		winLose.setFont(new Font(fuente, Font.BOLD, heightBotton));
		winLose.setHorizontalAlignment(SwingConstants.CENTER);
		winLose.setBounds(0, 0, width, heightBotton);
		add(winLose);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.setFont(new Font(fuente, Font.BOLD, heightBotton/2));
		btnRestart.setBounds((width - widthBotton) / 2, height/2, widthBotton, heightBotton);
		add(btnRestart);
		
		JButton btnSaveScore = new JButton("SAVE");
		btnSaveScore.setFont(new Font(fuente, Font.BOLD, heightBotton/2));
		btnSaveScore.setBounds((width - widthBotton) / 2, height/2 + heightBotton + heightBotton/5, widthBotton, heightBotton);
		add(btnSaveScore);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font(fuente, Font.BOLD, heightBotton/2));
		btnExit.setBounds((width - widthBotton) / 2, height/2 + 2*heightBotton + 2*heightBotton/5, widthBotton, heightBotton);
		add(btnExit);
	}
	
	public void backToMenu() {
		//TODO imp
	}
}
