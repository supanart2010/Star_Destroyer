package gui;

import application.AudioManager;
import application.ResourceManager;
import application.SceneManager.State;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class LosingScene extends GameScene {
	private Button title;
	private Button newGame;
	private Label gameOver;

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

		vB.getChildren().addAll(gameOver, newGame, title);
		vB.setAlignment(Pos.CENTER);
		vB.setSpacing(20);

		root.getChildren().add(vB);
		addListener();
		
		AudioManager.playBGM(ResourceManager.readMedia("losing_theme.mp3"),0.5,false);
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
