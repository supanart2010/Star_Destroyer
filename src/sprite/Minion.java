package sprite;

import java.util.Random;

import logic.ResourceManager;
import logic.SceneManager;

public class Minion extends Entity {
	private static final int MINION_MAXHP = 20;
	private static final double MINION_SPEEDX_RANGE = 3;
	private static final double MINION_SPEEDY_RANGE = 3;
	private static final int MINION_DAMAGE = 10;
	private int type;

	// Constructor
	public Minion() {
		super(0);
		randomType();
		setMaxHp(MINION_MAXHP);
		setHp(MINION_MAXHP);
		setSpeedX(randomMinionSpeedX());
		setSpeedY(randomMinionSpeedY());
		if (this.getType() == 1) {
			this.setImage(ResourceManager.gameStart.GREENMINION);
		} else if (this.getType() == 2) {
			this.setImage(ResourceManager.gameStart.YELLOWMINION);
		} else {
			this.setImage(ResourceManager.gameStart.REDMINION);
		}
		this.setSize(100, 100);
		setPositionX(randomPositionX());
	}

	public int getDamage() {
		return MINION_DAMAGE;
	}
	private double randomPositionX() {
		double min = 1;
		double max = SceneManager.WINDOW_WIDTH-400;
		Random r = new Random();
		return min + (max - min) * r.nextDouble();
	}

	private void randomType() {
		type = new Random().nextInt(3) + 1;
	}

	private double randomMinionSpeedX() {
		return new Random().nextDouble() * MINION_SPEEDX_RANGE + 1;
	}

	private double randomMinionSpeedY() {
		return new Random().nextDouble() * MINION_SPEEDY_RANGE + 1;
	}

	public int getType() {
		return type;
	}
}
