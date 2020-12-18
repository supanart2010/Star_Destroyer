package sprite;

import logic.ResourceManager;

public class BombBullet extends Bullet {
	public static final int BOMB_DELAYTIME = 3000;
	public static final int BOMB_DAMAGE = 50;

	public BombBullet(Rocket rocket) {
		super(rocket);
		this.setImage(ResourceManager.gameStart.BOMBBULLET);
		this.setSize(10, 10);
		this.setPosition(rocket.getPositionX() + 40, rocket.getPositionY());
		setBulletDamage(BOMB_DAMAGE);	
	}
}
