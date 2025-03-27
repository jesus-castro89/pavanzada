package org.brick_breaker.sprites;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Ball extends MovingSprite {

    public static final int BALL_WIDTH = 20;
    public static final int INITIAL_BALL_X = 224;
    public static final int INITIAL_BALL_Y = 585;
    public static final Point INITIAL_BALL_POSITION = new Point(INITIAL_BALL_X, INITIAL_BALL_Y);
    public static final Dimension BALL_SIZE = new Dimension(BALL_WIDTH, BALL_WIDTH);
    private int speed;
    private boolean stop;
    private int dxStop;

    public Ball() {
        super(INITIAL_BALL_POSITION, "ball",
                BALL_SIZE, 1, -1);
        this.speed = 3;
        this.stop = true;
        this.dxStop = 0;
    }

    public void draw(Graphics2D g2d, ImageObserver observer) {

        SpriteCache cache = SpriteCache.getInstance();
        ImageIcon ballIcon = cache.getImage(getImageName(), true);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.drawImage(ballIcon.getImage(), position.x, position.y, observer);
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
    public void addImageToCache() {

        SpriteCache.getInstance().addImage("ball",
                SpriteLoader.loadGif("ball.gif"));
    }

    // Getters y setters
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public int getDxStop() {
        return dxStop;
    }

    public void setDxStop(int dxStop) {
        this.dxStop = dxStop;
    }
}
