package bullets;

import entity.Entity;
import rocket.Rocket;

public class LaserBullet extends Bullet {
	//field of laser bullet 
	public static final int LASER_DELAYTIME = 3000; // 3 seconds
	public LaserBullet(Rocket rocket) {
		super(rocket);
		// TODO Auto-generated constructor stub
		setBulletDamage(10); // edit it later -> laser damage for player
	}

	public LaserBullet(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
		setBulletDamage(10); // edit it later -> laser damage for entity
	}
}
