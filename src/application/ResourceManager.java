package application;

import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

public class ResourceManager {
	//inner class for load resource
//	public static TitleResource title;
//	public static ;
//	
//	
//	public static class TitleResource{
//		
//		
//		
//	}
	
	
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