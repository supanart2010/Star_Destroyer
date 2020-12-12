package entity;

public class MiniBoss extends Entity{
	private static final String MINIBOSS_NAME = "Gheinzet";
	private static final int MINIBOSS_MAXHP = 20;
	private static final int MINIBOSS_SPEEDX = 10;
	private static final int MINIBOSS_SPEEDY = 5;
	
	//Constructor
	public MiniBoss() {
		super(MINIBOSS_NAME,MINIBOSS_MAXHP,MINIBOSS_SPEEDX,MINIBOSS_SPEEDY);
	}
}
