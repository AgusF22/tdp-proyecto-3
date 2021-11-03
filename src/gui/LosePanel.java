package gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

public class LosePanel extends GameOverPanel {
	public LosePanel(int finalScore) {
		setSize(500, 500);
		setBackground(Color.RED);
		setLayout(null);
		
		// FIXME no repetir strings, usar constantes -AF
		
		JLabel lblLose = new JLabel("YOU LOSE");
		lblLose.setFont(new Font("SansSerif", Font.BOLD, 60));
		lblLose.setHorizontalAlignment(SwingConstants.CENTER);
		lblLose.setBounds(50, 50, 400, 100);
		add(lblLose);
		
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
