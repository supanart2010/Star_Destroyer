package gui;

import application.AudioManager;
import application.Main;
import application.ResourceManager;
import application.SceneManager.State;
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

public class CreditsScene extends GameScene {
	private Button TitleButton;

	public CreditsScene() {
		super();
		setGameBackground(ResourceManager.credits.CREDITS_BACKGROUND);
		TitleButton = new Button("Go back");
		TitleButton.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		TitleButton.setBackground(null);
		TitleButton.setTextFill(Color.WHITE);
		TitleButton.setPadding(new Insets(5));

		addListener();

		HBox hB = new HBox();
		hB.getChildren().add(TitleButton);
		hB.setAlignment(Pos.BOTTOM_LEFT);
		hB.setSpacing(10);
		hB.setPadding(new Insets(30));

		root.getChildren().addAll(hB);

		AudioManager.playBGM(ResourceManager.bgm.TITLE, 0.5, true);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		// handle
		TitleButton.setOnMouseClicked(e -> {
			changeScene(State.TITLE);
		});
		TitleButton.setOnMouseEntered(e -> {
			TitleButton.setTextFill(Color.RED);
		});
		TitleButton.setOnMouseExited(e -> {
			TitleButton.setTextFill(Color.WHITE);
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
