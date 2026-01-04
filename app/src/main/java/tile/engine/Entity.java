package tile.engine;

import javafx.scene.canvas.GraphicsContext;

public abstract class Entity {
    public double x, y;
    public final int width = 12;
    public final int height = 12;

    abstract void update(double dt, TileMap map);
    abstract void render(GraphicsContext gc, Camera cam);
}
