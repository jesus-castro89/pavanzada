package org.brick_breaker.sprites;

import java.awt.*;

/**
 * Clase que permite definir las barras de la zona de juego.
 */
public enum Borders {
    /**
     * Barra de la izquierda de la zona de juego.
     */
    LEFT_BAR("leftbar.png", new Point(0, 0)),
    /**
     * Barra de la derecha de la zona de juego.
     */
    RIGHT_BAR("rightbar.png", new Point(444, 0)),
    /**
     * Barra superior de la zona de juego.
     */
    TOP_BAR("topbar.png", new Point(24, 0)),
    /**
     * Barra inferior de la zona de juego.
     */
    BOTTOM_BAR("bottombar.png", new Point(24, 444));

    /**
     * Nombre del archivo de imagen para cada tipo de Barra
     */
    private final String imageName;

    /**
     * Posición de la barra en la pantalla.
     */
    private final Point position;

    Borders(String imageName, Point position) {

        this.imageName = imageName;
        this.position = position;
    }

    /**
     * Función que permite dibujar los elementos de la interfaz.
     */
    public void drawObject() {
        //TODO: Implementar método para dibujar los elementos de la interfaz
    }
}
