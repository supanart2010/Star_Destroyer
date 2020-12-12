package rocket;

public class RocketTypeA extends Rocket {
	private static final String TYPE_A_NAME = "Hawk";
	private static final int TYPE_A = 1;
	private static final int TYPE_A_BOMBCAP = 5;
	private static final int TYPE_A_LASERCAP = 10;
	private static final Storage TYPE_A_STORAGE = new Storage(TYPE_A_BOMBCAP, TYPE_A_LASERCAP);
	private static final int TYPE_A_MAXHP = 250;
	private static final int TYPE_A_SPEEDX = 10;
	private static final int TYPE_A_SPEEDY = 10;

	public RocketTypeA() {
		// TODO Auto-generated constructor stub
		super(TYPE_A_NAME, TYPE_A, TYPE_A_STORAGE, TYPE_A_MAXHP, TYPE_A_SPEEDX, TYPE_A_SPEEDY);
	}
}
