package gui;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GraphicSelectorFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	public GraphicSelectorFrame() {
		setSize(320, 380);
		getContentPane().setLayout(null);
		setUndecorated(true);
		setLocationRelativeTo(null);
		crearBotones();
	}
	
	private void crearBotones() {
		JButton btnMinecraft = new JButton("MINECRAFT");
		btnMinecraft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMinecraft.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnMinecraft.setBounds(50, 101, 220, 50);
		getContentPane().add(btnMinecraft);
		
		JButton btnDungeon = new JButton("DUNGEON");
		btnDungeon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDungeon.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnDungeon.setBounds(50, 161, 220, 50);
		getContentPane().add(btnDungeon);
		
		JLabel lblNewLabel = new JLabel("SELECT GRAPHICS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
		lblNewLabel.setBounds(10, 11, 300, 40);
		getContentPane().add(lblNewLabel);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnExit.setBounds(50, 271, 220, 50);
		getContentPane().add(btnExit);
	}
}
