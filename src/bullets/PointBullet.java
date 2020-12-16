package bullets;

import entity.Entity;
import rocket.Rocket;

public class PointBullet extends Bullet {
	public static final int POINT_DELAYTIME = 50;

	public PointBullet(Entity entity) {
		super(entity);
	}

	public PointBullet(Rocket rocket) {
		super(rocket);
	}
}
