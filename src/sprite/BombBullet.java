package sprite;

import logic.ResourceManager;

public class BombBullet extends Bullet {
	public static final int BOMB_DELAYTIME = 3000;
	public static final int BOMB_DAMAGE = 50;

	public BombBullet(Rocket rocket) {
		super(rocket);
		setBulletDamage(BOMB_DAMAGE);	
		setImage(ResourceManager.gameStart.BOMBBULLET);
		setSize(BULLET_WIDTH,BULLET_HEIGHT);
		setPosition(rocket.getPositionX() + rocket.getWidth()/2 - 10, rocket.getPositionY() - BULLET_HEIGHT);
	}
}
