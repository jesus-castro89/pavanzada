package org.brick_breaker.utils;

import org.brick_breaker.sprites.bonus.BonusType;

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

    public static boolean getRandomBoolean() {

        return randomInt(0, 1) == 1;
    }

    public static boolean getRandomBoolean(int probability) {

        return randomInt(0, 100) < probability;
    }

    /**
     * Función que se encarga de generar un número aleatorio entre 0 y el número de tipos de bonus.
     *
     * @return Tipo de bonus aleatorio.
     */
    public static BonusType getRandomBonusType() {

        BonusType[] bonusTypes = BonusType.values();
        int randomIndex = randomInt(0, bonusTypes.length - 1);
        return bonusTypes[randomIndex];
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
        return random.nextInt(max - min + 1) + min;
    }
}
