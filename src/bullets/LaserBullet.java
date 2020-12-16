package bullets;

import entity.Entity;
import rocket.Rocket;

public class LaserBullet extends Bullet {
	public static final int LASER_DELAYTIME = 3000;

	public LaserBullet(Rocket rocket) {
		super(rocket);
		setBulletDamage(10); // edit it later -> laser damage for player
	}

	public LaserBullet(Entity entity) {
		super(entity);
		setBulletDamage(10); // edit it later -> laser damage for entity
	}
}
