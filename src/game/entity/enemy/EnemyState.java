package game.entity.enemy;

import game.labyrinth.Direction;

public abstract class EnemyState {
	
	protected Enemy contextEnemy;
	
	/**
	 * Crea un nuevo estado para el enemigo pasado como parametro.
	 * @param enemy Un enemigo.
	 */
	protected EnemyState(Enemy enemy) {
		this.contextEnemy = enemy;
	}
	
	/**
	 * Mueve al enemigo que se encuentra en este estado.
	 */
	public abstract void move();
	
	/**
	 * Retorna la direccion en la que se debe mover el enemigo que se encuentra en este estado.
	 * @return La proxima direccion de movimiento.
	 */
	public abstract Direction nextMoveDirection();
	
	/**
	 * Hace que el enemigo que se encuentra en este estado colisione con el jugador.
	 */
	public abstract void collideWithPlayer();
	
	/**
	 * Retorna si este estado esta bloqueado y no puede ser cambiado por el cliente.
	 * @return True si el estado puede ser cambiado por el cliente, false si no.
	 */
	public abstract boolean locked();
	
}
