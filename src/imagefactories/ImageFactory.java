package imagefactories;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import gui.GUI;

/**
 * Modela una fabrica de imagenes abstracta.
 */
public abstract class ImageFactory {
	
	protected int currentScreenWidth;
	protected int currentScreenHeight;
	
	/**
	 * Crea una nueva fabrica de imagenes.
	 */
	protected ImageFactory() {
		super();
	}
	
	/**
	 * Setea las dimensiones de la pantalla, para poder construir iconos del tamaño correcto.
	 * @param currentScreenWidth El ancho de la pantalla.
	 * @param currentScreenHeight La altura de la pantalla.
	 */
	public void setSize(int currentScreenWidth, int currentScreenHeight) {
		this.currentScreenWidth = currentScreenWidth;
		this.currentScreenHeight = currentScreenHeight;
	}
	
	/**
	 * Devuelve el icono correspondiente al laberinto 1.
	 * @return El icono correspondiente al laberinto 1.
	 */
	public abstract Icon getLabyrinth1Image();
	
	/**
	 * Devuelve el icono correspondiente al laberinto 2.
	 * @return El icono correspondiente al laberinto 2.
	 */
	public abstract Icon getLabyrinth2Image();
	
	/**
	 * Devuelve el icono correspondiente al laberinto 3.
	 * @return El icono correspondiente al laberinto 3.
	 */
	public abstract Icon getLabyrinth3Image();
	
	/**
	 * Devuelve el icono correspondiente a la imagen de fondo del laberinto 1.
	 * @return El icono correspondiente a la imagen de fondo del laberinto 1.
	 */
	public abstract Icon getLabyrinth1bgImage();
	
	/**
	 * Devuelve el icono correspondiente a la imagen de fondo del laberinto 2.
	 * @return El icono correspondiente a la imagen de fondo del laberinto 2.
	 */
	public abstract Icon getLabyrinth2bgImage();
	
	/**
	 * Devuelve el icono correspondiente a la imagen de fondo del laberinto 3.
	 * @return El icono correspondiente a la imagen de fondo del laberinto 3.
	 */
	public abstract Icon getLabyrinth3bgImage();
	
	/**
	 * Devuelve el icono correspondiente a la imagen de fondo de la pantalla de fin de juego.
	 * @return El icono correspondiente a la imagen de fondo de fin de juego.
	 */
	public abstract Icon getGameOverBgImage();
	
	/**
	 * Devuelve el icono correspondiente a la imagen de fondo de la pantalla de inicio del juego.
	 * @return El icono correspondiente a la imagen de fondo de la pantalla de inicio del juego.
	 */
	public abstract Icon getStartBgImage();
	
	/**
	 * Devuelve el icono correspondiente a la imagen de fondo de la pantalla de stats.
	 * @return El icono correspondiente a la imagen de fondo de la pantalla de stats.
	 */
	public abstract Icon getStatsBgImage();
	
	/**
	 * Devuelve un arreglo con los iconos correspondientes al jugador.
	 * @return Un arreglo con los iconos correspondientes al jugador.
	 */
	public abstract Icon[] getPlayerImages();

	/**
	 * Devuelve un arreglo con los iconos correspondientes al enemigo rosa.
	 * @return Un arreglo con los iconos correspondientes al enemigo rosa.
	 */
	public abstract Icon[] getPinkEnemyImages();
	
	/**
	 * Devuelve un arreglo con los iconos correspondientes al enemigo rojo.
	 * @return Un arreglo con los iconos correspondientes al enemigo rojo.
	 */
	public abstract Icon[] getRedEnemyImages();
	
	/**
	 * Devuelve un arreglo con los iconos correspondientes al enemigo naranja.
	 * @return Un arreglo con los iconos correspondientes al enemigo naranja.
	 */
	public abstract Icon[] getOrangeEnemyImages();
	
	/**
	 * Devuelve un arreglo con los iconos correspondientes al enemigo azul.
	 * @return Un arreglo con los iconos correspondientes al enemigo azul.
	 */
	public abstract Icon[] getBlueEnemyImages();
	
	/**
	 * Devuelve el icono del efecto de velocidad.
	 * @return El icono del efecto de velocidad.
	 */
	protected abstract Icon getSpeedEffectImage();
	
	/**
	 * Devuelve el icono del efecto de aturdimiento.
	 * @return El icono del efecto de aturdimiento.
	 */
	protected abstract Icon getStunEffectImage();
	
	/**
	 * Devuelve el icono correspondiente al punto.
	 * @return El icono correspondiente al punto.
	 */
	public abstract Icon getDotImage();
	
	/**
	 * Devuelve el icono correspondiente al power pellet.
	 * @return El icono correspondiente al power pellet.
	 */
	public abstract Icon getPowerPelletImage();
	
	/**
	 * Devuelve el icono correspondiente a la fruta 1.
	 * @return El icono correspondiente a la fruta 1.
	 */
	public abstract Icon getFruit1Image();
	
	/**
	 * Devuelve el icono correspondiente a la fruta 2.
	 * @return El icono correspondiente a la fruta 2.
	 */
	public abstract Icon getFruit2Image();
	
	/**
	 * Devuelve el icono correspondiente a la fruta 3.
	 * @return El icono correspondiente a la fruta 3.
	 */
	public abstract Icon getFruit3Image();
	
	/**
	 * Devuelve el icono correspondiente a la pocion 1.
	 * @return El icono correspondiente a la pocion 1.
	 */
	public abstract Icon getPotion1();
	
	/**
	 * Devuelve el icono correspondiente a la pocion 2.
	 * @return El icono correspondiente a la pocion 2.
	 */
	public abstract Icon getPotion2();
	
	/**
	 * Devuelve el icono correspondiente a la pocion 3.
	 * @return El icono correspondiente a la pocion 3.
	 */
	public abstract Icon getPotion3();
	
	/**
	 * Devuelve el icono correspondiente a una bomba.
	 * @return El icono correspondiente a una bomba.
	 */
	public abstract Icon getBombImage();
	
	/**
	 * Devuelve el icono correspondiente a una explosion.
	 * @return El icono correspondiente a una explosion.
	 */
	public abstract Icon getExplosionImage();
	
	/**
	 * Devuelve un icono escalado de acuerdo al tamaño de la pantalla.
	 * @param imageIcon El icono a escalar.
	 * @return Un nuevo ImageIcon escalado.
	 */
	protected ImageIcon scale(ImageIcon imageIcon) {
		int width = currentScreenWidth * imageIcon.getIconWidth() / GUI.DEFAULT_SCREEN_WIDTH;
		int height = currentScreenHeight * imageIcon.getIconHeight() / GUI.DEFAULT_SCREEN_HEIGHT;
		return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
	
	/**
	 * Carga un icono desde el archivo referenciado por la direccion pasada como parametro.
	 * @param path La direccion del archivo imagen.
	 * @return Un icono.
	 */
	protected ImageIcon getIcon(String path) {
		ImageIcon icon = new ImageIcon(ImageFactory.class.getResource(path));
		return scale(icon);
	}

}
