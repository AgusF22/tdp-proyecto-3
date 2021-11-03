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
	protected List<ScorePlayer> ranking;
	
	public TopPlayers() {
		ranking = new ArrayList<ScorePlayer>();
	}
	
	public void addPlayer(ScorePlayer p) {
		ranking.add(p);
	}
	
	public List<ScorePlayer> listPlayers() {
		Collections.sort(this.ranking, Collections.reverseOrder());
		List<ScorePlayer> top = new ArrayList<ScorePlayer>();
		int i = 0;
		
		for (ScorePlayer p: this.ranking) {
			top.add(p);
			if (i == 5) break;
			i++;
		}
		
		return top;
	}
}
