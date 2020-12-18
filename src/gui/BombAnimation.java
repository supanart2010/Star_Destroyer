package gui;

import application.AudioManager;
import application.ResourceManager;
import javafx.scene.canvas.GraphicsContext;
import sprite.Sprite;

public class BombAnimation extends Sprite {

	private static double width = 50;
	private static double height = 50;

	public BombAnimation(double positionX, double positionY) {
		super(positionX, positionY, width, height);
		this.setImage(ResourceManager.readImg("explosion.png"));
		setSize(50, 50);
		// TODO Auto-generated constructor stub
	}

	public void update() {
		// TODO Auto-generated method stub
		AudioManager.playSFX(ResourceManager.readAudioClip("bomb.mp3"), 0.4);
	}
}
