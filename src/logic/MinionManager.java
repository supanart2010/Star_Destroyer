package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import gui.GameStartScene;
import javafx.scene.canvas.GraphicsContext;
import sprite.BombAnimation;
import sprite.BombBullet;
import sprite.Bullet;
import sprite.Entity;
import sprite.LaserBullet;
import sprite.Minion;
import sprite.Rocket;

public class MinionManager {
	private ArrayList<Entity> minions = new ArrayList<>();
	//private ArrayList<BombAnimation> animations = new ArrayList<BombAnimation>();
	//private List<BombAnimation> animations = Collections.synchronizedList(new ArrayList<BombAnimation>());
	
	public MinionManager() {
		for (int i = 0; i < 3; ++i) {
			addMinion();
		}
	}

	public void addMinion() {
		Minion minion = new Minion();
		minions.add(minion);

	}

	public void update(BulletManager bulletManager, GraphicsContext gc, Rocket rocket) {
		ArrayList<Integer> toRemoveBullets = new ArrayList<>();
		ArrayList<Integer> toRemoveMinions = new ArrayList<>();
		int more = 0;
		for (Entity minion : minions) {
			minion.update();
			minion.render(gc, minion.getWidth(), minion.getHeight());
			if (minion.getPositionY() > GameStartScene.GAMELAYER_HEIGHT) {
				toRemoveMinions.add(minions.indexOf(minion));
			}
			if (minion.intersects(rocket)) {
				minion.hit(rocket);
				rocket.hit(minion);
			}
			for (Bullet bullet : bulletManager.getBullets()) {
				if (minion.intersects(bullet)) {
//					BombAnimation b = new BombAnimation(bullet.getPositionX(), bullet.getPositionY());
//					animations.add(b);
//					Thread t = new Thread(()->{
//						try {
//							Thread.sleep(50);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						animations.remove(animations.indexOf(b));
//					});
//					t.start();
					if (bullet instanceof LaserBullet) {
						minion.hit(bullet);
//						bullet.hit();
					} else if (bullet instanceof BombBullet) {
						minion.hit(bullet);
						bullet.hit();
					} else {
						minion.hit(bullet);
						bullet.hit();
					}

					// explosion effect
//					BombAnimation b = new BombAnimation(minion.getPositionX(),minion.getPositionY());
//					b.update();
//					b.render(gc, b.getWidth()+10, b.getHeight()+10);
				}
				if (bullet.isConsumed()) {
					toRemoveBullets.add(bulletManager.getBullets().indexOf(bullet));
				}
			}
			if (minion.isDead()) {
				minion.looted(rocket);
				toRemoveMinions.add(minions.indexOf(minion));
			}
		}
//		for (BombAnimation b : animations) {
//			b.update(gc);
//		}
		HashSet<Integer> b = new HashSet<>(toRemoveBullets);
		HashSet<Integer> m = new HashSet<>(toRemoveMinions);
		toRemoveBullets.clear();
		toRemoveBullets.addAll(b);
		toRemoveBullets.sort(Collections.reverseOrder());
		toRemoveMinions.clear();
		toRemoveMinions.addAll(m);
		toRemoveMinions.sort(Collections.reverseOrder());
		for (int i : toRemoveBullets) {
			bulletManager.getBullets().remove(i);
		}
		for (int i : toRemoveMinions) {
			minions.remove(i);
			more++;
		}
		for (int i = 0; i < more; i++) {
			addMinion();
		}

	}

	public void clear() {
		minions.clear();
	}
}
