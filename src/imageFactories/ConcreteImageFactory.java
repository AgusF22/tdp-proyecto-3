package imageFactories;

import javax.swing.ImageIcon;

public class ConcreteImageFactory implements ImageFactory{

	@Override
	public ImageIcon getLabyrinth1Image() {
		return new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/maps/labyrinth1.png"));
	}
	
	@Override
	public ImageIcon getLabyrinth2Image() {
		return new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/maps/labyrinth2.png"));
	}
	
	@Override
	public ImageIcon getLabyrinth3Image() {
		return new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/maps/labyrinth3.png"));
	}
	
	@Override
	public ImageIcon[] getPlayerImages() {
		ImageIcon[] rta = new ImageIcon[4];
		rta[0] = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/character/player/steveB.gif"));
		rta[1] = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/character/player/steveR.gif"));
		rta[2] = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/character/player/steveF.gif"));
		rta[3] = new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/entity/character/player/steveL.gif"));
		return rta;
	}

	@Override
	public ImageIcon[] getPinkEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon[] getRedEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon[] getOrangeEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon[] getBlueEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon[] getFleeingEnemyImages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageIcon getDotImage() {
		return new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/prize/dot.png"));
	}

	@Override
	public ImageIcon getPowerPelletImage() {
		return new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/prize/powerpellet.png"));
	}

	@Override
	public ImageIcon getFruit1Image() {
		return new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/prize/fruit1.png"));
	}
	
	@Override
	public ImageIcon getFruit2Image() {
		return new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/prize/fruit2.png"));
	}
	
	@Override
	public ImageIcon getFruit3Image() {
		return new ImageIcon(imageFactories.ConcreteImageFactory.class.getResource("/res/minecraft/prize/fruit2.png"));
	}

	

}
