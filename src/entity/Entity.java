package entity;

import java.util.Random;

import bullets.Bullet;
import logic.Hitable;
import logic.Moveable;
import logic.Sprite;
import logic.Updatable;
import rocket.Rocket;
import rocket.Storage;

public abstract class Entity extends Sprite implements Updatable, Moveable, Hitable {
	private String name;
	private int maxHp;
	private int hp;
	private int speedX;
	private int speedY;
	private boolean isMovingLeftDirection = new Random().nextBoolean();

	// Constructor
	public Entity(String name, int maxHp, int speedX, int speedY) {
		super(0, 0, 0, 0); // edit it later
		setName(name);
		setMaxHp(maxHp);
		setHp(maxHp); // when instance, it has full HP
		setSpeedX(0);
		setSpeedY(0);
	}

	// Addition Method
	public void decreaseHp(int damage) {
		if (damage > hp) {
			hp = 0;
		} else {
			hp -= damage;
		}
	}

	public boolean isDead() {
		return hp == 0;
	}

	public void checkDirectionX() {
		if(isBoarderCollision()) {
			isMovingLeftDirection = !isMovingLeftDirection;
		}
	}
	public boolean isBoarderCollision() {
		int CanvasWidth = 500;
		return (getPositionX() < 0) || (getPositionX()+this.getWidth() > CanvasWidth);
		// edit CanvasWidht later
	}
	
	// Interface Method
	@Override
	public void update() {
		// TODO Auto-generated method stub
		moveDown();
		if (isMovingLeftDirection) {
			moveLeft();
		} else {
			moveRight();
		}
		checkDirectionX();
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub

	}

	public void hit(Rocket rocket) {
		// TODO Auto-generated method stub
		decreaseHp(rocket.getBodyDamage());
	}
	
	public void hit(Bullet bullet) {
		// TODO Auto-generated method stub
		decreaseHp(bullet.getBulletDamage());
	}
	
	@Override
	public void moveUp() {
		// TODO Auto-generated method stub
		//Do nothing.
	}
	
	@Override
	public void moveDown() {
		// TODO Auto-generated method stub
		positionY += speedY;
	}

	@Override
	public void moveLeft() {
		// TODO Auto-generated method stub
		positionX -= speedX;
	}

	@Override
	public void moveRight() {
		// TODO Auto-generated method stub
		positionX += speedX;
	}

	// Getter & Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
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

	public abstract int getDamage();
}
