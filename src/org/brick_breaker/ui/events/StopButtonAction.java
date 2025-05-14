package org.brick_breaker.ui.events;

import org.brick_breaker.ui.panels.GamePanel;
import org.brick_breaker.ui.windows.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StopButtonAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {

        GamePanel.getInstance().stopGame();
        MainWindow.getInstance().getStartButton().setEnabled(true);
        MainWindow.getInstance().getStopButton().setEnabled(false);
    }
}
