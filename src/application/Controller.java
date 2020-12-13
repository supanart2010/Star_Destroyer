package application;

public class Controller{
	private static boolean isMoveLeft = false;
	private static boolean isMoveRight = false;
	private static boolean isMoveUp = false;
	private static boolean isMoveDown = false;
	private static boolean isShooting = false;
	
	
	public static boolean isMoveLeft() {
		return isMoveLeft;
	}
	public static void setMoveLeft(boolean isMoveLeft) {
		Controller.isMoveLeft = isMoveLeft;
	}
	public static boolean isMoveRight() {
		return isMoveRight;
	}
	public static void setMoveRight(boolean isMoveRight) {
		Controller.isMoveRight = isMoveRight;
	}
	public static boolean isMoveUp() {
		return isMoveUp;
	}
	public static void setMoveUp(boolean isMoveUp) {
		Controller.isMoveUp = isMoveUp;
	}
	public static boolean isMoveDown() {
		return isMoveDown;
	}
	public static void setMoveDown(boolean isMoveDown) {
		Controller.isMoveDown = isMoveDown;
	}
	public static boolean isShooting() {
		return isShooting;
	}
	public static void setShooting(boolean isShooting) {
		Controller.isShooting = isShooting;
	}
	
	
	
	
}
