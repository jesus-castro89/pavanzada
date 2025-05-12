package org.brick_breaker.sprites.bricks;

import org.brick_breaker.sprites.Sprite;
import org.brick_breaker.utils.collisions.CollisionManager;

import java.awt.*;
import java.io.Serializable;

/**
 * Clase que representa un ladrillo en el juego.
 */
public class Brick extends Sprite implements Serializable {
    /**
     * Ancho del ladrillo.
     */
    public final static int BRICK_WIDTH = 42;
    /**
     * Alto del ladrillo.
     */
    public final static int BRICK_HEIGHT = 20;
    /**
     * Tamaño del ladrillo.
     */
    public final static Dimension BRICK_SIZE = new Dimension(BRICK_WIDTH, BRICK_HEIGHT);
    /**
     * Tipo de ladrillo.
     */
    private final BrickType type;
    /**
     * Vida actual del ladrillo.
     */
    private int life;
    /**
     * Bandera que indica si el ladrillo ha sido destruido.
     */
    private boolean destroyed;

    /**
     * Constructor del ladrillo que requiere la posición, nombre de la imagen, tamaño y tipo del ladrillo.
     *
     * @param position  Posición del ladrillo.
     * @param imageName Nombre de la imagen del ladrillo.
     * @param type      Tipo del ladrillo.
     */
    public Brick(Point position, String imageName, BrickType type) {
        super(position, imageName, BRICK_SIZE);
        this.type = type;
        this.life = type.getLife();
        this.destroyed = false;
    }

    @Override
    public void addImageToCache() {
        if (type != null)
            type.loadSprite(imageName);
    }

    public void hit() {
        life--;
        if (life == 0) {
            destroyed = true;
            CollisionManager.getInstance().unregisterCollidable(this);
        }
    }

    @Override
    public String toString() {
        return type.toString();
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public int getScore() {
        return type.getScore();
    }

    public BrickType getType() {
        return type;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }
}
