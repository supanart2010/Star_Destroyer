package entity;

public class Boss extends Entity{
	private static final String BOSS_NAME = "Dravrains";
	private static final int BOSS_MAXHP = 20;
	private static final int BOSS_SPEEDX = 10;
	private static final int BOSS_SPEEDY = 5;
	
	//Constructor
	public Boss() {
		super(BOSS_NAME,BOSS_MAXHP,BOSS_SPEEDX,BOSS_SPEEDY);
	}

	@Override
	public int getDamage() {
		// TODO Auto-generated method stub
		return 0;
	}
}
