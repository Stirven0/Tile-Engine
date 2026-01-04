package tile.engine;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class SpriteSheet {
    private final Image image;
    private final int frameW, frameH;

    public SpriteSheet(Image image, int frameW, int frameH) {
        this.image = image;
        this.frameW = frameW;
        this.frameH = frameH;
    }

    public WritableImage getFrame(int col, int row) {
        return new WritableImage(
            image.getPixelReader(),
            col * frameW,
            row * frameH,
            frameW,
            frameH
        );
    }
}
