package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class StatsData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String fileName = "SCORE.txt";
	protected TopPlayers topPlayers;
	
	
	public TopPlayers load()  throws IOException, ClassNotFoundException {
		topPlayers = new TopPlayers();
		FileInputStream file = new FileInputStream(fileName);		// FIXME si se lanza la excepcion este recurso no se cierra, usar try-with-resources, o 
		ObjectInputStream in = new ObjectInputStream(file);			// usar try catch, cerrar el recurso y relanzar la excepcion -AF
		topPlayers = (TopPlayers)in.readObject();
		in.close();
		file.close();
		
		return topPlayers;
	}
	
	public void save() throws IOException {
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(topPlayers);
		out.flush();
		out.close();
		file.close();
	}
}
