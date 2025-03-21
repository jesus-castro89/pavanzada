package org.brick_breaker.sprites.bonus;

import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.MovingSprite;
import org.brick_breaker.sprites.bricks.Brick;

import java.awt.*;
import java.io.Serializable;

/**
 * Clase que representa a los bloques de bonus que podremos recolectar con la barra de jugador.
 */
public class Bonus extends MovingSprite implements Serializable {

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
    }

    @Override
    public void move() {

        position.y += dy;
    }

    @Override
    public void draw(Graphics g) {

    }

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
