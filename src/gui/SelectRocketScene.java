package gui;

import application.Main;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.AudioManager;
import logic.ResourceManager;
import logic.SceneManager.State;

public class SelectRocketScene extends GameScene {

	private Button titleButton;
	private Button rocketABtn;
	private Button rocketBBtn;
	private Label chooseRocket;
	private HBox selectRocket;

	public SelectRocketScene() {
		super();
		this.sceneState = State.SELECTROCKET;
		setGameBackground(ResourceManager.selectRocket.SELECTROCKET_BACKGROUND);

		chooseRocket = new Label("Choose your Rocket");
		chooseRocket.setTextFill(Color.WHITE);
		chooseRocket.setFont(new Font("Times New Roman",40));

		titleButton = new Button("Go back");
		titleButton.setFont(new Font("Times New Roman",30));
		titleButton.setBackground(null);
		titleButton.setTextFill(Color.WHITE);
		titleButton.setPadding(new Insets(5));

		rocketABtn = new Button();
		rocketABtn.setPrefSize(200, 200);
		rocketABtn.setGraphic(new ImageView(ResourceManager.selectRocket.ROCKETA));
		rocketABtn.setBackground(null);

		rocketBBtn = new Button();
		rocketABtn.setPrefSize(200, 200);
		rocketBBtn.setGraphic(new ImageView(ResourceManager.selectRocket.ROCKETB));
		rocketBBtn.setBackground(null);

		selectRocket = new HBox();
		selectRocket.getChildren().add(rocketABtn);
		selectRocket.getChildren().add(rocketBBtn);
		selectRocket.setAlignment(Pos.CENTER);
		selectRocket.setSpacing(20);

		addListener();
		
		BorderPane bP = new BorderPane();
		bP.setPadding(new Insets(30));
		bP.setTop(chooseRocket);
		BorderPane.setMargin(chooseRocket, new Insets(50));
		BorderPane.setAlignment(chooseRocket, Pos.CENTER);
		bP.setCenter(selectRocket);
		bP.setBottom(titleButton);

//		VBox vB = new VBox();
//		vB.getChildren().addAll(chooseRocket, selectRocket, titleButton);
//		vB.setAlignment(Pos.TOP_CENTER);
//		vB.setPadding(new Insets(30));

		root.getChildren().addAll(bP);

		AudioManager.playBGM(ResourceManager.bgm.SELECT, 0.5, true);
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

		rocketABtn.setOnMouseClicked(e -> {
			GameStartScene.setRocketA(true);
			changeScene(State.PLAYING);
		});
		rocketABtn.setOnMouseEntered(e -> {
			rocketABtn.setBackground(
					new Background(new BackgroundFill(new Color(0.8, 1, 1, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		});
		rocketABtn.setOnMouseExited(e -> {
			rocketABtn.setBackground(null);
		});

		rocketBBtn.setOnMouseClicked(e -> {
			GameStartScene.setRocketA(false);
			changeScene(State.PLAYING);
		});
		rocketBBtn.setOnMouseEntered(e -> {
			rocketBBtn.setBackground(
					new Background(new BackgroundFill(new Color(0.8, 1, 1, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
		});
		rocketBBtn.setOnMouseExited(e -> {
			rocketBBtn.setBackground(null);
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
