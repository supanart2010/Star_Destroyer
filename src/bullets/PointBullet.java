package bullets;

import rocket.Rocket;

public class PointBullet extends Bullet {
	public static final int POINT_DELAYTIME = 50;
	public static final int POINT_DAMAGE = 5;

	public PointBullet(Rocket rocket) {
		super(rocket);
		setBulletDamage(POINT_DAMAGE);
	}

}
