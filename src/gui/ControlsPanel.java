package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * Modela el panel que muestra los controles del juego.
 */
public class ControlsPanel extends GUIPanel {
	
	private static final long serialVersionUID = 1L;
	
	protected JLabel fondo;
	
	/**
	 * Crea un nuevo panel de controles.
	 * @param gui La gui en la que se encontrara este panel.
	 */
	public ControlsPanel(GUI gui) {
		super(gui);
		setLayout(null);
		setSize(guiPanelWidth, guiPanelHeight);
		
		crearBotones();
		crearInfoControles();
		crearFondo();
	}
	
	/**
	 * Crea el fondo de este panel.
	 */
	private void crearFondo() {
		fondo = new JLabel("");
		fondo.setBounds(0, 0, guiPanelWidth, guiPanelHeight);
		fondo.setIcon(frame.getImageFactory().getStartBgImage());
		add(fondo);
	}
	
	/**
	 * Crea una tabla con informacion de controles.
	 */
	private void crearInfoControles() {
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
		
		tabla.setBounds((guiPanelWidth - scaleWidth * 3) / 2, scaleHeight / 2, scaleWidth * 3, scaleHeight * 7);
		tabla.setFont(new Font(fuente, Font.BOLD, scaleHeight / 3));
		tabla.setShowVerticalLines(false);
		tabla.setRowHeight(scaleHeight);
		tabla.setEnabled(false);
		tabla.setBackground(new Color(250, 128, 114));
		tabla.setForeground(new Color(186, 64, 50));
		
		
		tabla.getColumnModel().getColumn(0).setMinWidth(scaleWidth);
		tabla.getColumnModel().getColumn(0).setMaxWidth(scaleWidth);
		
		tabla.getColumnModel().getColumn(1).setMinWidth((scaleWidth));
		tabla.getColumnModel().getColumn(1).setMaxWidth(scaleWidth);

		tabla.getColumnModel().getColumn(2).setMinWidth(scaleWidth);
		tabla.getColumnModel().getColumn(2).setMinWidth(scaleWidth);
		
		DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
		renderer.setOpaque(true);
		renderer.setHorizontalAlignment(SwingConstants.CENTER);
		tabla.getColumnModel().getColumn(0).setCellRenderer(renderer);
		tabla.getColumnModel().getColumn(1).setCellRenderer(renderer);
		tabla.getColumnModel().getColumn(2).setCellRenderer(renderer);
		
		add(tabla);
	}
	
	/*
	 * Crea y agrega los botones de este panel.
	 */
	private void crearBotones() {
		JButton btnMenu = new JButton("MENU");

		btnMenu.addActionListener(e -> backToMenu());
		
		btnMenu.setFont(new Font(fuente, Font.BOLD, scaleHeight/2));
		btnMenu.setBounds((guiPanelWidth - scaleWidth*2) / 2, guiPanelHeight/2 + (scaleHeight*6)/5,
							scaleWidth*2, scaleHeight);
		add(btnMenu);
	}
	
	/**
	 * Retorna la gui a la pantalla de inicio.
	 */
	protected void backToMenu() {
		frame.setPanel(new StartPanel(frame));
	}
}
