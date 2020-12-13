package gui;

import application.Main;
import application.SceneManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class CreditsScene {
	private static Label CreditTitle;
	private static Label NameTag1;
	private static Label NameTag2;
	private static Button TitleButton;
	public static Scene getCreditsScene() {
		CreditTitle = new Label("Credits");
		CreditTitle.setFont(new Font(28));
		
		NameTag1 = new Label("Poravee Binhayeearason 6230314421");
		NameTag2 = new Label("Supanart Barnsongkit 6230522621");
		
		TitleButton = new Button("Go back");
		TitleButton.setPrefSize(80, 50);
		TitleButton.setPadding(new Insets(5));
		TitleButton.setOnMouseClicked(e->{
			Main.titleHandle(Main.window);
		});
		
		VBox root = new VBox();
		root.getChildren().addAll(CreditTitle,NameTag1,NameTag2,TitleButton);
		Scene titleScene = new Scene(root,800,600);
		return titleScene;
	}
}
