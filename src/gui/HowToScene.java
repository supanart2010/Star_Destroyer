package gui;

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class HowToScene {
	private static Label HowToTitle;
	private static Label Desc1;
	private static Label Desc2;
	private static Button TitleButton;

	public static Scene getHowToScene() {
		HowToTitle = new Label("How To Play ?");
		HowToTitle.setFont(new Font(28));

		Desc1 = new Label(
				"Use arrow key to move your rocket and use key 'Space', 'Z', 'X' and 'C' to shoot different bullets.");
		Desc2 = new Label("Defeats the Invader and protects the Universe.");

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

		StackPane root = new StackPane();

		VBox vb = new VBox();
		vb.getChildren().addAll(HowToTitle, Desc1, Desc2, TitleButton);
		// add canvas to root and VBox
		root.getChildren().addAll(vb);
		root.setBackground(bg);
		
		Scene HowtoScene = new Scene(root, 800, 600);
		return HowtoScene;
	}
}
