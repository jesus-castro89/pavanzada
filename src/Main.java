import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.ui.windows.MainWindow;
import org.brick_breaker.utils.FileManager;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

//        Level level = new Level("background",
//                "music");
//        FileManager.writeLevel(level);
//        level = FileManager.readLevel(1);
//        for(Brick[] row : level.getBricks()) {
//            System.out.println(Arrays.toString(row));
//        }
        new MainWindow();
    }
}
