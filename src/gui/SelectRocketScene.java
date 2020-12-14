package gui;

import application.Main;
import application.ResourceManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class SelectRocketScene {

	private static Button TitleButton;
	private static Button Start;
	private static Label chooseRocket;
	private static Canvas rocketA;
	private static Canvas rocketB;

	public static Scene getSelectRocketScene() {

		chooseRocket = new Label("Choose your Rocket");
		chooseRocket.setTextFill(Color.WHITE);
		chooseRocket.setFont(new Font(40));

		Start = new Button("Start");
		Start.setPrefSize(80, 50);
		Start.setPadding(new Insets(5));
		Start.setOnMouseClicked(e -> {
			Main.gameStartHandle(Main.window);
		});

		TitleButton = new Button("Go back");
		TitleButton.setPrefSize(80, 50);
		TitleButton.setPadding(new Insets(5));
		TitleButton.setOnMouseClicked(e -> {
			Main.titleHandle(Main.window);
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
			GameStartScene.setRocketA(true);
			Main.gameStartHandle(Main.window);
		});

		// draw rocketB
		rocketB = new Canvas(100, 100);
		GraphicsContext gcRB = rocketB.getGraphicsContext2D();
		// draw image rocketA
		gcRB.drawImage(new Image(ClassLoader.getSystemResource("rocketB.png").toString()), 0, 0, 100, 100);

		StackPane root = new StackPane();
		GridPane grid = new GridPane();
		VBox vb = new VBox();
		vb.getChildren().addAll(Start, TitleButton);

		grid.add(vb, 0, 0);
		grid.add(rocketA, 2, 10);
		grid.add(rocketB, 5, 10);
		// add canvas and VBox to root
		root.getChildren().addAll(grid);
		root.setBackground(bg);

		Scene selectRocketScene = new Scene(root, 800, 600);

		return selectRocketScene;

	}

}
