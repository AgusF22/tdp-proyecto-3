package imagefactories;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ConcreteImageFactory extends ImageFactory{
	// FIXME no repetir literales!!! usar constantes, o un metodo para obtener los 4 iconos -AF
	public ConcreteImageFactory(int currentScreenWidth, int currentScreenHeight) {
		super(currentScreenWidth, currentScreenHeight);
	}

	@Override
	public Icon getLabyrinth1Image() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/maps/labyrinth1.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getLabyrinth2Image() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/maps/labyrinth2.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getLabyrinth3Image() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/maps/labyrinth3.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getLabyrinth1bgImage() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/maps/labyrinth1bg.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getLabyrinth2bgImage() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/maps/labyrinth2bg.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getLabyrinth3bgImage() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/maps/labyrinth3bg.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getGameOverBgImage() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/gui/gameOverBg.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getStartBgImage() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/gui/startBg.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getStatsBgImage() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/gui/statsBg.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon[] getPlayerImages() {
		
		ImageIcon imgIcon0 = getIcon("/res/img/minecraft/entity/character/player/steveB.gif");
		ImageIcon imgIcon1 = getIcon("/res/img/minecraft/entity/character/player/steveR.gif");
		ImageIcon imgIcon2 = getIcon("/res/img/minecraft/entity/character/player/steveF.gif");
		ImageIcon imgIcon3 = getIcon("/res/img/minecraft/entity/character/player/steveL.gif");
		ImageIcon imgIcon4 = getIcon("/res/img/minecraft/entity/character/player/steveSpeedB.gif");
		ImageIcon imgIcon5 = getIcon("/res/img/minecraft/entity/character/player/steveSpeedR.gif");
		ImageIcon imgIcon6 = getIcon("/res/img/minecraft/entity/character/player/steveSpeedF.gif");
		ImageIcon imgIcon7 = getIcon("/res/img/minecraft/entity/character/player/steveSpeedL.gif");
		ImageIcon imgIcon8 = getIcon("/res/img/minecraft/entity/character/player/steveShieldB.gif");
		ImageIcon imgIcon9 = getIcon("/res/img/minecraft/entity/character/player/steveShieldR.gif");
		ImageIcon imgIcon10 = getIcon("/res/img/minecraft/entity/character/player/steveShieldF.gif");
		ImageIcon imgIcon11 = getIcon("/res/img/minecraft/entity/character/player/steveShieldL.gif");
		
		Icon[] rta = new Icon[12];
		rta[0] = scale(imgIcon0);
		rta[1] = scale(imgIcon1);
		rta[2] = scale(imgIcon2);
		rta[3] = scale(imgIcon3);
		rta[4] = scale(imgIcon4);
		rta[5] = scale(imgIcon5);
		rta[6] = scale(imgIcon6);
		rta[7] = scale(imgIcon7);
		rta[8] = scale(imgIcon8);
		rta[9] = scale(imgIcon9);
		rta[10] = scale(imgIcon10);
		rta[11] = scale(imgIcon11);
		
		return rta;
	}

	@Override
	public Icon[] getPinkEnemyImages() {
		ImageIcon imgIcon0 = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanB.gif");
		ImageIcon imgIcon1 = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanR.gif");
		ImageIcon imgIcon2 = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanF.gif");
		ImageIcon imgIcon3 = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanL.gif");
		ImageIcon imgIcon4 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeB.gif");	
		ImageIcon imgIcon5 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeR.gif");
		ImageIcon imgIcon6 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeF.gif");
		ImageIcon imgIcon7 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeL.gif");
		ImageIcon imgIcon8 = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanStunB.gif");
		ImageIcon imgIcon9 = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanStunR.gif");
		ImageIcon imgIcon10 = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanStunF.gif");
		ImageIcon imgIcon11 = getIcon("/res/img/minecraft/entity/character/enemy/pigman/pigmanStunL.gif");
		
		Icon[] rta = new Icon[12];
		rta[0] = scale(imgIcon0);
		rta[1] = scale(imgIcon1);
		rta[2] = scale(imgIcon2);
		rta[3] = scale(imgIcon3);
		rta[4] = scale(imgIcon4);
		rta[5] = scale(imgIcon5);
		rta[6] = scale(imgIcon6);
		rta[7] = scale(imgIcon7);
		rta[8] = scale(imgIcon8);
		rta[9] = scale(imgIcon9);
		rta[10] = scale(imgIcon10);
		rta[11] = scale(imgIcon11);
		
		return rta;
	}

	@Override
	public Icon[] getRedEnemyImages() {
		ImageIcon imgIcon0 = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonB.gif");
		ImageIcon imgIcon1 = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonR.gif");
		ImageIcon imgIcon2 = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonF.gif");
		ImageIcon imgIcon3 = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonL.gif");
		ImageIcon imgIcon4 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeB.gif");
		ImageIcon imgIcon5 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeR.gif");
		ImageIcon imgIcon6 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeF.gif");
		ImageIcon imgIcon7 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeL.gif");
		ImageIcon imgIcon8 = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonStunB.gif");
		ImageIcon imgIcon9 = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonStunR.gif");
		ImageIcon imgIcon10 = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonStunF.gif");
		ImageIcon imgIcon11 = getIcon("/res/img/minecraft/entity/character/enemy/skeleton/skeletonStunL.gif");
		
		Icon[] rta = new Icon[12];
		rta[0] = scale(imgIcon0);
		rta[1] = scale(imgIcon1);
		rta[2] = scale(imgIcon2);
		rta[3] = scale(imgIcon3);
		rta[4] = scale(imgIcon4);
		rta[5] = scale(imgIcon5);
		rta[6] = scale(imgIcon6);
		rta[7] = scale(imgIcon7);
		rta[8] = scale(imgIcon8);
		rta[9] = scale(imgIcon9);
		rta[10] = scale(imgIcon10);
		rta[11] = scale(imgIcon11);
		
		return rta;
	}

	@Override
	public Icon[] getOrangeEnemyImages() {
		ImageIcon imgIcon0 = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperB.gif");
		ImageIcon imgIcon1 = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperR.gif");
		ImageIcon imgIcon2 = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperF.gif");
		ImageIcon imgIcon3 = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperL.gif");
		ImageIcon imgIcon4 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeB.gif");
		ImageIcon imgIcon5 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeR.gif");
		ImageIcon imgIcon6 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeF.gif");
		ImageIcon imgIcon7 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeL.gif");
		ImageIcon imgIcon8 = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperStunB.gif");
		ImageIcon imgIcon9 = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperStunR.gif");
		ImageIcon imgIcon10 = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperStunF.gif");
		ImageIcon imgIcon11 = getIcon("/res/img/minecraft/entity/character/enemy/creeper/creeperStunL.gif");
		
		Icon[] rta = new Icon[12];
		rta[0] = scale(imgIcon0);
		rta[1] = scale(imgIcon1);
		rta[2] = scale(imgIcon2);
		rta[3] = scale(imgIcon3);
		rta[4] = scale(imgIcon4);
		rta[5] = scale(imgIcon5);
		rta[6] = scale(imgIcon6);
		rta[7] = scale(imgIcon7);
		rta[8] = scale(imgIcon8);
		rta[9] = scale(imgIcon9);
		rta[10] = scale(imgIcon10);
		rta[11] = scale(imgIcon11);
		
		return rta;
	}

	@Override
	public Icon[] getBlueEnemyImages() {
		ImageIcon imgIcon0 = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieB.gif");
		ImageIcon imgIcon1 = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieR.gif");
		ImageIcon imgIcon2 = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieF.gif");
		ImageIcon imgIcon3 = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieL.gif");
		ImageIcon imgIcon4 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeB.gif");
		ImageIcon imgIcon5 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeR.gif");
		ImageIcon imgIcon6 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeF.gif");
		ImageIcon imgIcon7 = getIcon("/res/img/minecraft/entity/character/enemy/bee/beeL.gif");
		ImageIcon imgIcon8 = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieStunB.gif");
		ImageIcon imgIcon9 = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieStunR.gif");
		ImageIcon imgIcon10 = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieStunF.gif");
		ImageIcon imgIcon11 = getIcon("/res/img/minecraft/entity/character/enemy/zombie/zombieStunL.gif");
		
		Icon[] rta = new Icon[12];
		rta[0] = scale(imgIcon0);
		rta[1] = scale(imgIcon1);
		rta[2] = scale(imgIcon2);
		rta[3] = scale(imgIcon3);
		rta[4] = scale(imgIcon4);
		rta[5] = scale(imgIcon5);
		rta[6] = scale(imgIcon6);
		rta[7] = scale(imgIcon7);
		rta[8] = scale(imgIcon8);
		rta[9] = scale(imgIcon9);
		rta[10] = scale(imgIcon10);
		rta[11] = scale(imgIcon11);
		
		return rta;
	}

	@Override
	public Icon getDotImage() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/entity/prize/dot.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getPowerPelletImage() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/entity/prize/powerpellet.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getFruit1Image() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/entity/prize/fruit1.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getFruit2Image() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/entity/prize/fruit2.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getFruit3Image() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/entity/prize/fruit3.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getPotion1() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/entity/prize/potion1.gif");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getPotion2() {
		ImageIcon imgIcon = getIcon("/res/img/minecraft/entity/prize/potion2.gif");
		return scale(imgIcon);
	}
	
	private ImageIcon getIcon(String path) {
		return new ImageIcon(imagefactories.ConcreteImageFactory.class.getResource(path));
	}

}
