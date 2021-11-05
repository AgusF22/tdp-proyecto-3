package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import imagefactories.ImageFactory;

public class WinPanel extends GameOverPanel {
	public WinPanel(GUI gui) {
		super(gui);
		winLose.setText("YOU WIN");
	}
	
}
