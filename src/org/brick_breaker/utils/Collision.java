package org.brick_breaker.utils;

import org.brick_breaker.sprites.Ball;
import org.brick_breaker.sprites.Borders;
import org.brick_breaker.sprites.Sprite;
import org.brick_breaker.sprites.paddles.Paddle;

import java.awt.*;
import java.util.Arrays;

/**
 * Clase utilitaria que permite determinar la colisión entre la pelota y los bordes de los sprites.
 */
public final class Collision {

    /**
     * Constructor privado de la clase.
     */
    private Collision() {

        throw new IllegalStateException("Utility class");
    }

    /**
     * Función que permite determinar el borde con el que la pelota colisiona y rebota.
     *
     * @param sprite1 Pelota con la que se desea comparar.
     * @param sprite2 Sprite con el que se desea comparar.
     * @return Tipo de borde con el que colisiona la pelota.
     */
    public static EdgeType distanceBallEdge(Ball sprite1, Sprite sprite2) {

        EdgeType edgeType = EdgeType.LEFT_EDGE;
        int leftImpact = sprite1.getPosition().x + sprite1.getImageIcon().getIconWidth() - sprite2.getPosition().x;
        int rightImpact = sprite2.getPosition().x + sprite2.getSize().width - sprite1.getPosition().x;
        int topImpact = sprite1.getPosition().y + sprite1.getImageIcon().getIconHeight() - sprite2.getPosition().y;
        int bottomImpact = sprite2.getPosition().y + sprite2.getSize().height - sprite1.getPosition().y;
        int[] impacts = {leftImpact, rightImpact, topImpact, bottomImpact};
        int minImpact = Arrays.stream(impacts).min().orElse(0);
        if (minImpact == rightImpact) edgeType = EdgeType.RIGHT_EDGE;
        else if (minImpact == topImpact) edgeType = EdgeType.TOP_EDGE;
        else if (minImpact == bottomImpact) edgeType = EdgeType.BOTTOM_EDGE;
        return edgeType;
    }

    private static void changeBallDirection(Ball ball, EdgeType edgeType) {

        switch (edgeType) {
            case LEFT_EDGE, RIGHT_EDGE -> ball.setDx(-ball.getDx());
            case TOP_EDGE, BOTTOM_EDGE -> ball.setDy(-ball.getDy());
        }
    }

    /**
     * Función que permite determinar el borde con el que la pelota colisiona y rebota.
     *
     * @param ball   Pelota con la que se desea comparar.
     * @param sprite Sprite con el que se desea comparar.
     */
    public static void bounceBall(Ball ball, Sprite sprite) {

        EdgeType edgeType = distanceBallEdge(ball, sprite);
        changeBallDirection(ball, edgeType);
        // Se ajusta la posición de la pelota después de la colisión.
        switch (edgeType) {

            case LEFT_EDGE -> ball.getPosition().x = sprite.getPosition().x - ball.getImageIcon().getIconWidth();
            case RIGHT_EDGE -> ball.getPosition().x = sprite.getPosition().x + sprite.getSize().width;
            case TOP_EDGE -> ball.getPosition().y = sprite.getPosition().y - ball.getImageIcon().getIconHeight();
            case BOTTOM_EDGE -> ball.getPosition().y = sprite.getPosition().y + sprite.getSize().height;
        }
    }
}
