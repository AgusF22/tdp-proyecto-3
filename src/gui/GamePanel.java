package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game.Game;
import imageFactories.ImageFactory;
import java.awt.BorderLayout;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GamePanel extends JPanel {
	
	/**
	 * Serial por defecto.
	 */
	private static final long serialVersionUID = 1L;
	
	protected Game game;
	protected ImageIcon labyrinthImage;
	//protected List<JLabel> labels;

	private JLabel lblNewLabel;
	
	public GamePanel(ImageFactory factory) {
		
		game = new Game(factory);
		//labels = new ArrayList<JLabel>();
		labyrinthImage = factory.getLabyrinth1Image();
		
		crearPanel();
		crearFondo();
		agregarControles();
		
		repaint();
	}
	
	private void crearPanel() {
		//setSize(870, 935);
		setSize(580, 623);
		setBackground(Color.BLACK);
		setLayout(new BorderLayout(0, 0));
	}
	
	private void crearFondo() {
		
		lblNewLabel = new JLabel("");
		//lblNewLabel.setSize(870, 935);
		lblNewLabel.setSize(580, 623);
		ImageIcon imgIcon = labyrinthImage;
		Image imgEscalada = imgIcon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		Icon iconoEscalado = new ImageIcon(imgEscalada);
		lblNewLabel.setIcon(iconoEscalado);
		add(lblNewLabel, BorderLayout.CENTER);
	}
	
	private void agregarControles() {
		Action moveUp = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveUp();
			}
		};
		
		Action moveDown = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveDown();
			}
		};
		
		Action moveRight = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveRight();
			}
		};
		
		Action moveLeft = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveLeft();
			}
		};
		
		getInputMap().put(KeyStroke.getKeyStroke("UP"), "arriba");
		getInputMap().put(KeyStroke.getKeyStroke("W"), "arriba");
		getInputMap().put(KeyStroke.getKeyStroke("DOWN"), "abajo");
		getInputMap().put(KeyStroke.getKeyStroke("S"), "abajo");
		getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), "derecha");
		getInputMap().put(KeyStroke.getKeyStroke("D"), "derecha");
		getInputMap().put(KeyStroke.getKeyStroke("LEFT"), "izquierda");
		getInputMap().put(KeyStroke.getKeyStroke("A"), "izquierda");
		
		getActionMap().put("arriba", moveUp);
		getActionMap().put("abajo", moveDown);
		getActionMap().put("derecha", moveRight);
		getActionMap().put("izquierda", moveLeft);
	}
	
	/**
	 * Mueve al personaje principal a arriba.
	 */
	public void moveUp() {
		System.out.println("W o UP");
		game.moveUp();
	}
	
	/**
	 * Mueve al personaje principal a la derecha.
	 */
	public void moveRight() {
		System.out.println("D o RIGHT");
		//game.moveRight();
	}
	
	/**
	 * Mueve al personaje principal a abajo.
	 */
	public void moveDown() {
		System.out.println("S o DOWN");
		game.moveDown();
	}
	
	/**
	 * Mueve al personaje principal a la izquierda.
	 */
	public void moveLeft() {
		System.out.println("A o LEFT");
		//game.moveLeft();
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
	
	public void addLabel(JLabel label) {
		this.add(label);
	}
	
	public void removeLabel(JLabel label) {
		this.remove(label);
	}
	
	public void updateLabel(JLabel label, float x, float y) {
		if (label.getParent() != this) {
			//tirar exception
		}
		
		label.setLocation(1, 1);
	}
}
