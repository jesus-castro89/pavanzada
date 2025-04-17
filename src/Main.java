import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.ui.windows.MainWindow;
import org.brick_breaker.utils.FileManager;

import javax.swing.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        //Level level = new Level();
        //FileManager.writeLevel(level);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow.getInstance().startGame();
            }
        });
    }
}
