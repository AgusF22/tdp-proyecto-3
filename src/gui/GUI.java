package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data.StatsData;
import game.Game;
import imageFactories.ConcreteImageFactory;
import java.awt.BorderLayout;
import imageFactories.ImageFactory;

public class GUI extends JFrame{
	
	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	
	protected Game game;

	private ImageFactory factory;
	
	private JPanel panelPrincipal;

	public GUI() {
		factory = new ConcreteImageFactory();
		//game = new Game(factory);
		createFrame();
		play();
		setVisible(true);
	}
	
	private void createFrame() {
		setSize(1920, 1080);
		//setSize(1280, 720);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void play() {
		panelPrincipal = new GamePanel(factory);
		
		int posW = (int) (getSize().getWidth() - panelPrincipal.getSize().getWidth()) / 2;
		int posH = (int) (getSize().getHeight() - panelPrincipal.getSize().getHeight()) / 2;
		
		panelPrincipal.setLocation(posW, posH);
		getContentPane().add(panelPrincipal);
		
	}
	
	public void setPanel(JPanel panel) {
		
	}
	
	public StatsData getStatsData() {
		return null;
	}
}
