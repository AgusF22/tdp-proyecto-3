package game.entity.player;

import game.labyrinth.Zone;
import game.labyrinth.ZoneType;
import game.Direction;
import game.entity.Entity;
import game.entity.Character;
import game.entity.GraphicCharacter;
import game.entity.visitor.PlayerVisitor;
import game.entity.visitor.Visitor;

public class Player extends Character{
	
	private static final float MOVEMENT_LENGTH = 0.1f;		// Distancia que puede recorrer el personaje en un movimiento // FIXME reemplazar por constante en Character -AF
	
	protected float movementSpeed;
	protected Direction attemptingMovement;
	protected static Player instance;
	
	/**
	 * Crea una nueva instancia de Player.
	 */
	private Player() {
		super(null, 0.1f);
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
		//TODO if (zone == null) excepcion 
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
	 * FIXME asume que la distancia sera siempre menor a 1 pero se setea antes de llegar al centro de la zona
	 * 		 entonces no llego al centro de donde queria ir que ya esta preguntando por el que sigue.
	 * @param n
	 */
	private void move(float n) {
		
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
		switch(movementDirection){
		case RIGHT:
			toReturn = (float) Math.abs(x - Math.ceil(x));
			break;
		case LEFT:
			toReturn = (float) Math.abs(x - Math.floor(x));
			break;
		case DOWN:
			toReturn = (float) Math.abs(y - Math.ceil(y));
			break;
		case UP:
			toReturn = (float) Math.abs(y - Math.floor(y));
			break;
		default:
			toReturn = 0f;
		}
		if(toReturn == 0f)
			toReturn = 1f;
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
