package org.brick_breaker.sprites;

import java.awt.*;

/**
 * Clase que representa un sprite móvil en el juego.
 */
public abstract class MovingSprite extends Sprite {

    /**
     * Velocidad de movimiento en el eje X.
     */
    protected int dx;
    /**
     * Velocidad de movimiento en el eje Y.
     */
    protected int dy;

    /**
     * Constructor de la clase.
     *
     * @param position  Posición del sprite.
     * @param imageName Nombre de la imagen del sprite.
     * @param size      Tamaño del sprite.
     * @param dx        Velocidad de movimiento en el eje X.
     * @param dy        Velocidad de movimiento en el eje Y.
     */
    public MovingSprite(Point position, String imageName, Dimension size, int dx, int dy) {

        super(position, imageName, size);
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Función que se encarga de mover el sprite.
     */
    public abstract void move();

    // Getters y Setters
    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
