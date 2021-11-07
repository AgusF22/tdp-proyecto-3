package game;

import java.util.Set;
import java.util.HashSet;

public class EndGamePublisher {
	//TODO documentar
	
	private static EndGamePublisher instance;
	protected Set<Subscriber> subscribers;
	
	private EndGamePublisher() {
		subscribers = new HashSet<>();
	}
	
	/**
	 * Devuelve la instancia actual del objeto, o en su defecto un nuevo objeto.
	 * @return
	 */
	public static EndGamePublisher getInstance() {
		if(instance == null) 
			instance = new EndGamePublisher();
		return instance;
	}
	
	/**
	 * Agrega el subscriber s a la lista subscribers.
	 * @param s Subscriber que se desea agregar.
	 */
	public void subscribe(Subscriber s) {
		subscribers.add(s);
	}
	
	/**
	 * remueve el Subscriber s de la lista subscribers.
	 * @param s Subscriber que se desea remover.
	 */
	public void unsubscribe(Subscriber s) {
		subscribers.remove(s);
	}
	
	public void notifySubscribers() {
		subscribers.forEach(Subscriber::update);
	}
}
