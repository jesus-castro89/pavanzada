package org.brick_breaker.ui.events;

import org.brick_breaker.sprites.Missile;
import org.brick_breaker.sprites.paddles.PaddleType;
import org.brick_breaker.ui.panels.GamePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardAction extends KeyAdapter {

    GamePanel gamePanel;

    public KeyboardAction(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gamePanel.getPaddle().setDx(-1);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getPaddle().setDx(1);
                break;
            case KeyEvent.VK_SPACE:
                if (gamePanel.isGameRunning()) {
                    if (!gamePanel.getBalls().isEmpty() && gamePanel.getBalls().getFirst().isStop())
                        gamePanel.getBalls().getFirst().setStop(false);
                    if (gamePanel.getPaddle().getType() == PaddleType.SHOOTER)
                        gamePanel.addMissile();
                }
                break;
            case KeyEvent.VK_F:
                gamePanel.destroyAllBricks();
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                gamePanel.getPaddle().setDx(0);
                break;
            default:
                break;
        }
    }

}
