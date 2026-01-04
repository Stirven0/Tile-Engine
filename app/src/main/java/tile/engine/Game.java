package tile.engine;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {

        Canvas canvas = new Canvas(320, 240);

        TileMap map = new TileMap();
        Camera cam = new Camera();

        AnimationTimer loop = new AnimationTimer() {

            @Override
            public void handle(long now) {
                Renderer.render(canvas.getGraphicsContext2D(), map, cam);
            }
            
        };
        loop.start();
        primaryStage.setScene(new Scene(new StackPane(canvas)));
        primaryStage.setTitle("Tile Engeni Demo");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
