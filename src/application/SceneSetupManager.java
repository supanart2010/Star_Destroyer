package application;

import javafx.scene.Scene;

public class SceneSetupManager {
	public static void setSceneControlable(Scene scene) {
		scene.setOnKeyPressed(e -> {
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
		scene.setOnKeyReleased(e -> {
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
}
