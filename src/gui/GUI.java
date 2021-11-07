package gui;

import javax.swing.JFrame;

import data.StatsData;
import imagefactories.ImageFactory;
import imagefactories.ConcreteImageFactory;

public class GUI extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	public static final int DEFAULT_SCREEN_WIDTH = 1920;
	public static final int DEFAULT_SCREEN_HEIGHT = 1080;
	
	protected final int CURRENT_SCREEN_WIDTH;
	protected final int CURRENT_SCREEN_HEIGHT;
	protected final String FUENTE;

	private transient ImageFactory factory;
	private GUIPanel panel;

	public GUI() {
		// TODO Descomentar en ver FINAL
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//CURRENT_SCREEN_WIDTH = Math.toIntExact(Math.round(screenSize.getWidth()));
		//CURRENT_SCREEN_HEIGHT = Math.toIntExact(Math.round(screenSize.getHeight()));
		
		CURRENT_SCREEN_WIDTH = 1280;
		CURRENT_SCREEN_HEIGHT = 720;
		FUENTE = "SansSerif";
		
		factory = new ConcreteImageFactory(CURRENT_SCREEN_WIDTH, CURRENT_SCREEN_HEIGHT);
		createFrame();
		play();
		setVisible(true);
		
		//panel = new LosePanel(this, 0);
		//panel = new StartPanel(this);
		add(panel);
		repaint();
	}
	
	private void createFrame() {
		setSize(CURRENT_SCREEN_WIDTH, CURRENT_SCREEN_HEIGHT);
		//setUndecorated(true);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void play() {					// TODO remover, usar setPanel -AF
		panel = new GamePanel(this);
		getContentPane().add(panel);	
	}
	
	/**
	 * Cambia el panel actual de esta gui.
	 * @param panel El panel para mostrar en la gui.
	 */
	public void setPanel(GUIPanel panel) {
		getContentPane().removeAll();
		this.panel = panel;
		getContentPane().add(panel);			// TODO revisar si esto es correcto -AF
	}
	
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
}
