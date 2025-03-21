package org.brick_breaker.sprites.bricks;

import java.io.Serializable;

/**
 * Enumerado que representa los tipos de ladrillos que existen en el juego.
 */
public enum BrickType implements Serializable {
    /**
     * Ladrillo amarillo. Cuenta con 1 vida y otorga 10 puntos al ser destruido.
     */
    YELLOW(1, 10),
    /**
     * Ladrillo rojo. Cuenta con 2 vidas y otorga 20 puntos al ser destruido.
     */
    RED(2, 20),
    /**
     * Ladrillo azul. Cuenta con 3 vidas y otorga 30 puntos al ser destruido.
     */
    BLUE(3, 30),
    /**
     * Ladrillo verde. Cuenta con 4 vidas y otorga 40 puntos al ser destruido.
     */
    GREEN(4, 40);

    /**
     * Vidas del ladrillo.
     */
    private final int life;
    /**
     * Puntos que otorga al ser destruido.
     */
    private final int score;

    /**
     * Constructor del enumerado.
     *
     * @param life  Vidas del ladrillo.
     * @param score Puntos que otorga al ser destruido.
     */
    BrickType(int life, int score) {

        this.life = life;
        this.score = score;
    }

    public int getLife() {
        return life;
    }

    public int getScore() {
        return score;
    }
}
