package bullets;

import application.ResourceManager;
import rocket.Rocket;

public class PointBullet extends Bullet {
	public static final int POINT_DELAYTIME = 50;
	public static final int POINT_DAMAGE = 5;

	public PointBullet(Rocket rocket) {
		super(rocket);
		setBulletDamage(POINT_DAMAGE);
		setImage(ResourceManager.gameStart.BULLET);
		this.setSize(10, 10);
		this.setPositionX(rocket.getPositionX() + 40);
		this.setPositionY(rocket.getPositionY());
	}

}
