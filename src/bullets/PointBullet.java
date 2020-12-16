package bullets;

import entity.Entity;
import rocket.Rocket;

public class PointBullet extends Bullet {

	public PointBullet(Entity entity) {
		super(entity);
	}

	public PointBullet(Rocket rocket) {
		super(rocket);
	}
}
