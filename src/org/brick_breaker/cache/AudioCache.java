package org.brick_breaker.cache;

import javax.sound.sampled.Clip;
import java.util.HashMap;

/**
 * Clase que se encarga de almacenar los sonidos que se van a reproducir en el juego.
 */
public class AudioCache {

    /**
     * Mapa que almacena los sonidos que se van a reproducir en el juego.
     */
    private final HashMap<String, Clip> cache = new HashMap<>();
    /**
     * Instancia de la clase.
     */
    private static final AudioCache INSTANCE = new AudioCache();

    /**
     * Constructor privado de la clase.
     */
    private AudioCache() {

    }

    /**
     * Función que devuelve la instancia global de la clase.
     *
     * @return Instancia de la clase.
     */
    public static AudioCache getInstance() {

        return INSTANCE;
    }

    /**
     * Función que añade un sonido al mapa de sonidos.
     *
     * @param name  Nombre del sonido.
     * @param music Sonido a añadir.
     */
    public void addMusic(String name, Clip music) {

        cache.putIfAbsent(name, music);
    }

    /**
     * Función que devuelve un sonido del mapa de sonidos.
     *
     * @param name Nombre del sonido.
     * @return Sonido del mapa de sonidos.
     */
    public Clip getMusic(String name) {

        return cache.getOrDefault(name, null);
    }
}
