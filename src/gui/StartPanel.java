package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;

public class StartPanel extends GUIPanel{
	
	protected JLabel fondo;
	
	public StartPanel(GUI gui) {
		super(gui);
		setLayout(null);
		setSize(width, height);
		int scaleWidth= width/4;
		int scaleHeight = height/15;
		
		crearBotones(scaleWidth, scaleHeight);
		crearFondo();
	}
	
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, width, height);
		fondo.setIcon(frame.getImageFactory().getStartBgImage());
		add(fondo);
	}
	
	private void crearBotones(int scaleWidth, int scaleHeight) {
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnPlay.setBounds((width - scaleWidth) / 2, height/2 + scaleHeight + scaleHeight/5, scaleWidth, scaleHeight);
		add(btnPlay);
		
		JButton btnScores = new JButton("SCORES");
		btnScores.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnScores.setBounds((width - scaleWidth) / 2, height/2 + 2*scaleHeight + 2*scaleHeight/5, scaleWidth, scaleHeight);
		add(btnScores);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnExit.setBounds((width - scaleWidth) / 2, height/2 + 3*scaleHeight + 3*scaleHeight/5, scaleWidth, scaleHeight);
		add(btnExit);
	}
	
	public void startGame() {
		//TODO imp
	}
	
	public void viewStats() {
		//TODO imp
	}
	
	public void exitGame() {
		//TODO imp
	}
}
