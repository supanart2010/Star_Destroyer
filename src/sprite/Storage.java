package sprite;

public class Storage {
	private int bombCapacity;
	private int laserCapacity;
	private int bombRemain;
	private int laserRemain;

	// Constructor
	public Storage(int bombCapacity, int laserCapacity) {
		setBombCapacity(bombCapacity);
		setBombRemain(bombCapacity);
		setLaserCapacity(laserCapacity);
		setLaserRemain(laserCapacity);
	}

	// Addition Method
	public boolean hasBombBullet() {
		return bombRemain > 0;
	}

	public void consumeBombBullet() {
		bombRemain--;
	}

	public boolean hasLaserBullet() {
		return laserRemain > 0;
	}

	public void consumeLaserBullet() {
		laserRemain--;
	}

	// Getter & Setter
	public int getBombCapacity() {
		return bombCapacity;
	}

	public void setBombCapacity(int bombCapacity) {
		this.bombCapacity = bombCapacity;
	}

	public int getLaserCapacity() {
		return laserCapacity;
	}

	public void setLaserCapacity(int laserCapacity) {
		this.laserCapacity = laserCapacity;
	}

	public int getBombRemain() {
		return bombRemain;
	}

	public void setBombRemain(int bombRemain) {
		this.bombRemain = bombRemain;
	}

	public int getLaserRemain() {
		return laserRemain;
	}

	public void setLaserRemain(int laserRemain) {
		this.laserRemain = laserRemain;
	}
}
