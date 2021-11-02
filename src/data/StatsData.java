package data;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;


public class StatsData implements Serializable {
	protected String fileName = "SCORE";
	
	public StatsData() {

	}
	
	@SuppressWarnings("unchecked")
	public Map<String, Integer> load()  throws IOException, ClassNotFoundException {
		Map<String, Integer> input = null;
		FileInputStream file = new FileInputStream(fileName);
		ObjectInputStream in = new ObjectInputStream(file);
		input = (Map<String, Integer>)in.readObject();
		in.close();
		file.close();
		return input;
	}
	
	public void save(Map<String, Integer> stats) throws IOException {
		FileOutputStream file = new FileOutputStream(fileName);
		ObjectOutputStream out = new ObjectOutputStream(file);
		out.writeObject(stats);
		out.close();
		file.close();
	}
}
