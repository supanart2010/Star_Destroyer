package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SceneManager {
	public static Scene loadTitleScene() {
		Label nametext = new Label("STAR DESTROYER");
		nametext.setFont(new Font(20));
		
		Button startGameButton = new Button("Start");
		startGameButton.setPrefSize(30, 50);
		startGameButton.setPadding(new Insets(5));
		startGameButton.setOnMouseClicked(e->{
//			startGameHandle();
		});
		
		Button HowtoButton = new Button("How to play?");
		HowtoButton.setPrefSize(30,50);
		HowtoButton.setPadding(new Insets(5));
		HowtoButton.setOnMouseClicked(e->{
//			howToHandle();
		});
		
		Button CreditButton = new Button("Credits");
		CreditButton.setPrefSize(30,50);
		CreditButton.setPadding(new Insets(5));
		CreditButton.setOnMouseClicked(e->{
//			creditsHandle();
		});	
		
		VBox root = new VBox();
		root.getChildren().addAll(nametext,startGameButton,HowtoButton,CreditButton);
		Scene title = new Scene(root,600,800);
		return title;
	}
}
