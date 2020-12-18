package sprite;

import gui.GameStartScene;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import logic.AudioManager;
import logic.BulletManager;
import logic.Controller;
import logic.ResourceManager;
import logic.SceneManager;

public class Rocket extends Sprite implements Hittable, Moveable, Updatable {
	public static final int ROCKET_WIDTH = 100;
	public static final int ROCKET_HEIGHT = 100;
	private String name;
	private Storage storage;
	private int maxHp;
	private int hp;
	private double speedX;
	private double speedY;
	private BulletManager bulletManager;
	private int bodyDamage;
	private int score;

	// Constructor
	public Rocket(String name, Storage storage, int maxHp, double speedX, double speedY, int bodyDamage) {
		super(0, 0, 0, 0); // edit it later
		setName(name);
		setStorage(storage);
		setMaxHp(maxHp);
		setHp(maxHp); // when instance, it has full HP
		setSpeedX(speedX);
		setSpeedY(speedY);
		setBodyDamage(bodyDamage);
		setScore(0);
		bulletManager = new BulletManager(this);
	}

	// Addition Method
	public void move() {
		if (Controller.isMoveUp() && positionY > 0) {
			moveUp();
		}
		if (Controller.isMoveDown() && positionY + getHeight() < GameStartScene.GAMELAYER_HEIGHT) {
			moveDown();
		}
		if (Controller.isMoveLeft() && positionX > 0) {
			moveLeft();
		}
		if (Controller.isMoveRight() && positionX + getWidth() < GameStartScene.GAMELAYER_WIDTH) {
			moveRight();
		}
	}
	
	public void shoot() {
		bulletManager.addBullet();
	}

	public void laser() {
		bulletManager.addLaserBullet();
	}

	public void bomb() {
		bulletManager.addBombBullet();
	}

	public void addScore(int score) {
		setScore(score + getScore());
	}

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
	
	public void updatePointShoot() {
		if (Controller.isShooting() && !Controller.isPointDelay()) {
			Thread t = new Thread() {
				public void run() {
					shoot();
					AudioManager.playSFX(ResourceManager.readAudioClip("gunsound.wav"), 0.3);
					Controller.setPointDelay(true);
					try {
						Thread.sleep(PointBullet.POINT_DELAYTIME);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					Controller.setPointDelay(false);
				}
			};
			t.start();
		}
	}
	
	public void updateLaserShoot() {
		if (Controller.isShootingLaser() && getStorage().hasLaserBullet() && !Controller.isLaserDelay()) {
			Thread t = new Thread() {
				public void run() {
					laser();
					AudioManager.playSFX(ResourceManager.readAudioClip("lasersound.wav"), 0.3);
					getStorage().consumeLaserBullet();
					Controller.setLaserDelay(true);
					try {
						Thread.sleep(LaserBullet.LASER_DELAYTIME);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					Controller.setLaserDelay(false);
				}
			};
			t.start();
		}
	}
	
	public void updateBombShoot() {
		if (Controller.isShootingBomb() && getStorage().hasBombBullet() && !Controller.isBombDelay()) {
			Thread t = new Thread() {
				public void run() {
					bomb();
					AudioManager.playSFX(ResourceManager.readAudioClip("bombsound.wav"), 0.3);
					getStorage().consumeBombBullet();
					Controller.setBombDelay(true);
					try {
						Thread.sleep(BombBullet.BOMB_DELAYTIME);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					Controller.setBombDelay(false);
				}
			};
			t.start();
		}
	}
	// Interface Method
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
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
	
	public void update(GraphicsContext gc) {
		// TODO Auto-generated method stub
		move();
		updatePointShoot();
		updateLaserShoot();
		updateBombShoot();
		bulletManager.update(gc, height);
		render(gc);
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
	}

	public void hit(Entity entity) {
		// TODO Auto-generated method stub
		decreaseHp(entity.getDamage());
	}

	

	// Getter & Setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public double getSpeedX() {
		return speedX;
	}

	public void setSpeedX(double typeASpeedx) {
		this.speedX = typeASpeedx;
	}

	public double getSpeedY() {
		return speedY;
	}

	public void setSpeedY(double typeASpeedy) {
		this.speedY = typeASpeedy;
	}


	public int getBodyDamage() {
		return bodyDamage;
	}

	public void setBodyDamage(int bodyDamage) {
		this.bodyDamage = bodyDamage;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public BulletManager getBulletManager() {
		return bulletManager;
	}
	
}
