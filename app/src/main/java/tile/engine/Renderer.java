package tile.engine;

import javafx.scene.canvas.GraphicsContext;

public class Renderer {
    public static void render(
            GraphicsContext gc,
            TileMap map,
            Camera cam){

        int startX = cam.x / TileMap.TILE_SIZE;
        int startY = cam.y / TileMap.TILE_SIZE;

        int endX = (cam.x + cam.width) / TileMap.TILE_SIZE + 1;
        int endY = (cam.y + cam.height) / TileMap.TILE_SIZE + 1;

        for (int ty = startY; ty < endY; ty++) {
            for (int tx = startX; tx < endX; tx++) {
                if (map.getTile(tx, ty) == null) continue;

                int[][] tile = TileGenerator.generateGrassTile(tx, ty);
                int px = tx * TileMap.TILE_SIZE - cam.x;
                int py = ty * TileMap.TILE_SIZE - cam.y;

                TileRenderer.renderTile(gc, tile, 1, px, py);
            }
        }
    }
}
