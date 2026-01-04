package tile.engine;

public class Camera {
    public int x, y;
    public final int width = 320;
    public final int height = 240;
    // public final int speed = 2;

    // public void moved(int dx, int dy, TileMap map) {
    //     x += dx * speed;
    //     y += dy * speed;

    //     int maxX = TileMap.MAP_WIDTH * TileMap.TILE_SIZE - width;
    //     int maxy = TileMap.MAP_HEIGHT * TileMap.TILE_SIZE - height;

    //     if (x<0) x=0;
    //     if (y<0) y=0;
    //     if (x>maxX) x=maxX;
    //     if (y>maxy) y=maxy;
    // }
    public void follow(Player player, TileMap map) {
        x = (int)(player.x + player.width/2 - width/2);
        y = (int)(player.y + player.width/2 - width/2);

        int maxX = TileMap.MAP_WIDTH * TileMap.TILE_SIZE - width;
        int maxY = TileMap.MAP_HEIGHT * TileMap.TILE_SIZE - height;
        if (x<0) x=0;
        if (y<0) y=0;
        if (x>maxX) x=maxX;
        if (y>maxY) y=maxY;
    }
}
