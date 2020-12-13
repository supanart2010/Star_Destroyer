package gui;

import application.AudioManager;
import application.Main;
import application.ResourceManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SelectRocketScene {
	private static Canvas rocketA;
	private static Canvas rocketB;
	private static Button TitleButton;
	private static Button Start;

	public static Scene getSelectRocketScene() {

		Label chooseRocket = new Label("Choose your Rocket");
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

		// draw rocketA
		rocketA = new Canvas(100, 100);
		GraphicsContext gcRA = rocketA.getGraphicsContext2D();
		// draw image rocketA
		gcRA.drawImage(new Image(ClassLoader.getSystemResource("rocketA.png").toString()), 0, 0, 100, 100);

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
