package gui;

import application.Main;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
		
		Desc1 = new Label("Use arrow key to move your rocket and use key 'Space', 'Z', 'X' and 'C' to shoot different bullets.");
		Desc2 = new Label("Defeats the Invader and protects the Universe.");
		
		TitleButton = new Button("Go back");
		TitleButton.setPrefSize(80, 50);
		TitleButton.setPadding(new Insets(5));
		TitleButton.setOnMouseClicked(e->{
			Main.titleHandle(Main.window);
		});
		
		VBox root = new VBox();
		root.getChildren().addAll(HowToTitle,Desc1,Desc2,TitleButton);
		Scene titleScene = new Scene(root,800,600);
		return titleScene;
	}
}
