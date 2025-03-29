package org.brick_breaker.sprites;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;

import javax.swing.*;
import java.awt.*;

public class Ball extends MovingSprite implements Resettable {

    public static final int BALL_WIDTH = 20;
    public static final int INITIAL_BALL_X = 224;
    public static final int INITIAL_BALL_Y = 570;
    public static final Point INITIAL_BALL_POSITION = new Point(INITIAL_BALL_X, INITIAL_BALL_Y);
    public static final Dimension BALL_SIZE = new Dimension(BALL_WIDTH, BALL_WIDTH);
    private int speed;
    private boolean stop;
    private int dxStop;

    public Ball() {

        super(INITIAL_BALL_POSITION, "ball", BALL_SIZE, 1, -1);
        this.speed = 3;
        this.stop = true;
        this.dxStop = 0;
    }

    @Override
    public void draw(Graphics2D g2d) {

        g2d.drawImage(getImageIcon().getImage(), position.x, position.y, null);
    }

    @Override
    public void move() {

        if (!stop) {
            position.x += dx * speed;
            position.y += dy * speed;
        } else {
            position.x += dxStop * speed;
        }
    }

    @Override
    public void resetPosition() {

        // Se reinicia la posición de la pelota a la posición inicial.
        position = new Point(INITIAL_BALL_X, INITIAL_BALL_Y);
        // Se reinicia la velocidad de la pelota.
        speed = 3;
        // Se reinicia la dirección de la pelota.
        dx = 1;
        dy = -1;
        // Se reinicia el estado de la pelota.
        stop = true;
    }

    @Override
    public void addImageToCache() {

        SpriteCache.getInstance().addImage(imageName, SpriteLoader.loadGif("ball.gif"));
    }

    public ImageIcon getImageIcon() {

        return SpriteCache.getInstance().getImageIcon(getImageName());
    }

    // Getters y setters
    public void setStop(boolean stop) {
        this.stop = stop;
    }
}
