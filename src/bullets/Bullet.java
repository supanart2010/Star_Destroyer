package bullets;

import entity.Entity;
import logic.Hitable;
import logic.Moveable;
import logic.Sprite;
import logic.Updatable;
import rocket.Rocket;

public class Bullet extends Sprite implements Moveable, Hitable,Updatable{
	private boolean isPlayerBullet;
	private int bulletDamage;
	private int speedX;
	private int speedY;
	
	//Constructor
	public Bullet(Rocket rocket) {
		super(0,0,0,0); //edit it later
		setPlayerBullet(true);
		setBulletDamage(5);//edit it later (5 -> some Constant such as ROCKETBULLETDAMAGE)
		setSpeedX(0);
		setSpeedY(10); //edit it later (10 -> some Constant such as ROCKETBULLETSPEED)
	}
	
	public Bullet(Entity entity) {
		super(0,0,0,0); //edit it later
		setPlayerBullet(false);
		setBulletDamage(5); //edit it later (5 -> some Constant such as ENTITYBULLETDAMAGE)
		setSpeedX(0);
		setSpeedY(10); //edit it later (10 -> some Constant such as ENTITYBULLETSPEED)
	}

	//Getter & Setter
	public boolean isPlayerBullet() {
		return isPlayerBullet;
	}

	public void setPlayerBullet(boolean isPlayerBullet) {
		this.isPlayerBullet = isPlayerBullet;
	}

	public int getBulletDamage() {
		return bulletDamage;
	}

	public void setBulletDamage(int bulletDamage) {
		this.bulletDamage = bulletDamage;
	}

	public int getSpeedX() {
		return speedX;
	}

	public void setSpeedX(int speedX) {
		this.speedX = speedX;
	}

	public int getSpeedY() {
		return speedY;
	}

	public void setSpeedY(int speedY) {
		this.speedY = speedY;
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		positionY -= speedY;
	}

	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}

	//update for bullet
	@Override
	public void update() {
		// TODO Auto-generated method stub
		moveUp();
	}
	
}
