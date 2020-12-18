package logic;

import java.util.ArrayList;
import java.util.Collections;

import javafx.scene.canvas.GraphicsContext;
import sprite.BombBullet;
import sprite.Bullet;
import sprite.LaserBullet;
import sprite.PointBullet;
import sprite.Rocket;

public class BulletManager {
	private Rocket rocket;
	private ArrayList<Bullet> bullets = new ArrayList<>();

	public BulletManager(Rocket rocket) {
		this.rocket = rocket;
	}

	public void addBullet() {
		Bullet bullet = new PointBullet(this.rocket);
		bullets.add(bullet);
	}

	public void addLaserBullet() {
		Bullet laserBullet = new LaserBullet(this.rocket);
		bullets.add(laserBullet);
	}

	public void addBombBullet() {
		Bullet bombBullet = new BombBullet(this.rocket);
		bullets.add(bombBullet);
	}

	public void update(GraphicsContext gc) {
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
