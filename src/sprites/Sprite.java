package sprites;

import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public class Sprite implements Renderable {
	protected Image image;
	protected double positionX;
	protected double positionY;
	protected double width;
	protected double height;

	// Constructor
	public Sprite(double positionX, double positionY, double width, double height) {
		setPositionX(positionX);
		setPositionY(positionY);
		setWidth(width);
		setHeight(height);
	}

	// Addition Method
	public void render(GraphicsContext gc) {
		gc.drawImage(image, positionX, positionY);
	}

	public void render(GraphicsContext gc, double width, double height) {
		gc.drawImage(image, positionX, positionY, width, height);
	}

	public Rectangle2D getBoundary() {
		return new Rectangle2D(positionX, positionY, width, height);
	}

	public boolean intersects(Sprite s) {
		return s.getBoundary().intersects(this.getBoundary());
	}

	// Getter &Setter
	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public void setPosition(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
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

	public void setSize(double width, double height) {
		this.width = width;
		this.height = height;
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
