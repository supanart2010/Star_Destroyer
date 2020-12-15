package entity;

import java.util.Random;

public class Minion extends Entity{
	private static final String MINION_NAME = "Invader";
	private static final int MINION_MAXHP = 20;
	private static final int MINION_SPEEDX_RANGE = 10;
	private static final int MINION_SPEEDY_RANGE = 5;
	private static final int MINION_DAMAGE = 10;
	public int getDamage() {
		return MINION_DAMAGE;
	}

	private int type; //use when load res (InvaderColor)
//	MINION_TYPE = new Random().nextInt(3) + 1;
//	
	
	//Constructor
	public Minion() {
		super(MINION_NAME,MINION_MAXHP,0,0);
		randomType();
		setSpeedX(randomMinionSpeedX());
		setSpeedY(randomMinionSpeedY());
	}

	private void randomType() {
		type = new Random().nextInt(3)+1;
	}
	
	private int randomMinionSpeedX() {
		return new Random().nextInt(MINION_SPEEDX_RANGE)+3;
	}
	
	private int randomMinionSpeedY() {
		return new Random().nextInt(MINION_SPEEDY_RANGE)+0;
	}
	
	public int getType() {
		return type;
	}
}
