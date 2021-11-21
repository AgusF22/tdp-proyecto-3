package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import exceptions.DataLoadException;
import game.Game;
import game.labyrinth.Labyrinth;
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
	private int score;
	private JLabel lblLives;

	private JLabel lblBombs;
	
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
		//lives = game.getLives();
		
		repaint();
		game.start();
	}
	
	/**
	 * Actualiza los puntos.
	 */
	public void updatePoints() {
		score = game.getPoints();
		lblScore.setText("SCORE: "+score);
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
	}
	
	/**
	 * Remueve el label pasado por parametro.
	 * @param label un label.
	 */
	public void removeLabel(JLabel label) {
		panelCapas.remove(label);
		panelCapas.revalidate();
		panelCapas.repaint();
	}
	
	/**
	 * Mueve el label pasado por parametro a la posicion pasada por parametro.
	 * @param label un label.
	 * @param x la coordenada x.
	 * @param y la coordenada y.
	 */
	public void updateLabel(JLabel label, float x, float y) {
		
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
	public void setLabyrinthImage(Icon lab, Icon bg) {
		int width = lab.getIconWidth();
		int height = lab.getIconHeight();
		
		panelCapas.setSize(width, height);
		
		labyrinthLabel.setSize(width, height);
		labyrinthLabel.setIcon(lab);
		
		setLabyrinthBgImage(bg);
		
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
	 * Cambia el contador de vidas de la ventana y lo actualiza.
	 */
	public void updateLives(int lives) {
		lblLives.setText("LIVES: " + lives);
	}
	
	/**
	 * Cambia el contador de bombas de la ventana y lo actualiza.
	 */
	public void updateBombs(int bombs) {
		lblBombs.setText("BOMBS: " + bombs);
	}

	/**
	 * Crea los labels y los coloca en el panel.
	 */
	private void crearLabels() {
		
		lblScore = new JLabel("");
		lblScore.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		lblScore.setHorizontalAlignment(SwingConstants.LEFT);
		lblScore.setForeground(new Color(186, 64, 50));
		lblScore.setBounds(((width - (scaleWidth*9)/4)*61)/100, (scaleHeight*1)/6, (scaleWidth*9)/4, scaleHeight);
		lblScore.setText("SCORE: "+score);
		lblScore.setBackground(new Color(250, 128, 114));
		lblScore.setOpaque(true);
		lblScore.setBorder(new LineBorder(new Color(186, 64, 50), scaleHeight/8, false));
		add(lblScore);
		
		lblLives = new JLabel("");
		lblLives.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		lblLives.setHorizontalAlignment(SwingConstants.LEFT);
		lblLives.setForeground(new Color(186, 64, 50));
		lblLives.setBounds(((width - (scaleWidth*5)/4)*32)/100, (scaleHeight*1)/6, (scaleWidth*5)/4, scaleHeight);
		lblLives.setText("LIVES: "+0);
		lblLives.setBackground(new Color(250, 128, 114));
		lblLives.setOpaque(true);
		lblLives.setBorder(new LineBorder(new Color(186, 64, 50), scaleHeight/8, false));
		add(lblLives);
		
		lblBombs = new JLabel("");
		lblBombs.setFont(new Font(fuente, Font.BOLD, scaleHeight));
		lblBombs.setHorizontalAlignment(SwingConstants.LEFT);
		lblBombs.setForeground(new Color(186, 64, 50));
		lblBombs.setBounds(((width - (scaleWidth*6)/4)*8)/100, (scaleHeight*1)/6, (scaleWidth*6)/4, scaleHeight);
		lblBombs.setText("BOMBS: "+0);
		lblBombs.setBackground(new Color(250, 128, 114));
		lblBombs.setOpaque(true);
		lblBombs.setBorder(new LineBorder(new Color(186, 64, 50), scaleHeight/8, false));
		add(lblBombs);
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
		
		Action bomb = new AbstractAction() {
			private static final long serialVersionUID = 1L;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				placeBomb();
			}
		};
		
		final String arriba = "arriba";
		final String abajo = "abajo";
		final String derecha = "deracha";
		final String izquierda = "izquierda";
		final String bomba = "bomba";
		
		InputMap iMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		iMap.put(KeyStroke.getKeyStroke("UP"), arriba);
		iMap.put(KeyStroke.getKeyStroke("W"), arriba);
		iMap.put(KeyStroke.getKeyStroke("DOWN"), abajo);
		iMap.put(KeyStroke.getKeyStroke("S"), abajo);
		iMap.put(KeyStroke.getKeyStroke("RIGHT"), derecha);
		iMap.put(KeyStroke.getKeyStroke("D"), derecha);
		iMap.put(KeyStroke.getKeyStroke("LEFT"), izquierda);
		iMap.put(KeyStroke.getKeyStroke("A"), izquierda);
		iMap.put(KeyStroke.getKeyStroke("SPACE"), bomba);
		
		getActionMap().put(arriba, moveUp);
		getActionMap().put(abajo, moveDown);
		getActionMap().put(derecha, moveRight);
		getActionMap().put(izquierda, moveLeft);
		getActionMap().put(bomba, bomb);
	}

	/**
	 * Coloca una bomba.
	 */
	private void placeBomb() {
		game.placeBomb();
	}

	/**
	 * Mueve al personaje principal a arriba.
	 */
	private void moveUp() {
		game.moveUp();
	}

	/**
	 * Mueve al personaje principal a la derecha.
	 */
	private void moveRight() {
		game.moveRight();
	}

	/**
	 * Mueve al personaje principal a abajo.
	 */
	private void moveDown() {
		game.moveDown();
	}

	/**
	 * Mueve al personaje principal a la izquierda.
	 */
	private void moveLeft() {
		game.moveLeft();
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
