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
import imagefactories.ConcreteImageFactory;
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
	private JLabel LabyrinthLabel;
	private JLayeredPane panelCapas;
	private JLabel fondo;
	
	public GamePanel(ImageFactory factory) { 
		crearPanel();
		agregarControles();
		
		game = new Game(this, factory);
		repaint();
		System.out.println("Creado panel de juego");
		
	}
	
	private void crearPanel() {
		setLayout(null);
		setLocation(0, 0);
		
		panelCapas = new JLayeredPane();
		add(panelCapas);
		
		fondo = new JLabel("");
		fondo.setLocation(0, 0);
		add(fondo);
		
		LabyrinthLabel = new JLabel("");
		LabyrinthLabel.setLocation(0, 0);
		panelCapas.add(LabyrinthLabel, 0);
	}
	
	private void agregarControles() {
		Action moveUp = new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				moveUp();
			}
		};
		
		Action moveDown = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveDown();
			}
		};
		
		Action moveRight = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveRight();
			}
		};
		
		Action moveLeft = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				moveLeft();
			}
		};
		
		final String arriba = "arriba";
		final String abajo = "abajo";
		final String derecha = "deracha";
		final String izquierda = "izquierda";
		
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
		panelCapas.add(label, 100);
		System.out.print("Agregada label"); //TODO sacar
	}
	
	public void removeLabel(JLabel label) {
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
	
	/**
	 * Cambia la imagen del laberinto
	 * @param lab Icon nuevo imagen del laberinto
	 */
	public void setLabyrinthImage(Icon lab) {
		int width = lab.getIconWidth();
		int height = lab.getIconHeight();
		
		panelCapas.setSize(width, height);
		
		LabyrinthLabel.setSize(width, height);
		LabyrinthLabel.setIcon(lab);
		
		//TODO sacar las dos siguientes 
		ImageFactory f = new ConcreteImageFactory(1280, 720);
		setLabyrinthBgImage(f.getLabyrinth1bgImage());
		// -------------------------------------------------
		
	}
	
	/**
	 * Cambia la imagen del fondo del laberinto
	 * @param lab Icon nuevo imagen del fondo del laberinto
	 */
	public void setLabyrinthBgImage(Icon lab) {
		int width = lab.getIconWidth();
		int height = lab.getIconHeight();
		
		setSize(width, height);
		fondo.setSize(width, height);
		fondo.setIcon(lab);
		centrar(width, height);
	}
	
	private void centrar(int w, int h) {
		int posW = (int) Math.round((getWidth() - panelCapas.getWidth()) / 2 - 7);
		int posH = (int) Math.round((getHeight() - panelCapas.getHeight()) - 38);
		panelCapas.setLocation(posW, posH);
	}
}
