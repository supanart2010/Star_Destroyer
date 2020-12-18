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
	private Button title;
	private Button newGame;
	private Label gameOver;
	private Label score;
	private Label highScore;

	public LosingScene() {
		super();
		this.sceneState = State.LOSING;
		setGameBackground(ResourceManager.losing.LOSING_BACKGROUND);

		VBox vB = new VBox();

		title = new Button("Main Menu");
		title.setFont(new Font("Times New Roman", 30));
		title.setPadding(new Insets(5));
		title.setTextFill(Color.WHITE);
		title.setBackground(null);

		gameOver = new Label("Game Over!!");
		gameOver.setTextFill(Color.WHITE);
		gameOver.setFont(new Font("Times New Roman", 60));

		newGame = new Button("Play Again?");
		newGame.setFont(new Font("Times New Roman", 50));
		newGame.setBackground(null);
		newGame.setTextFill(Color.WHITE);
		newGame.setPadding(new Insets(5));

		score = new Label("Your score : " + GameStartScene.getCurrentScore());
		score.setFont(new Font("Times New Roman", 30));
		score.setTextFill(Color.WHITE);

		highScore = new Label("High score : " + GameStartScene.getHighScore());
		highScore.setFont(new Font("Times New Roman", 30));
		highScore.setTextFill(Color.WHITE);

		vB.getChildren().addAll(gameOver, score, highScore, newGame, title);
		vB.setAlignment(Pos.CENTER);
		vB.setSpacing(20);

		root.getChildren().add(vB);
		addListener();

		AudioManager.playBGM(ResourceManager.bgm.LOSING, 0.5, false);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		title.setOnMouseClicked(e -> {
			changeScene(State.TITLE);
		});
		title.setOnMouseEntered(e -> {
			title.setTextFill(Color.YELLOW);
		});
		title.setOnMouseExited(e -> {
			title.setTextFill(Color.WHITE);
		});
		newGame.setOnAction(e -> {
			changeScene(State.SELECTROCKET);
		});
		newGame.setOnMouseEntered(e -> {
			newGame.setTextFill(Color.YELLOW);
		});
		newGame.setOnMouseExited(e -> {
			newGame.setTextFill(Color.WHITE);
		});

	}

	@Override
	protected void releaseSceneComponents() {
		ResourceManager.clearResources(State.LOSING);
	}

	public void update() {

	}

}
