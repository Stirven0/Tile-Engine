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
        Scene scene = new Scene(new StackPane(canvas));
        Input.attach(scene);

        AnimationTimer loop = new AnimationTimer() {

            @Override
            public void handle(long now) {

                int dx = 0, dy = 0;

                if(Input.isDown("A") || Input.isDown("LEFT")) dx--;
                if(Input.isDown("D") || Input.isDown("RIGHT")) dx++;
                if(Input.isDown("W") || Input.isDown("UP")) dy--;
                if(Input.isDown("S") || Input.isDown("DOWN")) dy++;

                cam.moved(dx, dy, map);

                canvas.getGraphicsContext2D().clearRect(0, 0, 320, 240);

                Renderer.render(canvas.getGraphicsContext2D(), map, cam);
            }
            
        };
        loop.start();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tile Engeni - Face 2 (Camara)");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
