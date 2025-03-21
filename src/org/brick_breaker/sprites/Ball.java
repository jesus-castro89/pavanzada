package org.brick_breaker.sprites;

import java.awt.*;

public class Ball extends MovingSprite {

    public static final int BALL_WIDTH = 20;
    public static final int INITIAL_BALL_X = 224;
    public static final int INITIAL_BALL_Y = 585;
    public static final Point INITIAL_BALL_POSITION =
            new Point(INITIAL_BALL_X, INITIAL_BALL_Y);
    public static final Dimension BALL_SIZE =
            new Dimension(BALL_WIDTH, BALL_WIDTH);
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
    public void draw(Graphics g) {

    }
}
