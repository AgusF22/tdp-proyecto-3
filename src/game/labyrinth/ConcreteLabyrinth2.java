package game.labyrinth;

import exceptions.DataLoadException;
import exceptions.InvalidZoneException;
import game.Game;
import game.entity.player.Player;

/**
 * Modela el laberinto del segundo nivel.
 */
public class ConcreteLabyrinth2  extends Labyrinth {
	
	/**
	 * Crea una nueva instancia de laberinto 2.
	 * @param game El juego a asociar al nuevo laberinto.
	 * @throws DataLoadException Si ocurre un error al cargar el laberinto.
	 */
	public ConcreteLabyrinth2(Game game) throws DataLoadException {
		super(game);
		
		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth2Image(),
								game.getImageFactory().getLabyrinth2bgImage());
		
		setLabyrinth("src/res/xml/labyrinth2.xml");
		setEntities();
	}
	
	@Override
	protected void setEntities() {
		setEnemies();											
		addFruit2		(14, 17);
		addPowerPellet	(01, 01);
		addPowerPellet	(27, 01);
		addPowerPellet	(01, 29);
		addPowerPellet	(27, 29);
		addPotionSpeed	(06, 14);
		addPotionShield	(22, 14);
	}
	
	@Override
	public Labyrinth nextLabyrinth() throws DataLoadException {
		return new ConcreteLabyrinth3(game);
	}

	@Override
	public void addPlayer() {
		Player player = Player.getInstance();
		playerSpawn = zones[14][23];									// ***Set Player***
		player.getGraphic().delete();
        
		try {
			player.setZone(zones[14][23]);
		} catch (InvalidZoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		player.attemptMovement(Direction.LEFT);
		fillWithDots();
	}

}
