package application;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.stage.Stage;
import logic.SceneManager;

public class Main extends Application {

	@Override
	public void init() {

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		SceneManager.init(primaryStage, SceneManager.State.TITLE);

		primaryStage.setTitle("Star Destroyer");
		primaryStage.setResizable(false);
		primaryStage.show();

		AnimationTimer timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				SceneManager.update();
			}
		};
		timer.start();
	}

	@Override
	public void stop() {

	}

	public static void main(String[] args) {
		launch();
	}
}
