package imageFactories;

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
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/maps/labyrinth1.png"));
		return scale(imgIcon);
	}
	
	@Override
	public Icon getLabyrinth2Image() {
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/maps/labyrinth2.png"));
		return scale(imgIcon);
	}
	
	@Override
	public Icon getLabyrinth3Image() {
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/maps/labyrinth3.png"));
		return scale(imgIcon);
	}
	
	@Override
	public Icon[] getPlayerImages() {
		
		ImageIcon imgIcon0 = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/character/player/steveB.gif"));
		ImageIcon imgIcon1 = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/character/player/steveR.gif"));
		ImageIcon imgIcon2 = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/character/player/steveF.gif"));
		ImageIcon imgIcon3 = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/character/player/steveL.gif"));
		
		Icon[] rta = new Icon[4];
		rta[0] = scale(imgIcon0);
		rta[1] = scale(imgIcon1);
		rta[2] = scale(imgIcon2);
		rta[3] = scale(imgIcon3);
		
		return rta;
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
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/prize/dot.png"));
		return scale(imgIcon);
	}

	@Override
	public Icon getPowerPelletImage() {
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/prize/powerpellet.png"));
		return scale(imgIcon);
	}

	@Override
	public Icon getFruit1Image() {
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/prize/fruit1.png"));
		return scale(imgIcon);
	}
	
	@Override
	public Icon getFruit2Image() {
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/prize/fruit2.png"));
		return scale(imgIcon);
	}
	
	@Override
	public Icon getFruit3Image() {
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/prize/fruit3.png"));
		return scale(imgIcon);
	}
	
	public Icon getPotion1() {
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/prize/potion1.png"));
		return scale(imgIcon);
	}
	
	public Icon getPotion2() {
		ImageIcon imgIcon = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/prize/potion2.png"));
		return scale(imgIcon);
	}

}
