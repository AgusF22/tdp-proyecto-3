package gui;

import java.awt.Font;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import data.PlayerScore;
import data.StatsData;
import data.TopPlayersRegistry;

public class StatsPanel extends GUIPanel{
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Crea una nueva instancia de StatsPanel y la asocia a a GUI pasada por parametro
	 * @param gui asociada al juego
	 */
	public StatsPanel(GUI gui) {
		super(gui);
		
		setLayout(null);
		setSize(guiPanelWidth, guiPanelHeight);
		
		crearBotones();
		crearTabla();
		crearFondo();
	}
	
	/**
	 * Crea y agrega la tabla a este panel.
	 */
	private void crearTabla() {
		TopPlayersRegistry registro = null;
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("NAME");
		modelo.addColumn("SCORE");
		
		String[] p0 = {"NAME", "SCORE"};
		modelo.addRow(p0);

		try {
			registro = (new StatsData()).load();
			for(PlayerScore s: registro.getScores()) {
				String[] p = {s.getName(), "" + s.getScore()};
				modelo.addRow(p);
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		tabla.setModel(modelo);
		
		tabla.setBounds((guiPanelWidth - scaleWidth * 2) / 2, 0, scaleWidth * 2, scaleHeight * 6);
		tabla.setFont(new Font(fuente, Font.BOLD, scaleHeight / 2));
		tabla.setShowVerticalLines(false);
		tabla.setRowHeight(scaleHeight);
		tabla.setEnabled(false);
		tabla.setOpaque(false);
		
		tabla.getColumnModel().getColumn(0).setMinWidth(scaleWidth);
		tabla.getColumnModel().getColumn(1).setMinWidth(scaleWidth);
		tabla.getColumnModel().getColumn(0).setMaxWidth(scaleWidth);
		tabla.getColumnModel().getColumn(1).setMaxWidth(scaleWidth);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setOpaque(false);
		centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
		
		tabla.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
		tabla.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
		
		add(tabla);
	}

	/**
	 * Crea y agrega el fondo de este panel
	 */
	private void crearFondo() {
		JLabel fondo = new JLabel("");
		fondo.setBounds(0, 0, guiPanelWidth, guiPanelHeight);
		fondo.setIcon(frame.getImageFactory().getStatsBgImage());
		add(fondo);
	}
	
	/*
	 * Crea y agrega los botones de este panel.
	 */
	private void crearBotones() {
		JButton btnMenu = new JButton("MENU");
		
		btnMenu.addActionListener(e -> backToMenu());
		
		btnMenu.setFont(new Font(fuente, Font.BOLD, scaleHeight / 2));
		btnMenu.setBounds((guiPanelWidth - scaleWidth * 2) / 2, guiPanelHeight / 2 + 
						(scaleHeight * 6) / 5, scaleWidth * 2, scaleHeight);
		add(btnMenu);
	}
	
	/**
	 * Carga en la gui una nueva pantalla de inicio
	 */
	public void backToMenu() {
		frame.setPanel(new StartPanel(frame));
	}
	
}
