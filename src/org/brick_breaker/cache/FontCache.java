package org.brick_breaker.cache;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Clase que se encarga de almacenar en caché las fuentes que se cargan en la aplicación.
 */
public class FontCache {

    /**
     * Mapa que almacena las fuentes en caché.
     */
    public static final Map<String, Font> cache = new HashMap<>();
    /**
     * Instancia de la caché de fuentes.
     */
    private static final FontCache INSTANCE = new FontCache();

    /**
     * Constructor privado de la clase para evitar instanciación.
     */
    private FontCache() {
    }

    /**
     * Función que se encarga de obtener la instancia de la caché de fuentes.
     *
     * @return Instancia de la caché de fuentes.
     */
    public static FontCache getInstance() {
        return INSTANCE;
    }

    /**
     * Función que se encarga de añadir una fuente a la caché.
     *
     * @param fontName Nombre de la fuente.
     * @param fontPath Ruta de la fuente.
     */
    public static Font addFont(String fontName, String fontPath) {

        Font font;
        if (!cache.containsKey(fontName)) {

            font = FontLoader.loadFont(fontPath);
            cache.put(fontName, font);
        } else {
            font = cache.get(fontName);
        }
        return font;
    }

    /**
     * Función que se encarga de obtener una fuente de la caché.
     *
     * @param fontName Nombre de la fuente.
     * @param style    Estilo de la fuente.
     * @param size     Tamaño de la fuente.
     * @return Fuente a retornar de la caché o la fuente Arial en caso de que la fuente a buscar no exista.
     */
    public static Font getFont(String fontName, int style, int size) {

        return cache.getOrDefault(fontName, Font.getFont("Arial")).deriveFont(style, size);
    }

    /**
     * Función que se encarga de obtener una fuente de la caché.
     *
     * @param fontName Nombre de la fuente.
     * @return Fuente a retornar de la caché o la fuente Arial en caso de que la fuente a buscar no exista.
     */
    public static Font getFont(String fontName) {

        return getFont(fontName, Font.PLAIN, 12);
    }

    /**
     * Función que se encarga de obtener una fuente de la caché.
     *
     * @param fontName Nombre de la fuente.
     * @param size     Tamaño de la fuente.
     * @return Fuente a retornar de la caché o la fuente Arial en caso de que la fuente a buscar no exista.
     */
    public static Font getFont(String fontName, int size) {

        return getFont(fontName, Font.PLAIN, size);
    }
}
