package tile.engine;

public class TileMap {
    public static final int TILE_SIZE = 16;
    public static final int MAP_WIDTH = 100;
    public static final int MAP_HEIGHT = 100;

    private final Tile[][] map = new Tile[MAP_HEIGHT][MAP_WIDTH];

    public TileMap(){
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {

                map[y][x] = new Tile();

                if(x == 0 || y == 0 || x == MAP_WIDTH-1 || y == MAP_HEIGHT-1){
                    map[y][x].id = 2; // muro
                    map[y][x].solid = true;
                }else{
                    map[y][x].id = 1; // solo pasto
                }
            }
        }
    }

    public boolean collides(double x, double y, double w, double h) {
        int left = (int)(x / TILE_SIZE);
        int right = (int)((x + w - 1) / TILE_SIZE);
        int top = (int)(y / TILE_SIZE);
        int bottom = (int)((y + h - 1) / TILE_SIZE);

        for (int ty = top; ty <= bottom; ty++) {
            for (int tx = left; tx <= right; tx++) {
                Tile t = getTile(tx, ty);
                if (t != null && t.solid) return true;
            }
        }
        return false;
    }

    public Tile getTile(int x, int y){
        if (x < 0 || y < 0 || x >= MAP_WIDTH || y >= MAP_HEIGHT) {
            return null;
        }
        return map[y][x];
    }

    public boolean isSolid(int idTile) {
        return idTile == 2;
    }
}
