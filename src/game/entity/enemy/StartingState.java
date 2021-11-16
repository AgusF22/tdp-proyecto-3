package game.entity.enemy;

public class StartingState extends RespawningState {

	public StartingState(Enemy enemy, int duration) {
		super(enemy);
		this.respawnTimer = duration;
	}

}
