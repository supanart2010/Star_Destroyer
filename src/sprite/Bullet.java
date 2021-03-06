package sprite;

public class Bullet extends Sprite implements Moveable, Hittable, Updatable {
	public static final int BULLET_SPEEDX = 0;
	public static final int BULLET_SPEEDY = 10;
	public static final int BULLET_WIDTH = 10;
	public static final int BULLET_HEIGHT = 10;
	private int bulletDamage;
	private int speedX;
	private int speedY;
	private boolean isConsumed;

	// Constructor
	public Bullet(Rocket rocket) {
		super(0, 0, 0, 0);
		setSpeedX(BULLET_SPEEDX);
		setSpeedY(BULLET_SPEEDY);
		setConsumed(false);
	}

	// Interface Methods
	@Override
	public void update() {
		moveUp();
	}
	@Override
	public void hit() {
		setConsumed(true);
	}

	@Override
	public void moveUp() {
		positionY -= speedY;
	}

	@Override
	public void moveDown() {
	}

	@Override
	public void moveLeft() {
	}

	@Override
	public void moveRight() {
	}

	// Getter & Setter
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

	public boolean isConsumed() {
		return isConsumed;
	}

	public void setConsumed(boolean isConsumed) {
		this.isConsumed = isConsumed;
	}
}
