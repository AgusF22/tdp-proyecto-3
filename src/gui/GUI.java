package gui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import audio.MusicPlayer;
import imagefactories.ImageFactory;
import imagefactories.ConcreteImageFactory1;

/**
 * Clase que modela la GUI principal del juego.
 */
public class GUI extends JFrame{
	
	public static final int DEFAULT_SCREEN_WIDTH = 1920;
	public static final int DEFAULT_SCREEN_HEIGHT = 1080;
	
	protected static final String FONT = "SansSerif";	
	
	private static final long serialVersionUID = 1L;

	protected final int currentScreenWidth;
	protected final int currentScreenHeight;
	protected transient MusicPlayer musicPlayer;

	private transient ImageFactory factory;

	/**
	 * Crea una nueva instancia de la gui.
	 */
	public GUI() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//		currentScreenWidth = Math.toIntExact(Math.round(screenSize.getWidth()));
//		currentScreenHeight = Math.toIntExact(Math.round(screenSize.getHeight()));
		
		currentScreenWidth = 1280;
		currentScreenHeight = 720;
		
		factory = new ConcreteImageFactory1(currentScreenWidth, currentScreenHeight);
		
		musicPlayer = new MusicPlayer("/res/music/minecraft/music.wav");
		
		createFrame();
		setPanel(new StartPanel(this));
		
		musicPlayer.start();
	}
	
	/**
	 * Setea las propiedades del frame.
	 */
	private void createFrame() {
		setSize(currentScreenWidth, currentScreenHeight);
//		setUndecorated(true);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	/**
	 * Cambia el panel actual de esta gui.
	 * @param panel El panel para mostrar en la gui.
	 */
	public void setPanel(GUIPanel panel) {
		getContentPane().removeAll();
		getContentPane().add(panel);
		repaint();
	}
	
	/**
	 * Retorna la fabrica de imagenes de esta gui.
	 * @return La fabrica de imagenes de esta gui.
	 */
	public ImageFactory getImageFactory() {
		return factory;
	}
	
	/**
	 * Devuelve el musicPlayer.
	 * @return El musicPlayer.
	 */
	public MusicPlayer getMusicPlayer() {
		return musicPlayer;
	}

}
