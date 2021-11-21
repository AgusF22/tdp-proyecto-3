package game.labyrinth;

import exceptions.DataLoadException;
import exceptions.NullZoneException;
import game.Game;
import game.entity.player.Player;

public class ConcreteLabyrinth3  extends Labyrinth {
	
	/**
	 * Crea una instancia concreta del laberinto 3.
	 * @param game asociado a este laberinto.
	 * @throws DataLoadException 
	 */
	public ConcreteLabyrinth3(Game game) throws DataLoadException {
		super(game);

		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth3Image(),
								game.getImageFactory().getLabyrinth3bgImage());
		
		setLabyrinth("src/res/xml/labyrinth3.xml");
		this.setEntity();
	}
	
	/**
	 * Crea y setea en el mapa a todas las entidades del laberinto 3.
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
	}
	
	/**
	 * @return el siguiente laberinto concreto, si no existe retorna null.
	 */
	public Labyrinth nextLabyrinth() {
		return null;
	}
	
	@Override
	public void addPlayer() {
		Player player = Player.getInstance();
		playerSpawn = zones[14][23];									// ***Set Player***
		playerSpawn.addEntity(player);
		player.getGraphic().delete();
		
		try {
			player.setZone(zones[14][23]);
		} catch (NullZoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.attemptMovement(Direction.LEFT);
		player.getGraphic().addToGUI(game.getGUI());
	}
}
