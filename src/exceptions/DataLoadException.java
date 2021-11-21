package exceptions;

/**
 * Señala que ocurrio una excepcion al cargar datos.
 */
public class DataLoadException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Crea una nueva DataLoadException con el mensaje pasado como parametro.
	 * @param msg Un mensaje que detalla el error.
	 */
	public DataLoadException(String msg) {
		super(msg);
	}
	
}
