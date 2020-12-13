package gui;

import application.Main;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class SelectRocketScene {
	private static Image rocketA;
	private static Image rocketB;
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

		// draw background image
		// Create new class for load image
		Canvas canvasBG = new Canvas(800, 600);
		GraphicsContext gcBG = canvasBG.getGraphicsContext2D();

		Image imgpath = new Image(ClassLoader.getSystemResource("spacebg.jpg").toString());
		gcBG.drawImage(imgpath, 0, 0, 800, 600);
		
		Canvas rocketA = new Canvas(100,100);
		GraphicsContext gcRA = rocketA.getGraphicsContext2D();
		//draw image rocketA
		gcRA.drawImage(new Image(ClassLoader.getSystemResource("rocketA.png").toString()),0,0,100,100);
		
		

		StackPane root = new StackPane();
		GridPane grid = new GridPane();
		VBox vb = new VBox();
		vb.getChildren().addAll(Start,TitleButton);

		grid.add(vb, 0, 0);
		grid.add(rocketA,2,10);
		// add canvas and VBox to root
		root.getChildren().addAll(canvasBG,grid);

		Scene selectRocketScene = new Scene(root, 800, 600);
		return selectRocketScene;

	}

}
