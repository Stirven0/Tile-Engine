package tile.engine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Player {
    public double x, y;
    public final int width = 12;
    public final int height = 12;
    public final double speed = 1.5;

    public Player(double startX, double startY){
        this.x = startX;
        this.y = startY;
    }

    public void update(TileMap map){
        double dx = 0, dy = 0;

        if(Input.isDown("A") || Input.isDown("LEFT")) dx--;
        if(Input.isDown("D") || Input.isDown("RIGHT")) dx++;
        if(Input.isDown("W") || Input.isDown("UP")) dy--;
        if(Input.isDown("S") || Input.isDown("DOWN")) dy++;

        if (dx != 0 && dy != 0) {
            dx *= 0.7071;
            dy *= 0.7071;
        }

        // x += dx *speed;
        // y += dy *speed;
        movedX(dx * speed, map);
        movedY(dy * speed, map);

        // esto no deja que el personaje salga por fuera del limite del mundo 

        // int maxX = TileMap.MAP_WIDTH * TileMap.TILE_SIZE - width;
        // int maxY = TileMap.MAP_HEIGHT * TileMap.TILE_SIZE - height;
        // if (x<0) x=0;
        // if (y<0) y=0;
        // if (x>maxX) x=maxX;
        // if (y>maxY) y=maxY;
    }

    private void movedX(double dx, TileMap map) {
        x += dx;
        if (collides(map)) x -= dx;
    }

    private void movedY(double dy, TileMap map) {
        y += dy;
        if (collides(map)) y -= dy;
    }

    private boolean collides(TileMap map) {
        int left = (int)(x / TileMap.TILE_SIZE);
        int right = (int)((x + width) / TileMap.TILE_SIZE);
        int top = (int)(y / TileMap.TILE_SIZE);
        int bottom = (int)((y + height) / TileMap.TILE_SIZE);

        for (int ty = top; ty <= bottom; ty++) {
            for (int tx = left; tx <= right; tx++) {
                int tile = map.getTile(tx, ty);
                if(tile !=-1 && map.isSolid(tile)) return true;
            }
        }
        return false;
    }

    public void render(GraphicsContext gc, Camera cam) {
        gc.setFill(Color.RED);
        gc.fillRect(x - cam.x, y - cam.y, width, height);
    }
}
