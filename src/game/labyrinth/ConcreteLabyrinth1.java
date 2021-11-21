package game.labyrinth;

import exceptions.DataLoadException;
import exceptions.NullZoneException;
import game.Game;
import game.entity.player.Player;

public class ConcreteLabyrinth1 extends Labyrinth {
	
	/**
	 * Crea una instancia concreta del laberinto 1.
	 * @param game asociado a este laberinto.
	 * @throws DataLoadException 
	 */
	public ConcreteLabyrinth1(Game game) throws DataLoadException {
		super(game);
		
		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth1Image(),
								game.getImageFactory().getLabyrinth1bgImage());
		
		setLabyrinth("src/res/xml/labyrinth1.xml");
		setEntity();
		//************************************
				// TODO ¡¡¡¡BORRAR!!!!
//				for (int y = 0; y < matrix[0].length; y++) {
//					for (int x = 0; x < matrix.length; x++) {
//						System.out.format("[%2d,%2d " + zones[x][y].getType().toString().charAt(0) + "]", x, y);
//					}
//					System.out.println();
//				}
		//************************************
	}
	
	/**
	 * Crea y setea en el mapa a todas las entidades del laberinto 1.
	 */
	private void setEntity() {
		setEnemies();											
		addFruit1(14, 17);
		addPowerPellet(1, 1);
		addPowerPellet(27, 1);
		addPowerPellet(1, 29);
		addPowerPellet(27, 29);
		addPotionSpeed(6, 14);
		addPotionShield(22, 14);
		addPotionBomb(14, 11);
	}
	
	/**
	 * @return el siguiente laberinto concreto, si no existe retorna null.
	 * @throws DataLoadException 
	 */
	public Labyrinth nextLabyrinth() throws DataLoadException {
		return new ConcreteLabyrinth2(game);
	}

	@Override
	public void addPlayer() {
		playerSpawn = zones[14][23];									// ***Set Player***
		playerSpawn.addEntity(Player.getInstance());
		
		try {
			Player.getInstance().setZone(zones[14][23]);
		} catch (NullZoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Player.getInstance().getGraphic().addToGUI(game.getGUI());
	}
}
