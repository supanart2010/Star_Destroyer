package application;

import gui.CreditsScene;
import gui.GameScene;
import gui.GameStartScene;
import gui.HowToScene;
import gui.LosingScene;
import gui.SelectRocketScene;
import gui.TitleScene;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class SceneManager {

	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;

	public static enum State {
		TITLE, SELECTROCKET, PLAYING, // GameplayScene
		TUTORIAL, CREDITS, LOSING
	}

	private static Stage window;
	private static GameScene currentScene; // Can also check whether the scene is ready for .update()
	private static State sceneState;

	public static void init(Stage stage, State sceneState) {
		SceneManager.window = stage;
		ResourceManager.loadAllSharedResources();
		SceneManager.sceneState = sceneState;
		setCurrentSceneFromSceneState(sceneState);
		SceneManager.window.setScene(currentScene);
	}

	public static Scene getCurrentScene() {
		return currentScene;
	}

	public static State getSceneState() {
		return sceneState;
	}

	public static void changeSceneState(State sceneState) {
//		if (window == null) {
//			//throw new SceneChangingException("At SceneManager, window is null");
//		}
		SceneManager.sceneState = sceneState;
		setCurrentSceneFromSceneState(sceneState);
		window.setScene(currentScene);
		window.show();
	}

	private static void setCurrentSceneFromSceneState(State sceneState) {
		GameScene scene = null;
		currentScene = null; // Preventing other thread to access .update() while changing scene
		switch (sceneState) {

		case TITLE:
			ResourceManager.loadResources(State.TITLE);
			scene = new TitleScene();
			break;
		case SELECTROCKET:
			ResourceManager.loadResources(State.SELECTROCKET);
			scene = new SelectRocketScene();
			break;
		case PLAYING:
			ResourceManager.loadResources(State.PLAYING);
			scene = new GameStartScene();
			break;
		case TUTORIAL:
			ResourceManager.loadResources(State.TUTORIAL);
			scene = new HowToScene();
			break;
		case CREDITS:
			ResourceManager.loadResources(State.CREDITS);
			scene = new CreditsScene();
			break;
//		case WINNING:
//			// ResourceManager.loadResources(State.WINNING);
//			scene = new WinningScene();
//			break;
		case LOSING:
			ResourceManager.loadResources(State.LOSING);
			scene = new LosingScene();
			break;
		default:
		}
		currentScene = scene;
	}

	public static void update() {
		if (currentScene != null) {
			currentScene.update();
		}
	}
}