package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StatsData implements Serializable {
	
	private static final long serialVersionUID = 1L;

	protected String fileName = "score.txt";

	public TopPlayersRegistry load() throws ClassNotFoundException, IOException {
		TopPlayersRegistry topPlayers = new TopPlayersRegistry();

		try (FileInputStream file = new FileInputStream(fileName);
				ObjectInputStream in = new ObjectInputStream(file)) {

			topPlayers = (TopPlayersRegistry)in.readObject();
		}

		return topPlayers;
	}

	public void save(TopPlayersRegistry topPlayers) throws IOException {

		try (FileOutputStream file = new FileOutputStream(fileName);
				ObjectOutputStream out = new ObjectOutputStream(file);) {

			out.writeObject(topPlayers);
			out.flush();

		}

	}

}
