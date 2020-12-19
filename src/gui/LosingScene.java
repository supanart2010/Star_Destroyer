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

public class LosingScene extends GameScene {
	private Label gameOver;
	private Label score;
	private Label highScore;
	private Button newGameButton;
	private Button titleButton;
	private VBox losingPane;

	public LosingScene() {
		super();
		this.sceneState = State.LOSING;
		setGameBackground(ResourceManager.losing.LOSING_BACKGROUND);

		titleButton = new Button("Main Menu");
		titleButton.setFont(new Font("Times New Roman", 30));
		titleButton.setPadding(new Insets(5));
		titleButton.setTextFill(Color.WHITE);
		titleButton.setBackground(null);

		gameOver = new Label("Game Over!!");
		gameOver.setTextFill(Color.WHITE);
		gameOver.setFont(new Font("Times New Roman", 60));

		newGameButton = new Button("Play Again?");
		newGameButton.setFont(new Font("Times New Roman", 50));
		newGameButton.setBackground(null);
		newGameButton.setTextFill(Color.WHITE);
		newGameButton.setPadding(new Insets(5));

		score = new Label("Your score : " + GameStartScene.getCurrentScore());
		score.setFont(new Font("Times New Roman", 30));
		score.setTextFill(Color.WHITE);

		highScore = new Label("High score : " + GameStartScene.getHighScore());
		highScore.setFont(new Font("Times New Roman", 30));
		highScore.setTextFill(Color.WHITE);

		losingPane = new VBox();
		losingPane.getChildren().addAll(gameOver, score, highScore, newGameButton, titleButton);
		losingPane.setAlignment(Pos.CENTER);
		losingPane.setSpacing(20);

		root.getChildren().add(losingPane);
		addListener();

		AudioManager.playBGM(ResourceManager.bgm.LOSING, 0.5, false);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		titleButton.setOnMouseClicked(e -> {
			changeScene(State.TITLE);
		});
		titleButton.setOnMouseEntered(e -> {
			titleButton.setTextFill(Color.YELLOW);
		});
		titleButton.setOnMouseExited(e -> {
			titleButton.setTextFill(Color.WHITE);
		});
		newGameButton.setOnAction(e -> {
			changeScene(State.SELECTROCKET);
		});
		newGameButton.setOnMouseEntered(e -> {
			newGameButton.setTextFill(Color.YELLOW);
		});
		newGameButton.setOnMouseExited(e -> {
			newGameButton.setTextFill(Color.WHITE);
		});

	}

	@Override
	protected void releaseSceneComponents() {
		ResourceManager.clearResources(State.LOSING);
	}

	public void update() {

	}

}
