package imageFactories;

import javax.swing.ImageIcon;

public interface ImageFactory {
	
	/**
	 * Devuelve la imagen correspondiente al laberinto 1.
	 * @return Una imagen.
	 */
	public ImageIcon getLabyrinth1Image();
	
	/**
	 * Devuelve la imagen correspondiente al laberinto 2.
	 * @return Una imagen.
	 */
	public ImageIcon getLabyrinth2Image();
	
	/**
	 * Devuelve la imagen correspondiente al laberinto 3.
	 * @return Una imagen.
	 */
	public ImageIcon getLabyrinth3Image();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al player.
	 * @return Un arreglo con imagenes.
	 */
	public ImageIcon[] getPlayerImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo rosa.
	 * @return Un arreglo con imagenes.
	 */
	public ImageIcon[] getPinkEnemyImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo rojo.
	 * @return Un arreglo con imagenes.
	 */
	public ImageIcon[] getRedEnemyImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo naranja.
	 * @return Un arreglo con imagenes.
	 */
	public ImageIcon[] getOrangeEnemyImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo azul.
	 * @return Un arreglo con imagenes.
	 */
	public ImageIcon[] getBlueEnemyImages();
	
	/**
	 * Devuelve un arreglo con las imagenes correspondientes al enemigo que huye.
	 * @return Un arreglo con imagenes.
	 */
	public ImageIcon[] getFleeingEnemyImages();
	
	/**
	 * Devuelve la imagen correspondiente al punto.
	 * @return Una imagen.
	 */
	public ImageIcon getDotImage();
	
	/**
	 * Devuelve la imagen correspondiente a la perla de poder.
	 * @return Una imagen.
	 */
	public ImageIcon getPowerPelletImage();
	
	/**
	 * Devuelve la imagen correspondiente a la fruta 1.
	 * @return Una imagen.
	 */
	public ImageIcon getFruit1Image();
	
	/**
	 * Devuelve la imagen correspondiente a la fruta 2.
	 * @return Una imagen.
	 */
	public ImageIcon getFruit2Image();
	
	/**
	 * Devuelve la imagen correspondiente a la fruta 3.
	 * @return Una imagen.
	 */
	public ImageIcon getFruit3Image();
	
	/**
	 * Devuelve la imagen correspondiente a la pocion 1.
	 * @return
	 */
	public ImageIcon getPotion1();
	
	/**
	 * Devuelve la imagen correspondiente a la pocion 1.
	 * @return
	 */
	public ImageIcon getPotion2();
}
