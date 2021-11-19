package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ControlsPanel extends GUIPanel{
	
	protected JLabel fondo;
	
	private static final long serialVersionUID = 1L;
	
	public ControlsPanel(GUI gui) {
		super(gui);
		setLayout(null);
		setSize(width, height);
		
		crearBotones();
		crearInfoControles();
		crearFondo();
	}
	
	/**
	 * Crea el fondo de este panel.
	 */
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, width, height);
		fondo.setIcon(frame.getImageFactory().getStartBgImage());
		add(fondo);
	}
	
	/**
	 * Crea una tabla con informacion de controles.
	 */
	private void crearInfoControles() {	// TODO ajustar tamaño de columnas, toggle music no se ve
		JTable tabla = new JTable();
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("1");
		modelo.addColumn("2");
		modelo.addColumn("3");
		
		modelo.addRow(new String[] {"CONTROLS", 	"OP1", 		"OP2"});
		modelo.addRow(new String[] {"MOVE UP", 		"W", 		Character.toString('\u2191')});
		modelo.addRow(new String[] {"MOVE DOWN", 	"S", 		Character.toString('\u2193')});
		modelo.addRow(new String[] {"MOVE LEFT", 	"A", 		Character.toString('\u2190')});
		modelo.addRow(new String[] {"MOVE RIGHT", 	"D", 		Character.toString('\u2192')});
		modelo.addRow(new String[] {"PLACE BOMB", 	"SPACE", 	"SPACE"});
		modelo.addRow(new String[] {"TOGGLE MUSIC", "M", 		"M"});
		
		tabla.setModel(modelo);
		
		tabla.setBounds((width - scaleWidth*3)/2, scaleHeight/2, scaleWidth*3, scaleHeight*7);
		tabla.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		tabla.setShowVerticalLines(false);
		tabla.setRowHeight(scaleHeight);
		tabla.setEnabled(false);
		tabla.setBackground(new Color(250, 128, 114));
		tabla.setForeground(new Color(186, 64, 50));
		
		
		tabla.getColumnModel().getColumn(0).setMinWidth(scaleWidth);
		tabla.getColumnModel().getColumn(0).setMaxWidth(scaleWidth);
		
		tabla.getColumnModel().getColumn(1).setMinWidth(scaleWidth);
		tabla.getColumnModel().getColumn(1).setMaxWidth(scaleWidth);

		tabla.getColumnModel().getColumn(2).setMinWidth(scaleWidth);
		tabla.getColumnModel().getColumn(2).setMinWidth(scaleWidth);
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setOpaque(true);
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getColumnModel().getColumn(0).setCellRenderer( renderer );
		tabla.getColumnModel().getColumn(1).setCellRenderer( renderer );
		tabla.getColumnModel().getColumn(2).setCellRenderer( renderer );
		
		
		
		add(tabla);
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
