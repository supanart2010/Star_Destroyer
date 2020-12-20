package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.AudioManager;
import logic.ResourceManager;
import logic.SceneManager.State;

public class SelectRocketScene extends GameScene {

	private Label chooseRocket;
	private Button rocketAButton;
	private Button rocketBButton;
	private HBox selectRocket;
	private Button titleButton;
	private BorderPane selectPane;

	public SelectRocketScene() {
		super();
		this.sceneState = State.SELECTROCKET;
		setGameBackground(ResourceManager.selectRocket.SELECTROCKET_BACKGROUND);

		chooseRocket = new Label("Choose your Rocket");
		chooseRocket.setTextFill(Color.WHITE);
		chooseRocket.setFont(new Font("Times New Roman",40));

		rocketAButton = new Button();
		rocketAButton.setPrefSize(200, 200);
		rocketAButton.setGraphic(new ImageView(ResourceManager.selectRocket.ROCKETA));
		rocketAButton.setBackground(null);

		rocketBButton = new Button();
		rocketAButton.setPrefSize(200, 200);
		rocketBButton.setGraphic(new ImageView(ResourceManager.selectRocket.ROCKETB));
		rocketBButton.setBackground(null);

		selectRocket = new HBox();
		selectRocket.getChildren().add(rocketAButton);
		selectRocket.getChildren().add(rocketBButton);
		selectRocket.setAlignment(Pos.CENTER);
		selectRocket.setSpacing(20);

		titleButton = new Button("Go back");
		titleButton.setFont(new Font("Times New Roman",30));
		titleButton.setBackground(null);
		titleButton.setTextFill(Color.WHITE);
		titleButton.setPadding(new Insets(5));

		addListener();
		
		selectPane = new BorderPane();
		selectPane.setPadding(new Insets(30));
		selectPane.setTop(chooseRocket);
		BorderPane.setMargin(chooseRocket, new Insets(50));
		BorderPane.setAlignment(chooseRocket, Pos.CENTER);
		selectPane.setCenter(selectRocket);
		selectPane.setBottom(titleButton);

		root.getChildren().addAll(selectPane);

		AudioManager.playBGM(ResourceManager.bgm.SELECT, 0.5, true);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		titleButton.setOnMouseClicked(e -> {
			changeScene(State.TITLE);		});
		titleButton.setOnMouseEntered(e -> {
			titleButton.setTextFill(Color.RED);
		});
		titleButton.setOnMouseExited(e -> {
			titleButton.setTextFill(Color.WHITE);
		});

		rocketAButton.setOnMouseClicked(e -> {
			GameStartScene.setRocketA(true);
			changeScene(State.PLAYING);
		});
		rocketAButton.setOnMouseEntered(e -> {
			rocketAButton.setBackground(
					new Background(new BackgroundFill(new Color(0.8, 1, 1, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		});
		rocketAButton.setOnMouseExited(e -> {
			rocketAButton.setBackground(null);
		});

		rocketBButton.setOnMouseClicked(e -> {
			GameStartScene.setRocketA(false);
			changeScene(State.PLAYING);
		});
		rocketBButton.setOnMouseEntered(e -> {
			rocketBButton.setBackground(
					new Background(new BackgroundFill(new Color(0.8, 1, 1, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		});
		rocketBButton.setOnMouseExited(e -> {
			rocketBButton.setBackground(null);
		});
	}

	@Override
	protected void releaseSceneComponents() {
		// TODO Auto-generated method stub
		ResourceManager.clearResources(State.SELECTROCKET);
	}

	public void update() {

	}
}
