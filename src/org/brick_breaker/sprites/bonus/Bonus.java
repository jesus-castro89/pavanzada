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

        position.y++;
    }

    @Override
    public void draw(Graphics g) {

    }

    /**
     * Función que se ejecutará cada cierto tiempo para mantener en movimiento el bloque de Bonus.
     *
     * @param x Posición X en el arreglo de bonus.
     * @param y Posición Y en el arreglo de bonus.
     */
    public void start(int x, int y) {
        // Aquí se moverá el bonus
        move();
        // Validamos si el bonus está activo
        if (this.active) {
            //Esto valida si el sprite de bonus llega a la parte inferior de la pantalla
            if (position.y == 680) {

                this.active = false;
                //Aquí eliminamos el elemento de la matriz de bonus
                delete(x, y);
            }
            //Validamos si el jugador entro en contacto con el bonus
            take(x, y);
        }
    }

    /**
     * Esta función eliminará el elemento de la matriz de bonus.
     *
     * @param x Posición X en el arreglo de bonus.
     * @param y Posición Y en el arreglo de bonus.
     */
    public void delete(int x, int y) {
        //TODO: Implementar la eliminación del bonus de la matriz de bonus
    }

    /**
     * Función que valida la colisión entre el jugador y el bonus.
     *
     * @param x Posición X en el arreglo de bonus.
     * @param y Posición Y en el arreglo de bonus
     */
    public void take(int x, int y) {

        //TODO: Implementar la validación de la colisión entre el jugador y el bonus
    }

    /**
     * Función que se encargará de activar el bonus de multiesferas.
     */
    private void multiBall() {

        //TODO: Implementar la lógica para el bonus de multi esferas
    }

    /**
     * Función que se encargará de recuperar la posición de la esfera principal.
     */
    private int getBallPosition() {

        return (int) Math.floor(Math.random() * ((Brick.BRICK_WIDTH * 10) - Level.ROW_MARGIN) +
                Level.ROW_MARGIN);
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
