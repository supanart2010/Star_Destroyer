package sprite;

import gui.GameStartScene;
import logic.ResourceManager;

public class RocketTypeB extends Rocket {
	private static final String TYPE_B_NAME = "Tank";
	private static final int TYPE_B_BOMBCAP = 10;
	private static final int TYPE_B_LASERCAP = 15;
	private static final Storage TYPE_B_STORAGE = new Storage(TYPE_B_BOMBCAP, TYPE_B_LASERCAP);
	private static final int TYPE_B_MAXHP = 350;
	private static final double TYPE_B_SPEEDX = 4;
	private static final double TYPE_B_SPEEDY = 4;
	private static final int TYPE_A_BODYDAMAGE = 30;

	public RocketTypeB() {
		super(TYPE_B_NAME, TYPE_B_STORAGE, TYPE_B_MAXHP, TYPE_B_SPEEDX, TYPE_B_SPEEDY, TYPE_A_BODYDAMAGE);
		this.setImage(ResourceManager.gameStart.ROCKETB);
		this.setWidth(ROCKET_WIDTH);
		this.setHeight(ROCKET_HEIGHT);
		this.setPositionX(GameStartScene.GAMELAYER_WIDTH/2 - this.getWidth());
		this.setPositionY(GameStartScene.GAMELAYER_HEIGHT - this.getHeight());
	}
}
