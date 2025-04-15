package org.brick_breaker.ui.events;

import org.brick_breaker.ui.panels.GamePanel;
import org.brick_breaker.ui.windows.MainWindow;

import java.awt.event.ActionListener;

public class StartButtonAction implements ActionListener {

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        GamePanel.getInstance().playGame();
        MainWindow.getInstance().getStartButton().setEnabled(false);
        MainWindow.getInstance().getStopButton().setEnabled(true);
    }
}
