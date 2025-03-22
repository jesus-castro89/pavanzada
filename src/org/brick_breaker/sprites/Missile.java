package org.brick_breaker.sprites;

import java.awt.*;

/**
 * Clase que representa un misil.
 */
public class Missile extends MovingSprite {

    /**
     * Ancho del sprite del misil.
     */
    public static final int MISSILE_WIDTH = 16;
    /**
     * Alto del sprite del misil.
     */
    public static final int MISSILE_HEIGHT = 37;
    /**
     * Velocidad del misil.
     */
    public static final int MISSILE_SPEED = 5;
    /**
     * Tamaño del misil.
     */
    public static final Dimension MISSILE_SIZE = new Dimension(MISSILE_WIDTH, MISSILE_HEIGHT);
    /**
     * Indica si el misil ha sido destruido.
     */
    private boolean destroyed;

    /**
     * Constructor de la clase.
     *
     * @param position Posición inicial del misil.
     */
    public Missile(Point position) {

        super(position, "missile", MISSILE_SIZE, 0, MISSILE_SPEED);
        this.destroyed = false;
    }

    @Override
    public void move() {

        position.y += dy;
    }

    @Override
    public void addImageToCache() {

    }

    // Getters y setters
    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
