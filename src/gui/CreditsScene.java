package gui;

import application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.AudioManager;
import logic.ResourceManager;
import logic.SceneManager.State;

public class CreditsScene extends GameScene {
	private Button titleButton;
	private HBox creditsPane;

	public CreditsScene() {
		super();
		this.sceneState = State.CREDITS;
		setGameBackground(ResourceManager.credits.CREDITS_BACKGROUND);
		titleButton = new Button("Go back");
		titleButton.setFont(new Font("Times New Roman",30));
		titleButton.setBackground(null);
		titleButton.setTextFill(Color.WHITE);
		titleButton.setPadding(new Insets(5));

		creditsPane = new HBox();
		creditsPane.getChildren().add(titleButton);
		creditsPane.setAlignment(Pos.BOTTOM_LEFT);
		creditsPane.setSpacing(10);
		creditsPane.setPadding(new Insets(30));
		
		addListener();

		root.getChildren().addAll(creditsPane);

		AudioManager.playBGM(ResourceManager.bgm.TITLE, 0.5, true);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		// handle
		titleButton.setOnMouseClicked(e -> {
			changeScene(State.TITLE);
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
		ResourceManager.clearResources(State.CREDITS);
	}

	public void update() {

	}
}
