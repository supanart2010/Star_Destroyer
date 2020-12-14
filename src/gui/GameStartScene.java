package gui;

import application.Controller;
import application.ResourceManager;
import application.SceneSetupManager;
import entity.Minion;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import logic.MinionManager;
import rocket.Rocket;
import rocket.RocketTypeA;
import rocket.RocketTypeB;

public class GameStartScene {
	private static Rocket rocketA;
	private static Rocket rocketB;
	private static Rocket choosedRocket;
	private static Canvas gameLayer;
	static boolean spacetrig = false;
	// border of window
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;

	private static boolean isRocketA = false;
	private static boolean isRocketB = false;

	public static Scene getGameStartScene() {

		// set background image
		Image bg_path = ResourceManager.readImg("default_bg.png");
		Background bg = new Background(
				new BackgroundImage(bg_path, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.DEFAULT, new BackgroundSize(800, 600, false, false, false, false)));

		// draw canvas
		gameLayer = new Canvas(800, 600);
		GraphicsContext gc = gameLayer.getGraphicsContext2D();

		// root
		StackPane root = new StackPane();

		// addAll object
		root.getChildren().addAll(gameLayer);
		root.setBackground(bg);

		// select rocket
		// if else rocket type
		rocketA = new RocketTypeA();
		rocketA.setImage(ResourceManager.readImg("rocketA.png"));
		rocketA.setWidth(100);
		rocketA.setHeight(100);
		rocketA.setPositionX(250 - rocketA.getWidth());
		rocketA.setPositionY(500);
		rocketA.render(gc,100,100);

		rocketB = new RocketTypeB();
		rocketB.setImage(ResourceManager.readImg("rocketB.png"));
		rocketB.setWidth(100);
		rocketB.setHeight(100);
		rocketB.setPositionX(250 - rocketB.getWidth());
		rocketB.setPositionY(500);
		rocketB.render(gc,100,100);

		MinionManager minionManager = new MinionManager();

		// Thread for animation timer
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				// create Override new method for update because it has long line
				gc.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
				rocketA.update(WINDOW_WIDTH, WINDOW_HEIGHT, gc);
				rocketA.render(gc,100,100);
				minionManager.update(rocketA.getBulletManager(),gc,WINDOW_WIDTH,WINDOW_HEIGHT,rocketA);
				
			}
		};
		timer.start();

		Scene gameStartedScene = new Scene(root, 800, 600);

		SceneSetupManager.setSceneControlable(gameStartedScene);

		return gameStartedScene;

	}

	public static boolean isSpacetrig() {
		return spacetrig;
	}
}
