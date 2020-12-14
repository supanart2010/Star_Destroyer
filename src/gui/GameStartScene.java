package gui;

import application.Controller;
import application.ResourceManager;
import application.SceneSetupManager;
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

public class GameStartScene {
	private static Rocket rocket;
	//border of window
	//public static final int WIDTH = 800;
	//public static final int HEIGHT = 600;

	public static Scene getGameStartScene() {
		//VAR for Rocket type

		// set background image
		Image bg_path = ResourceManager.readImg("default_bg.png");
		Background bg = new Background(
				new BackgroundImage(bg_path, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.DEFAULT, new BackgroundSize(800, 600, false, false, false, false)));

		// draw canvas
		Canvas canvas = new Canvas(800, 600);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		// root
		StackPane root = new StackPane();

		// container for object
		// VBox vb = new VBox();
		// vb.getChildren().add(bg)

		// addAll object
		root.getChildren().addAll(canvas);
		root.setBackground(bg);

		rocket = new RocketTypeA();
		
		rocket.setImage(ResourceManager.readImg("rocketA.png"));
		rocket.setWidth(1);
		rocket.setHeight(1);
		rocket.setPositionX(250);
		rocket.setPositionY(300 - rocket.getHeight());
		rocket.render(gc);
		// Thread for animation timer
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
				//create Override new method for update because it has long line
				gc.clearRect(0, 0, 800, 600);
				rocket.update();
				rocket.render(gc);
			}
		};
		timer.start();

		Scene gameStartedScene = new Scene(root, 800, 600);
		SceneSetupManager.setSceneControlable(gameStartedScene);
		return gameStartedScene;

	}
}
