package data;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import exceptions.DataLoadException;
import game.labyrinth.ZoneType;

/**
 * Clase encargada de recuperar la matriz que se utilizara para crear un laberinto desde un archivo XML.
 */
public class LabyrinthLoader {
	
	protected SAXParser saxParser;
	protected String path;
	
	/**
	 * Crea una nueva instancia de LabyrinthLoader.
	 * @param path La direccion del archivo a cargar.
	 * @throws DataLoadException Si ocurre un error durante la creacion del parser.
	 */
	public LabyrinthLoader(String path) throws DataLoadException {
		try {
			saxParser = SAXParserFactory.newInstance().newSAXParser();
			this.path = path;
		} catch (ParserConfigurationException | SAXException e) {
			throw new DataLoadException(e.getMessage());
		} 
	}
	
	/**
	 * Setea la direccion del archivo a cargar. 
	 * @param path La direccion del archivo a cargar. 
	 */
	public void setPath(String path) {
		this.path = path;
	}
	
	/**
	 * Carga la matriz desde el archivo.
	 * @return La matriz recuperada.
	 * @throws DataLoadException Si no se pudo cargar el archivo.
	 */
	public ZoneType[][] load() throws DataLoadException {
		LabyrinthFileParser parser = new LabyrinthFileParser();
		try {
			saxParser.parse(path, parser);
		} catch (SAXException | IOException e) {
			throw new DataLoadException(e.getMessage());
		} catch (IllegalArgumentException e) {
			throw new DataLoadException("Excepcion al cargar laberinto: path nulo");
		}
		return parser.getMatrix();
	}
}
