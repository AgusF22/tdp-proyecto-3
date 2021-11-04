package imagefactories;


import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import gui.GUI;

public abstract class ImageFactory {
	
	protected int currentScreenWidth;
	protected int currentScreenHeight;
	
	protected ImageFactory(int currentScreenWidth, int currentScreenHeight) {
		this.currentScreenWidth = currentScreenWidth;
		this.currentScreenHeight = currentScreenHeight;
	}
	
	/**
	 * Devuelve el icono correspondiente al laberinto 1.
	 * @return Una imagen.
	 */
	public abstract Icon getLabyrinth1Image();
	
	/**
	 * Devuelve el icono correspondiente al laberinto 2.
	 * @return Una imagen.
	 */
	public abstract Icon getLabyrinth2Image();
	
	/**
	 * Devuelve el icono correspondiente al laberinto 3.
	 * @return Una imagen.
	 */
	public abstract Icon getLabyrinth3Image();
	
	/**
	 * Devuelve el icono correspondiente a la imagen de fondo del laberinto 1.
	 * @return Una imagen.
	 */
	public abstract Icon getLabyrinth1bgImage();
	
	/**
	 * Devuelve el icono correspondiente a la imagen de fondo del laberinto 2.
	 * @return Una imagen.
	 */
	public abstract Icon getLabyrinth2bgImage();
	
	/**
	 * Devuelve el icono correspondiente a la imagen de fondo del laberinto 3.
	 * @return Una imagen.
	 */
	public abstract Icon getLabyrinth3bgImage();
	
	/**
	 * Devuelve el icono correspondiente al fondo de fin de juego.
	 * @return Una imagen.
	 */
	public abstract Icon getGameOverBgImage();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al player.
	 * @return Un arreglo con imagenes.
	 */
	public abstract Icon[] getPlayerImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo rosa.
	 * @return Un arreglo con imagenes.
	 */
	public abstract Icon[] getPinkEnemyImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo rojo.
	 * @return Un arreglo con imagenes.
	 */
	public abstract Icon[] getRedEnemyImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo naranja.
	 * @return Un arreglo con imagenes.
	 */
	public abstract Icon[] getOrangeEnemyImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo azul.
	 * @return Un arreglo con imagenes.
	 */
	public abstract Icon[] getBlueEnemyImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo que huye.
	 * @return Un arreglo con imagenes.
	 */
	public abstract Icon[] getFleeingEnemyImages();
	
	/**
	 * Devuelve el icono correspondiente al punto.
	 * @return Una imagen.
	 */
	public abstract Icon getDotImage();
	
	/**
	 * Devuelve el icono correspondiente a la perla de poder.
	 * @return Una imagen.
	 */
	public abstract Icon getPowerPelletImage();
	
	/**
	 * Devuelve el icono correspondiente a la fruta 1.
	 * @return Una imagen.
	 */
	public abstract Icon getFruit1Image();
	
	/**
	 * Devuelve el icono correspondiente a la fruta 2.
	 * @return Una imagen.
	 */
	public abstract Icon getFruit2Image();
	
	/**
	 * Devuelve el icono correspondiente a la fruta 3.
	 * @return Una imagen.
	 */
	public abstract Icon getFruit3Image();
	
	/**
	 * Devuelve el icono correspondiente a la pocion 1.
	 * @return
	 */
	public abstract Icon getPotion1();
	
	/**
	 * Devuelve el icono correspondiente a la pocion 1.
	 * @return
	 */
	public abstract Icon getPotion2();
	
	protected ImageIcon scale(ImageIcon imageIcon) {
		int width = currentScreenWidth * imageIcon.getIconWidth() / GUI.DEFAULT_SCREEN_WIDTH;
		int height = currentScreenHeight * imageIcon.getIconHeight() / GUI.DEFAULT_SCREEN_HEIGHT;
		return new ImageIcon(imageIcon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
	}
}
