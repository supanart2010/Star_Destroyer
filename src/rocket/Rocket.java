package rocket;

import application.Controller;
import logic.Hitable;
import logic.Moveable;
import logic.Sprite;
import logic.Updatable;

public class Rocket extends Sprite implements Hitable, Moveable, Updatable {
	private String name;
	private int type;
	private Storage storage;
	private int maxHp;
	private int hp;
	private int speedX;
	private int speedY;

	// Constructor
	public Rocket(String name, int type, Storage storage, int maxHp, int speedX, int speedY) {
		super(0, 0, 0, 0); // edit it later
		setName(name);
		setType(type);
		setStorage(storage);
		setMaxHp(maxHp);
		setHp(maxHp); // when instance, it has full HP
		setSpeedX(speedX);
		setSpeedY(speedY);
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

	// Interface Method
	public void update() {
		// TODO Auto-generated method stub
		if (Controller.isMoveUp() && positionY > 0) {
			moveUp();
		}
		if (Controller.isMoveDown() && positionY < 500) {
			moveDown();
		}
		if (Controller.isMoveLeft() && positionX > 0) {
			moveLeft();
		}
		if (Controller.isMoveRight() && positionX < 400) {
			moveRight();
		}
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
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

}
