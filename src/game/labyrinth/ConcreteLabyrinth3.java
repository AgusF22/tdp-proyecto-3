package game.labyrinth;

import exceptions.DataLoadException;
import exceptions.InvalidZoneException;
import game.Game;
import game.entity.player.Player;

/**
 * Modela el laberinto del tercer nivel.
 */
public class ConcreteLabyrinth3  extends Labyrinth {
	
	/**
	 * Crea una nueva instancia de laberinto 3.
	 * @param game El juego a asociar al nuevo laberinto.
	 * @throws DataLoadException Si ocurre un error al cargar el laberinto.
	 */
	public ConcreteLabyrinth3(Game game) throws DataLoadException {
		super(game);

		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth3Image(),
								game.getImageFactory().getLabyrinth3bgImage());
		
		setLabyrinth("src/res/xml/labyrinth3.xml");
		setEntities();
	}
	
	@Override
	protected void setEntities() {
		setEnemies();											
		addFruit3		(14, 17);
		addPowerPellet	(01, 01);
		addPowerPellet	(27, 01);
		addPowerPellet	(01, 29);
		addPowerPellet	(27, 29);
		addPotionSpeed	(06, 14);
		addPotionShield	(22, 14);
		addPotionBomb	(14, 11);
	}
	
	@Override
	public Labyrinth nextLabyrinth() {
		return null;
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
