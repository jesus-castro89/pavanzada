package org.brick_breaker.sprites;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.ui.panels.GamePanel;
import org.brick_breaker.utils.colissions.CollisionListener;
import org.brick_breaker.utils.colissions.CollisionManager;
import org.brick_breaker.utils.colissions.EdgeType;

import java.awt.*;

/**
 * Clase que representa un misil.
 */
public class Missile extends MovingSprite implements CollisionListener {

    /**
     * Ancho del sprite del misil.
     */
    public static final int MISSILE_WIDTH = 16;
    /**
     * Alto del sprite del misil.
     */
    public static final int MISSILE_HEIGHT = 37;
    /**
     * Velocidad del misil.
     */
    public static final int MISSILE_SPEED = 5;
    /**
     * Tamaño del misil.
     */
    public static final Dimension MISSILE_SIZE = new Dimension(MISSILE_WIDTH, MISSILE_HEIGHT);

    /**
     * Constructor de la clase.
     *
     * @param position Posición inicial del misil.
     */
    public Missile(Point position) {

        super(position, "missile", MISSILE_SIZE, 0, MISSILE_SPEED);
        // Se registra el misil en el gestor de colisiones.
        CollisionManager.getInstance().addListener(this);
    }

    @Override
    public void onCollisionDetected(Sprite collider, Sprite collidedWith, EdgeType edgeType) {
        // Se verifica si el misil colisiona con otro objeto.
        if (collider == this) {
            if (collidedWith instanceof Brick brick) {
                brick.hit();
                if (brick.isDestroyed()) {
                    GamePanel.removeBrick(brick);
                }
                // Se destruye el misil al colisionar con un ladrillo.
                GamePanel.removeMissile(this);
            }
            if (collidedWith instanceof Borders) {
                // Se destruye el misil al colisionar con un borde.
                GamePanel.removeMissile(this);
            }
        }
    }

    @Override
    public void move() {

        position.y -= dy;
    }

    @Override
    public void addImageToCache() {
        // Se agrega la imagen del misil al caché de sprites.
        SpriteCache spriteCache = SpriteCache.getInstance();
        spriteCache.addImage("missile", SpriteLoader.loadImage("missile.png"));
    }
}
