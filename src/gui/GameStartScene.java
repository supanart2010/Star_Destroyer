package gui;

import application.AudioManager;
import application.Main;

import application.Controller;

import application.ResourceManager;

import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import rocket.Rocket;
import rocket.RocketTypeA;

public class GameStartScene {
	private static Rocket rocket;

	public static Scene getGameStartScene() {
		//VAR for Rocket type

		// set background image
		Image bg_path = ResourceManager.readImg("spacebg.jpg");
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
				gc.clearRect(0, 0, 800, 600);
				rocket.update();
				rocket.render(gc);
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
			default:
				break;
			}
		});
		return gameStartedScene;

	}
}
