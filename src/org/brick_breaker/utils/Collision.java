package org.brick_breaker.utils;

import org.brick_breaker.sprites.Ball;
import org.brick_breaker.sprites.Sprite;

import java.util.Arrays;

/**
 * Clase utilitaria que permite determinar la colisión entre la pelota y los bordes de los sprites.
 */
public final class  Collision {

    /**
     * Constructor privado de la clase.
     */
    private Collision() {

        throw new IllegalStateException("Utility class");
    }

    /**
     * Función que permite calcular la distancia entre el centro de una pelota y el borde de un sprite.
     *
     * @param sprite1  Pelota con la que se desea comparar.
     * @param sprite2  Sprite con el que se desea comparar.
     * @param edgeType Tipo de borde con el que se desea comparar.
     * @return Distancia entre el centro de la pelota y el borde del sprite.
     */
    public static double distanceBallEdge(Ball sprite1, Sprite sprite2, EdgeType edgeType) {

        // Se obtienen las coordenadas del centro de la pelota.
        double ballX = sprite1.getBounds().getCenterX();
        double ballY = sprite1.getBounds().getCenterY();
        // Se declaran las variables que se usarán para calcular la distancia.
        double x1, y1, x2, y2, u, distance;
        // Se obtienen las coordenadas de los puntos que forman el borde del sprite.
        switch (edgeType) {
            case TOP_EDGE -> {
                x1 = sprite2.getBounds().getMinX();
                y1 = sprite2.getBounds().getMinY();
                x2 = sprite2.getBounds().getMaxX();
                y2 = sprite2.getBounds().getMinY();
            }
            case BOTTOM_EDGE -> {
                x1 = sprite2.getBounds().getMinX();
                y1 = sprite2.getBounds().getMaxY();
                x2 = sprite2.getBounds().getMaxX();
                y2 = sprite2.getBounds().getMaxY();
            }
            case LEFT_EDGE -> {
                x1 = sprite2.getBounds().getMinX();
                y1 = sprite2.getBounds().getMinY();
                x2 = sprite2.getBounds().getMinX();
                y2 = sprite2.getBounds().getMaxY();
            }
            default -> {
                x1 = sprite2.getBounds().getMaxX();
                y1 = sprite2.getBounds().getMinY();
                x2 = sprite2.getBounds().getMaxX();
                y2 = sprite2.getBounds().getMaxY();
            }
        }
        // Se obtiene el valor de u para calcular la distancia. Dónde u es el valor de la proyección del vector entre
        // los puntos del borde del sprite y el centro de la pelota.
        u = ((ballX - x1) * (x2 - x1) + (ballY - y1) * (y2 - y1)) / (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        if (u < 0) {
            // Si u es menor a 0, la distancia será la distancia entre el centro de la pelota y el punto 1 del borde del sprite.
            distance = Math.sqrt(Math.pow(ballX - x1, 2) + Math.pow(ballY - y1, 2));
        } else if (u > 1) {
            // Si u es mayor a 1, la distancia será la distancia entre el centro de la pelota y el punto 2 del borde del sprite.
            distance = Math.sqrt(Math.pow(ballX - x2, 2) + Math.pow(ballY - y2, 2));
        } else {
            // Si u está entre 0 y 1, la distancia será la distancia entre el centro de la pelota y la proyección del vector.
            // Se calcula la proyección del vector.
            double x = x1 + u * (x2 - x1);
            double y = y1 + u * (y2 - y1);
            distance = Math.sqrt(Math.pow(ballX - x, 2) + Math.pow(ballY - y, 2));
        }
        // Se retorna la distancia calculada.
        return distance;
    }

    /**
     * Función que determina el nuevo ángulo de rebote de la pelota.
     *
     * @param ball     Pelota con la que se desea comparar.
     * @param edgeType Tipo de borde con el que se desea comparar.
     */
    private static void changeBallDirection(Ball ball, EdgeType edgeType) {

        // Se obtiene el ángulo de rebote de la pelota.
        double angle = Math.atan2(ball.getDy(), ball.getDx());
        // Se calcula el ángulo de rebote de la pelota.
        switch (edgeType) {
            case TOP_EDGE, BOTTOM_EDGE -> angle = -angle;
            case LEFT_EDGE, RIGHT_EDGE -> angle = Math.PI - angle;
        }
        // Se calcula el ángulo de rebote de la pelota.
        angle = 2 * angle - Math.PI;
        // Se calcula la nueva dirección de la pelota.
        ball.setDx(Math.cos(angle) > 0 ? 1 : -1);
        ball.setDy(Math.sin(angle) > 0 ? 1 : -1);
    }

    /**
     * Función que permite determinar el borde con el que la pelota colisiona y rebota.
     *
     * @param ball   Pelota con la que se desea comparar.
     * @param sprite Sprite con el que se desea comparar.
     */
    public static void bounceBall(Ball ball, Sprite sprite) {

        // Se calcula la distancia entre la pelota y los bordes del sprite.
        double bottomDistance = distanceBallEdge(ball, sprite, EdgeType.BOTTOM_EDGE);
        double topDistance = distanceBallEdge(ball, sprite, EdgeType.TOP_EDGE);
        double leftDistance = distanceBallEdge(ball, sprite, EdgeType.LEFT_EDGE);
        double rightDistance = distanceBallEdge(ball, sprite, EdgeType.RIGHT_EDGE);
        // Guardamos las distancias en un arreglo.
        double[] distances = {bottomDistance, topDistance, leftDistance, rightDistance};
        // Se obtiene la distancia mínima.
        double minDistance = Arrays.stream(distances).min().getAsDouble();
        // Se determina el borde con el que la pelota colisiona y rebota.
        switch ((int) minDistance) {
            case 0 -> changeBallDirection(ball, EdgeType.BOTTOM_EDGE);
            case 1 -> changeBallDirection(ball, EdgeType.TOP_EDGE);
            case 2 -> changeBallDirection(ball, EdgeType.LEFT_EDGE);
            case 3 -> changeBallDirection(ball, EdgeType.RIGHT_EDGE);
        }
    }
}
