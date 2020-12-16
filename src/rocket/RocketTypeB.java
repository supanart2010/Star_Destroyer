package rocket;

public class RocketTypeB extends Rocket {
	private static final String TYPE_B_NAME = "Tank";
	private static final int TYPE_B = 2;
	private static final int TYPE_B_BOMBCAP = 10;
	private static final int TYPE_B_LASERCAP = 15;
	private static final Storage TYPE_B_STORAGE = new Storage(TYPE_B_BOMBCAP, TYPE_B_LASERCAP);
	private static final int TYPE_B_MAXHP = 350;
	private static final int TYPE_B_SPEEDX = 7;
	private static final int TYPE_B_SPEEDY = 7;
	private static final int TYPE_A_BODYDAMAGE = 30;

	public RocketTypeB() {
		super(TYPE_B_NAME, TYPE_B, TYPE_B_STORAGE, TYPE_B_MAXHP, TYPE_B_SPEEDX, TYPE_B_SPEEDY, TYPE_A_BODYDAMAGE);
	}
}
