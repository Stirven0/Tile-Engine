package tile.engine;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Player extends Entity {
    double speed = 100;
    // boolean up, down, left, right;
    Animator animator;

    public Player(double startX, double startY) {
        this.x = startX;
        this.y = startY;
        this.animator = new Animator(new Image(""));
    }

    @Override
    public void update(double td, TileMap map) {
        double nx = x, ny = y;
        boolean moving = false;

        // if (up)
            // ny -= speed * td;
        // if (down)
            // ny += speed * td;
        // if (left)
        //     nx -= speed * td;
        // if (right)
        // nx += speed * td;
        
        if (Input.isDown("A") || Input.isDown("LEFT")) {
            // nx--;
            nx -= speed * td;
            animator.dir = Direction.LEFT;
            moving = true;
        }
        if (Input.isDown("D") || Input.isDown("RIGHT")) {
            // nx++;
            nx += speed * td;
            animator.dir = Direction.RIGHT;
            moving = true;
        }
        if (Input.isDown("W") || Input.isDown("UP")) {
            // ny--;
            ny -= speed * td;
            animator.dir = Direction.UP;
            moving = true;
        }
        if (Input.isDown("S") || Input.isDown("DOWN")) {
            // ny++;
            ny += speed * td;
            animator.dir = Direction.DOWN;
            moving = true;
        }

        if (!map.collides(nx, y, width, height))
            x = nx;
        if (!map.collides(x, ny, width, height))
            y = ny;

        // if (nx != 0 && ny != 0) {
        // nx *= 0.7071;
        // ny *= 0.7071;
        // }
    }

    @Override
    public void render(GraphicsContext gc, Camera cam) {
        // gc.setFill(Color.RED);
        // gc.fillRect(x - cam.x, y - cam.y, width, height);

        gc.drawImage(animator.getFrame(), x - cam.x, y - cam.y);
    }
}
