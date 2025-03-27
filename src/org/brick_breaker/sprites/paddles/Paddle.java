package org.brick_breaker.sprites.paddles;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.sprites.MovingSprite;
import org.brick_breaker.sprites.Resettable;

import java.awt.*;

public class Paddle extends MovingSprite implements Resettable {

    public static final int INITIAL_PADDLE_X = 202;
    public static final int INITIAL_PADDLE_Y = 604;
    public static final Point INITIAL_PADDLE_POSITION =
            new Point(INITIAL_PADDLE_X, INITIAL_PADDLE_Y);
    private PaddleType type;

    public Paddle(PaddleType type) {

        super(INITIAL_PADDLE_POSITION, type.getImageName(), type.getSize(), 0, 0);
        this.type = type;
    }

    @Override
    public void move() {

    }

    @Override
    protected void addImageToCache() {

        SpriteCache spriteCache = SpriteCache.getInstance();
        spriteCache.addImage(PaddleType.SMALL.getImageName(),
                SpriteLoader.loadImage("paddle.png"));
        spriteCache.addImage(PaddleType.MEDIUM.getImageName(),
                SpriteLoader.loadImage("paddle.png"));
        spriteCache.addImage(PaddleType.LARGE.getImageName(),
                SpriteLoader.loadImage("paddle-large.png"));
        spriteCache.addImage(PaddleType.SHOOTER.getImageName(),
                SpriteLoader.loadImage("paddle-laser.png"));
    }

    // Getters y setters
    public PaddleType getType() {
        return type;
    }

    public void changeType(PaddleType type) {

        this.type = type;
        this.size = type.getSize();
    }

    @Override
    public void resetPosition() {

    }
}
