package imagefactories;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ConcreteImageFactory extends ImageFactory{
	
	public ConcreteImageFactory(int currentScreenWidth, int currentScreenHeight) {
		super(currentScreenWidth, currentScreenHeight);
	}

	@Override
	public Icon getLabyrinth1Image() {
		return getIcon("/res/img/minecraft/maps/labyrinth1.png");
	}
	
	@Override
	public Icon getLabyrinth2Image() {
		return getIcon("/res/img/minecraft/maps/labyrinth2.png");
	}
	
	@Override
	public Icon getLabyrinth3Image() {
		return getIcon("/res/img/minecraft/maps/labyrinth3.png");
	}
	
	@Override
	public Icon getLabyrinth1bgImage() {
		return getIcon("/res/img/minecraft/maps/labyrinth1bg.png");
	}

	@Override
	public Icon getLabyrinth2bgImage() {
		return getIcon("/res/img/minecraft/maps/labyrinth2bg.png");
	}

	@Override
	public Icon getLabyrinth3bgImage() {
		return getIcon("/res/img/minecraft/maps/labyrinth3bg.png");
	}

	@Override
	public Icon getGameOverBgImage() {
		return getIcon("/res/img/minecraft/gui/gameOverBg.png");
	}
	
	@Override
	public Icon getStartBgImage() {
		return getIcon("/res/img/minecraft/gui/startBg.png");
	}
	
	@Override
	public Icon getStatsBgImage() {
		return getIcon("/res/img/minecraft/gui/statsBg.png");
	}
	
	@Override
	public Icon[] getPlayerImages() {
		Icon[] toReturn = new Icon[6];
		
		toReturn[0] = getIcon("/res/img/minecraft/entity/character/player/steveB.gif");
		toReturn[1] = getIcon("/res/img/minecraft/entity/character/player/steveR.gif");
		toReturn[2] = getIcon("/res/img/minecraft/entity/character/player/steveF.gif");
		toReturn[3] = getIcon("/res/img/minecraft/entity/character/player/steveL.gif");
		
		toReturn[4] = getSpeedEffectImage();
		
		toReturn[5] = getIcon("/res/img/minecraft/entity/character/player/shieldEffect.gif");
		
		return toReturn;
	}

	@Override
	public Icon[] getPinkEnemyImages() {
		Icon[] toReturn = new Icon[10];
		Icon[] fleeingIcons = getFleeingEnemyImages();
		
		toReturn[0] = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanB.gif");
		toReturn[1] = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanR.gif");
		toReturn[2] = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanF.gif");
		toReturn[3] = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanL.gif");
		
		toReturn[4] = getSpeedEffectImage();
		
		toReturn[5] = fleeingIcons[0];
		toReturn[6] = fleeingIcons[1];
		toReturn[7] = fleeingIcons[2];
		toReturn[8] = fleeingIcons[3];
		
		toReturn[9] = getStunEffectImage();
		
		return toReturn;
	}

	@Override
	public Icon[] getRedEnemyImages() {
		Icon[] toReturn = new Icon[10];
		Icon[] fleeingIcons = getFleeingEnemyImages();
		
		toReturn[0] = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonB.gif");
		toReturn[1] = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonR.gif");
		toReturn[2] = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonF.gif");
		toReturn[3] = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonL.gif");
		
		toReturn[4] = getSpeedEffectImage();
		
		toReturn[5] = fleeingIcons[0];
		toReturn[6] = fleeingIcons[1];
		toReturn[7] = fleeingIcons[2];
		toReturn[8] = fleeingIcons[3];
		
		toReturn[9] = getStunEffectImage();
		
		return toReturn;
	}

	@Override
	public Icon[] getOrangeEnemyImages() {
		Icon[] toReturn = new Icon[10];
		Icon[] fleeingIcons = getFleeingEnemyImages();
		
		toReturn[0] = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperB.gif");
		toReturn[1] = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperR.gif");
		toReturn[2] = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperF.gif");
		toReturn[3] = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperL.gif");
		
		toReturn[4] = getSpeedEffectImage();
		
		toReturn[5] = fleeingIcons[0];
		toReturn[6] = fleeingIcons[1];
		toReturn[7] = fleeingIcons[2];
		toReturn[8] = fleeingIcons[3];
		
		toReturn[9] = getStunEffectImage();
		
		return toReturn;
	}

	@Override
	public Icon[] getBlueEnemyImages() {
		Icon[] toReturn = new Icon[10];
		Icon[] fleeingIcons = getFleeingEnemyImages();
		
		toReturn[0] = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieB.gif");
		toReturn[1] = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieR.gif");
		toReturn[2] = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieF.gif");
		toReturn[3] = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieL.gif");
		
		toReturn[4] = getSpeedEffectImage();
		
		toReturn[5] = fleeingIcons[0];
		toReturn[6] = fleeingIcons[1];
		toReturn[7] = fleeingIcons[2];
		toReturn[8] = fleeingIcons[3];
		
		toReturn[9] = getStunEffectImage();
		
		return toReturn;
	}
	
	/**
	 * Retorna el icono del efecto de velocidad.
	 * @return El icono del efecto de velocidad.
	 */
	protected Icon getSpeedEffectImage() {
		return getIcon("/res/img/minecraft/entity/character/speedEffect.gif");
	}
	
	/**
	 * Retorna el icono del efecto de aturdimiento.
	 * @return El icono del efecto de aturdimiento.
	 */
	protected Icon getStunEffectImage() {
		return getIcon("/res/img/minecraft/entity/character/enemy/stunEffect.gif");
	}
	
	/**
	 * Retorna un arreglo de 4 componentes con los iconos del enemigo escapando.
	 * @return Un arreglo de 4 componentes con los iconos del enemigo escapando.
	 */
	protected Icon[] getFleeingEnemyImages() {
		Icon[] toReturn = new Icon[4];
		toReturn[0] = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeB.gif");
		toReturn[1] = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeR.gif");
		toReturn[2] = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeF.gif");
		toReturn[3] = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeL.gif");
		return toReturn;
	}

	@Override
	public Icon getDotImage() {
		return getIcon("/res/img/minecraft/entity/prize/dot.png");
	}

	@Override
	public Icon getPowerPelletImage() {
		return getIcon("/res/img/minecraft/entity/prize/powerpellet.png");
	}

	@Override
	public Icon getFruit1Image() {
		return getIcon("/res/img/minecraft/entity/prize/fruit1.png");
	}
	
	@Override
	public Icon getFruit2Image() {
		return getIcon("/res/img/minecraft/entity/prize/fruit2.png");
	}
	
	@Override
	public Icon getFruit3Image() {
		return getIcon("/res/img/minecraft/entity/prize/fruit3.png");
	}
	
	@Override
	public Icon getPotion1() {
		return getIcon("/res/img/minecraft/entity/prize/potion1.gif");
	}
	
	@Override
	public Icon getPotion2() {
		return getIcon("/res/img/minecraft/entity/prize/potion2.gif");
	}
	
	@Override
	public Icon getPotion3() {
		return getIcon("/res/img/minecraft/entity/prize/potion3.gif");
	}
	
	@Override
	public Icon getBomb() {
		return getIcon("/res/img/minecraft/entity/prize/tnt.gif");
	}
	
	private ImageIcon getIcon(String path) {
		ImageIcon icon = new ImageIcon(imagefactories
				.ConcreteImageFactory.class.getResource(path));

		return scale(icon);
	}

}
