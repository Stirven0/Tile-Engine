package tile.engine;

import javafx.scene.canvas.GraphicsContext;

public class TileRenderer {

    public static void renderTile(
            GraphicsContext gc,
            int[][] tile,
            int pixelScale,
            int offsetX,
            int offsetY) {

        for (int y = 0; y < tile.length; y++) {
            for (int x = 0; x < tile[y].length; x++) {
                gc.setFill(Palette.COLORS[tile[y][x]]);
                gc.fillRect(
                        offsetX + x * pixelScale,
                        offsetY + y * pixelScale,
                        pixelScale,
                        pixelScale
                );
            }
        }
    }
}
