package gui;

import application.Main;
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
		//vb.getChildren().addAll(TitleButton);

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

		Scene titleScene = new Scene(root, 800, 600);
		return titleScene;

	}
}
