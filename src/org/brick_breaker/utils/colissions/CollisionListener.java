package org.brick_breaker.utils.colissions;

import org.brick_breaker.sprites.Sprite;

/**
 * Interfaz que define un listener para detectar colisiones entre sprites.
 */
public interface CollisionListener {
    /**
     * Función que se ejecuta cuando se detecta una colisión entre dos sprites.
     *
     * @param collider     El sprite que colisiona.
     * @param collidedWith El sprite con el que se colisiona.
     * @param edgeType     El tipo de borde con el que se colisiona.
     */
    void onCollisionDetected(Sprite collider, Sprite collidedWith, EdgeType edgeType);
}