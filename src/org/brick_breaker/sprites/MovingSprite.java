package org.brick_breaker.sprites;

import java.awt.*;

public abstract class MovingSprite extends Sprite {

    protected int dx;
    protected int dy;

    public MovingSprite(Point position, String imageName, Dimension size, int dx, int dy) {
        super(position, imageName, size);
        this.dx = dx;
        this.dy = dy;
    }

    public abstract void move();
}
