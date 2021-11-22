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

/**
 * Modela el panel del juego.
 */
public class GamePanel extends GUIPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected transient Game game;
	
	private JLabel labyrinthLabel;
	private JLayeredPane panelCapas;
	private JLabel fondo;
	private JLabel lblScore;
	private JLabel lblLives;
	private JLabel lblBombs;
	
	/**
	 * Crea un nuevo panel del juego.
	 * @param gui La gui en la que se encontrara este panel.
	 */
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
		
		repaint();
		game.start();
	}
	
	/**
	 * Setea propiedades del panel.
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
	 * Crea los labels y los coloca en el panel.
	 */
	private void crearLabels() {
		Font font = new Font(fuente, Font.BOLD, scaleHeight);
		Color foregroundColor = new Color(186, 64, 50);
		Color backgroundColor = new Color(250, 128, 114);
		LineBorder border = new LineBorder(new Color(186, 64, 50), scaleHeight/8, false);
		int yPos = (scaleHeight * 1) / 6;
		
		lblScore = new JLabel("SCORE: " + 0);
		lblLives = new JLabel("LIVES: " + 0);
		lblBombs = new JLabel("BOMBS: " + 0);
		
		lblScore.setFont(font);
		lblLives.setFont(font);
		lblBombs.setFont(font);
		
		lblScore.setHorizontalAlignment(SwingConstants.LEFT);
		lblLives.setHorizontalAlignment(SwingConstants.LEFT);
		lblBombs.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblScore.setForeground(foregroundColor);
		lblLives.setForeground(foregroundColor);
		lblBombs.setForeground(foregroundColor);
		
		lblScore.setBounds(((guiPanelWidth - (scaleWidth * 9) / 4) * 61) / 100,
							yPos, (scaleWidth * 9) / 4, scaleHeight);
		lblLives.setBounds(((guiPanelWidth - (scaleWidth * 5) / 4) * 32) / 100,
							yPos, (scaleWidth * 5) / 4, scaleHeight);
		lblBombs.setBounds(((guiPanelWidth - (scaleWidth * 6) / 4) * 8) / 100,
							yPos, (scaleWidth * 6) / 4, scaleHeight);
		
		lblScore.setBackground(backgroundColor);
		lblLives.setBackground(backgroundColor);
		lblBombs.setBackground(backgroundColor);
		
		lblScore.setOpaque(true);
		lblLives.setOpaque(true);
		lblBombs.setOpaque(true);
		
		lblScore.setBorder(border);
		lblLives.setBorder(border);
		lblBombs.setBorder(border);
		
		add(lblScore);
		add(lblLives);
		add(lblBombs);
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
		
		final String arriba		= "arriba";
		final String abajo		= "abajo";
		final String derecha	= "deracha";
		final String izquierda	= "izquierda";
		final String bomba		= "bomba";
		
		InputMap iMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		iMap.put(KeyStroke.getKeyStroke("UP"),		arriba);
		iMap.put(KeyStroke.getKeyStroke("W"),		arriba);
		iMap.put(KeyStroke.getKeyStroke("DOWN"),	abajo);
		iMap.put(KeyStroke.getKeyStroke("S"),		abajo);
		iMap.put(KeyStroke.getKeyStroke("RIGHT"),	derecha);
		iMap.put(KeyStroke.getKeyStroke("D"),		derecha);
		iMap.put(KeyStroke.getKeyStroke("LEFT"),	izquierda);
		iMap.put(KeyStroke.getKeyStroke("A"),		izquierda);
		iMap.put(KeyStroke.getKeyStroke("SPACE"),	bomba);
		
		getActionMap().put(arriba,		moveUp);
		getActionMap().put(abajo,		moveDown);
		getActionMap().put(derecha,		moveRight);
		getActionMap().put(izquierda,	moveLeft);
		getActionMap().put(bomba,		bomb);
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
	 * Informa al juego que se quiere colocar una bomba.
	 */
	private void placeBomb() {
		game.placeBomb();
	}

	/**
	 * Informa al juego que se quiere mover al jugador hacia arriba.
	 */
	private void moveUp() {
		game.moveUp();
	}

	/**
	 * Informa al juego que se quiere mover al jugador hacia la derecha.
	 */
	private void moveRight() {
		game.moveRight();
	}

	/**
	 * Informa al juego que se quiere mover al jugador hacia abajo.
	 */
	private void moveDown() {
		game.moveDown();
	}

	/**
	 * Informa al juego que se quiere mover al jugador hacia la izquierda.
	 */
	private void moveLeft() {
		game.moveLeft();
	}
	
	/**
	 * Actualiza el puntaje mostrado.
	 */
	public void updatePoints() {
		lblScore.setText("SCORE: " + game.getPoints());
	}
	
	/**
	 * Actualiza las vidas mostradas.
	 * @param lives La nueva cantidad de vidas a mostrar.
	 */
	public void updateLives(int lives) {
		lblLives.setText("LIVES: " + lives);
	}
	
	/**
	 * Actualiza las bombas mostradas.
	 * @param bombs La nueva cantidad de bombas a mostrar.
	 */
	public void updateBombs(int bombs) {
		lblBombs.setText("BOMBS: " + bombs);
	}
	
	/**
	 * Cambia la gui al panel de juego ganado.
	 */
	public void winGame() {
		frame.setPanel(new WinPanel(frame, game.getPoints()));
	}
	
	/**
	 * Cambia la gui al panel de juego perdido.
	 */
	public void loseGame() {
		frame.setPanel(new LosePanel(frame, game.getPoints()));
	}
	
	/**
	 * Agrega el label pasado por parametro al panel
	 * @param label Un label.
	 * @parama depth La profundidad en la que se añadira el label (a mayor valor, mas al frente).
	 */
	public void addLabel(JLabel label, int depth) {
		panelCapas.add(label, Integer.valueOf(1 + depth), 0);
	}
	
	/**
	 * Remueve el label pasado por parametro del panel.
	 * @param label Un label.
	 */
	public void removeLabel(JLabel label) {
		panelCapas.remove(label);
		panelCapas.revalidate();
		panelCapas.repaint();
	}
	
	/**
	 * Mueve el label pasado como parametro a las coordenadas indicadas.
	 * @param label Un label.
	 * @param x Coordenada x.
	 * @param y Coordenada y.
	 */
	public void updateLabel(JLabel label, float x, float y) {
		
		float zoneWidth = (float) panelCapas.getWidth() / Labyrinth.WIDTH;
		float zoneHeight = (float) panelCapas.getHeight() / Labyrinth.HEIGHT;
		
		float posX = x * zoneWidth + zoneWidth / 2f;
		float posY = y * zoneHeight + zoneHeight / 2f;
		
		posX -= (float) label.getWidth() / 2;
		posY -= label.getHeight();
		
		label.setLocation(Math.round(posX), Math.round(posY));
	}
	
	/**
	 * Cambia la imagen del laberinto
	 * @param labIcon Icon nuevo imagen del laberinto
	 */
	public void setLabyrinthImage(Icon labIcon, Icon bgIcon) {
		int width = labIcon.getIconWidth();
		int height = labIcon.getIconHeight();
		
		panelCapas.setSize(width, height);
		
		labyrinthLabel.setSize(width, height);
		labyrinthLabel.setIcon(labIcon);
		
		setLabyrinthBgImage(bgIcon);
		
	}
	
	/**
	 * Cambia la imagen de fondo de este panel.
	 * @param icon nuevo imagen de fondo para este panel.
	 */
	public void setLabyrinthBgImage(Icon icon) {
		int width = icon.getIconWidth();
		int height = icon.getIconHeight();
		
		setSize(width, height);
		fondo.setSize(width, height);
		fondo.setIcon(icon);
		
		// Centrar panelCapas
		int posW = Math.round((getWidth() - panelCapas.getWidth()) / 2f - 7f);
		int posH = Math.round((getHeight() - panelCapas.getHeight()) - 38f);
		panelCapas.setLocation(posW, posH);
	}
	
	/**
	 * Devuelve la fabrica de imagenes de la gui principal.
	 * @return La fabrica de imagenes de la gui principal.
	 */
	public ImageFactory getImageFactory() {
		return frame.getImageFactory();
	}
	
	
	
}
