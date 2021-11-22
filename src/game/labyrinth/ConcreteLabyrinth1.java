package game.labyrinth;

import exceptions.DataLoadException;
import exceptions.InvalidZoneException;
import game.Game;
import game.entity.player.Player;

/**
 * Modela el laberinto del primer nivel.
 */
public class ConcreteLabyrinth1 extends Labyrinth {
	
	/**
	 * Crea una nueva instancia de laberinto 1.
	 * @param game El juego a asociar al nuevo laberinto.
	 * @throws DataLoadException Si ocurre un error al cargar el laberinto.
	 */
	public ConcreteLabyrinth1(Game game) throws DataLoadException {
		super(game);
		
		game.getGUI().setLabyrinthImage(game.getImageFactory().getLabyrinth1Image(),
								game.getImageFactory().getLabyrinth1bgImage());
		
		setLabyrinth("src/res/xml/labyrinth1.xml");
		setEntities();
	}
	
	@Override
	protected void setEntities() {
		setEnemies();											
		addFruit1		(14, 17);
		addPowerPellet	(01, 01);
		addPowerPellet	(27, 01);
		addPowerPellet	(01, 29);
		addPowerPellet	(27, 29);
		addPotionSpeed	(06, 14);
		addPotionShield	(22, 14);
		addPotionBomb	(14, 11);
	}
	
	@Override
	public Labyrinth nextLabyrinth() throws DataLoadException {
		return new ConcreteLabyrinth2(game);
	}

	@Override
	public void addPlayer() {
		Player player = Player.getInstance();
		playerSpawn = zones[14][23];
		
		try {
			Player.getInstance().setZone(playerSpawn);
		} catch (InvalidZoneException e) {
			/* Este catch no debe ser alcanzado, se debe asegurar
			en este metodo que setZone reciba una zona valida */
			throw new AssertionError();
		}
		player.attemptMovement(Direction.LEFT);
		fillWithDots();
	}
}
