package gui;

import application.AudioManager;
import application.Main;
import application.ResourceManager;
import application.SceneManager.State;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class HowToScene extends GameScene {
	private static Label HowToTitle;
	private Button titleButton;

	public HowToScene() {
		super();
		this.sceneState = State.TUTORIAL;
		setGameBackground(ResourceManager.tutorial.TUTORIAL_BACKGROUND);

		titleButton = new Button("Go back");
		titleButton.setFont(new Font(30));
		titleButton.setPadding(new Insets(5));
		titleButton.setTextFill(Color.WHITE);
		titleButton.setBackground(null);

		VBox vb = new VBox();
		vb.getChildren().addAll(titleButton);
		vb.setAlignment(Pos.BOTTOM_LEFT);

		root.getChildren().addAll(vb);

		addListener();

		AudioManager.playBGM(ResourceManager.readMedia("startMenuBGM.mp3"), 0.5, true);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		titleButton.setOnMouseClicked(e -> {
			changeScene(State.TITLE);
			;
		});
		titleButton.setOnMouseEntered(e -> {
			titleButton.setTextFill(Color.RED);
		});
		titleButton.setOnMouseExited(e -> {
			titleButton.setTextFill(Color.WHITE);
		});
	}

	@Override
	protected void releaseSceneComponents() {
		// TODO Auto-generated method stub
		ResourceManager.clearResources(State.TUTORIAL);
	}

	public void update() {

	}
}
