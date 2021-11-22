package exceptions;

/**
 * Señala que ocurrio una excepcion al usar una zona.
 */
public class InvalidZoneException extends Exception {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Crea una nueva InvalidZoneException con el mensaje pasado como parametro.
	 * @param msg Un mensaje que detalla el error.
	 */
	public InvalidZoneException(String msg) {
		super(msg);
	}
	
}
