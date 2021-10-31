package gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import game.Game;
import imageFactories.ImageFactory;

public class GamePanel extends JPanel {
	
	/**
	 * Serial por defecto.
	 */
	private static final long serialVersionUID = 1L;
	
	protected Game game;
	JLabel[] labels;
	
	public GamePanel(ImageFactory factory) {
		this.game = new Game(factory);
	}
	
	public void moveUp() {
		game.moveUp();
	}
	
	public void moveRight() {
		game.moveRight();
	}
	
	public void moveDown() {
		game.moveDown();
	}
	
	public void moveLeft() {
		game.moveLeft();
	}
	
	public void updatePoints() {
		//TODO imp
	}
	
	public void winGame() {
		//TODO imp
	}
	
	public void loseGame() {
		//TODO imp
	}
	
	public void updateLabel(JLabel label, float x, float y) {
		
	}
}
