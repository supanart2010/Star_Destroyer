package application;

import gui.GameStartScene;
import javafx.scene.Scene;

public class SceneSetupManager {
	public static void setSceneControlable(Scene scene) {
		scene.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case LEFT:
				Controller.setMoveLeft(true);
//				System.out.println("isPressedLeft");
				break;
			case RIGHT:
				Controller.setMoveRight(true);
//				System.out.println("isPressedRight");
				break;
			case UP:
				Controller.setMoveUp(true);
//				System.out.println("isPressedUp");
				break;
			case DOWN:
				Controller.setMoveDown(true);
//				System.out.println("isPressedDown");
				break;
			case SPACE:
				Controller.setShooting(true);
//				System.out.println("isPressedSpace");
				break;
			case Z:
				Controller.setShootingLaser(true);
//				System.out.println("isPressed 'Z' ");
				break;
			case X:
				Controller.setShootingBomb(true);
//				System.out.println("isPressed 'X' ");
				break;
			default:
				break;

			}
		});
		scene.setOnKeyReleased(e -> {
			switch (e.getCode()) {
			case LEFT:
				Controller.setMoveLeft(false);
//				System.out.println("isReleasedLeft");
				break;
			case RIGHT:
				Controller.setMoveRight(false);
//				System.out.println("isReleasedRight");
				break;
			case UP:
				Controller.setMoveUp(false);
//				System.out.println("isReleasedUp");
				break;
			case DOWN:
				Controller.setMoveDown(false);
//				System.out.println("isReleasedDown");
				break;
			case SPACE:
				Controller.setShooting(false);
//				System.out.println("isReleasedSpace");
				break;
			case Z:
				Controller.setShootingLaser(false);
//				System.out.println("isReleased 'Z' ");
				break;
			case X:
				Controller.setShootingBomb(false);
//				System.out.println("isReleased 'X' ");
				break;
			default:
				break;
			}
		});
	}
}
