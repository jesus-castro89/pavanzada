package org.brick_breaker.sprites;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase que permite definir las barras de la zona de juego.
 */
public class Borders extends Sprite {

    public static final Borders LEFT_BAR = new Borders("leftBar", new Point(0, 0));
    public static final Borders RIGHT_BAR = new Borders("rightBar", new Point(438, 0));
    public static final Borders TOP_BAR = new Borders("topBar", new Point(18, 0));

    /**
     * Constructor de la clase.
     *
     * @param imageName Nombre de la imagen de la barra.
     */
    private Borders(String imageName, Point location) {

        super(location, imageName, new Dimension(0, 0));
    }

    @Override
    protected void addImageToCache() {

        SpriteCache spriteCache = SpriteCache.getInstance();
        BufferedImage image = SpriteLoader.loadImage(imageName + ".png");
        spriteCache.addImage(imageName, image);
        setSize(new Dimension(image.getWidth(), image.getHeight()));
    }
}
