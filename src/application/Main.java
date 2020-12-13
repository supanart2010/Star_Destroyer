package application;

import gui.CreditsScene;
import gui.GameStartScene;
import gui.HowToScene;
import gui.SelectRocketScene;
import gui.TitleScene;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	private static Scene titleScene;
	private static Scene gameStartScene;
	private static Scene howToScene;
	private static Scene creditsScene;
	public static Stage window = new Stage();
	private static Scene selectRocketScene;
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub

		setUpScene();
		window.setScene(titleScene);
		window.setTitle("Star Destroyer");
		window.setResizable(false);
		window.show();

		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	public static void setUpScene() {
		titleScene = TitleScene.getTitleScene();
		gameStartScene = GameStartScene.getGameStartScene();
		selectRocketScene = SelectRocketScene.getSelectRocketScene();
		howToScene = HowToScene.getHowToScene();
		creditsScene = CreditsScene.getCreditsScene();
	}
	public static void titleHandle(Stage window) {
		window.setScene(titleScene);
	}
	public static void creditsHandle(Stage window) {
		window.setScene(creditsScene);
	}
	public static void howToHandle(Stage window) {
		window.setScene(howToScene);
	}
	public static void gameStartHandle(Stage window) {
		window.setScene(gameStartScene);
	}
	public static void selectRocketHandle(Stage window) {
		window.setScene(selectRocketScene);
	}
	
}
