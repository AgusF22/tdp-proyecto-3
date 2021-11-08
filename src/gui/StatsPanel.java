package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class StatsPanel extends GUIPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	
	public StatsPanel(GUI gui) {
		super(gui);
		
		setLayout(null);
		setSize(width, height);
		
		int scaleWidth= width/4;
		int scaleHeight = height/15;
		
		crearBotones(scaleWidth, scaleHeight);
		crearFondo();
	}
	
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, width, height);
		fondo.setIcon(frame.getImageFactory().getStatsBgImage());
		add(fondo);
	}
	
	private void crearBotones(int scaleWidth, int scaleHeight) {
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		btnMenu.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnMenu.setBounds((width - scaleWidth) / 2, height/2 + scaleHeight + scaleHeight/5, scaleWidth, scaleHeight);
		add(btnMenu);
	}
	
	/**
	 * Carga en la gui una nueva pantalla de inicio
	 */
	public void backToMenu() {
		frame.setPanel(new StartPanel(frame));
	}
	
}
