package gui;

import application.Main;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CreditsScene {
	private static Label CreditTitle;
	private static Label NameTag1;
	private static Label NameTag2;
	private static Button TitleButton;
	public static Scene getCreditsScene() {
		CreditTitle = new Label("Credits");
		CreditTitle.setFont(new Font(28));
		CreditTitle.setTextFill(Color.WHITE);
		
		NameTag1 = new Label("Poravee Binhayeearason 6230314421");
		NameTag1.setTextFill(Color.WHITE);
		NameTag2 = new Label("Supanart Barnsongkit 6230522621");
		NameTag2.setTextFill(Color.WHITE);
		
		TitleButton = new Button("Go back");
		TitleButton.setPrefSize(80, 50);
		TitleButton.setPadding(new Insets(5));
		TitleButton.setOnMouseClicked(e->{
			Main.titleHandle(Main.window);
		});
		
		//draw background image
		//Create new class for load image
		Canvas canvas = new Canvas(800,600);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		Image imgpath = new Image(ClassLoader.getSystemResource("spacebg.jpg").toString());
		gc.drawImage(imgpath, 0, 0,800,600);
		
		StackPane root = new StackPane();
		
		VBox vb = new VBox();
		vb.getChildren().addAll(CreditTitle,NameTag1,NameTag2,TitleButton);

		//add canvas to root and VBox
		root.getChildren().addAll(canvas,vb);
		
		Scene titleScene = new Scene(root,800,600);
		return titleScene;
	}
}
