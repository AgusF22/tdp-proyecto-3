package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopPlayers implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected ArrayList<PlayerScore> ranking;
	
	public TopPlayers() {
		ranking = new ArrayList<>();
	}
	
	public void addPlayer(PlayerScore p) {
		ranking.add(p);
	}
	
	public List<PlayerScore> listPlayers() {
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
