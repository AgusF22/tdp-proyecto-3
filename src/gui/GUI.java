package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data.StatsData;
import data.TopPlayers;
import game.Game;
import imagefactories.ConcreteImageFactory;
import imagefactories.ImageFactory;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;

public class GUI extends JFrame{
	
	/**
	 * Serial por defecto
	 */
	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_SCREEN_WIDTH = 1920;
	public static final int DEFAULT_SCREEN_HEIGHT = 1080;
	protected final int CURRENT_SCREEN_WIDTH;
	protected final int CURRENT_SCREEN_HEIGHT;

	private transient ImageFactory factory;
	private JPanel panelPrincipal;

	public GUI() {
		// TODO Descomentar en ver FINAL
		//Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		//CURRENT_SCREEN_WIDTH = Math.toIntExact(Math.round(screenSize.getWidth()));
		//CURRENT_SCREEN_HEIGHT = Math.toIntExact(Math.round(screenSize.getHeight()));
		
		CURRENT_SCREEN_WIDTH = 1280;
		CURRENT_SCREEN_HEIGHT = 720;
		
		factory = new ConcreteImageFactory(CURRENT_SCREEN_WIDTH, CURRENT_SCREEN_HEIGHT);
		createFrame();
		play();
		setVisible(true);
	}
	
	private void createFrame() {
		setSize(CURRENT_SCREEN_WIDTH, CURRENT_SCREEN_HEIGHT);
		//setUndecorated(true);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void play() {
		panelPrincipal = new GamePanel(factory);
		
		int posW = (int) Math.round((getSize().getWidth() - panelPrincipal.getSize().getWidth()) / 2 -7);
		int posH = (int) Math.round((getSize().getHeight() - panelPrincipal.getSize().getHeight()) -38);
		
		panelPrincipal.setLocation(posW, posH);
		getContentPane().add(panelPrincipal);
		
	}
	
	public void setPanel(JPanel panel) {
		//TODO imp
	}
	
	public StatsData getStatsData() {
		return new StatsData();
	}
}
