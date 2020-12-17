package application;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class ResourceManager {
	public static TitleResource title;
	public static SelectRocketResource selectRocket;
	public static GameStartResource gameStart;
	public static TutorialResource tutorial;
	public static CreditsResource credits;
//	public static WinningResource winning;
	public static LosingResource losing;

	public static class TitleResource {
		public final Image TITLE_BACKGROUND;

		TitleResource() {
			this.TITLE_BACKGROUND = readImg("title_bg.png");
		}
	}

	public static class SelectRocketResource {
		public final Image SELECTROCKET_BACKGROUND;
		public final Image ROCKETA;
		public final Image ROCKETB;

		SelectRocketResource() {
			SELECTROCKET_BACKGROUND = readImg("title_bg.png");
			ROCKETA = readImg("rocketA200px.png");
			ROCKETB = readImg("rocketB200px.png");
		}
	}

	public static class GameStartResource {
		public final Image GAMESTART_BACKGROUND;
		public final Image ROCKETA;
		public final Image ROCKETB;
		public final Image BULLET;
		public final Image LASERBULLET;
		public final Image BOMBBULLET;
		public final Image GREENMINION;
		public final Image REDMINION;
		public final Image YELLOWMINION;
		public final Image BOMB;

		GameStartResource() {
			GAMESTART_BACKGROUND = readImg("default_bg.png");
			ROCKETA = readImg("rocketA.png");
			ROCKETB = readImg("rocketB.png");
			BULLET = readImg("pointbullettest.png");
			LASERBULLET = readImg("lasercontinue.png");
			BOMBBULLET = readImg("bombbullet.png");
			GREENMINION = readImg("alien_green.png");
			REDMINION = readImg("alien_red.png");
			YELLOWMINION = readImg("alien_yellow.png");
			BOMB = readImg("explosion.png");
		}

	}

	public static class TutorialResource {
		public final Image TUTORIAL_BACKGROUND;

		TutorialResource() {
			TUTORIAL_BACKGROUND = readImg("tutorialbg.png");
		}
	}

	public static class CreditsResource {
		public final Image CREDITS_BACKGROUND;

		CreditsResource() {
			CREDITS_BACKGROUND = readImg("democredit.png");
		}
	}

	public static class LosingResource {
		public final Image LOSING_BACKGROUND;

		public LosingResource() {
			LOSING_BACKGROUND = readImg("title_bg.png");

		}
	}

	public static void loadResources(SceneManager.State sceneState) {

		switch (sceneState) {
		case TITLE:
			if (title == null)
				title = new TitleResource();
			break;
		case SELECTROCKET:
			if (selectRocket == null)
				selectRocket = new SelectRocketResource();
			break;

		case PLAYING:
			if (gameStart == null)
				gameStart = new GameStartResource();
			break;
		case TUTORIAL:
			if (tutorial == null)
				tutorial = new TutorialResource();
			break;
		case CREDITS:
			if (credits == null)
				credits = new CreditsResource();
			break;
//		case WINNING:
//			if (winning == null)
//				winning = new WinningResource();
//			break;
		case LOSING:
			if (losing == null)
				losing = new LosingResource();
			break;
		default:
		}
	}

	public static void clearResources(SceneManager.State sceneState) {
		switch (sceneState) {
		case TITLE:
			title = null;
		case SELECTROCKET:
			selectRocket = null;
		case PLAYING:
			gameStart = null;
		case TUTORIAL:
			tutorial = null;
		case CREDITS:
			credits = null;
//		case WINNING:
//			winning = null;
		case LOSING:
			losing = null;
		default:
			break;
		}
	}

	public static Image readImg(String filename) {
		return new Image(ClassLoader.getSystemResource(filename).toString());
	}

	public static Media readMedia(String filename) {
		return new Media(ClassLoader.getSystemResource(filename).toString());
	}

	public static AudioClip readAudioClip(String filename) {
		return new AudioClip(ClassLoader.getSystemResource(filename).toString());
	}
}