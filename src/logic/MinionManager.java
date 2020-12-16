package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import application.AudioManager;
import application.ResourceManager;
import bullets.BombBullet;
import bullets.Bullet;
import bullets.LaserBullet;
import entity.Entity;
import entity.Minion;
import gui.Bomb;
import javafx.scene.canvas.GraphicsContext;
import rocket.Rocket;

public class MinionManager {
	private static ArrayList<Entity> minions = new ArrayList<>();

	public MinionManager() {
		for (int i = 0; i < 1; ++i) {
			addMinion();
		}
	}

	public void addMinion() {
		Entity minion = new Minion();
		minion.setImage(ResourceManager.readImg("alien_green.png"));
		minion.setSize(100, 100);
		minions.add(minion);

	}

	public void update(BulletManager bulletManager, GraphicsContext gc, double width, double height, Rocket rocket) {
		ArrayList<Integer> toRemoveBullets = new ArrayList<>();
		ArrayList<Integer> toRemoveMinions = new ArrayList<>();
		for (Entity minion : minions) {
			minion.update();
			minion.render(gc,minion.getWidth(), minion.getHeight());
		}
		int more = 0;
		for (Entity minion : minions) {
			minion.update();
			minion.render(gc,minion.getWidth(), minion.getHeight());
			if (minion.positionY > height) {
				toRemoveMinions.add(minions.indexOf(minion));
			}
//            if (minion.positionX > width || minion.positionX < 0){
//                toRemoveMinions.add(minions.indexOf(minion));
//            }
			if (minion.intersects(rocket)) {
//				rocket.setHp(rocket.getHp() - minion.getDamage());
//				toRemoveMinions.add(minions.indexOf(minion));
//				System.out.println(rocket.getHp());
				minion.hit(rocket);
				rocket.hit(minion);
			}
			for (Bullet bullet : bulletManager.getBullets()) {
				if (minion.intersects(bullet)) {
					if (bullet instanceof LaserBullet) {
						System.out.println("laser");
						minion.hit(bullet);
					}else if (bullet instanceof BombBullet) {
						System.out.println("bomb");
						minion.hit(bullet);
						bullet.hit();
					}else {
						System.out.println("point");
						minion.hit(bullet);
						bullet.hit();
					}
					
					//explosion effect
//					Bomb b = new Bomb(minion.getPositionX(),minion.getPositionY());
//					b.update();
//					b.render(gc,b.getWidth()+10,b.getHeight()+10);
				}
				if(bullet.isConsumed()) {
					toRemoveBullets.add(bulletManager.getBullets().indexOf(bullet));
				}
			}
			if(minion.isDead()) {
				toRemoveMinions.add(minions.indexOf(minion));
			}
		}
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
