package sprite;

import logic.ResourceManager;

public class PointBullet extends Bullet {
	public static final int POINT_DELAYTIME = 50;
	public static final int POINT_DAMAGE = 5;

	public PointBullet(Rocket rocket) {
		super(rocket);
		setBulletDamage(POINT_DAMAGE);
		setImage(ResourceManager.gameStart.BULLET);
		setSize(BULLET_WIDTH,BULLET_HEIGHT);
		setPosition(rocket.getPositionX() + rocket.getWidth()/2 - 10, rocket.getPositionY() - BULLET_HEIGHT);
	}

}
