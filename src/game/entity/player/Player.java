package game.entity.player;

import game.labyrinth.Zone;
import game.labyrinth.ZoneType;
import game.Direction;
import game.entity.Entity;
import game.entity.Character;
import game.entity.GraphicCharacter;
import game.entity.visitor.PlayerVisitor;
import game.entity.visitor.Visitor;

public final class Player extends Character{
	
	protected Direction attemptingMovement;
	protected static Player instance;
	protected boolean hasShield;
	
	/**
	 * Crea una nueva instancia de Player.
	 */
	private Player() {
		super(null, 0.1f);
		attemptingMovement = null;
		hasShield = false;
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
	 * Intena mover al personaje por cada invocacion
	 */
	public void move() {
		if (attemptingMovement == movementDirection.getOpposite()) {
			movementDirection = attemptingMovement;
			graphic.updateImage();	
		}
		move(speedMultiplier * movementSpeed);
	}
	
	/**
	 * Mueve al jugador las unidades pasadas por parametro en una direccion
	 * @param n Flaot unidades a mover
	 */
	private void move(float n) {
		
		float d = nextCenterDistance();
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
		graphic.updatePosition();			//Actualiza la posicion de la Label en la grafica luego de cambiar su posicion
	}
	
	/**
	 * Actualiza de ser necesario la direccion del personaje
	 */
	private void updateDir() {
		if (attemptingMovement != null && zone.getAdjacent(attemptingMovement).getType() == ZoneType.PATH) {
			movementDirection = attemptingMovement;
			graphic.updateImage();	
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
	
	/**
	 * Setea el estado de escudo segundo lo pasado por parametro
	 * @param shield Boolean , true si tiene escudo, false sino
	 */
	public void setShield(boolean shield) {
		hasShield = shield;
	}
	
	/**
	 * Consulta si el personaje tiene escudo
	 * @return True si tiene, no sino tiene
	 */
	public boolean hasShield() {
		return hasShield;
	} 
}
