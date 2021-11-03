package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WinPanel extends GameOverPanel {
	public WinPanel(int finalScore) {
		setSize(500, 500);
		setBackground(Color.GREEN);
		setLayout(null);
		
		// FIXME no repetir strings, usar constantes -AF
		
		JLabel lblWin = new JLabel("YOU WIN");
		lblWin.setFont(new Font("SansSerif", Font.BOLD, 60));
		lblWin.setHorizontalAlignment(SwingConstants.CENTER);
		lblWin.setBounds(50, 50, 400, 100);
		add(lblWin);
		
		JButton btnRestart = new JButton("RESTART");
		btnRestart.setFont(new Font("SansSerif", Font.BOLD, 30));
		btnRestart.setBounds(125, 200, 250, 50);
		add(btnRestart);
		
		JButton btnSaveScore = new JButton("SAVE");
		btnSaveScore.setFont(new Font("SansSerif", Font.BOLD, 30));
		btnSaveScore.setBounds(125, 260, 250, 50);
		add(btnSaveScore);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 30));
		btnExit.setBounds(125, 320, 250, 50);
		add(btnExit);
	}
	
}
