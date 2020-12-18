package sprite;

import application.AudioManager;
import application.Controller;
import application.ResourceManager;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import logic.BulletManager;

public class Rocket extends Sprite implements Hittable, Moveable, Updatable {
	private String name;
	private int type;
	private Storage storage;
	private int maxHp;
	private int hp;
	private double speedX;
	private double speedY;
	private BulletManager bulletManager;
	private int bodyDamage;
	private int score;

	// Constructor
	public Rocket(String name, int type, Storage storage, int maxHp, double typeASpeedx, double typeASpeedy, int bodyDamage) {
		super(0, 0, 0, 0); // edit it later
		setName(name);
		setType(type);
		setStorage(storage);
		setMaxHp(maxHp);
		setHp(maxHp); // when instance, it has full HP
		setSpeedX(typeASpeedx);
		setSpeedY(typeASpeedy);
		setBodyDamage(bodyDamage);
		setScore(0);
		bulletManager = new BulletManager(this);
	}

	// Addition Method
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

	// Interface Method
	// debug update with parameter and unimplement Updatable
	public void update(double width, double height, GraphicsContext gc) {
		// TODO Auto-generated method stub
		if (Controller.isMoveUp() && positionY > 0) {
			moveUp();
		}
		if (Controller.isMoveDown() && positionY + this.getHeight() < height) {
			moveDown();
		}
		if (Controller.isMoveLeft() && positionX > 0) {
			moveLeft();
		}
		if (Controller.isMoveRight() && positionX + this.getWidth() < width - 300) {
			moveRight();
		}
		if (Controller.isShooting() && !Controller.isPointDelay()) {
			Thread t = new Thread() {
				public void run() {
					Platform.runLater(new Runnable() {
						public void run() {
							shoot();
							AudioManager.playSFX(ResourceManager.readAudioClip("gunsound.wav"), 0.3);
							Controller.setPointDelay(true);
						}
					});
					try {
						Thread.sleep(PointBullet.POINT_DELAYTIME);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					Platform.runLater(new Runnable() {
						public void run() {
							Controller.setPointDelay(false);
						}
					});
				}
			};
			t.start();
		}
		if (Controller.isShootingLaser() && getStorage().hasLaserBullet() && !Controller.isLaserDelay()) {
			Thread t = new Thread() {
				public void run() {
					Platform.runLater(new Runnable() {
						public void run() {
							laser();
							AudioManager.playSFX(ResourceManager.readAudioClip("lasersound.wav"), 0.3);
							getStorage().consumeLaserBullet();
							Controller.setLaserDelay(true);
						}
					});
					try {
						Thread.sleep(LaserBullet.LASER_DELAYTIME);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					Platform.runLater(new Runnable() {
						public void run() {
							Controller.setLaserDelay(false);
						}
					});
				}
			};
			t.start();

		}
		if (Controller.isShootingBomb() && getStorage().hasBombBullet() && !Controller.isBombDelay()) {
			Thread t = new Thread() {
				public void run() {
					Platform.runLater(new Runnable() {
						public void run() {
							bomb();
							AudioManager.playSFX(ResourceManager.readAudioClip("bombsound.wav"), 0.3);
							getStorage().consumeBombBullet();
							Controller.setBombDelay(true);
						}
					});
					try {
						Thread.sleep(BombBullet.BOMB_DELAYTIME);
					} catch (InterruptedException ex) {
						ex.printStackTrace();
					}
					Platform.runLater(new Runnable() {
						public void run() {
							Controller.setBombDelay(false);
						}
					});
				}
			};
			t.start();
//			System.out.println(getStorage().getBombRemain());
		}
//		if (Controller.isShootingLaser() && !getStorage().hasLaserBullet()) {
//			System.out.println("out of laser ammo");
//		}
//		if (Controller.isShootingBomb() && !getStorage().hasBombBullet()) {
//			System.out.println("out of bomb ammo");
//		}
		bulletManager.update(gc, height);
		this.render(gc);
	}

	@Override
	public void hit() {
		// TODO Auto-generated method stub
	}

	public void hit(Entity entity) {
		// TODO Auto-generated method stub
		decreaseHp(entity.getDamage());
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

	// Pointbullet
	public void shoot() {
		bulletManager.addBullet();
	}

	// laserbullet
	public void laser() {
		bulletManager.addLaserBullet();
	}

	// bombbullet
	public void bomb() {
		bulletManager.addBombBullet();
	}

	public BulletManager getBulletManager() {
		return bulletManager;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

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

}