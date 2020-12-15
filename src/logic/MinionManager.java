package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import application.AudioManager;
import application.ResourceManager;
import bullets.Bullet;
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
				rocket.setHp(rocket.getHp() - minion.getDamage());
				toRemoveMinions.add(minions.indexOf(minion));
				System.out.println(rocket.getHp());
			}
			for (Bullet bullet : bulletManager.getBullets()) {
				if (minion.intersects(bullet)) {
					
					toRemoveMinions.add(minions.indexOf(minion));
					toRemoveBullets.add(bulletManager.getBullets().indexOf(bullet));
					//explosion effect
					Bomb b = new Bomb(minion.getPositionX(),minion.getPositionY());
					b.update();
					b.render(gc,b.getWidth(),b.getHeight());
				}
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
