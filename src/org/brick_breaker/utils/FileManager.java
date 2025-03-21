package org.brick_breaker.utils;

import org.brick_breaker.game.Level;

import java.io.*;
import javax.swing.*;

public class FileManager {

    public static Level readLevel(int currentLevel) {

        Level level = null;
        InputStream file = null;
        InputStream buffer = null;
        ObjectInput input = null;
        try {

            file = new FileInputStream("levels/level_" + currentLevel + ".lvl");
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            level = (Level) input.readObject();
            input.close();
            buffer.close();
            file.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Error al cargar el nivel: " + currentLevel,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return level;
    }

    public static void writeLevel(Level level) {

        OutputStream file = null;
        OutputStream buffer = null;
        ObjectOutputStream output = null;
        try {

            file = new FileOutputStream(
                    "levels/level_" + level.getCurrentLevel() + ".lvl");
            buffer = new BufferedOutputStream(file);
            output = new ObjectOutputStream(buffer);
            output.writeObject(level);
            output.close();
            buffer.close();
            file.close();
            JOptionPane.showMessageDialog(null,
                    "Nivel guardado: " + level.getCurrentLevel(),
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e1) {

            JOptionPane.showMessageDialog(null,
                    "Error al guardar el nivel: " + level.getCurrentLevel(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}