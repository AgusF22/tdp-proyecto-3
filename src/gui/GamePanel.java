package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import exceptions.DataLoadException;
import game.Game;
import game.labyrinth.Labyrinth;
import imagefactories.ConcreteImageFactory;
import imagefactories.ImageFactory;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.InputMap;
import javax.swing.JComponent;

public class GamePanel extends GUIPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected transient Game game;
	private JLabel labyrinthLabel;
	private JLayeredPane panelCapas;
	private JLabel fondo;
	private JLabel lblScore;
	private JLabel lblScoreText;
	private int score;
	
	// TODO se necesitan componentes para mostrar el puntaje, y para poder implementar winGame, loseGame, y updatePoints -AF
	
	public GamePanel(GUI gui) { 
		super(gui);
		
		crearPanel();
		crearLabels();
		agregarControles();
		crearFondo();
		
		try {
			game = new Game(this);
		} catch (DataLoadException e) {
			e.printStackTrace();
		}
		
		score = game.getPoints();
		lblScore.setText(""+score);
		
		repaint();
		
		
		System.out.println();
		System.out.println("Creado panel de juego");
		
		game.start();
	}
	
	/**
	 * Crea los labels y los coloca en el panel.
	 */
	private void crearLabels() {
		lblScoreText = new JLabel("");
		lblScoreText.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		lblScoreText.setHorizontalAlignment(SwingConstants.LEFT);
		lblScoreText.setForeground(new Color(250, 128, 114));
		lblScoreText.setBounds(((width - scaleWidth)*2/5), 0, scaleWidth, scaleHeight);
		lblScoreText.setText("SCORE: ");
		add(lblScoreText);
		
		lblScore = new JLabel("");
		lblScore.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		lblScore.setHorizontalAlignment(SwingConstants.LEFT);
		lblScore.setForeground(new Color(250, 128, 114));
		lblScore.setBounds(((width - scaleWidth)*3/5), 0, scaleWidth, scaleHeight);
		lblScore.setText(""+score);
		add(lblScore);
	}

	/**
	 * Setea algunas propiedades del panel.
	 */
	private void crearPanel() {
		setLayout(null);
		setLocation(0, 0);
		panelCapas = new JLayeredPane();
		add(panelCapas);
		
		labyrinthLabel = new JLabel("");
		labyrinthLabel.setLocation(0, 0);
		panelCapas.add(labyrinthLabel, Integer.valueOf(0), 0);
	}
	
	/**
	 * Crea el fondo del panel.
	 */
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setLocation(0, 0);
		add(fondo);
	}
	
	/**
	 * Agrega los controles al panel.
	 */
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
		
		InputMap iMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		iMap.put(KeyStroke.getKeyStroke("UP"), arriba);
		iMap.put(KeyStroke.getKeyStroke("W"), arriba);
		iMap.put(KeyStroke.getKeyStroke("DOWN"), abajo);
		iMap.put(KeyStroke.getKeyStroke("S"), abajo);
		iMap.put(KeyStroke.getKeyStroke("RIGHT"), derecha);
		iMap.put(KeyStroke.getKeyStroke("D"), derecha);
		iMap.put(KeyStroke.getKeyStroke("LEFT"), izquierda);
		iMap.put(KeyStroke.getKeyStroke("A"), izquierda);
		
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
	
	/**
	 * Actualiza los puntos.
	 */
	public void updatePoints() {
		score = game.getPoints();
		lblScore.setText(""+score);
	}
	
	/**
	 * Elimina este panel y carga un nuevo panel de juego ganado en la gui principal.
	 */
	public void winGame() {
		frame.setPanel(new WinPanel(frame, game.getPoints()));
	}
	
	/**
	 * Elimina este panel y carga un nuevo panel de juego perdido en la gui principal.
	 */
	public void loseGame() {
		frame.setPanel(new LosePanel(frame, game.getPoints()));
	}
	
	/**
	 * Agrega el label pasado por parametro al panel
	 * @param label
	 */
	public void addLabel(JLabel label) {
		panelCapas.add(label, Integer.valueOf(1), 0);
		System.out.print("Agregada label "); //TODO sacar
	}
	
	/**
	 * Remueve el label pasado por parametro.
	 * @param label un label.
	 */
	public void removeLabel(JLabel label) {
		panelCapas.remove(label);
	}
	
	/**
	 * Mueve el label pasado por parametro a la posicion pasada por parametro.
	 * @param label un label.
	 * @param x la coordenada x.
	 * @param y la coordenada y.
	 */
	public void updateLabel(JLabel label, float x, float y) {		
		if (label.getParent() != this) {
			//tirar exception
		}
		
		float zoneWidth = (float) panelCapas.getWidth() / Labyrinth.WIDTH;
		float zoneHeight = (float) panelCapas.getHeight() / Labyrinth.HEIGHT;
		
		float posX = x * zoneWidth + zoneWidth / 2f;
		float posY = y * zoneHeight + zoneHeight / 2f;
		
		posX -= (float) label.getWidth() / 2;
		posY -= label.getHeight(); //TODO si las imagenes nuevas quedan mal: restar o sumar const.
		
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
		
		labyrinthLabel.setSize(width, height);
		labyrinthLabel.setIcon(lab);
		
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
		centrar();
	}
	
	/**
	 * Devuelve la fabrica de imagenes de la gui principal.
	 * @return La fabrica de imagenes de la gui principal.
	 */
	public ImageFactory getImageFactory() {
		return frame.getImageFactory();
	}
	
	/**
	 * Centra el panelCapas.
	 */
	private void centrar() {
		int posW = (int) Math.round((getWidth() - panelCapas.getWidth()) / 2 - 7f);
		int posH = (int) Math.round((getHeight() - panelCapas.getHeight()) - 38f);
		panelCapas.setLocation(posW, posH);
	}
}
