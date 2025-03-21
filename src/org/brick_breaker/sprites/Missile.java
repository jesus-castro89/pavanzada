package org.brick_breaker.sprites;

import java.awt.*;

public class Missile extends MovingSprite {

    public static final int MISSILE_WIDTH = 16;
    public static final int MISSILE_HEIGHT = 37;
    public static final int MISSILE_SPEED = 5;
    public static final Dimension MISSILE_SIZE =
            new Dimension(MISSILE_WIDTH, MISSILE_HEIGHT);
    private boolean destroyed;

    public Missile(Point position) {

        super(position, "missile", MISSILE_SIZE, 0, MISSILE_SPEED);
        this.destroyed = false;
    }

    @Override
    public void move() {

        position.y += dy;
    }

    @Override
    public void draw(Graphics g) {

    }
}
