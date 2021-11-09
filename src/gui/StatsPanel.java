package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import data.PlayerScore;
import data.TopPlayersRegistry;

public class StatsPanel extends GUIPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel fondo;
	
	public StatsPanel(GUI gui) {
		super(gui);
		
		setLayout(null);
		setSize(width, height);
		
		crearBotones();
		crearTabla();
		crearFondo();
	}
	
	/**
	 * Crea y agrega la tabla a este panel.
	 */
	private void crearTabla() {
		TopPlayersRegistry registro = null;
		try {
			registro = frame.getStatsData().load();
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		List<PlayerScore> scores = registro.getScores();
		
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("NAME");
		modelo.addColumn("SCORE");
		
		String[] p0 = {"NAME", "SCORE"};
		modelo.addRow(p0);
		
		for(PlayerScore s: scores) {
			String[] p = {s.getName(), ""+s.getScore()};
			modelo.addRow(p);
		}

		tabla.setModel(modelo);
		
		tabla.setBounds((width - scaleWidth*2) / 2, 0, scaleWidth*2, scaleHeight*6);
		tabla.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
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
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		tabla.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
		tabla.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
		
		add(tabla);
	}

	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, width, height);
		fondo.setIcon(frame.getImageFactory().getStatsBgImage());
		add(fondo);
	}
	
	/*
	 * Crea y agrega los botones de este panel.
	 */
	private void crearBotones() {
		JButton btnMenu = new JButton("MENU");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				backToMenu();
			}
		});
		btnMenu.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnMenu.setBounds((width - scaleWidth*2) / 2, height/2 + (scaleHeight*6)/5, scaleWidth*2, scaleHeight);
		add(btnMenu);
	}
	
	/**
	 * Carga en la gui una nueva pantalla de inicio
	 */
	public void backToMenu() {
		frame.setPanel(new StartPanel(frame));
	}
	
}
