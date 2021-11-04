package game.entity.player;

import game.labyrinth.Zone;
import game.labyrinth.ZoneType;
import game.Direction;
import game.entity.Entity;
import game.entity.GraphicCharacter;
import game.entity.visitor.PlayerVisitor;
import game.entity.visitor.Visitor;

public class Player extends Entity{
	
	private static final float MOVEMENT_LENGTH = 0.1f;		// Distancia que puede recorrer el personaje en un movimiento
	
	protected float movementSpeed;
	protected Direction movementDirection;
	protected Direction attemptingMovement;
	protected static Player instance;
	
	/**
	 * Crea una nueva instancia de Player.
	 */
	private Player() {
		super(null);
		movementDirection = Direction.LEFT;
		attemptingMovement = null;
	}
	
	/**
	 * Retorna la intancia de player.
	 * @return La intancia de player.
	 */
	public static Player getInstance() {
		if(instance == null) 
			instance = new Player();
		return instance;
	}
	
	/**
	 * Setea la zona donde se encuentra el jugador
	 * @param zone Zone
	 */
	public void setZone(Zone zone) {
		this.zone = zone;
		this.setCoordinates(zone.getX(), zone.getY());
		setGraphic();
	}
	
	/**
	 * Crea y asigna la entidad grafica del personaje
	 */
	private void setGraphic() {
		graphic = new GraphicCharacter(this, zone.getLabyrinth().getImageFactory().getPlayerImages());
	}
	
	/**
	 * Asigna la velocidad de movimiento
	 * @param speed Float multiplo de velocidad
	 */
	public void setMovementSpeed(float speed) {
		movementSpeed = speed;
	}
	
	/**
	 * Intena mover al personaje por cada invocacion
	 */
	public void move() {
		if (attemptingMovement == movementDirection.getOpposite()) {
			movementDirection = attemptingMovement;
			updateMovementDirection();				//TODO quitar cuando existar char
		}
		move(MOVEMENT_LENGTH * movementSpeed);
		//graphic.update();						//TODO setear con update() cuando este implementado
	}
	
	/**
	 * TODO documentar
	 * @param n
	 */
	private void move (float n) {
		
		float d = nextCenterDistance();
		System.out.println("Distancia "+d);
		boolean canMove = true;
		if (n < 0) {
			n = 0;
		}
		if (d == 1) {
			updateDir();
			canMove = canMove();
		}
		if (canMove) {
			if (d >= n) {
				//mover
				updateLocation(n);
				//return
			} else {
				//mover distancia d
				updateLocation(d);
				//move (n - distancia)
				move(n - d);
			}
		}
	}
	
	/**
	 * Actualiza las coordenadas y la zona con respecto a la direccion y parametro
	 * @param float Unidades a moverse en la direccion actual
	 */
	private void updateLocation(float n) {
		switch (movementDirection){
			case UP:
				y -= n;
				break;
			case RIGHT:
				x += n;
				break;
			case DOWN:
				y += n;
				break;
			case LEFT:
				x -= n;
				break;
		}
		x = Math.round(x * 10f) / 10f;
		y = Math.round(y * 10f) / 10f;
		
		this.setCoordinates(x, y);
	}
	
	/**
	 * Actualiza de ser necesario la direccion del personaje
	 */
	private void updateDir() {
		if (attemptingMovement != null && zone.getAdjacent(attemptingMovement).getType() == ZoneType.PATH) {
			movementDirection = attemptingMovement;
			updateMovementDirection();					//TODO quitar cuando existar char
		}
	}
	
	/**
	 * Consulta cuando esta en el centro de una zona si puede moverse
	 * @return True si puede, false sino
	 */
	private boolean canMove() {
		return zone.getAdjacent(movementDirection).getType() == ZoneType.PATH;
	}
	
	/**
	 * Calcula la distancia entre el proximo centro desde la posicion actual
	 * @return float distancia entre posicion y centro proximo en direccion actual
	 */
	private float nextCenterDistance() {
		float toReturn;
		Zone adjacent = zone.getAdjacent(movementDirection);
		if (x == adjacent.getX()) {
			toReturn = Math.abs(y - adjacent.getY());
		} else {
			toReturn = Math.abs(x - adjacent.getX());
		}
		toReturn = Math.round(toReturn * 10f) / 10f;
		if (toReturn == 0) {
			toReturn = 1;
		}
		return toReturn;
	}
	
	/**
	 * Actualiza la direccion de movimiento de la grafica
	 */
	private void updateMovementDirection() {
		switch (movementDirection){
		case UP:
			((GraphicCharacter) graphic).setMovingUp();
			break;
		case RIGHT:
			((GraphicCharacter) graphic).setMovingRight();
			break;
		case DOWN:
			((GraphicCharacter) graphic).setMovingDown();
			break;
		case LEFT:
			((GraphicCharacter) graphic).setMovingLeft();
			break;
		}
	}
	
	/**
	 * Asigna una nueva direccion a la que intentar mover al jguador
	 * 
	 * @param dir Direction 
	 */
	public void attemptMovement(Direction dir) {
		attemptingMovement = dir;
	}
	
	/**
	 * Colisiona al jugador con todas las entidades que se encuantran en su zona.
	 */
	public void collide() {
		Visitor v = new PlayerVisitor();
		for (Entity e : zone.zoneEntities()) {
			e.accept(v);								// TODO cambiar condicion de colision a distancia (y actualizar javadoc posteriormente) -AF
		}
	}
	
	/**
	 * Acepta un visitor.
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
}
