package imagefactories;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import gui.GUI;

public class ConcreteImageFactory extends ImageFactory{
	
	public ConcreteImageFactory(int currentScreenWidth, int currentScreenHeight) {
		super(currentScreenWidth, currentScreenHeight);
	}

	@Override
	public Icon getLabyrinth1Image() {
		ImageIcon imgIcon = getIcon("/res/minecraft/maps/labyrinth1.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getLabyrinth2Image() {
		ImageIcon imgIcon = getIcon("/res/minecraft/maps/labyrinth2.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getLabyrinth3Image() {
		ImageIcon imgIcon = getIcon("/res/minecraft/maps/labyrinth3.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getLabyrinth1bgImage() {
		ImageIcon imgIcon = getIcon("/res/minecraft/maps/labyrinth1bg.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getLabyrinth2bgImage() {
		ImageIcon imgIcon = getIcon("/res/minecraft/maps/labyrinth2bg.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getLabyrinth3bgImage() {
		ImageIcon imgIcon = getIcon("/res/minecraft/maps/labyrinth3bg.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getGameOverBgImage() {
		ImageIcon imgIcon = getIcon("/res/minecraft/gui/gameOverBg.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getStartBgImage() {
		ImageIcon imgIcon = getIcon("/res/minecraft/gui/startBg.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon[] getPlayerImages() {
		
		ImageIcon imgIcon0 = getIcon("/res/minecraft/entity/character/player/steveB.gif");
		ImageIcon imgIcon1 = getIcon("/res/minecraft/entity/character/player/steveR.gif");
		ImageIcon imgIcon2 = getIcon("/res/minecraft/entity/character/player/steveF.gif");
		ImageIcon imgIcon3 = getIcon("/res/minecraft/entity/character/player/steveL.gif");
		
		Icon[] rta = new Icon[4];
		rta[0] = scale(imgIcon0);
		rta[1] = scale(imgIcon1);
		rta[2] = scale(imgIcon2);
		rta[3] = scale(imgIcon3);
		
		return rta;
	}
	
	@Override
	public Icon[] getEffectImages() { // TODO 0) velocidad 1) escudo
		return null;
	}

	@Override
	public Icon[] getPinkEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon[] getRedEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon[] getOrangeEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon[] getBlueEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon[] getFleeingEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Icon getDotImage() {
		ImageIcon imgIcon = getIcon("/res/minecraft/entity/prize/dot.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getPowerPelletImage() {
		ImageIcon imgIcon = getIcon("/res/minecraft/entity/prize/powerpellet.png");
		return scale(imgIcon);
	}

	@Override
	public Icon getFruit1Image() {
		ImageIcon imgIcon = getIcon("/res/minecraft/entity/prize/fruit1.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getFruit2Image() {
		ImageIcon imgIcon = getIcon("/res/minecraft/entity/prize/fruit2.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getFruit3Image() {
		ImageIcon imgIcon = getIcon("/res/minecraft/entity/prize/fruit3.png");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getPotion1() {
		ImageIcon imgIcon = getIcon("/res/minecraft/entity/prize/potion1.gif");
		return scale(imgIcon);
	}
	
	@Override
	public Icon getPotion2() {
		ImageIcon imgIcon = getIcon("/res/minecraft/entity/prize/potion2.gif");
		return scale(imgIcon);
	}
	
	private ImageIcon getIcon(String path) {
		return new ImageIcon(imagefactories.ConcreteImageFactory.class.getResource(path));
	}

}
