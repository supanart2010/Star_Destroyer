package bullets;

import entity.Entity;
import rocket.Rocket;

public class BombBullet extends Bullet {
	public static final int BOMB_DELAYTIME = 3000;
	private int radius;

	public BombBullet(Rocket rocket) {
		super(rocket);
	}

	public BombBullet(Entity entity) {
		super(entity);
	}
}
