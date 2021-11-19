package gui;

import javax.swing.JFrame;

import audio.MusicPlayer;
import data.StatsData;
import imagefactories.ImageFactory;
import imagefactories.ConcreteImageFactory;

public class GUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_SCREEN_WIDTH = 1920;
	public static final int DEFAULT_SCREEN_HEIGHT = 1080;
	
	protected final int currentScreenWidth;
	protected final int currentScreenHeight;
	protected final String fuente;
	protected MusicPlayer musicPlayer;

	private transient ImageFactory factory;

	public GUI() {
		// TODO Descomentar en ver FINAL
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//CURRENT_SCREEN_WIDTH = Math.toIntExact(Math.round(screenSize.getWidth()));
		//CURRENT_SCREEN_HEIGHT = Math.toIntExact(Math.round(screenSize.getHeight()));
		currentScreenWidth = 1280;
		currentScreenHeight = 720;
		fuente = "SansSerif";
		factory = new ConcreteImageFactory(currentScreenWidth, currentScreenHeight);
		
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
		//setUndecorated(true);
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
	 * Devuelve los datos de stats.
	 * @return un StatsData.
	 */
	public StatsData getStatsData() {
		return new StatsData();
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
	 * @return el musicPlayer.
	 */
	public MusicPlayer getMusicPlayer() {
		return musicPlayer;
	}

}
