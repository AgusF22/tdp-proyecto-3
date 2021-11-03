package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;

public class StartPanel extends JPanel{
	
	public StartPanel() {
		setSize(500, 500);
		setBackground(Color.PINK);
		setLayout(null);
		
		JButton btnPlay = new JButton("PLAY");
		btnPlay.setFont(new Font("SansSerif", Font.BOLD, 40));
		btnPlay.setBounds(125, 50, 250, 50);
		add(btnPlay);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 40));
		btnExit.setBounds(125, 170, 250, 50);
		add(btnExit);
		
		JButton btnScores = new JButton("SCORES");
		btnScores.setFont(new Font("SansSerif", Font.BOLD, 40));
		btnScores.setBounds(125, 110, 250, 50);
		add(btnScores);
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
