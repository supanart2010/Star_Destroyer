package application;

import gui.CreditsScene;
import gui.GameStartScene;
import gui.HowToScene;
import gui.SelectRocketScene;
import gui.TitleScene;
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
		AudioManager.playBGM(ResourceManager.readMedia("startmenuBGM.mp3"),0.5,true);
		
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
		AudioManager.stopBGM();
		AudioManager.playBGM(ResourceManager.readMedia("startMenuBGM.mp3"),0.5,true);
		
	}
	public static void creditsHandle(Stage window) {
		window.setScene(creditsScene);
		AudioManager.stopBGM();
		
	}
	public static void howToHandle(Stage window) {
		window.setScene(howToScene);
		AudioManager.stopBGM();
	}
	public static void gameStartHandle(Stage window) {
		window.setScene(gameStartScene);
		AudioManager.stopBGM();
		AudioManager.playBGM(ResourceManager.readMedia("gameStartBGM.mp3"),0.5,true);
	}
	public static void selectRocketHandle(Stage window) {
		window.setScene(selectRocketScene);
		AudioManager.stopBGM();
		AudioManager.playBGM(ResourceManager.readMedia("selectRocketBGM.mp3"),0.5,true);
		
	}
	public static Scene getGameStartScene() {
		return gameStartScene;
	}
	
}
