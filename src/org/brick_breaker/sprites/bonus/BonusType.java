package org.brick_breaker.sprites.bonus;

import java.io.Serializable;

/**
 * Esta clase permitirá definir los tipos de bonus posibles dentro del juego, la lista de opciones es la siguientes:
 * L: Para una vida extra
 * S: Para activar el modo de disparo
 * M: Para activar los multi esferas (aquí cada que se recoja un bonus, se triplicará la esfera principal)
 * R: Para reducir el tamaño de la barra del jugador
 * E: Para expandir la barra del jugador
 * B: Es para subir en 1000 puntos el puntaje del jugador
 * C: Es para regresar la barra al tamaño comun o base del jugador
 * D: TODO Definir un bonus a su gusto (Puede ser un aumento de puntos o algo más)
 * P: TODO Definir un bonus a su gusto (Puede ser un aumento de puntos o algo más)
 * T: TODO Definir un bonus a su gusto (Puede ser un aumento de puntos o algo más)
 */
public enum BonusType implements Serializable {

    L("l_bonus"),
    S("s_bonus"),
    M("m_bonus"),
    R("r_bonus"),
    E("e_bonus"),
    B("b_bonus"),
    C("c_bonus"),
    D("D_bonus"),
    P("p_bonus"),
    T("t_bonus");

    /**
     * Nombre del archivo de imagen para cada tipo de Bonus
     */
    private final String imageName;

    /**
     * Constructor básico del tipo Enumerado que recibe el nombre de la imagen asociada al tipo de Bonus
     *
     * @param imageName Nombre de la imagen asociada al tipo de Bonus
     */
    BonusType(String imageName) {
        this.imageName = imageName;
    }

    public String getImageName() {
        return imageName;
    }
}
