package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.AudioManager;
import logic.ResourceManager;
import logic.SceneManager.State;

public class TitleScene extends GameScene {
	private Label nameText;
	private Button startGameButton;
	private Button tutorialButton;
	private Button creditsButton;
	private VBox titlePane;

	public TitleScene() {
		super();
		this.sceneState = State.TITLE;
		setGameBackground(ResourceManager.title.TITLE_BACKGROUND);
		
		startGameButton = new Button("Start");
		startGameButton.setFont(new Font("Times New Roman", 50));
		startGameButton.setBackground(null);
		startGameButton.setTextFill(Color.WHITE);
		startGameButton.setPadding(new Insets(5));

		nameText = new Label("STAR DESTROYER");
		nameText.setTextFill(Color.WHITE);
		nameText.setFont(new Font("Times New Roman", 60));

		tutorialButton = new Button("Tutorial");
		tutorialButton.setFont(new Font("Times New Roman", 50));
		tutorialButton.setBackground(null);
		tutorialButton.setTextFill(Color.WHITE);
		tutorialButton.setPadding(new Insets(5));

		creditsButton = new Button("Credits");
		creditsButton.setFont(new Font("Times New Roman", 50));
		creditsButton.setBackground(null);
		creditsButton.setTextFill(Color.WHITE);
		creditsButton.setPadding(new Insets(5));

		addListener();

		titlePane = new VBox();
		titlePane.getChildren().addAll(nameText, startGameButton, tutorialButton, creditsButton);
		titlePane.setPadding(new Insets(50));
		titlePane.setSpacing(20);
		titlePane.setPrefSize(800, 600);
		titlePane.setAlignment(Pos.TOP_CENTER);

		// add canvas and VBox to root
		root.getChildren().addAll(titlePane);

		AudioManager.playBGM(ResourceManager.bgm.TITLE, 0.5, true);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		// handler
		startGameButton.setOnMouseClicked(e -> {
			changeScene(State.SELECTROCKET);
			;
		});
		startGameButton.setOnMouseEntered(e -> {
			startGameButton.setTextFill(Color.YELLOW);
		});
		startGameButton.setOnMouseExited(e -> {
			startGameButton.setTextFill(Color.WHITE);
		});

		// handler
		tutorialButton.setOnMouseClicked(e -> {
			changeScene(State.TUTORIAL);
			;
		});
		tutorialButton.setOnMouseEntered(e -> {
			tutorialButton.setTextFill(Color.YELLOW);
		});
		tutorialButton.setOnMouseExited(e -> {
			tutorialButton.setTextFill(Color.WHITE);
		});

		// handler
		creditsButton.setOnMouseClicked(e -> {
			changeScene(State.CREDITS);
			;
		});
		creditsButton.setOnMouseEntered(e -> {
			creditsButton.setTextFill(Color.YELLOW);
		});
		creditsButton.setOnMouseExited(e -> {
			creditsButton.setTextFill(Color.WHITE);
		});

	}

	@Override
	protected void releaseSceneComponents() {
		ResourceManager.clearResources(State.TITLE);
	}

	public void update() {

	}

}
