package bullets;

import rocket.Rocket;

public class LaserBullet extends Bullet {
	public static final int LASER_DELAYTIME = 3000;
	public static final int LASER_DAMAGE = 10;

	public LaserBullet(Rocket rocket) {
		super(rocket);
		setBulletDamage(LASER_DAMAGE);
	}
}
