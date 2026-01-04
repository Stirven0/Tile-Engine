package tile.engine;

import java.util.HashSet;
import java.util.Set;

import javafx.scene.Scene;

public class Input {
    private static final Set<String> keys = new HashSet<>();

    public static void attach(Scene scene){
        scene.setOnKeyPressed(e -> keys.add(e.getCode().toString()));
        scene.setOnKeyReleased(e -> keys.remove(e.getCode().toString()));
    }
    public static boolean isDown(String key){return keys.contains(key);}
}
