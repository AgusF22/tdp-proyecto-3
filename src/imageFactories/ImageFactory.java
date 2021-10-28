package imageFactories;

import javax.swing.ImageIcon;

public interface ImageFactory {
	
	/**
	 * Devuelve la imagen correspondiente al laberinto 1.
	 * @return Una imagen.
	 */
	public ImageIcon getLabyrinth1Image();
	
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
	 * Devuelve la imagen correspondiente a la fruta.
	 * @return Una imagen.
	 */
	public ImageIcon getFruitImage();
}
