package bullets;

import application.ResourceManager;
import rocket.Rocket;

public class LaserBullet extends Bullet {
	public static final int LASER_DELAYTIME = 3000;
	public static final int LASER_DAMAGE = 10;

	public LaserBullet(Rocket rocket) {
		super(rocket);
		setBulletDamage(LASER_DAMAGE);
		this.setImage(ResourceManager.gameStart.LASERBULLET);
		this.setSize(10, 10);
		this.setPosition(rocket.getPositionX() + 40, rocket.getPositionY() - 30);

	}
}
