package data;

import java.io.Serializable;

public class ScorePlayer implements Serializable, Comparable<ScorePlayer> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer score;
	
	public ScorePlayer(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public Integer getScore() {
		return score;
	}
	
	// FIXME sobreescribir tambien el metodo equals para cumplir el contrato de la interfaz Comparable
	
	@Override
	public int compareTo(ScorePlayer arg0) {
		return this.score.compareTo(arg0.getScore());
	}
	
	public String toString() {
		return name + " " + score;
	}
}
