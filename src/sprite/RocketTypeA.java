package sprite;

import gui.GameStartScene;
import logic.ResourceManager;

public class RocketTypeA extends Rocket {
	private static final String TYPE_A_NAME = "Hawk";
	private static final int TYPE_A_BOMBCAP = 5;
	private static final int TYPE_A_LASERCAP = 10;
	private static final Storage TYPE_A_STORAGE = new Storage(TYPE_A_BOMBCAP, TYPE_A_LASERCAP);
	private static final int TYPE_A_MAXHP = 250;
	private static final double TYPE_A_SPEEDX = 6;
	private static final double TYPE_A_SPEEDY = 6;
	private static final int TYPE_A_BODYDAMAGE = 20;

	public RocketTypeA() {
		super(TYPE_A_NAME, TYPE_A_STORAGE, TYPE_A_MAXHP, TYPE_A_SPEEDX, TYPE_A_SPEEDY, TYPE_A_BODYDAMAGE);
		this.setImage(ResourceManager.gameStart.ROCKETA);
		this.setWidth(ROCKET_WIDTH);
		this.setHeight(ROCKET_HEIGHT);
		this.setPositionX(GameStartScene.GAMELAYER_WIDTH/2 - this.getWidth());
		this.setPositionY(GameStartScene.GAMELAYER_HEIGHT - this.getHeight());
	}
}
