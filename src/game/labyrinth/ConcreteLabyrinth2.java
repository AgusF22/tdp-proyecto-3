package game.labyrinth;

import exceptions.DataLoadException;
import exceptions.NullZoneException;
import game.Game;
import game.entity.player.Player;

public class ConcreteLabyrinth2  extends LabyrinthAux {
	
	/**
	 * Crea una instancia concreta del laberinto 2.
	 * @param game asociado a este laberinto.
	 * @throws DataLoadException 
	 */
	public ConcreteLabyrinth2(Game game) throws DataLoadException {
		super(game);
		
		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth2Image(),
								game.getImageFactory().getLabyrinth2bgImage());
		
		setLabyrinth("src/res/xml/labyrinth2.xml");
		this.setEntity();
	}
	
	/**
	 * Crea y setea en el mapa a todas las entidades del laberinto 2.
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
	 * @throws DataLoadException 
	 */
	public Labyrinth nextLabyrinth() throws DataLoadException {
		return new ConcreteLabyrinth3(game);
	}

	@Override
	public void addPlayer() {
		Player player = Player.getInstance();
		player.getGraphic().delete();
        zones[14][23].addEntity(player);							// ***Set Player***
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
