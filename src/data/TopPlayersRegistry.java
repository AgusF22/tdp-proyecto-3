package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Modela una coleccion de mejores jugadores.
 * Esta estructura guarda solo 5 puntajes, que son siempre los mas altos que hayan sido ingresados.
 */
public class TopPlayersRegistry implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<PlayerScore> ranking;
	
	/**
	 * Crea un nuevo registro de mejores jugadores.
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
	 * Retorna una coleccion iterable de puntajes de jugador, ordenada de mayor a menor.
	 * @return una coleccion iterable de puntajes de jugador, ordenada de mayor a menor.
	 */
	public Iterable<PlayerScore> getScores() {
		return new ArrayList<>(ranking);
	}
}
