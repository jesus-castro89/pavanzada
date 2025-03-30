package org.brick_breaker.ui.buttons.events;

import org.brick_breaker.ui.windows.MainWindow;

import java.awt.event.ActionListener;

public class InGameAction implements ActionListener {

    MainWindow mainWindow;

    public InGameAction(MainWindow mainWindow) {
        this.mainWindow = mainWindow;
    }

    /**
     * Función que se ejecuta al hacer clic en el botón de acción en el juego.
     * Aquí puedes implementar la lógica de acción en el juego.
     */
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {

        mainWindow.getStartButton().setVisible(!mainWindow.getStartButton().isVisible());
        mainWindow.getStopButton().setVisible(!mainWindow.getStopButton().isVisible());
    }
}
