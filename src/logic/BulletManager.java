package logic;

import java.util.ArrayList;
import java.util.Collections;

import application.ResourceManager;
import bullets.BombBullet;
import bullets.Bullet;
import bullets.LaserBullet;
import bullets.PointBullet;
import javafx.scene.canvas.GraphicsContext;
import rocket.Rocket;

public class BulletManager {
	// class for contain bullets
	private Rocket rocket;
	private static ArrayList<Bullet> bullets = new ArrayList<>();

	public BulletManager(Rocket rocket) {
		this.rocket = rocket;
	}

	public void addBullet() {
		Bullet bullet = new PointBullet(this.rocket);
		bullet.setImage(ResourceManager.readImg("pointbullettest.png"));
		bullet.setSize(10, 10);
		bullet.setPositionX(rocket.positionX + 40);
		bullet.setPositionY(rocket.positionY);
		bullets.add(bullet);
	}

	public void addLaserBullet() {
		Bullet laserBullet = new LaserBullet(this.rocket);
		laserBullet.setImage(ResourceManager.readImg("lasercontinue.png"));
		laserBullet.setSize(10, 10);
		laserBullet.setPosition(rocket.positionX + 40, rocket.positionY-30);
		bullets.add(laserBullet);
	}

	public void addBombBullet() {
		Bullet bombBullet = new BombBullet(this.rocket);
		bombBullet.setImage(ResourceManager.readImg("bombbullet.png"));
		bombBullet.setSize(10, 10);
		bombBullet.setPosition(rocket.positionX+40, rocket.positionY);
		bullets.add(bombBullet);
	}

	public void update(GraphicsContext gc, double height) {
		ArrayList<Integer> toRemove = new ArrayList<>();
		for (Bullet b : bullets) {
			if (b.getPositionX() < 0) {
				toRemove.add(bullets.indexOf(b));
			} else {
				b.update();
				b.render(gc);
			}
		}
		toRemove.sort(Collections.reverseOrder());
		for (int i : toRemove) {
			bullets.remove(i);
		}
	}

	public void clear() {
		bullets.clear();
	}

	public ArrayList<Bullet> getBullets() {
		return bullets;
	}
}
