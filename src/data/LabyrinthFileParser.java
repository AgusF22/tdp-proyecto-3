package data;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import game.labyrinth.ZoneMatrixBuilder;
import game.labyrinth.ZoneType;

/**
 * Clase para leer un archivo de laberinto usando event handlers de SAX2.
 */
public class LabyrinthFileParser extends DefaultHandler {
	
	private static final String SPAWN 		= "spawn";
	private static final String DUNGEON 	= "dungeon";
	private static final String PATH 		= "path";
	private static final String START 		= "start";
	private static final String END 		= "end";
	private static final String COORDS 		= "coords";
	
	private ZoneMatrixBuilder matrixBuilder;
	
	private int[] point1;
	private int[] point2;
	
	/**
	 * Recibe notificacion del inicio del documento.
	 * Inicializa el builder de la matriz, y los arreglos de enteros.
	 */
	@Override
	public void startDocument() throws SAXException {
		matrixBuilder = new ZoneMatrixBuilder();
		point1 = new int[2];
		point2 = new int[2];
	}
	
	/**
	 * Recibe notificacion del inicio de un elemento.
	 * Setea los atributos (coordenadas) del elemento en el arreglo correspondiente.
	 */
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName) {
		case COORDS:
		case START:
			setPoint(point1, attributes);
			break;
		case END:
			setPoint(point2, attributes);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Recibe notificacion del final de un elemento.
	 * Dependiendo del elemento terminado, setea los valores correspondientes en el builder de la matriz.
	 */
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case SPAWN:
			matrixBuilder.setSpawn(point1[0], point1[1]);
			break;
		case DUNGEON:
			matrixBuilder.setDungeon(point1[0], point1[1], point2[0], point2[1]);
			break;
		case PATH:
			matrixBuilder.setPath(point1[0], point1[1], point2[0], point2[1]);
			break;
		default:
			break;
		}
	}
	
	/**
	 * Setea los valores de los atributos "x" e "y" en el primer y segundo lugar del arreglo pasado como parametro.
	 * @param point Un arreglo de enteros de longitud >= 2.
	 * @param attributes Una lista de atributos XML.
	 */
	private void setPoint(int[] point, Attributes attributes) {
		point[0] = Integer.valueOf(attributes.getValue("x"));
		point[1] = Integer.valueOf(attributes.getValue("y"));
	}

	/**
	 * Devuelve la matriz obtenida.
	 * @return La matriz obtenida.
	 */
	public ZoneType[][] getMatrix() {
		return matrixBuilder.build();
	}
	
}
