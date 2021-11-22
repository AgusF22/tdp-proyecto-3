package game.entity;

import javax.swing.JLabel;

import gui.GamePanel;

/**
 * Modela una entidad grafica.
 */
public abstract class GraphicEntity extends JLabel{
	
	private static final long serialVersionUID = 1L;
	
	protected transient Entity entity;
	protected GamePanel panel;
	
	protected int depth;

	/**
	 * Crea una nueva entidad grafica.
	 * @param entity La entidad asociada a esta entidad grafica.
	 */
	protected GraphicEntity(Entity entity) {
		super();
		this.entity = entity;
	}
	
	/**
	 * Actualiza la posicion de esta entidad grafica en la gui.
	 */
	public void updatePosition() {
		panel.updateLabel(this, entity.getX(), entity.getY());
	}
	
	/**
	 * Actualiza la imagen de esta entidad grafica.
	 */
	public abstract void updateImage();
	
	/**
	 * Borra esta entidad grafica de la gui.
	 */
	public void delete() {
		panel.removeLabel(this);
	}
	
	/**
	 * Añade esta entidad grafica a la gui.
	 * @param gui GUI en la que se añadira esta entidad grafica.
	 */
	public void addToGUI(GamePanel gui) {
		this.panel = gui;
		panel.addLabel(this, depth);
		this.updatePosition();
	}
	
	/**
	 * Añade o quita el efecto de velocidad de esta entidad grafica.
	 * @param speed True para hacer que la entidad grafica tenga un efecto de velocidad, false en caso contrario.
	 */
	public abstract void setSpeedEffect(boolean speed);
	
	/**
	 * Añade o quita el efecto de aturdimiento de esta entidad grafica.
	 * @param stuned True para hacer que la entidad grafica tenga un efecto de aturdimiento, false en caso contrario.
	 */
	public abstract void setStunEffect(boolean stuned);
	
	/**
	 * Añade o quita el efecto de escudo de esta entidad grafica.
	 * @param shield True para hacer que la entidad grafica tenga un efecto de escudo, false en caso contrario.
	 */
	public abstract void setShieldEffect(boolean shield);

	/**
	 * Añade o quita el efecto de huida de esta entidad grafica.
	 * @param fleeing True para hacer que la entidad grafica tenga un efecto de huida, false en caso contrario.
	 */
	public abstract void setFleeing(boolean fleeing);
}
