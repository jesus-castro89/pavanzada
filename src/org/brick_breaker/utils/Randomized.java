package org.brick_breaker.utils;

import java.util.Random;

/**
 * Clase que se encarga de generar valores aleatorios.
 */
public class Randomized {

    /**
     * Constructor privado para evitar instanciación.
     */
    private Randomized() {

    }

    /**
     * Función que se encarga de generar un número aleatorio dentro un rango.
     *
     * @param min Valor mínimo del rango de números.
     * @param max Valor máximo del rango de números.
     * @return Número aleatorio generado.
     */
    public static int randomInt(int min, int max) {

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(max - min + 1) + min;
    }
}
