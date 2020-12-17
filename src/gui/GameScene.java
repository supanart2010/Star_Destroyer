package gui;

import application.SceneManager;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public abstract class GameScene extends Scene {
	protected SceneManager.State sceneState;
	protected StackPane root;
	protected Canvas gameLayer;

	public GameScene() {
		super(new StackPane());

		sceneState = null;

		gameLayer = new Canvas(SceneManager.WINDOW_WIDTH, SceneManager.WINDOW_HEIGHT);

		root = (StackPane) this.getRoot();

		root.setPrefSize(SceneManager.WINDOW_WIDTH, SceneManager.WINDOW_HEIGHT);

	}

	protected void setGameBackground(Image image) {
		if (image != null) {
			root.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
		}
	}

	protected abstract void addListener();

	protected abstract void releaseSceneComponents();

	protected void changeScene(SceneManager.State sceneState) {
		releaseSceneComponents();

		SceneManager.changeSceneState(sceneState);
	}

	public void update() {

	}
}
