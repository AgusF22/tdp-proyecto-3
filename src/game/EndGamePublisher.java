package game;


public class EndGamePublisher {
	//TODO documentar
	
	private EndGamePublisher instance;
	protected Subscriber[] subscribers; //TODO definir coleccion
	
	private EndGamePublisher() {
		//TODO implementar
	}
	
	/**
	 * Devuelve la instancia actual del objeto, o en su defecto un nuevo objeto.
	 * @return
	 */
	public EndGamePublisher getInstance() {
		return instance != null? instance : new EndGamePublisher();
	}
	
	public void subscribe(Subscriber s) {
		//TODO implementar
	}
	
	public void unsubscribe(Subscriber s) {
		//TODO implementar
	}
	
	public void notifySubscribers() {
		//TODO implementar
	}
}
