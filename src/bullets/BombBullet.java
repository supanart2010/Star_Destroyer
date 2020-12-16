package bullets;

import entity.Entity;
import rocket.Rocket;

public class BombBullet extends Bullet{
	//field of bomb bullet
	public static final int BOMB_DELAYTIME = 3000; // 3 seconds
	private int radius;

	public BombBullet(Rocket rocket) {
		super(rocket);
		// TODO Auto-generated constructor stub
	}

	public BombBullet(Entity entity) {
		super(entity);
		// TODO Auto-generated constructor stub
	}
	
	//method for calculate bomb damage
//	@Override
//	public void hit() {
//		//calculate Aoe damage
//	}
}
