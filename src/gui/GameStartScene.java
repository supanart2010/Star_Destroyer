package gui;

import application.Controller;
import application.ResourceManager;
import application.SceneSetupManager;
import entity.Minion;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.MinionManager;
import rocket.Rocket;
import rocket.RocketTypeA;
import rocket.RocketTypeB;

public class GameStartScene {
	private static Rocket rocketA;
	private static Rocket rocketB;
	private static Rocket choosedRocket;
	private static Rocket myRocket;
	private static Canvas gameLayer;
	static boolean spacetrig = false;
	// border of window
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;

//	private static boolean isRocketA = false;
//	private static boolean isRocketB = false;

	public static Scene getGameStartScene() {
		// set background image
		Image bg_path = ResourceManager.readImg("default_bg.png");
		Background bg = new Background(
				new BackgroundImage(bg_path, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.DEFAULT, new BackgroundSize(800, 600, false, false, false, false)));

		// draw canvas
		gameLayer = new Canvas(500, 600);
		GraphicsContext gc = gameLayer.getGraphicsContext2D();

		// root
		HBox root = new HBox();

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
		rocketA.render(gc, 100, 100);

		rocketB = new RocketTypeB();
		rocketB.setImage(ResourceManager.readImg("rocketB.png"));
		rocketB.setWidth(100);
		rocketB.setHeight(100);
		rocketB.setPositionX(250 - rocketB.getWidth());
		rocketB.setPositionY(500);
		rocketB.render(gc, 100, 100);

		// Right Field
		VBox rightField = new VBox();
		Text hp = new Text("Health : " + rocketA.getHp());
		hp.setFill(Color.WHITE);
		hp.setFont(new Font(20));

		Text stage = new Text("stage : ");
		stage.setFill(Color.WHITE);
		stage.setFont(new Font(20));

		Text laser = new Text("Laser ammo : " + rocketA.getStorage().getLaserCapacity());
		laser.setFill(Color.WHITE);
		laser.setFont(new Font(20));

		Text bomb = new Text("Bomb ammo : " + rocketA.getStorage().getBombCapacity());
		bomb.setFill(Color.WHITE);
		bomb.setFont(new Font(20));

		Text score = new Text("Score : " + rocketA.getScore());
		score.setFill(Color.WHITE);
		score.setFont(new Font(20));

		rightField.getChildren().addAll(stage, hp, laser, bomb, score);
		root.getChildren().add(rightField);

		MinionManager minionManager = new MinionManager();

		// Thread for animation timer
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				// create Override new method for update because it has long line
				gc.clearRect(0, 0, WINDOW_WIDTH, WINDOW_HEIGHT);
				rocketA.update(WINDOW_WIDTH, WINDOW_HEIGHT, gc);
				minionManager.update(rocketA.getBulletManager(), gc, WINDOW_WIDTH, WINDOW_HEIGHT, rocketA);
				hp.setText("Health : " + rocketA.getHp());
				laser.setText("Laser ammo : " + rocketA.getStorage().getLaserRemain());
				bomb.setText("Bomb ammo : " + rocketA.getStorage().getBombRemain());
				score.setText("Score : " + rocketA.getScore());

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
