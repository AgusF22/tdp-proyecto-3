package game.entity.enemy;

import game.entity.Entity;
import game.entity.visitor.Visitor;
import game.labyrinth.Zone;

public abstract class Enemy extends Entity{
	
	protected EnemyState state;
	
	/**
	 * Construye un nuevo enemigo.
	 * @param zone La zona en la que se encontrara el nuevo enemigo.
	 */
	protected Enemy(Zone zone) {
		super(zone);
		state = new ChasingState(this);
	}
	
	/**
	 * Ejecuta el movimiento de este enemigo.
	 */
	public void move() {
		state.move();
	}
	
	/**
	 * Ordena a este enemigo calcular el camino hacia su objetivo.
	 */
	public abstract void calculateChasePath();
	
	/**
	 * Acepta un visitor.
	 */
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	public void setFleeing() {
		state = new FleeingState(this);
	}
	
	public void CollideWithPlayer() {
		state.CollideWithPlayer();
	}
	
	protected void changeState(EnemyState state) {
		this.state = state; 
	}
}
