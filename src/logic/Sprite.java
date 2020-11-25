package logic;

import javafx.scene.image.Image;

public class Sprite {
	protected Image image;
	protected double positionX;
	protected double positionY;
	protected double width;
	protected double height;
	
	public Sprite(double positionX, double positionY, double width, double height){
		setPositionX(positionX);
		setPositionY(positionY);
		setWidth(width);
		setHeight(height);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

}
