package gui;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import imagefactories.ImageFactory;

import java.awt.Font;
import javax.swing.JButton;

public class LosePanel extends GameOverPanel {
	public LosePanel(GUI gui) {
		super(gui);
		winLose.setText("YOU LOSE");
	}
}
