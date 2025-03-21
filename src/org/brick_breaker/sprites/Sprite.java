package org.brick_breaker.sprites;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * Clase que representa un sprite en el juego.
 */
public abstract class Sprite {

    /**
     * Posición del sprite.
     */
    protected Point position;
    /**
     * Nombre de la imagen del sprite.
     */
    protected String imageName;
    /**
     * Tamaño del sprite.
     */
    protected Dimension size;

    /**
     * Constructor de la clase.
     *
     * @param position  Posición del sprite.
     * @param imageName Nombre de la imagen del sprite.
     * @param size      Tamaño del sprite.
     */
    public Sprite(Point position, String imageName, Dimension size) {
        this.position = position;
        this.imageName = imageName;
        this.size = size;
    }

    /**
     * Función que se encarga de dibujar el sprite.
     *
     * @param g Gráficos de la ventana.
     */
    public abstract void draw(Graphics g);

    // Getters y Setters
    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }
}
