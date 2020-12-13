package application;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class ResourceManager {
	private Image image;
	private Media media;
	private AudioClip audioClip;
	
	public ResourceManager() {
		// TODO Auto-generated constructor stub
	}
	
	
	private static Image readImg(String filename) {
		return new Image(ClassLoader.getSystemResource(filename).toString());
	}
	
	private static Media readMedia(String filename) {
		return new Media(ClassLoader.getSystemResource(filename).toString());
	}

	private static AudioClip readAudioClip(String filename) {
		return new AudioClip(ClassLoader.getSystemResource(filename).toString());
	}
}
