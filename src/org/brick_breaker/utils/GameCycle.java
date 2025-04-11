package org.brick_breaker.utils;

import org.brick_breaker.ui.panels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameCycle implements ActionListener {

    private final GamePanel panel;

    public GameCycle(GamePanel panel) {

        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        doGameCycle();
    }

    private void doGameCycle() {

        panel.update();
        panel.repaint();
    }
}
