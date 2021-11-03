package data;

import java.io.Serializable;

public class PlayerScore implements Serializable, Comparable<PlayerScore> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private Integer score;
	
	public PlayerScore(String name, Integer score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}

	public Integer getScore() {
		return score;
	}
	
	@Override
	public int compareTo(PlayerScore arg0) {
		return this.score.compareTo(arg0.getScore());
	}
	
	public boolean equals(PlayerScore arg0) {
		return this.score == arg0.getScore();
	}
	
	public String toString() {
		return name + " " + score;
	}
}
