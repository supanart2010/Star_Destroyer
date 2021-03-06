package sprite;

import logic.ResourceManager;

public class LaserBullet extends Bullet {
	public static final int LASER_DELAYTIME = 3000;
	public static final int LASER_DAMAGE = 40;

	public LaserBullet(Rocket rocket) {
		super(rocket);
		setBulletDamage(LASER_DAMAGE);
		setImage(ResourceManager.gameStart.LASERBULLET);
		setSize(BULLET_WIDTH,BULLET_HEIGHT);
		setPosition(rocket.getPositionX() + rocket.getWidth()/2 - 10, rocket.getPositionY() - BULLET_HEIGHT);

	}
}
