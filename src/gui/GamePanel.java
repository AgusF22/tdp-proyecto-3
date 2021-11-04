package gui;

import java.awt.Color;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import game.Game;
import game.labyrinth.Labyrinth;
import imagefactories.ImageFactory;

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
	
	protected transient Game game;
	protected transient Icon labyrinthImage;
	private JLabel lblNewLabel;
	private JLayeredPane panelCapas;
	
	public GamePanel(ImageFactory factory) { 
		labyrinthImage = factory.getLabyrinth1Image();
		crearPanel();
		game = new Game(this, factory);
		crearFondo();
		agregarControles();
		
		repaint();
		System.out.println("Creado panel de juego");
		
		
//		JLabel a = new JLabel("AAAA");
//		a.setBackground(Color.yellow);
//		a.setOpaque(true);
//		a.setBounds(0, 0, 50, 50);
//		
//		JLabel b = new JLabel("BBBB");
//		b.setBackground(Color.red);
//		b.setOpaque(true);
//		b.setBounds(0, 50, 50, 50);
//		
//		JLabel c = new JLabel("CCCC");
//		c.setBackground(Color.green);
//		c.setOpaque(true);
//		c.setBounds(25,25, 50, 50);
//		
//			
//		
//		panelCapas.add(a, JLayeredPane.PALETTE_LAYER);
//		
//		panelCapas.add(b, JLayeredPane.PALETTE_LAYER);
//		
//		panelCapas.add(c, JLayeredPane.PALETTE_LAYER);
	}
	
	private void crearPanel() {
		setSize(labyrinthImage.getIconWidth(), labyrinthImage.getIconHeight());
		setBackground(Color.BLACK);
		setLayout(null);
		
		//TODO probando capas con JLayerPane
		panelCapas = new JLayeredPane();
		panelCapas.setBounds(0, 0, this.getWidth(), this.getHeight());
		add(panelCapas);
		
	}
	
	private void crearFondo() {
		lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, labyrinthImage.getIconWidth(), labyrinthImage.getIconHeight());
		lblNewLabel.setIcon(labyrinthImage);
		//add(lblNewLabel); TODO PROBANDO CAPAS
		
		panelCapas.add(lblNewLabel, JLayeredPane.DEFAULT_LAYER);
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
		
		// FIXME los string arriba, abajo, izquierda, y derecha se repiten 3 veces, cambiar a constantes -AF
		String arriba = "arriba";
		String abajo = "abajo";
		String derecha = "deracha";
		String izquierda = "izquierda";
		
		getInputMap().put(KeyStroke.getKeyStroke("UP"), arriba);
		getInputMap().put(KeyStroke.getKeyStroke("W"), arriba);
		getInputMap().put(KeyStroke.getKeyStroke("DOWN"), abajo);
		getInputMap().put(KeyStroke.getKeyStroke("S"), abajo);
		getInputMap().put(KeyStroke.getKeyStroke("RIGHT"), derecha);
		getInputMap().put(KeyStroke.getKeyStroke("D"), derecha);
		getInputMap().put(KeyStroke.getKeyStroke("LEFT"), izquierda);
		getInputMap().put(KeyStroke.getKeyStroke("A"), izquierda);
		
		getActionMap().put(arriba, moveUp);
		getActionMap().put(abajo, moveDown);
		getActionMap().put(derecha, moveRight);
		getActionMap().put(izquierda, moveLeft);
	}
	
	/**
	 * Mueve al personaje principal a arriba.
	 */
	public void moveUp() {
		System.out.println("W o UP");
		game.moveUp(); //TODO sacar
	}
	
	/**
	 * Mueve al personaje principal a la derecha.
	 */
	public void moveRight() {
		System.out.println("D o RIGHT"); //TODO sacar
		game.moveRight();
	}
	
	/**
	 * Mueve al personaje principal a abajo.
	 */
	public void moveDown() {
		System.out.println("S o DOWN"); //TODO sacar
		game.moveDown();
	}
	
	/**
	 * Mueve al personaje principal a la izquierda.
	 */
	public void moveLeft() {
		System.out.println("A o LEFT"); //TODO sacar
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
	
	public void addLabel(JLabel label) {
		//this.add(label);  TODO PROBANDO CAPAS
		panelCapas.add(label, JLayeredPane.PALETTE_LAYER);
		System.out.println("Agregada label"); //TODO sacar
	}
	
	public void removeLabel(JLabel label) {
		//this.remove(label);  TODO PROBANDO CAPAS
		panelCapas.remove(label);
	}
	
	public void updateLabel(JLabel label, float x, float y) {		
		if (label.getParent() != this) {
			//tirar exception
		}
		
		float zoneWidth = (float) getWidth() / Labyrinth.WIDTH;			// FIXME castear uno de los operandos a float -AF
		float zoneHeight = (float) getHeight() / Labyrinth.HEIGHT;		// FIXME castear uno de los operandos a float -AF
		
		float posX = x * zoneWidth + zoneWidth / 2;
		float posY = y * zoneHeight + zoneHeight / 2;
		
		posX -= (float) label.getWidth() / 2;							// FIXME castear uno de los operandos a float -AF
		posY -= (float) label.getHeight();
		
		label.setLocation(Math.round(posX), Math.round(posY));
	}
}
