package game.entity;

import game.Game;
import game.labyrinth.Direction;
import game.labyrinth.Zone;

public abstract class Character extends Entity {

	protected Direction movementDirection;
	protected final float movementSpeed;
	
	protected float speedMultiplier;
	protected int speedEffectTimer;
	
	protected Character(Zone zone, float movementSpeed) {
		super(zone);
		this.movementSpeed = movementSpeed;
		movementDirection = Direction.LEFT;
		speedMultiplier = 1;
		speedEffectTimer = 0;
	}
	
	/**
	 * Mueve a este personaje. El resultado de este metodo depende del tipo y estado del personaje.
	 */
	public abstract void move();
	
	/**
	 * Retorna la direccion de movimiento actual del personaje.
	 * @return La direccion de movimiento actual del personaje.
	 */
	public Direction getMovementDirection() {
		return movementDirection;
	}
	
	public float getSpeed() {
		return movementSpeed * speedMultiplier;
	}
	
	/**
	 * Respawnea a este personaje.
	 */
	public abstract void respawn();
	
	/**
	 * Mueve a este personaje el valor pasado por parametro en una direccion.
	 * @param n Valor a mover.
	 */
	public void move(float n) {
		
		float d = nextCenterDistance();
		boolean canMove = true;
		if (n < 0) {
			n = 0;
		}
		if (d == 1) {				//Si se encuentra a distancia 1 entonces esta en un centro, puede intentar cambiar de direccion
			updateMovementDirection();
			canMove = canMove();
		}
		if (canMove) {				
			if (d >= n) {			//Si esta a una distancia menor al centro se mueve a esa distancia
				updateLocation(n);
			} else {
				updateLocation(d);	//Si se quiere mover a una distancia mayor al proximo centro , se mueve al proximo centro
				move(n - d);
			}
		}
	}
	
	/**
	 * Evalua y actualiza la direccion del personaje
	 */
	protected abstract void updateMovementDirection();
	
	/**
	 * Actualiza las coordenadas y la zona con respecto a la direccion y parametro
	 * @param float Unidades a moverse en la direccion actual
	 */
	protected void updateLocation(float n) {
		switch (movementDirection){			//Actualizamos coordenadas dependiendo de la direccion
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
		x = Math.round(x * 100f) / 100f;		//Solo necesitamos precision de dos decimales	
		y = Math.round(y * 100f) / 100f;
		
		this.setCoordinates(x, y);			
		graphic.updatePosition();			//Actualiza la posicion de la Label en la grafica luego de cambiar su posicion
	}
	
	/**
	 * Consulta si este personaje puede moverse. Debe ser llamado solo si el personaje esta en el centro de una zona.
	 * @return True si puede moverse, false si no.
	 */
	protected abstract boolean canMove();
	
	/**
	 * Calcula la distancia entre el proximo centro desde la posicion actual
	 * @return float distancia entre posicion y centro proximo en direccion actual
	 */
	protected float nextCenterDistance() {
		float toReturn;
		switch(movementDirection){			//Evaluamos el centro en la direccion a moverse
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
		if(toReturn == 0f)					//Si la distancia un centro es 0, es que esta en un centro, entonces tiene otro centro a distancia 1
			toReturn = 1f;
		return toReturn;
	}
	
	public void addSpeedMultiplier(float multiplier) {
		speedMultiplier = multiplier;
		speedEffectTimer = 10 * Game.CYCLES_PER_SECOND;
		graphic.setSpeedEffect(true);
	}
	
	protected void removeSpeedMultiplier() {
		speedMultiplier = 1;
		graphic.setSpeedEffect(false);
	}

	protected void updateEffects() {
		if (speedEffectTimer != 0) {
			--speedEffectTimer;
			if (speedEffectTimer == 0) {
				removeSpeedMultiplier();
			}
		}
	}
	
}
