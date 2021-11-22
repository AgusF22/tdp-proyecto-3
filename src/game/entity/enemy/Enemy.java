package game.entity.enemy;

import java.util.EnumSet;
import java.util.Set;

import game.entity.Character;
import game.entity.visitor.Visitor;
import game.labyrinth.Direction;
import game.labyrinth.LabyrinthCursor;
import game.labyrinth.Zone;
import game.labyrinth.ZoneType;

/**
 * Clase que modela un enemigo.
 */
public abstract class Enemy extends Character {
	
	protected EnemyState state;
	protected int spawnDelay;
	
	/**
	 * Construye un nuevo enemigo.
	 * @param zone La zona en la que se encontrara el nuevo enemigo.
	 * @param movementSpeed La velocidad de movimiento para el nuevo enemigo.
	 */
	protected Enemy(Zone zone, float movementSpeed) {
		super(zone, 0.1f);
	}
	
	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	/**
	 * Aturde a este enemigo, haciendo que no pueda moverse ni interactuar por un tiempo.
	 */
	public void stun() {
		state = new StunedState(this);
	}
	
	/**
	 * Cambia el comportamiento de este enemigo, haciendo que intente escapar del jugador.
	 */
	public void setFleeing() {
		if (!state.locked()) {
			state = new FleeingState(this);
		}
	}
	
	/**
	 * Mata a este enemigo, haciendo que entre en estado de reaparicion.
	 */
	public void kill() {
		state = new RespawningState(this);
	}
	
	@Override
	public void respawn() {
		state = new StartingState(this, spawnDelay);
	}
	
	/**
	 * Cambia el estado de este enemigo.
	 * @param state El nuevo estado para este enemigo.
	 */
	protected void changeState(EnemyState state) {
		this.state = state; 
	}
	
	/**
	 * Colisiona este enemigo con el jugador.
	 */
	public void collideWithPlayer() {
		state.collideWithPlayer();
	}
	
	@Override
	public void addSpeedMultiplier(float multiplier) {
		speedMultiplier = multiplier;
		speedEffectTimer = FleeingState.FLEEING_DURATION;
	}
	
	@Override
	protected void removeSpeedMultiplier() {
		speedMultiplier = 1;
	}
	
	/**
	 * Cambia la direccion actual por su opuesta.
	 */
	protected void turnAround() {
		movementDirection = movementDirection.getOpposite();
	}
	
	/**
	 * Ordena a este enemigo calcular el camino hacia su objetivo.
	 */
	protected abstract Direction calculateChasePath();
	
	@Override
	public void move() {
		updateEffects();
		state.move();
	}
	
	@Override
	protected void updateMovementDirection() {
		if (isIntersection(zone)) {
			movementDirection = state.nextMoveDirection();
			graphic.updateImage();
		} else {
			if (!canMove()) {
				turnAtPathEnd();
				graphic.updateImage();
			}
		}
	}
	
	@Override
	protected boolean canMove() {
		return zone.getAdjacent(movementDirection).getType() != ZoneType.WALL;
	}
	
	/**
	 * Asumiendo que este enemigo no puede continuar moviendose ya que se topo con una pared y no se encuentra en una interseccion,
	 * cambia de direccion para continuar por el mismo camino.
	 */
	private void turnAtPathEnd() {
		Direction cwDir = movementDirection.getCWDirection();
		Direction ccwDir = movementDirection.getCCWDirection();
		if (zone.getAdjacent(cwDir).getType() != ZoneType.WALL) {
			movementDirection = cwDir;
		} else if (zone.getAdjacent(ccwDir).getType() != ZoneType.WALL) {
			movementDirection = ccwDir;
		} else {
			movementDirection = movementDirection.getOpposite();
		}
	}
	
	/**
	 * Calcula el mejor camino para acercarse a una zona destino.
	 * @param destZone La zona destino.
	 * @return La mejor direccion para acercarse a una zona destino.
	 */
	protected Direction bestAproachPath(Zone destZone) {
		Direction bestDirection = movementDirection;
		double bestValue = Double.MIN_VALUE;
		double value;
		LabyrinthCursor cursor = new LabyrinthCursor(zone, movementDirection);
		Set<Direction> directions = EnumSet.complementOf(
				EnumSet.of(movementDirection.getOpposite()));

		for (Direction d : directions) {
			if(zone.getAdjacent(d).getType() != ZoneType.WALL) {
				value = pathValue(cursor.sendCloneTo(d), destZone, 10);
				if (value > bestValue) {
					bestValue = value;
					bestDirection = d;
				}
			}
		}
		return bestDirection;
	}

	/**
	 * Calcula el mejor camino para alejarse de una zona destino.
	 * @param destZone La zona destino.
	 * @return La mejor direccion para alejarse de una zona destino.
	 */
	protected Direction bestFleePath(Zone destZone) {
		Direction bestDirection = movementDirection;
		double bestValue = Double.MAX_VALUE;
		double value;
		LabyrinthCursor cursor = new LabyrinthCursor(zone, movementDirection);
		Set<Direction> directions = EnumSet.complementOf(
				EnumSet.of(movementDirection.getOpposite()));

		for (Direction d : directions) {
			if(zone.getAdjacent(d).getType() != ZoneType.WALL) {
				value = pathValue(cursor.sendCloneTo(d), destZone, 10);
				if (value < bestValue) {
					bestValue = value;
					bestDirection = d;
				}
			}
		}
		return bestDirection;
	}

	/**
	 * Calcula recursivamente el valor de un camino.
	 * @param cursor Un cursor.
	 * @param destZone La zona destino, con la cual se calcula el valor de cada zona evaluada.
	 * @param n La cantidad de zonas que quedan por evaluar.
	 * @return El valor del camino, que es igual al mejor valor de las zonas del camino.
	 */
	private double pathValue(LabyrinthCursor cursor, Zone destZone, int n) {
		double toReturn = zoneValue(cursor.getZone(), destZone);
		Set<Direction> directions;
		LabyrinthCursor newCursor;
		if (n > 0) {
			if (cursor.isInIntersection()) {
				directions = EnumSet.complementOf(
						EnumSet.of(cursor.getDirection().getOpposite()));
				
				for (Direction d : directions) {
					newCursor = cursor.sendCloneTo(d);
					if (newCursor != null) {
						toReturn = Math.max(toReturn, 
								pathValue(newCursor, destZone, n - 1));
					}
				}
				
			} else {
				toReturn = Math.max(toReturn, pathValue(cursor, destZone, n - 1));
			}
		}
		return toReturn;
	}
	
	/**
	 * Devuelve el valor de una zona. El valor depende de la distancia a la zona objetivo del enemigo.
	 * @param zone1 La zona cuyo valor sera calculado.
	 * @param zone2 La zona objetivo.
	 * @return El valor de una zona.
	 */
	private double zoneValue(Zone zone1, Zone zone2) {
		double distance = Math.sqrt(
								Math.pow((double) zone1.getX() - zone2.getX(), 2) +
								Math.pow((double) zone1.getY() - zone2.getY(), 2));
		
		return distance == 0 ? Double.MAX_VALUE : 1 / distance;
	}
	
	/**
	 * Chequea si la zona dada es una interseccion para el enemigo.
	 * @param zone Una zona.
	 * @return True si la zona es interseccion para el enemigo, false en caso contrario.
	 */
	private boolean isIntersection(Zone zone) {
		int connections = 0;
		for(Direction d : Direction.values()) {
			if(zone.getAdjacent(d).getType() != ZoneType.WALL) {
				connections++;
			}
		}
		return connections > 2;
	}

}
