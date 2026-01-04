package tile.engine;

public class TileMap {
    public static final int TILE_SIZE = 16;
    public static final int MAP_WIDTH = 100;
    public static final int MAP_HEIGHT = 100;

    private final int[][] map = new int[MAP_HEIGHT][MAP_WIDTH];

    public TileMap(){
        for (int y = 0; y < MAP_HEIGHT; y++) {
            for (int x = 0; x < MAP_WIDTH; x++) {
                if(x == 0 || y == 0 || x == MAP_WIDTH-1 || y == MAP_HEIGHT-1){
                    map[y][x] = 2; // muro
                }else{
                    map[y][x] = 1; // solo pasto
                }
            }
        }
    }

    public int getTile(int x, int y){
        if (x < 0 || y < 0 || x >= MAP_WIDTH || y >= MAP_HEIGHT) {
            return -1;
        }
        return map[y][x];
    }

    public boolean isSolid(int idTile) {
        return idTile == 2;
    }
}
