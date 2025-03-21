package org.brick_breaker.utils;

import org.brick_breaker.game.Level;

import java.io.*;
import javax.swing.*;

public class FileManager {

    public static void main(String[] args) {

        Level level = new Level("background2.png", "level2.wav");
        FileManager fileManager = new FileManager();
        fileManager.writeLevel(level, 2);
        System.out.println("---NIVEL GUARDADO CON ÉXITO---");
        /*FileManager fileManager = new FileManager();
        Level level = fileManager.readLevel(1);
        System.out.println(level);*/
    }

    public Level readLevel(int currentLevel) {

        Level level = null;
        InputStream file = null;
        InputStream buffer = null;
        ObjectInput input = null;
        try {

            file = new FileInputStream("levels/level" + currentLevel + ".lvl");
            buffer = new BufferedInputStream(file);
            input = new ObjectInputStream(buffer);
            level = (Level) input.readObject();
            input.close();
            buffer.close();
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (file != null) {
                try {
                    file.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return level;
    }

    public void writeLevel(Level level, int curentLevel) {

        OutputStream file = null;
        OutputStream buffer = null;
        ObjectOutputStream output = null;
        try {

            file = new FileOutputStream("levels/level" + curentLevel + ".lvl");
            buffer = new BufferedOutputStream(file);
            output = new ObjectOutputStream(buffer);
            output.writeObject(level);
            output.close();
            buffer.close();
            file.close();
        } catch (Exception e1) {

            e1.printStackTrace();
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (file != null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}