package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.AudioManager;
import logic.ResourceManager;
import logic.SceneManager.State;

public class TutorialScene extends GameScene {
	private Button titleButton;
	private HBox titlePane;

	public TutorialScene() {
		super();
		this.sceneState = State.TUTORIAL;
		setGameBackground(ResourceManager.tutorial.TUTORIAL_BACKGROUND);

		titleButton = new Button("Go back");
		titleButton.setFont(new Font("Times New Roman",30));
		titleButton.setBackground(null);
		titleButton.setTextFill(Color.WHITE);
		titleButton.setPadding(new Insets(5));

		titlePane = new HBox();
		titlePane.getChildren().add(titleButton);
		titlePane.setAlignment(Pos.BOTTOM_LEFT);
		titlePane.setSpacing(10);
		titlePane.setPadding(new Insets(30));
		
		addListener();

		root.getChildren().addAll(titlePane);

		AudioManager.playBGM(ResourceManager.bgm.TITLE, 0.5, true);
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
