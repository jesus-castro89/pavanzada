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

    public static EdgeType distanceBallEdge(Ball sprite1, Sprite sprite2) {

        int leftImpact = sprite1.getPosition().x + sprite1.getImageIcon().getIconWidth() - sprite2.getPosition().x;
        int rightImpact = sprite2.getPosition().x + sprite2.getSize().width - sprite1.getPosition().x;
        int topImpact = sprite1.getPosition().y + sprite1.getImageIcon().getIconHeight() - sprite2.getPosition().y;
        int bottomImpact = sprite2.getPosition().y + sprite2.getSize().height - sprite1.getPosition().y;

        if (leftImpact < rightImpact && leftImpact < topImpact && leftImpact < bottomImpact) {
            return EdgeType.LEFT_EDGE;
        } else if (rightImpact < leftImpact && rightImpact < topImpact && rightImpact < bottomImpact) {
            return EdgeType.RIGHT_EDGE;
        } else if (topImpact < leftImpact && topImpact < rightImpact && topImpact < bottomImpact) {
            return EdgeType.TOP_EDGE;
        } else {
            return EdgeType.BOTTOM_EDGE;
        }
    }

    private static void changeBallDirection(Ball ball, EdgeType edgeType, Sprite sprite) {

        switch (edgeType) {
            case LEFT_EDGE, RIGHT_EDGE -> {
                ball.setDx(-ball.getDx());
            }
            case TOP_EDGE, BOTTOM_EDGE -> {
                ball.setDy(-ball.getDy());
            }
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
        changeBallDirection(ball, edgeType, sprite);
        // Se ajusta la posición de la pelota después de la colisión.
        switch (edgeType) {
            case LEFT_EDGE -> ball.getPosition().x = sprite.getPosition().x - ball.getImageIcon().getIconWidth();
            case RIGHT_EDGE -> ball.getPosition().x = sprite.getPosition().x + sprite.getSize().width;
            case TOP_EDGE -> ball.getPosition().y = sprite.getPosition().y - ball.getImageIcon().getIconHeight();
            case BOTTOM_EDGE -> ball.getPosition().y = sprite.getPosition().y + sprite.getSize().height;
        }
    }
}
