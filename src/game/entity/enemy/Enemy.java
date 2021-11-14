package game.entity.enemy;

import java.util.EnumSet;
import java.util.Set;

import game.Direction;
import game.entity.Character;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;
import game.labyrinth.ZoneType;

public abstract class Enemy extends Character {
	
	protected EnemyState state;
	
	/**
	 * Construye un nuevo enemigo.
	 * @param zone La zona en la que se encontrara el nuevo enemigo.
	 */
	protected Enemy(Zone zone) {
		super(zone, 0.15f);
		state = new ChasingState(this);
	}
	
	/**
	 * Acepta un visitor.
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	protected float getSpeedMultiplier() {
		return speedMultiplier;
	}
	
	protected float getMovementSpeed() {
		return movementSpeed;
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
		state = new FleeingState(this);
	}
	
	/**
	 * Colisiona este enemigo con el jugador.
	 */
	public void collideWithPlayer() {
		state.collideWithPlayer();
	}
	
	/**
	 * Cambia el estado de este enemigo.
	 * @param state El nuevo estado para este enemigo.
	 */
	protected void changeState(EnemyState state) {
		this.state = state; 
	}
	
	/**
	 * Ejecuta el movimiento de este enemigo.
	 */
	public void move() {
		state.move();
	}
	
	@Override
	protected void updateMovementDirection() {
		if (isIntersection(zone)) {
			movementDirection = calculateChasePath();
			graphic.updateImage();
		} else {
			if (!canMove()) {
				turnAtPathEnd();
				graphic.updateImage();
			}
		}
	}
	
	private void turnAtPathEnd() {
		Direction cwDir = movementDirection.getCWDirection();
		Direction ccwDir = movementDirection.getCCWDirection();
		if (zone.getAdjacent(cwDir).getType() != ZoneType.WALL) {
			movementDirection = cwDir;
		} else if (zone.getAdjacent(cwDir).getType() != ZoneType.WALL) {
			movementDirection = ccwDir;
		} else {
			movementDirection = movementDirection.getOpposite();
		}
	}

	@Override
	protected boolean canMove() {
		return zone.getAdjacent(movementDirection).getType() != ZoneType.WALL;
	}
	
	/**
	 * Ordena a este enemigo calcular el camino hacia su objetivo.
	 */
	public abstract Direction calculateChasePath();
	
	/**
	 * Calcula el mejor camino para acercarse a una zona destino.
	 * @param destZone La zona destino.
	 * @return La mejor direccion para acercarse a una zona destino.
	 */
	protected Direction bestAproachPath(Zone destZone) {
		Direction bestDirection = movementDirection;
		double bestValue = Double.MIN_VALUE;
		double value;
		Cursor cursor = new Cursor(zone, movementDirection);
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
		Cursor cursor = new Cursor(zone, movementDirection);
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
	 * Calcula el valor de un camino.
	 * @param cursor Un cursor.
	 * @param destZone La zona destino, con la cual se calcula el valor de cada zona evaluada.
	 * @param n La cantidad de zonas que quedan por evaluar.
	 * @return El valor del camino, que es igual al mejor valor de las zonas del camino.
	 */
	private double pathValue(Cursor cursor, Zone destZone, int n) {
		double toReturn = zoneValue(cursor.zone, destZone);
		Set<Direction> directions;
		if (n == 0) {
			toReturn = zoneValue(cursor.zone, destZone);
		} else {
			cursor.nextZone();
			if (cursor.isInIntersection()) {
				directions = EnumSet.complementOf(EnumSet.of(cursor.direction));
				for (Direction d : directions) {
					toReturn = Math.max(toReturn, pathValue(
										cursor.sendCloneTo(d), destZone, n - 1));
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
	
	/**
	 * Tipo de dato que modela un par zona direccion. A ser usado para calcular el movimiento del enemigo.
	 */
	private class Cursor {
		
		private Zone zone;
		private Direction direction;
		
		/**
		 * Crea una nueva instancia de cursor.
		 * @param zone Una zona.
		 * @param direction Una direccion.
		 */
		private Cursor(Zone zone, Direction direction) {
			this.zone = zone;
			this.direction = direction;
		}
		
		/**
		 * Mueve este cursor para que apunte a la siguiente zona, de acuerdo a la direccion actual.
		 */
		private void nextZone() {
			if(zone.getAdjacent(direction).getType() != ZoneType.WALL) {
				zone = zone.getAdjacent(direction);
			} else {
				if(zone.getAdjacent(direction.getCWDirection())
						.getType() != ZoneType.WALL) {
					zone = zone.getAdjacent(direction.getCWDirection());
					direction = direction.getCWDirection();
				} else {
					zone = zone.getAdjacent(direction.getCCWDirection());
					direction = direction.getCCWDirection();
				}
			}
		}
		
		/**
		 * Clona este cursor, le asigna una nueva direccion, y lo mueve en dicha direccion.
		 * @param direction La direccion para el nuevo cursor.
		 * @return El nuevo cursor, movido una vez.
		 */
		private Cursor sendCloneTo(Direction direction) {
			Cursor clone = new Cursor(zone, direction);
			clone.nextZone();
			return clone;
		}
		
		/**
		 * Comprueba si este cursor se encuentra en una zona interseccion, es decir, una zona adyacente a mas de 2 caminos.
		 * @return True si la zona a la que apunta este cursor es interseccion, false si no.
		 */
		private boolean isInIntersection() {
			int connections = 0;
			EnumSet<Direction> directions = EnumSet.complementOf(EnumSet.of(direction));
			for(Direction d : directions) {
				if(zone.getAdjacent(d).getType() != ZoneType.WALL) {
					connections++;
				}
			}
			return connections > 1;
		}
		
	}
	
}
