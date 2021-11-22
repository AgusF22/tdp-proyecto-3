package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;

import imagefactories.*;

/**
 * Frame usado para seleccionar la apariencia del juego.
 */
public class GraphicSelectorFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Crea un nuevo selector de graficas.
	 */
	public GraphicSelectorFrame() {
		setSize(320, 380);
		getContentPane().setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		crearBotones();
		setVisible(true);
	}
	
	/**
	 * Crea los botones de este frame.
	 */
	private void crearBotones() {
		Font font = new Font("SansSerif", Font.BOLD, 20);
		
		JButton btnMinecraft = new JButton("MINECRAFT");
		JButton btnDungeon = new JButton("DUNGEON");
		JButton btnExit = new JButton("EXIT");
		
		btnMinecraft.addActionListener(e -> startWithFactory(new ConcreteImageFactory1()));
		btnDungeon.addActionListener(e -> startWithFactory(new ConcreteImageFactory2()));
		btnExit.addActionListener(e -> exit());
		
		btnMinecraft.setFont(font);
		btnDungeon.setFont(font);
		btnExit.setFont(font);
		
		btnMinecraft.setBounds(50, 101, 220, 50);
		btnDungeon.setBounds(50, 161, 220, 50);
		btnExit.setBounds(50, 271, 220, 50);
		
		getContentPane().add(btnMinecraft);
		getContentPane().add(btnDungeon);
		getContentPane().add(btnExit);
		
		JLabel lblNewLabel = new JLabel("SELECT GRAPHICS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(font);
		lblNewLabel.setBounds(10, 11, 300, 40);
		getContentPane().add(lblNewLabel);
		
		
	}
	
	/**
	 * Inicia la gui del juego.
	 * @param imgFact La factory para el juego.
	 */
	protected void startWithFactory(ImageFactory imgFact) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int currentScreenWidth = Math.toIntExact(Math.round(screenSize.getWidth()));
		int currentScreenHeight = Math.toIntExact(Math.round(screenSize.getHeight()));
		
		new GUI(imgFact, currentScreenWidth, currentScreenHeight);
	}
	
	/**
	 * Cierra el programa.
	 */
	protected void exit() {
		System.exit(0);
	}
	
}
