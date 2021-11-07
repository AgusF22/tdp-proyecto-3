package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
		ranking.add(p);
	}
	
	// TODO añadir javadoc, especificando el orden de la lista retornada -AF
	public List<PlayerScore> getScores() {
		Collections.sort(this.ranking, Collections.reverseOrder());
		List<PlayerScore> top = new ArrayList<>();
		int i = 0;
		
		for (PlayerScore p: this.ranking) {
			top.add(p);
			if (i == 5) break;
			i++;
		}
		
		return top;
	}
	
}
