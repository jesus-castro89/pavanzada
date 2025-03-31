package org.brick_breaker.sprites;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.utils.colissions.CollisionManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * Clase que representa un sprite en el juego.
 */
public abstract class Sprite implements Serializable {

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
        addImageToCache();
        CollisionManager.getInstance().registerCollidable(this);
    }

    /**
     * Función que se encarga de dibujar el sprite.
     *
     * @param g2d Gráficos de la ventana.
     */
    public void draw(Graphics2D g2d) {

        g2d.drawImage(getImage(), position.x, position.y, null);
    }

    /**
     * Función que se encarga de añadir la imagen del sprite a la caché.
     */
    protected abstract void addImageToCache();

    /**
     * Función que se encarga de obtener la caja de colisión del sprite.
     *
     * @return Límites del sprite.
     */
    public Rectangle getBounds() {

        return new Rectangle(position, size);
    }

    public BufferedImage getImage() {

        return SpriteCache.getInstance().getImage(imageName);
    }

    // Getters y Setters
    public Point getPosition() {
        return position;
    }

    public String getImageName() {
        return imageName;
    }

    public Dimension getSize() {
        return size;
    }

    public void setSize(Dimension size) {
        this.size = size;
    }
}
