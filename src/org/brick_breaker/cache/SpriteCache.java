package org.brick_breaker.cache;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class SpriteCache {

    /**
     * Caché de imágenes. Se almacenan las imágenes cargadas en la aplicación.
     */
    private final HashMap<String, BufferedImage> cache = new HashMap<>();
    /**
     * Instancia de la caché de imágenes.
     */
    private static final SpriteCache INSTANCE = new SpriteCache();

    /**
     * Constructor privado de la clase para evitar instanciación.
     */
    private SpriteCache() {

    }

    /**
     * Función que se encarga de obtener la instancia de la caché de imágenes.
     *
     * @return Instancia de la caché de imágenes.
     */
    public static SpriteCache getInstance() {

        return INSTANCE;
    }

    /**
     * Función que se encarga de añadir una imagen a la caché.
     *
     * @param name  Nombre de la imagen.
     * @param image Imagen a añadir a la caché.
     */
    public void addImage(String name, BufferedImage image) {

        cache.putIfAbsent(name, image);
    }

    /**
     * Función que se encarga de obtener una imagen de la caché.
     *
     * @param name Nombre de la imagen.
     * @return Imagen a retornar de la caché o null en caso de que la imagen a buscar no exista.
     */
    public BufferedImage getImage(String name) {

        return cache.getOrDefault(name, null);
    }
}
