package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.AudioManager;
import logic.Controller;
import logic.MinionManager;
import logic.ResourceManager;
import logic.SceneManager;
import logic.SceneManager.State;
import sprite.Rocket;
import sprite.RocketTypeA;
import sprite.RocketTypeB;

public class GameStartScene extends GameScene {
	public static final int GAMELAYER_WIDTH = 500;
	public static final int GAMELAYER_HEIGHT = 600;
	public static final int DATALAYER_WIDTH = 300;
	public static final int DATALAYER_HEIGHT = 600;

	private Rocket myRocket;

	private GraphicsContext gc;
	private MinionManager minionManager;
	private Text rocketName, hp, laser, bomb, score;

	private static int currentScore;
	private static int highScore = 0;
	private static boolean isRocketA = false;

	public GameStartScene() {
		super();
		this.sceneState = State.PLAYING;
		setGameBackground(ResourceManager.gameStart.GAMESTART_BACKGROUND);

		gameLayer = new Canvas(GAMELAYER_WIDTH, GAMELAYER_HEIGHT);
		gc = gameLayer.getGraphicsContext2D();

		HBox newroot = new HBox();
		newroot.setPrefSize(SceneManager.WINDOW_WIDTH, SceneManager.WINDOW_HEIGHT);

		if (isRocketA) {
			myRocket = new RocketTypeA();
			myRocket.render(gc, Rocket.ROCKET_WIDTH, Rocket.ROCKET_HEIGHT);
		} else {
			myRocket = new RocketTypeB();
			myRocket.render(gc, Rocket.ROCKET_WIDTH, Rocket.ROCKET_HEIGHT);
		}
		// Right Field
		VBox dataLayer = new VBox();
		dataLayer.setPrefSize(DATALAYER_WIDTH, DATALAYER_HEIGHT);
		dataLayer.setAlignment(Pos.CENTER);
		dataLayer.setBackground(new Background(new BackgroundFill(null, CornerRadii.EMPTY, new Insets(0))));

		rocketName = new Text("Rocket : " + myRocket.getName());
		rocketName.setFill(Color.WHITE);
		rocketName.setFont(new Font(20));

		hp = new Text("Health : " + myRocket.getHp());
		hp.setFill(Color.WHITE);
		hp.setFont(new Font(20));

		laser = new Text("Laser ammo : " + myRocket.getStorage().getLaserCapacity());
		laser.setFill(Color.WHITE);
		laser.setFont(new Font(20));

		bomb = new Text("Bomb ammo : " + myRocket.getStorage().getBombCapacity());
		bomb.setFill(Color.WHITE);
		bomb.setFont(new Font(20));

		score = new Text("Score : " + myRocket.getScore());
		score.setFill(Color.WHITE);
		score.setFont(new Font(20));

		dataLayer.getChildren().addAll(rocketName, hp, laser, bomb, score);
		newroot.getChildren().add(gameLayer);
		newroot.getChildren().add(dataLayer);
		root.getChildren().add(newroot);

		minionManager = new MinionManager();
		addListener();

		setDefaultController();
		setCurrentScore(0);
		AudioManager.playBGM(ResourceManager.bgm.START, 0.5, true);
	}

	@Override
	protected void addListener() {
		// TODO Auto-generated method stub
		this.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case LEFT:
				Controller.setMoveLeft(true);
				break;
			case RIGHT:
				Controller.setMoveRight(true);
				break;
			case UP:
				Controller.setMoveUp(true);
				break;
			case DOWN:
				Controller.setMoveDown(true);
				break;
			case SPACE:
				Controller.setShooting(true);
				break;
			case Z:
				Controller.setShootingLaser(true);
				break;
			case X:
				Controller.setShootingBomb(true);
				break;
			default:
				break;

			}
		});
		this.setOnKeyReleased(e -> {
			switch (e.getCode()) {
			case LEFT:
				Controller.setMoveLeft(false);
				break;
			case RIGHT:
				Controller.setMoveRight(false);
				break;
			case UP:
				Controller.setMoveUp(false);
				break;
			case DOWN:
				Controller.setMoveDown(false);
				break;
			case SPACE:
				Controller.setShooting(false);
				break;
			case Z:
				Controller.setShootingLaser(false);
				break;
			case X:
				Controller.setShootingBomb(false);
				break;
			default:
				break;
			}
		});
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
		myRocket.update(gc);
		minionManager.update(myRocket.getBulletManager(), gc, myRocket);
		hp.setText("Health : " + myRocket.getHp());
		laser.setText("Laser ammo : " + myRocket.getStorage().getLaserRemain());
		bomb.setText("Bomb ammo : " + myRocket.getStorage().getBombRemain());
		score.setText("Score : " + myRocket.getScore());
		setCurrentScore(myRocket.getScore());
		if (getHighScore() < getCurrentScore()) {
			setHighScore(currentScore);
		}
	}

	public static boolean isRocketA() {
		return isRocketA;
	}

	public static void setRocketA(boolean isRocketA) {
		GameStartScene.isRocketA = isRocketA;
	}

	public void setDefaultController() {
		Controller.setMoveLeft(false);
		Controller.setMoveRight(false);
		Controller.setMoveDown(false);
		Controller.setMoveUp(false);
		Controller.setShooting(false);
		Controller.setShootingLaser(false);
		Controller.setShootingBomb(false);
		Controller.setPointDelay(false);
		Controller.setLaserDelay(false);
		Controller.setBombDelay(false);
	}

	public static int getCurrentScore() {
		return currentScore;
	}

	public static void setCurrentScore(int currentScore) {
		GameStartScene.currentScore = currentScore;
	}

	public static int getHighScore() {
		return highScore;
	}

	public static void setHighScore(int highScore) {
		GameStartScene.highScore = highScore;
	}
}
