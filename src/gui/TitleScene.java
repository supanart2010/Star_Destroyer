package gui;

import application.AudioManager;
import application.Main;
import application.ResourceManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class TitleScene {
	private static Label nameText;
	private static Button startGameButton;
	private static Button HowtoButton;
	private static Button CreditButton;

	public static Scene getTitleScene() {
		nameText = new Label("STAR DESTROYER");
		// nameText.set
		nameText.setTextFill(Color.WHITE);
		nameText.setFont(new Font(40));

		startGameButton = new Button("Game Start");
		startGameButton.setPrefSize(80, 50);
		startGameButton.setPadding(new Insets(5));
		startGameButton.setOnMouseClicked(e -> {
			Main.selectRocketHandle(Main.window);
		});

		HowtoButton = new Button("How to play?");
		HowtoButton.setPrefSize(80, 50);
		HowtoButton.setPadding(new Insets(5));
		HowtoButton.setOnMouseClicked(e -> {
			Main.howToHandle(Main.window);
		});

		CreditButton = new Button("Credits");
		CreditButton.setPrefSize(80, 50);
		CreditButton.setPadding(new Insets(5));
		CreditButton.setOnMouseClicked(e -> {
			Main.creditsHandle(Main.window);
		});
		// set background image
		Image bg_path = ResourceManager.readImg("spacebg.jpg");
		Background bg = new Background(
				new BackgroundImage(bg_path, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
						BackgroundPosition.DEFAULT, new BackgroundSize(800, 600, false, false, false, false)));


		StackPane root = new StackPane();

		// root.getChildren().addAll(canvas,nameText,startGameButton,HowtoButton,CreditButton);

		VBox vb = new VBox();
		vb.getChildren().addAll(nameText, startGameButton, HowtoButton, CreditButton);

		// add canvas and VBox to root
		root.getChildren().addAll(vb);
		root.setBackground(bg);

		Scene titleScene = new Scene(root, 800, 600);

		return titleScene;
	}

}
