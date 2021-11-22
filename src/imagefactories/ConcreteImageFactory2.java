package imagefactories;

import javax.swing.Icon;

/**
 * Modela la fabrica de imagenes de dungeon.
 */
public class ConcreteImageFactory2 extends ImageFactory {

	/**
	 * Crea una nueva fabrica de imagenes de dungeon.
	 */
	public ConcreteImageFactory2() {
		super();
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
		
		toReturn[0] = getIcon("/res/img/dungeon/entity/character/player/player_walkRight.gif");
		toReturn[1] = getIcon("/res/img/dungeon/entity/character/player/player_walkRight.gif");
		toReturn[2] = getIcon("/res/img/dungeon/entity/character/player/player_walkLeft.gif");
		toReturn[3] = getIcon("/res/img/dungeon/entity/character/player/player_walkLeft.gif");
		
		toReturn[4] = getSpeedEffectImage();
		
		toReturn[5] = getIcon("/res/img/minecraft/entity/character/player/shieldEffect.gif");
		
		return toReturn;
	}

	@Override
	public Icon[] getPinkEnemyImages() {
		Icon[] toReturn = new Icon[10];
		Icon[] fleeingIcons = getFleeingEnemyImages();
		
		toReturn[0] = getIcon("/res/img/dungeon/entity/character/enemy/ghoul/ghoul_walkRight.gif");
		toReturn[1] = getIcon("/res/img/dungeon/entity/character/enemy/ghoul/ghoul_walkRight.gif");
		toReturn[2] = getIcon("/res/img/dungeon/entity/character/enemy/ghoul/ghoul_walkLeft.gif");
		toReturn[3] = getIcon("/res/img/dungeon/entity/character/enemy/ghoul/ghoul_walkLeft.gif");
		
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
		
		toReturn[0] = getIcon("/res/img/dungeon/entity/character/enemy/eye/eye_walkRight.gif");
		toReturn[1] = getIcon("/res/img/dungeon/entity/character/enemy/eye/eye_walkRight.gif");
		toReturn[2] = getIcon("/res/img/dungeon/entity/character/enemy/eye/eye_walkLeft.gif");
		toReturn[3] = getIcon("/res/img/dungeon/entity/character/enemy/eye/eye_walkLeft.gif");
		
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
		
		toReturn[0] = getIcon("/res/img/dungeon/entity/character/enemy/imp/imp_walkRight.gif");
		toReturn[1] = getIcon("/res/img/dungeon/entity/character/enemy/imp/imp_walkRight.gif");
		toReturn[2] = getIcon("/res/img/dungeon/entity/character/enemy/imp/imp_walkLeft.gif");
		toReturn[3] = getIcon("/res/img/dungeon/entity/character/enemy/imp/imp_walkLeft.gif");
		
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
		
		toReturn[0] = getIcon("/res/img/dungeon/entity/character/enemy/cyclops/cyclops_walkRight.gif");
		toReturn[1] = getIcon("/res/img/dungeon/entity/character/enemy/cyclops/cyclops_walkRight.gif");
		toReturn[2] = getIcon("/res/img/dungeon/entity/character/enemy/cyclops/cyclops_walkLeft.gif");
		toReturn[3] = getIcon("/res/img/dungeon/entity/character/enemy/cyclops/cyclops_walkLeft.gif");
		
		toReturn[4] = getSpeedEffectImage();
		
		toReturn[5] = fleeingIcons[0];
		toReturn[6] = fleeingIcons[1];
		toReturn[7] = fleeingIcons[2];
		toReturn[8] = fleeingIcons[3];
		
		toReturn[9] = getStunEffectImage();
		
		return toReturn;
	}
	
	@Override
	protected Icon getSpeedEffectImage() {
		return getIcon("/res/img/minecraft/entity/character/speedEffect.gif");
	}
	
	@Override
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
		return getIcon("/res/img/dungeon/entity/staticentity/dot.png");
	}

	@Override
	public Icon getPowerPelletImage() {
		return getIcon("/res/img/dungeon/entity/staticentity/powerPellet.png");
	}

	@Override
	public Icon getFruit1Image() {
		return getIcon("/res/img/dungeon/entity/staticentity/fruit1.png");
	}
	
	@Override
	public Icon getFruit2Image() {
		return getIcon("/res/img/dungeon/entity/staticentity/fruit2.png");
	}
	
	@Override
	public Icon getFruit3Image() {
		return getIcon("/res/img/dungeon/entity/staticentity/fruit3.png");
	}
	
	@Override
	public Icon getPotion1() {
		return getIcon("/res/img/dungeon/entity/staticentity/shieldPotion.png");
	}
	
	@Override
	public Icon getPotion2() {
		return getIcon("/res/img/dungeon/entity/staticentity/speedPotion.png");
	}
	
	@Override
	public Icon getPotion3() {
		return getIcon("/res/img/dungeon/entity/staticentity/BombPotion.png");
	}
	
	@Override
	public Icon getBombImage() {
		return getIcon("/res/img/dungeon/entity/staticentity/bomb.png");
	}
	
	@Override
	public Icon getExplosionImage() {
		return getIcon("/res/img/dungeon/entity/staticentity/explosion.png");
	}
	
}
