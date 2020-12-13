package gui;

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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CreditsScene {
	private static Label CreditTitle;
	private static Label NameTag1;
	private static Label NameTag2;
	private static Button TitleButton;

	public static Scene getCreditsScene() {
		CreditTitle = new Label("Credits");
		CreditTitle.setFont(Font.font("Arial",FontWeight.EXTRA_BOLD,50));
		CreditTitle.setTextFill(Color.WHITE);

		NameTag1 = new Label("Poravee Binhayeearason 6230314421");
		NameTag1.setFont(Font.font("Arial",FontWeight.EXTRA_LIGHT,28));
		NameTag1.setTextFill(Color.WHITE);
		NameTag2 = new Label("Supanart Barnsongkit 6230522621");
		NameTag2.setFont(Font.font("Arial",FontWeight.EXTRA_LIGHT,28));
		NameTag2.setTextFill(Color.WHITE);

		TitleButton = new Button("Go back");
		TitleButton.setFont(Font.font("Arial",FontWeight.BOLD,28));
		TitleButton.setBackground(null);
		TitleButton.setTextFill(Color.WHITE);
		TitleButton.setPadding(new Insets(5));
		
		//handle
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

		StackPane root = new StackPane();

		VBox vb = new VBox();
		vb.getChildren().addAll(CreditTitle, NameTag1, NameTag2, TitleButton);
		vb.setPadding(new Insets(50));
		vb.setSpacing(20);
		vb.setPrefSize(800, 600);
		vb.setAlignment(Pos.TOP_CENTER);

		// add canvas to root and VBox
		root.getChildren().addAll(vb);
		root.setBackground(bg);

		Scene titleScene = new Scene(root, 800, 600);
		return titleScene;
	}
}
