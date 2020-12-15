package logic;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;

public interface Renderable {
	public Rectangle2D getBoundary();

	public void render(GraphicsContext gc);

	public boolean intersects(Sprite s);
}
