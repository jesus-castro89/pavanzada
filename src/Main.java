import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.ui.windows.MainWindow;
import org.brick_breaker.ui.windows.StartWindow;
import org.brick_breaker.utils.FileManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*ArrayList<Level> levels = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Level level = new Level();
            FileManager.writeLevel(level);
        }*/

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new StartWindow();
            }
        });
    }
}
