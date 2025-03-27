package org.brick_breaker.game;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.sprites.bricks.BrickType;
import org.brick_breaker.utils.Randomized;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Clase que representa un nivel en el juego.
 */
public class Level implements Serializable {

    /**
     * Margen entre los ladrillos en el eje X.
     */
    public static final int ROW_MARGIN = 18;
    /**
     * Margen entre los ladrillos en el eje Y.
     */
    public static final int COLUMN_MARGIN = 19;
    /**
     * Ancho del nivel en bloques.
     */
    public static final int LEVEL_WIDTH = 10;
    /**
     * Alto del nivel en bloques.
     */
    public static final int LEVEL_HEIGHT = 10;
    /**
     * Contador de niveles.
     */
    public static int levelNumber = 1;
    /**
     * Matriz de ladrillos que conforman el nivel.
     */
    private Brick[][] bricks;
    /**
     * Nombre de la imagen de fondo del nivel.
     */
    private String backgroundName;
    /**
     * Nombre de la música del nivel.
     */
    private String musicName;
    /**
     * Nivel actual.
     */
    private int currentLevel;

    static {
        SpriteCache spriteCache = SpriteCache.getInstance();
        spriteCache.addImage("red_brick", SpriteLoader.loadImage("brick-red.png"));
        spriteCache.addImage("blue_brick", SpriteLoader.loadImage("brick-blue.png"));
        spriteCache.addImage("green_brick", SpriteLoader.loadImage("brick-green.png"));
        spriteCache.addImage("yellow_brick", SpriteLoader.loadImage("brick-yellow.png"));
    }

    /**
     * Constructor de la clase.
     *
     * @param backgroundName Nombre de la imagen de fondo del nivel.
     * @param musicName      Nombre de la música del nivel.
     */
    public Level(String backgroundName, String musicName) {

        this.backgroundName = backgroundName;
        this.musicName = musicName;
        bricks = new Brick[LEVEL_WIDTH][LEVEL_HEIGHT];
        currentLevel = levelNumber++;
        populateLevel();
    }

    /**
     * Función que se encarga de generar la matriz de ladrillos del nivel.
     */
    private void populateLevel() {

        BrickType brickType;
        Point position;
        for (int row = 0; row < LEVEL_WIDTH; row++) {

            for (int column = 0; column < LEVEL_HEIGHT; column++) {

                // Se genera un número aleatorio para seleccionar un tipo de ladrillo.
                brickType = BrickType.values()[Randomized.randomInt(0, BrickType.values().length - 1)];
                // Se generá la posición del ladrillo.
                position = new Point(column * Brick.BRICK_WIDTH + ROW_MARGIN,
                        row * Brick.BRICK_HEIGHT + COLUMN_MARGIN);
                // Se crea el ladrillo según el tipo.
                switch (brickType) {

                    case RED -> bricks[row][column] = new Brick(position, "red_brick", BrickType.RED);
                    case BLUE -> bricks[row][column] = new Brick(position, "blue_brick", BrickType.BLUE);
                    case GREEN -> bricks[row][column] = new Brick(position, "green_brick", BrickType.GREEN);
                    case YELLOW -> bricks[row][column] = new Brick(position, "yellow_brick", BrickType.YELLOW);
                }
            }
        }
    }

    // Getters y Setters
    public Brick[][] getBricks() {
        return bricks;
    }

    public void setBricks(Brick[][] bricks) {
        this.bricks = bricks;
    }

    public String getBackgroundName() {
        return backgroundName;
    }

    public void setBackgroundName(String backgroundName) {
        this.backgroundName = backgroundName;
    }

    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}
