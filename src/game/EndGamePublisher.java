package game;

import game.entity.player.Player;

public class EndGamePublisher {
	//TODO documentar
	
	private static EndGamePublisher instance;
	protected Subscriber[] subscribers; //TODO definir coleccion
	
	private EndGamePublisher() {
		//TODO implementar
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
