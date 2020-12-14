package gui;

import application.Main;
import application.ResourceManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

public class SelectRocketScene {

	private static Button TitleButton;

	public static Scene getSelectRocketScene() {

		Label chooseRocket = new Label("Choose your Rocket");
		chooseRocket.setTextFill(Color.WHITE);
		chooseRocket.setFont(new Font(40));

		TitleButton = new Button("Go Back");
		//TitleButton.setPrefSize(80, 50);
		TitleButton.setBackground(null);
		TitleButton.setTextFill(Color.WHITE);
		TitleButton.setFont(new Font(40));
		TitleButton.setPadding(new Insets(5));
		TitleButton.setOnMouseClicked(e -> {
			Main.titleHandle(Main.window);
		});
		TitleButton.setOnMouseEntered(e -> {
			TitleButton.setTextFill(Color.RED);
		});
		TitleButton.setOnMouseExited(e -> {
			TitleButton.setTextFill(Color.WHITE);
		});

		// set background image
		Image bg_path = ResourceManager.readImg("title_bg.png");
		Background bg = new Background(
				new BackgroundImage(bg_path, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.DEFAULT, new BackgroundSize(800, 600, false, false, false, false)));

		Button rocketABtn = new Button();
		rocketABtn.setPrefSize(200, 200);
		rocketABtn.setGraphic(new ImageView(ResourceManager.readImg("rocketA200px.png")));
		rocketABtn.setBackground(null);
		rocketABtn.setOnMouseClicked(e -> {
			//GameStartScene.setRocketA(true);
			Main.gameStartHandle(Main.window);
		});

		Button rocketBBtn = new Button();
		rocketABtn.setPrefSize(200, 200);
		rocketBBtn.setGraphic(new ImageView(ResourceManager.readImg("rocketB200px.png")));
		rocketBBtn.setBackground(null);
		rocketBBtn.setOnMouseClicked(e -> {
			//GameStartScene.setRocketB(true);
			Main.gameStartHandle(Main.window);
		});

		HBox hB = new HBox();
		hB.getChildren().add(rocketABtn);
		hB.getChildren().add(rocketBBtn);
		hB.setAlignment(Pos.CENTER);

		StackPane root = new StackPane();

		VBox vB = new VBox();
		vB.getChildren().addAll(chooseRocket, hB, TitleButton);
		vB.setAlignment(Pos.CENTER);

		root.getChildren().addAll(vB);
		root.setBackground(bg);

		Scene selectRocketScene = new Scene(root, 800, 600);

		return selectRocketScene;

	}

}
