package gui;

import application.AudioManager;
import application.Controller;
import application.ResourceManager;
import application.SceneManager;
import application.SceneManager.State;
import application.SceneSetupManager;
import entity.Minion;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.MinionManager;
import rocket.Rocket;
import rocket.RocketTypeA;
import rocket.RocketTypeB;

public class GameStartScene extends GameScene {
	private Rocket myRocket;

	private GraphicsContext gc;
	private MinionManager minionManager;
	private Text hp, laser, bomb, stage, score;
	// border of window
//	public static final int WINDOW_WIDTH = 800;
//	public static final int WINDOW_HEIGHT = 600;

	private static boolean isRocketA = false;

	public GameStartScene() {
		super();
		this.sceneState = State.PLAYING;
		setGameBackground(ResourceManager.gameStart.GAMESTART_BACKGROUND);

		gameLayer = new Canvas(500, 600);
		gc = gameLayer.getGraphicsContext2D();

		HBox newroot = new HBox();
		newroot.getChildren().add(gameLayer);
		newroot.setPrefSize(800, 600);

		if (isRocketA) {
			myRocket = new RocketTypeA();
			myRocket.render(gc, 100, 100);
		} else {
			myRocket = new RocketTypeB();
			myRocket.render(gc, 100, 100);
		}
		// Right Field
		VBox rightField = new VBox();
		hp = new Text("Health : " + myRocket.getHp());
		hp.setFill(Color.WHITE);
		hp.setFont(new Font(20));

		stage = new Text("stage : ");
		stage.setFill(Color.WHITE);
		stage.setFont(new Font(20));

		laser = new Text("Laser ammo : " + myRocket.getStorage().getLaserCapacity());
		laser.setFill(Color.WHITE);
		laser.setFont(new Font(20));

		bomb = new Text("Bomb ammo : " + myRocket.getStorage().getBombCapacity());
		bomb.setFill(Color.WHITE);
		bomb.setFont(new Font(20));

		score = new Text("Score : " + myRocket.getScore());
		score.setFill(Color.WHITE);
		score.setFont(new Font(20));

		// score add later

		rightField.getChildren().addAll(stage, hp, laser, bomb,score);
		newroot.getChildren().add(rightField);
		root.getChildren().add(newroot);

		minionManager = new MinionManager();

		SceneSetupManager.setSceneControlable(this);

		AudioManager.playBGM(ResourceManager.readMedia("gameStartBGM.mp3"), 0.5, true);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void releaseSceneComponents() {
		// TODO Auto-generated method stub
		ResourceManager.clearResources(this.sceneState);
	}

	public void update() {
		if (myRocket.isDead()) {
			changeScene(State.LOSING);
			return;
		}
		gc.clearRect(0, 0, SceneManager.WINDOW_WIDTH, SceneManager.WINDOW_HEIGHT);
		myRocket.update(SceneManager.WINDOW_WIDTH, SceneManager.WINDOW_HEIGHT, gc);
		minionManager.update(myRocket.getBulletManager(), gc, SceneManager.WINDOW_WIDTH, SceneManager.WINDOW_HEIGHT,
				myRocket);
		hp.setText("Health : " + myRocket.getHp());
		laser.setText("Laser ammo : " + myRocket.getStorage().getLaserRemain());
		bomb.setText("Bomb ammo : " + myRocket.getStorage().getBombRemain());
		score.setText("Score : " + myRocket.getScore());
	}

	public static boolean isRocketA() {
		return isRocketA;
	}

	public static void setRocketA(boolean isRocketA) {
		GameStartScene.isRocketA = isRocketA;
	}
}
