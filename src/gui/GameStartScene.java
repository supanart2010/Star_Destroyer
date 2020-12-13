package gui;

import application.AudioManager;
import application.Main;
<<<<<<< Updated upstream
import application.Controller;
||||||| constructed merge base
=======
import application.ResourceManager;
>>>>>>> Stashed changes
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameStartScene {
	private static Button TitleButton;

	public static Scene getGameStartScene() {

		// draw bg image
		Canvas canvas = new Canvas(800, 600);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image imgpath = new Image(ClassLoader.getSystemResource("spacebg.jpg").toString());
		gc.drawImage(imgpath, 0, 0, 800, 600);

		// root
		StackPane root = new StackPane();

		// container for object
		VBox vb = new VBox();
		// vb.getChildren().addAll(TitleButton);

		// addAll object
		root.getChildren().addAll(canvas);

		// thred for animation timer
		AnimationTimer timer = new AnimationTimer() {

			@Override
			public void handle(long arg0) {
				// TODO Auto-generated method stub
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
