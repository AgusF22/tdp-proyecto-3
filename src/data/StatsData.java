package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Clase encargada de cargar y guardar el registro de puntajes.
 */
public class StatsData implements Serializable {

	protected static final String FILE_NAME = "score";

	private static final long serialVersionUID = 1L;

	/**
	 * Carga el registro de mejores puntajes. Si no existe, crea uno nuevo.
	 * @return El registro de mejores puntajes.
	 * @throws ClassNotFoundException Si no se encuentra la clase TopPlayersRegistry.
	 * @throws IOException Si ocurre un error de entrada/salida.
	 */
	public TopPlayersRegistry load() throws ClassNotFoundException, IOException {
		TopPlayersRegistry topPlayers = null;

		try (FileInputStream file = new FileInputStream(FILE_NAME);
				ObjectInputStream in = new ObjectInputStream(file)) {
			
			topPlayers = (TopPlayersRegistry)in.readObject();
			
		} catch (FileNotFoundException e) {
			topPlayers = new TopPlayersRegistry();
		}

		return topPlayers;
	}

	/**
	 * Salva el registro de mejores puntajes pasado como parametro.
	 * @param topPlayers Un registro de mejores puntajes.
	 * @throws IOException Si ocurre un error de entrada/salida.
	 */
	public void save(TopPlayersRegistry topPlayers) throws IOException {
		try (FileOutputStream file = new FileOutputStream(FILE_NAME);
				ObjectOutputStream out = new ObjectOutputStream(file);) {
			out.writeObject(topPlayers);
		}
	}

}
