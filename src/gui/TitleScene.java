package gui;

import application.Main;
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
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import logic.AudioManager;
import logic.ResourceManager;
import logic.SceneManager.State;

public class TitleScene extends GameScene {
	private Label nameText;
	private Button startGameButton;
	private Button HowtoButton;
	private Button CreditButton;

	public TitleScene() {
		super();
		this.sceneState = State.TITLE;
		setGameBackground(ResourceManager.title.TITLE_BACKGROUND);
		
		Circle btnShape = new Circle(50,Color.valueOf("#cc0a0a"));
		btnShape.setStrokeWidth(3);
		btnShape.setStroke(Color.WHITE);

		startGameButton = new Button("Start");
		startGameButton.setFont(new Font("Times New Roman", 50));
		startGameButton.setBackground(null);
		startGameButton.setTextFill(Color.WHITE);
		startGameButton.setPadding(new Insets(5));

		nameText = new Label("STAR DESTROYER");
		nameText.setTextFill(Color.WHITE);
		nameText.setFont(new Font("Times New Roman", 60));

		HowtoButton = new Button("Tutorial");
		HowtoButton.setFont(new Font("Times New Roman", 50));
		HowtoButton.setBackground(null);
		HowtoButton.setTextFill(Color.WHITE);
		HowtoButton.setPadding(new Insets(5));

		CreditButton = new Button("Credits");
		CreditButton.setFont(new Font("Times New Roman", 50));
		CreditButton.setBackground(null);
		CreditButton.setTextFill(Color.WHITE);
		CreditButton.setPadding(new Insets(5));

		addListener();

		VBox vb = new VBox();
		vb.getChildren().addAll(nameText, startGameButton, HowtoButton, CreditButton);
		vb.setPadding(new Insets(50));
		vb.setSpacing(20);
		vb.setPrefSize(800, 600);
		vb.setAlignment(Pos.TOP_CENTER);

		// add canvas and VBox to root
		root.getChildren().addAll(vb);

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
		HowtoButton.setOnMouseClicked(e -> {
			changeScene(State.TUTORIAL);
			;
		});
		HowtoButton.setOnMouseEntered(e -> {
			HowtoButton.setTextFill(Color.YELLOW);
		});
		HowtoButton.setOnMouseExited(e -> {
			HowtoButton.setTextFill(Color.WHITE);
		});

		// handler
		CreditButton.setOnMouseClicked(e -> {
			changeScene(State.CREDITS);
			;
		});
		CreditButton.setOnMouseEntered(e -> {
			CreditButton.setTextFill(Color.YELLOW);
		});
		CreditButton.setOnMouseExited(e -> {
			CreditButton.setTextFill(Color.WHITE);
		});

	}

	@Override
	protected void releaseSceneComponents() {
		ResourceManager.clearResources(State.TITLE);
	}

	public void update() {

	}

}
