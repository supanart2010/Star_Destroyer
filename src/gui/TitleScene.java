package gui;

import application.Main;
import application.SceneManager;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TitleScene{
	private static Label nameText;
	private static Button startGameButton;
	private static Button HowtoButton;
	private static Button CreditButton;
	public static Scene getTitleScene() {
		nameText = new Label("STAR DESTROYER");
		nameText.setFont(new Font(20));
		
		startGameButton = new Button("Game Start");
		startGameButton.setPrefSize(80, 50);
		startGameButton.setPadding(new Insets(5));
		startGameButton.setOnMouseClicked(e->{
			Main.gameStartHandle(Main.window);
		});
		
		HowtoButton = new Button("How to play?");
		HowtoButton.setPrefSize(80, 50);
		HowtoButton.setPadding(new Insets(5));
		HowtoButton.setOnMouseClicked(e->{
			Main.howToHandle(Main.window);
		});
		
		CreditButton = new Button("Credits");
		CreditButton.setPrefSize(80, 50);
		CreditButton.setPadding(new Insets(5));
		CreditButton.setOnMouseClicked(e->{
			Main.creditsHandle(Main.window);
		});	
		
		VBox root = new VBox();
		root.getChildren().addAll(nameText,startGameButton,HowtoButton,CreditButton);
		Scene titleScene = new Scene(root,800,600);
		return titleScene;
	}
	
	
}
