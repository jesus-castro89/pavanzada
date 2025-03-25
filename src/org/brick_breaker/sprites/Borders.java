package org.brick_breaker.sprites;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase que permite definir las barras de la zona de juego.
 */
public enum Borders {
    /**
     * Barra de la izquierda de la zona de juego.
     */
    LEFT_BAR("leftBar", new Point(0, 0)),
    /**
     * Barra de la derecha de la zona de juego.
     */
    RIGHT_BAR("rightBar", new Point(448, 0)),
    /**
     * Barra superior de la zona de juego.
     */
    TOP_BAR("topBar", new Point(18, 0)),
    /**
     * Barra inferior de la zona de juego.
     */
    BOTTOM_BAR("bottomBar", new Point(24, 444));

    /**
     * Nombre del archivo de imagen para cada tipo de Barra
     */
    private final String imageName;

    /**
     * Posición de la barra en la pantalla.
     */
    private final Point position;
    private final Rectangle bounds;

    static {
        SpriteCache cache = SpriteCache.getInstance();
        cache.addImage("leftBar", SpriteLoader.loadImage("leftBar.png"));
        cache.addImage("rightBar", SpriteLoader.loadImage("rightBar.png"));
        cache.addImage("topBar", SpriteLoader.loadImage("topBar.png"));
    }

    Borders(String imageName, Point position) {

        this.imageName = imageName;
        this.position = position;
        this.bounds = new Rectangle(position.x, position.y, 0, 0);
    }

    /**
     * Función que permite dibujar los elementos de la interfaz.
     */
    public void drawObject(Graphics2D g) {

        BufferedImage image = null;
        image = SpriteCache.getInstance().getImage(imageName);
        this.bounds.width = image.getWidth();
        this.bounds.height = image.getHeight();
        g.drawImage(SpriteCache.getInstance().getImage(imageName), position.x, position.y, null);
    }

    // Getters y Setters
    public String getImageName() {
        return imageName;
    }

    public Point getPosition() {
        return position;
    }
}
