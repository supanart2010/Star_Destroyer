package entity;

import java.util.Random;

import application.ResourceManager;

public class Minion extends Entity{
	private static final String MINION_NAME = "Invader";
	private static final int MINION_MAXHP = 20;
	private static final double MINION_SPEEDX_RANGE = 3;
	private static final double MINION_SPEEDY_RANGE = 3;
	private static final int MINION_DAMAGE = 10;
	private int type;
	
	//Constructor
	public Minion() {
		super(MINION_NAME,MINION_MAXHP,0,0);
		randomType();
		setSpeedX(randomMinionSpeedX());
		setSpeedY(randomMinionSpeedY());
		this.setImage(ResourceManager.gameStart.MINION);
		this.setSize(100, 100);
	}

	public int getDamage() {
		return MINION_DAMAGE;
	}
	
	private void randomType() {
		type = new Random().nextInt(3)+1;
	}
	
	private double randomMinionSpeedX() {
		return new Random().nextDouble()*MINION_SPEEDX_RANGE+1;
	}
	
	private double randomMinionSpeedY() {
		return new Random().nextDouble()*MINION_SPEEDY_RANGE+1;
	}
	
	public int getType() {
		return type;
	}
}
