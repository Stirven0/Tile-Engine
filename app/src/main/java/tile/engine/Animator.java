package tile.engine;

import javafx.scene.image.Image;

public class Animator {
    private final SpriteSheet sheet;
    private int frame;
    private double timer;

    private double frameTime = 0.15;

    public AnimState state = AnimState.IDLE;
    public Direction dir = Direction.DOWN;

    public Animator(Image spriteSheet) {
        this.sheet = new SpriteSheet(spriteSheet, 16, 16);
    }

    public void update(double dt, boolean moving) {
        state = moving ? AnimState.WALK : AnimState.IDLE;
        if (state == AnimState.IDLE) {
            frame = 0;
            return;
        }
        timer += dt;
        if (timer >= frameTime) {
            frame = ( frame + 1) % 4;
            timer = 0;
        }
    }
    public Image getFrame() {
        int row = switch(dir){
            case DOWN -> 0;
            case LEFT -> 1;
            case RIGHT -> 2;
            case UP -> 3;
        };
        return sheet.getFrame(frame, row);
    }
}
