package org.brick_breaker.cache;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Clase que se encarga de cargar las imágenes del juego.
 */
public class SpriteLoader {
    /**
     * Ruta de las imágenes.
     */
    private static final String SPRITES_PATH = "image/";

    /**
     * Función que se encarga de cargar una imagen en formato png.
     *
     * @param fileName Nombre de la imagen a cargar con formato png.
     * @return Imagen cargada.
     */
    public static BufferedImage loadImage(String fileName) {

        try {

            return ImageIO.read(new File(SPRITES_PATH + fileName));
        } catch (IOException e) {
            JOptionPane.showConfirmDialog(null,
                    "Error al cargar la imagen: " + fileName,
                    "Error", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Función que se encarga de cargar una imagen en formato gif.
     *
     * @param fileName Nombre de la imagen a cargar con formato gif.
     * @return Imagen cargada.
     */
    public static ImageIcon loadGif(String fileName) {

        try {

            return new ImageIcon(SPRITES_PATH + fileName);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,
                    "Error al cargar la imagen: " + fileName,
                    "Error", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
