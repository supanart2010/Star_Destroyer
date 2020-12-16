package bullets;

import rocket.Rocket;

public class BombBullet extends Bullet {
	public static final int BOMB_DELAYTIME = 3000;
	public static final int BOMB_DAMAGE = 50;
	private int radius;

	public BombBullet(Rocket rocket) {
		super(rocket);
		setBulletDamage(BOMB_DAMAGE);
	}
}
