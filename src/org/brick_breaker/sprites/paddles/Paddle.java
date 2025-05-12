package org.brick_breaker.sprites.paddles;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.sprites.Borders;
import org.brick_breaker.sprites.MovingSprite;
import org.brick_breaker.sprites.Resettable;
import org.brick_breaker.ui.panels.GamePanel;

import java.awt.*;

public class Paddle extends MovingSprite implements Resettable {

    private static final int SPEED = 3;
    public static final int INITIAL_PADDLE_X = 202;
    public static final int INITIAL_PADDLE_Y = 588;
    public static final Point INITIAL_PADDLE_POSITION =
            new Point(INITIAL_PADDLE_X, INITIAL_PADDLE_Y);
    private PaddleType type;

    public Paddle(PaddleType type) {

        super(INITIAL_PADDLE_POSITION, type.getImageName(), type.getSize(), 0, 0);
        this.type = type;
    }

    @Override
    public void move() {
        if (dx != 0) {
            position.x += dx * SPEED;
            if (position.x < Borders.LEFT_BAR.getImage().getWidth()) {
                position.x = Borders.LEFT_BAR.getImage().getWidth();
            } else if (position.x > GamePanel.GAME_WIDTH - getImage().getWidth()) {
                position.x = GamePanel.GAME_WIDTH - getImage().getWidth();
            }
        }
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
    public void changeType(PaddleType type) {

        this.type = type;
        this.imageName = type.getImageName();
        setSize(type.getSize());
    }

    public PaddleType getType() {
        return type;
    }

    @Override
    public void resetPosition() {
        position.x = INITIAL_PADDLE_X;
        position.y = INITIAL_PADDLE_Y;
        dy = 0;
        dx = 0;
        changeType(PaddleType.MEDIUM);
    }
}
