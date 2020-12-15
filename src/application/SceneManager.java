package application;

import application.SceneManager.State;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class SceneManager {
	
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	public static enum State {
		MENU,
		LEVELSELECT,
		PLAYING,			// GameplayScene
		TUTORIAL,
		CREDITS,
		WINNING,
		LOSING,
		BLANK				// BlankScene (Testing only)
	}
	private static Stage window;
	private static Scene currentScene;				// Can also check whether the scene is ready for .update()
	private static State sceneState;
	
	public static void init() {
		SceneManager.window = stage;
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
	
	
	
	public static void changeSceneState(State sceneState) throws GameException {
		if (window == null) {
			//throw new SceneChangingException("At SceneManager, window is null");
		}
		SceneManager.sceneState = sceneState;
		setCurrentSceneFromSceneState(sceneState);
		window.setScene(currentScene);
		window.show();
	}
	
	private static void setCurrentSceneFromSceneState(State sceneState) throws GameException {
		GameScene scene;
		currentScene = null;					// Preventing other thread to access .update() while changing scene
		switch (sceneState) {
			case MENU:
				ResourceManager.loadResources(State.MENU);
				scene = new MenuScene();
				break;
			case LEVELSELECT:
				ResourceManager.loadResources(State.LEVELSELECT);
				scene = new LevelSelectScene();
				break;
			case PLAYING:
				ResourceManager.loadResources(State.PLAYING);
				scene = getGameLevel(targetGameLevel);
				break;
			case TUTORIAL:
				ResourceManager.loadResources(State.TUTORIAL);
				scene = new TutorialScene();
				break;
			case CREDITS:
				ResourceManager.loadResources(State.CREDITS);
				scene = new CreditsScene();
				break;
			case WINNING:
				ResourceManager.loadResources(State.WINNING);
				scene = new WinningScene();
				break;
			case LOSING:
				ResourceManager.loadResources(State.LOSING);
				scene = new LosingScene();
				break;
			case BLANK:
			default:
				scene = new BlankScene();
		}
		currentScene = scene;
	}
	
	
	public static void update() {
		if (currentScene != null) {
			currentScene.update();
		}
	}