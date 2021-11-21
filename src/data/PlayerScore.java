package data;

import java.io.Serializable;

/**
 * Clase que registra el puntaje de un jugador.
 * Nota: esta clase tiene un ordenamiento natural inconsistente con equals.
 */
public class PlayerScore implements Serializable, Comparable<PlayerScore> {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Integer score;
	
	/**
	 * Crea una nueva instancia de PlayerScore.
	 * @param name El nombre del jugador.
	 * @param score El puntaje del jugador.
	 */
	public PlayerScore(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	
	/**
	 * Retorna el nombre del jugador.
	 * @return El nombre del jugador.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Retorna un entero, el puntaje guardado.
	 * @return Un entero, el puntaje guardado.
	 */
	public Integer getScore() {
		return score;
	}
	
	@Override
	public int compareTo(PlayerScore playerScore) {
		int toReturn;
		if (playerScore == null) {
			throw new NullPointerException();
		}
		if (score < playerScore.score) {
			toReturn = -1;
		} else if (score > playerScore.score) {
			toReturn = 1;
		} else {
			toReturn = 0;
		}
		return toReturn;
	}
	
	@Override
	public String toString() {
		return name + " " + score;
	}
	
}
