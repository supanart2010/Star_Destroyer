package application;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class AudioManager {

	private static final double GLOBAL_VOLUME = 0.5;

	private static MediaPlayer bgmPlayer;

	private static boolean isBGMPlaying() {
		return bgmPlayer != null;
	}
	
	public static Media getCurrentBGM() {
		return isBGMPlaying() ? bgmPlayer.getMedia() : null;
	}
	
	public static void playBGM(Media bgm, double localVolume, boolean isLoop) {
		if (bgm == null) {
			stopBGM();
		} else if (!bgm.equals(getCurrentBGM())) {
			stopBGM();
			bgmPlayer = new MediaPlayer(bgm);
			bgmPlayer.setVolume(GLOBAL_VOLUME * localVolume);
			if (isLoop) {
				bgmPlayer.setCycleCount(MediaPlayer.INDEFINITE);
			}
			bgmPlayer.play();
		}
	}
	
	public static void stopBGM() {
		if (isBGMPlaying()) {
			bgmPlayer.stop();
			bgmPlayer = null;
		}
	}
	
	//method for sound effect ex. bullets bomb //maybe cut off
	public static void playSFX(AudioClip sfx, double localVolume) {
		sfx.setVolume(GLOBAL_VOLUME * localVolume);
		sfx.play();
	}
	
	
	
}
