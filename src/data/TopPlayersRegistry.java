package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class TopPlayersRegistry implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<PlayerScore> ranking;
	
	/**
	 * Crea una nueva registro de mejores jugadores.
	 */
	public TopPlayersRegistry() {
		ranking = new ArrayList<>();
	}
	
	/**
	 * Añade un puntaje de jugador a este registro.
	 * @param p Un puntaje de jugador.
	 */
	public void addPlayer(PlayerScore p) {
		ranking.add(p);														// Agrega nuevo puntaje 
		Collections.sort(this.ranking, Collections.reverseOrder());			// Ordena
		if (ranking.size() > 5) {											// Controla que solo se guarden los 5 mejores puntajes.
			ranking.remove(ranking.size() - 1);
		}
	}
	
	/**
	 * @return una lista ordenada de mayor a menor de objetos PlayerScore. 
	 */
	public Iterable<PlayerScore> getScores() {
		return new ArrayList<>(ranking);
	}
}
