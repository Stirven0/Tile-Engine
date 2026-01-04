package tile.engine;

public class TileGenerator {

    public static final int SIZE = 16;

    public static int[][] generateGrassTile(int tileX, int tileY) {

        int[][] tile = new int[SIZE][SIZE];

        int seed = (tileX * 73856093) ^ (tileY * 19349663);

        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {

                int hash = (x * 374761393 + y * 668265263) ^ seed;
                hash = (hash ^ (hash >> 13)) * 1274126177;

                int r = hash & 0xFF;

                if (r < 18)        tile[y][x] = 1;   // sombra
                else if (r < 36)   tile[y][x] = 3;   // brillo
                else if (r < 48)   tile[y][x] = 13;  // seco
                else if (r < 60)   tile[y][x] = 14;  // húmedo
                else               tile[y][x] = 2;   // base
            }
        }

        return tile;
    }
}
