package gui;

import application.Controller;
import application.ResourceManager;
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
import rocket.Rocket;
import rocket.RocketTypeA;
import rocket.RocketTypeB;

public class GameStartScene {
	private static Rocket rocketA;
	private static Rocket rocketB;
	private static Rocket choosedRocket;
	private static Canvas gameLayer;
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
		//if else rocket type
		rocketA = new RocketTypeA();
		rocketA.setImage(ResourceManager.readImg("rocketA.png"));
		rocketA.setWidth(100);
		rocketA.setHeight(100);
		rocketA.setPositionX(250 - rocketA.getWidth());
		rocketA.setPositionY(500);
		rocketA.render(gc);

		rocketB = new RocketTypeB();
		rocketB.setImage(ResourceManager.readImg("rocketB.png"));
		rocketB.setWidth(100);
		rocketB.setHeight(100);
		rocketB.setPositionX(250 - rocketB.getWidth());
		rocketB.setPositionY(500);
		rocketB.render(gc);

		if (isRocketA()) {
			choosedRocket = rocketA;
		} else
			choosedRocket = rocketB;
		choosedRocket.render(gc);

		// Thread for animation timer
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				// create Override new method for update because it has long line
				gc.clearRect(0, 0, 800, 600);
				choosedRocket.update(WINDOW_WIDTH, WINDOW_HEIGHT, gc);
				choosedRocket.render(gc);
			}
		};
		timer.start();

		Scene gameStartedScene = new Scene(root, 800, 600);
		gameStartedScene.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case LEFT:
				Controller.setMoveLeft(true);
				System.out.println("isPressedLeft");
				break;
			case RIGHT:
				Controller.setMoveRight(true);
				System.out.println("isPressedRight");
				break;
			case UP:
				Controller.setMoveUp(true);
				System.out.println("isPressedUp");
				break;
			case DOWN:
				Controller.setMoveDown(true);
				System.out.println("isPressedDown");
				break;
			case SPACE:
				Controller.setShooting(true);
				System.out.println("isPressedSpace");
				break;
			case Z:
				Controller.setShootingLaser(true);
				System.out.println("isPressed 'Z' ");
				break;
			case X:
				Controller.setShootingBomb(true);
				System.out.println("isPressed 'X' ");
				break;
			default:
				break;

			}
		});
		gameStartedScene.setOnKeyReleased(e -> {
			switch (e.getCode()) {
			case LEFT:
				Controller.setMoveLeft(false);
				System.out.println("isReleasedLeft");
				break;
			case RIGHT:
				Controller.setMoveRight(false);
				System.out.println("isReleasedRight");
				break;
			case UP:
				Controller.setMoveUp(false);
				System.out.println("isReleasedUp");
				break;
			case DOWN:
				Controller.setMoveDown(false);
				System.out.println("isReleasedDown");
				break;
			case SPACE:
				Controller.setShooting(false);
				System.out.println("isReleasedSpace");
				break;
			case Z:
				Controller.setShootingLaser(false);
				System.out.println("isReleased 'Z' ");
				break;
			case X:
				Controller.setShootingBomb(false);
				System.out.println("isReleased 'X' ");
				break;
			default:
				break;
			}
		});
		return gameStartedScene;

	}

	public static boolean isRocketA() {
		return isRocketA;
	}

	public static void setRocketA(boolean isRocketA) {
		GameStartScene.isRocketA = isRocketA;
	}

	public static boolean isRocketB() {
		return isRocketB;
	}

	public static void setRocketB(boolean isRocketB) {
		GameStartScene.isRocketB = isRocketB;
	}
}
