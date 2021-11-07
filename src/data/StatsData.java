package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StatsData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	protected String fileName = "SCORE.txt";
	protected TopPlayersRegistry topPlayers;
	
	public TopPlayersRegistry load() throws ClassNotFoundException, IOException {
		topPlayers = new TopPlayersRegistry();
		
		try (FileInputStream file = new FileInputStream(fileName);
			 ObjectInputStream in = new ObjectInputStream(file)) {
			
			topPlayers = (TopPlayersRegistry)in.readObject();
		}
		
		return topPlayers;
	}
	
	public void save() throws IOException {
		FileOutputStream file = new FileOutputStream(fileName);		// FIXME cambiar a try with resources -AF
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(topPlayers);
		out.flush();
		out.close();
		file.close();
	}
	
}
