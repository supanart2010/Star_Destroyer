package logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import application.ResourceManager;
import bullets.Bullet;
import entity.Entity;
import entity.Minion;
import javafx.scene.canvas.GraphicsContext;
import rocket.Rocket;

public class MinionManager {
	private static ArrayList<Entity> minions = new ArrayList<>();

	public MinionManager() {
		for (int i = 0; i <5; ++i) {
			addMinion();
		}
	}

	public void addMinion() {
		Entity minion = new Minion();
		minion.setImage(ResourceManager.readImg("alien_green.png"));
		minion.setSize(50, 50);
		minions.add(minion);
		
	}

	public void update(BulletManager bulletManager, GraphicsContext gc, double width, double height, Rocket rocket) {
		ArrayList<Integer> toRemoveBullets = new ArrayList<>();
        ArrayList<Integer> toRemoveMeteors = new ArrayList<>();
        for (Entity minion: minions) {
        	minion.update();
        	minion.render(gc,50,50);
        }
        int more = 0;
        for (Entity minion: minions){
            minion.update();
            minion.render(gc,50,50);
            if (minion.positionY > height){
                toRemoveMeteors.add(minions.indexOf(minion));
            }
            if (minion.positionX > width || minion.positionX < 0){
                toRemoveMeteors.add(minions.indexOf(minion));
            }
            if (minion.intersects(rocket)){
                rocket.setHp(rocket.getHp()- minion.getDamage());
                toRemoveMeteors.add(minions.indexOf(minion));
                System.out.println(rocket.getHp());
            }
            for (Bullet bullet : bulletManager.getBullets()){
                if (minion.intersects(bullet)){
                    toRemoveMeteors.add(minions.indexOf(minion));
                    toRemoveBullets.add(bulletManager.getBullets().indexOf(bullet));
                }
            }
        }
        HashSet<Integer> b = new HashSet<>(toRemoveBullets);
        HashSet<Integer> m = new HashSet<>(toRemoveMeteors);
        toRemoveBullets.clear();
        toRemoveBullets.addAll(b);
        toRemoveBullets.sort(Collections.reverseOrder());
        toRemoveMeteors.clear();
        toRemoveMeteors.addAll(m);
        toRemoveMeteors.sort(Collections.reverseOrder());
        for (int i : toRemoveBullets){
            bulletManager.getBullets().remove(i);
        }
        for(int i: toRemoveMeteors){
            minions.remove(i);
            more++;
        }
        for (int i = 0;i<more;i++){
            addMinion();
        }
        
	}

	
	public void clear() {
		minions.clear();
	}
}

