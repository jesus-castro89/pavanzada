package org.brick_breaker.sprites;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.ui.panels.GamePanel;
import org.brick_breaker.utils.EdgeType;
import org.brick_breaker.utils.colissions.CollisionListener;
import org.brick_breaker.utils.colissions.CollisionManager;

import javax.swing.*;
import java.awt.*;

public class Ball extends MovingSprite implements Resettable, CollisionListener {
    /**
     * Ancho de la pelota.
     */
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
        speed = 3;
        stop = false;
        dxStop = 0;
        CollisionManager.getInstance().addListener(this);
    }

    @Override
    public void onCollisionDetected(Sprite collider, Sprite collidedWith, EdgeType edgeType) {

        if (collider == this) {
            // Se ajusta la posición de la pelota para que no se quede pegada al borde del objeto con el que colisionó.
            switch (edgeType) {

                case LEFT_EDGE -> getPosition().x = collidedWith.getPosition().x - getImageIcon().getIconWidth();
                case RIGHT_EDGE -> getPosition().x = collidedWith.getPosition().x + collidedWith.getSize().width;
                case TOP_EDGE -> getPosition().y = collidedWith.getPosition().y - getImageIcon().getIconHeight();
                case BOTTOM_EDGE -> getPosition().y = collidedWith.getPosition().y + collidedWith.getSize().height;
            }
            // Se invierte la dirección de la pelota al colisionar con un borde o un ladrillo.
            switch (edgeType) {
                case LEFT_EDGE, RIGHT_EDGE -> setDx(-getDx());
                case TOP_EDGE, BOTTOM_EDGE -> setDy(-getDy());
            }
            // Se determina el tipo de objeto con el que colisiona la pelota.
            switch (collidedWith.getClass().getSimpleName()) {
                // Si es un ladrillo, se indicará al panel que lo elimine.
                case "Brick" -> {
                    ((Brick) collidedWith).hit();
                    if (((Brick) collidedWith).isDestroyed()) {
                        GamePanel.removeBrick((Brick) collidedWith);
                    }
                }
                // Si es un borde y además es el borde inferior, se eliminará la pelota.
                case "Borders" -> {
                    if (collidedWith == Borders.BOTTOM_BAR) {
                        GamePanel.removeBall(this);
                    }
                }
            }
        }
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
        position.x = INITIAL_BALL_X;
        position.y = INITIAL_BALL_Y;
        // Se reinicia la velocidad de la pelota.
        speed = 3;
        // Se reinicia la dirección de la pelota.
        dx = 1;
        dy = -1;
        // Se reinicia el estado de la pelota.
        // stop = true;
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
