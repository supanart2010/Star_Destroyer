package bullets;

import entity.Entity;
import rocket.Rocket;

public class BombBullet extends Bullet{
	//field of bomb bullet
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
//	public hit() {
//		//calculate Aoe damage
//	}
}
