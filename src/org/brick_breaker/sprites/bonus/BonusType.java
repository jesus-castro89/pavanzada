package org.brick_breaker.sprites.bonus;

import org.brick_breaker.sprites.paddles.PaddleType;
import org.brick_breaker.ui.panels.GamePanel;

import java.io.Serializable;

/**
 * Esta clase permitirá definir los tipos de bonus posibles dentro del juego, la lista de opciones es la siguientes:
 */
public enum BonusType implements Serializable {

    L("l_bonus") {
        @Override
        public void activateBonus() {
            GamePanel.getInstance().addLife();
        }
    },
    S("s_bonus") {
        @Override
        public void activateBonus() {
            GamePanel.getInstance().getPaddle().changeType(PaddleType.SHOOTER);
        }
    },
    M("m_bonus") {
        @Override
        public void activateBonus() {
            GamePanel.getInstance().duplicateScore();
        }
    },
    R("r_bonus") {
        @Override
        public void activateBonus() {
            GamePanel.getInstance().getPaddle().changeType(PaddleType.SMALL);
        }
    },
    E("e_bonus") {
        @Override
        public void activateBonus() {
            GamePanel.getInstance().getPaddle().changeType(PaddleType.LARGE);
        }
    },
    B("b_bonus") {
        @Override
        public void activateBonus() {
            GamePanel.getInstance().addScore(1000);
        }
    },
    C("c_bonus") {
        @Override
        public void activateBonus() {
            GamePanel.getInstance().getPaddle().changeType(PaddleType.MEDIUM);
        }
    },
    D("d_bonus") {
        @Override
        public void activateBonus() {
        }
    },
    P("p_bonus") {
        @Override
        public void activateBonus() {
        }
    },
    T("t_bonus") {
        @Override
        public void activateBonus() {
        }
    };

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

    public abstract void activateBonus();
}
