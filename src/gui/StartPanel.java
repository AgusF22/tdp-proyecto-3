package gui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import data.PlayerScore;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;

public class StartPanel extends GUIPanel{
	
	private static final long serialVersionUID = 1L;
	
	protected JLabel fondo;
	
	public StartPanel(GUI gui) {
		super(gui);
		setLayout(null);
		setSize(width, height);
		
		crearBotones();
		crearInfoControles();
		crearBotonesBasura(); //TODO basura borrar luego de probar cosas
		crearFondo();
	}
	
	private void crearBotonesBasura() { //TODO metodo basura, luego borrar
		Random rnd = new Random();
		JButton btnPerder = new JButton("PERDER");
		btnPerder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setPanel(new LosePanel(frame, (rnd.nextInt()%10000)+10000));
			}
		});
		btnPerder.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnPerder.setBounds((width - scaleWidth), height/2 + scaleHeight + scaleHeight/5, scaleWidth, scaleHeight);
		add(btnPerder);
		
		JButton btnGanar = new JButton("GANAR");
		btnGanar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setPanel(new WinPanel(frame, (rnd.nextInt()%10000)+10000));
			}
		});
		btnGanar.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnGanar.setBounds((width - scaleWidth), height/2 + 2*scaleHeight + 2*scaleHeight/5, scaleWidth, scaleHeight);
		add(btnGanar);
	}

	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, width, height);
		fondo.setIcon(frame.getImageFactory().getStartBgImage());
		add(fondo);
	}
	
	private void crearInfoControles() {
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("1");
		modelo.addColumn("2");
		modelo.addColumn("3");
		
		modelo.addRow(new String[] {"CONTROLS", "", ""});
		modelo.addRow(new String[] {"MOVE UP", "W", Character.toString('\u2191')});
		modelo.addRow(new String[] {"MOVE DOWN", "S", Character.toString('\u2193')});
		modelo.addRow(new String[] {"MOVE LEFT", "A", Character.toString('\u2190')});
		modelo.addRow(new String[] {"MOVE RIGHT", "D", Character.toString('\u2192')});

		tabla.setModel(modelo);
		
		tabla.setBounds(width - scaleWidth*2, 0, scaleWidth*2, scaleHeight*5);
		tabla.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		tabla.setShowVerticalLines(false);
		tabla.setRowHeight(scaleHeight);
		tabla.setEnabled(false);
		tabla.setOpaque(false);
		
		tabla.getColumnModel().getColumn(0).setMinWidth(scaleWidth);
		tabla.getColumnModel().getColumn(0).setMaxWidth(scaleWidth);
		
		tabla.getColumnModel().getColumn(1).setMinWidth(scaleWidth/2);
		tabla.getColumnModel().getColumn(1).setMaxWidth(scaleWidth/2);

		tabla.getColumnModel().getColumn(2).setMinWidth(scaleWidth/2);
		tabla.getColumnModel().getColumn(2).setMinWidth(scaleWidth/2);
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setOpaque(false);
		tabla.getColumnModel().getColumn(0).setCellRenderer( renderer );
		tabla.getColumnModel().getColumn(1).setCellRenderer( renderer );
		tabla.getColumnModel().getColumn(2).setCellRenderer( renderer );
		
		add(tabla);
	}
	
	private void crearBotones() {
		JButton btnPlay = new JButton("PLAY");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startGame();
			}
		});
		btnPlay.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnPlay.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*6)/5, scaleWidth*2, scaleHeight);
		add(btnPlay);
		
		JButton btnScores = new JButton("SCORES");
		btnScores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewStats();
			}
		});
		btnScores.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnScores.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*12)/5, scaleWidth*2, scaleHeight);
		add(btnScores);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exitGame();
			}
		});
		btnExit.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnExit.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*18)/5, scaleWidth*2, scaleHeight);
		add(btnExit);
	}
	
	/**
	 * Cambia la gui principal a la pantalla del juego (Inicia el juego).
	 */
	public void startGame() {
		frame.setPanel(new GamePanel(frame));
	}
	
	/**
	 * Cambia la gui principal a la pantalla de stats.
	 */
	public void viewStats() {
		frame.setPanel(new StatsPanel(frame));
	}
	
	/**
	 * Termina la ejecucion del juego.
	 */
	public void exitGame() {
		System.exit(0);
	}
}
