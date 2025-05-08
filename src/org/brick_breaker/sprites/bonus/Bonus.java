package org.brick_breaker.sprites.bonus;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.Borders;
import org.brick_breaker.sprites.MovingSprite;
import org.brick_breaker.sprites.Sprite;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.sprites.paddles.Paddle;
import org.brick_breaker.ui.panels.GamePanel;
import org.brick_breaker.utils.colissions.CollisionListener;
import org.brick_breaker.utils.colissions.CollisionManager;
import org.brick_breaker.utils.colissions.EdgeType;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Clase que representa a los bloques de bonus que podremos recolectar con la barra de jugador.
 */
public class Bonus extends MovingSprite implements Serializable, CollisionListener {

    /**
     * Este atributo se usa para saber si se mostrará o no en pantalla el bonus.
     * Recordemos que entrará en modo activo cuando el ladrillo que lo contengan sea destruido.
     */
    private boolean active;

    /**
     * Tipo de bonus que se usará para hacer diversas acciones en el juego de acuerdo a lo que se necesite.
     */
    private BonusType type;

    /**
     * Constructor básico de la clase Bonus que recibe la posición inicial y el tipo de bonus.
     *
     * @param startPosition Posición inicial del bonus.
     * @param type          Tipo de bonus que se mostrará en pantalla.
     */
    public Bonus(Point startPosition, BonusType type) {

        super(startPosition, type.getImageName(), Brick.BRICK_SIZE, 0, 1);
        this.type = type;
        this.active = false;
        CollisionManager.getInstance().addListener(this);
    }

    @Override
    public void move() {

        position.y += dy;
    }

    @Override
    public void draw(Graphics2D g2d) {

        Graphics2D g2 = (Graphics2D) g2d.create();
        g2.drawImage(getImageIcon().getImage(), position.x, position.y, null);
        g2.dispose();
    }

    public ImageIcon getImageIcon() {

        return SpriteCache.getInstance().getImageIcon(getImageName());
    }

    @Override
    public void onCollisionDetected(Sprite collider, Sprite collidedWith, EdgeType edgeType) {

        if (collider == this) {
            if (collidedWith == null) {
                GamePanel.removeBonus(this);
            }
            if (collidedWith instanceof Paddle) {
                switch (edgeType) {
                    case TOP_EDGE -> getPosition().y = collidedWith.getPosition().y - getImageIcon().getIconHeight();
                    case BOTTOM_EDGE -> getPosition().y = collidedWith.getPosition().y + collidedWith.getSize().height;
                }
                GamePanel.removeBonus(this);
                getType().activateBonus();
            }
        }
    }

    @Override
    public void addImageToCache() {

        SpriteCache cache = SpriteCache.getInstance();
        if (type != null) {
            switch (type) {

                case L -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/L.gif"));
                case S -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/S.gif"));
                case M -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/M.gif"));
                case R -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/R.gif"));
                case E -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/E.gif"));
                case B -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/B.gif"));
                case C -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/C.gif"));
                case D -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/D.gif"));
                case P -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/P.gif"));
                case T -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/T.gif"));
            }
        }
    }

    // Getters y Setters
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public BonusType getType() {
        return type;
    }

    public void setType(BonusType type) {
        this.type = type;
    }
}
