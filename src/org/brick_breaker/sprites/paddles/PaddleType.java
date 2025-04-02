package org.brick_breaker.sprites.paddles;

import java.awt.*;

public enum PaddleType {
    SMALL(new Dimension(32, 16)),
    MEDIUM(new Dimension(64, 16)),
    LARGE(new Dimension(128, 16)),
    SHOOTER(new Dimension(64, 16));

    private final Dimension size;

    PaddleType(Dimension size) {
        this.size = size;
    }

    public Dimension getSize() {
        return size;
    }

    public String getImageName() {
        return name().toLowerCase() + "Paddle";
    }
}
