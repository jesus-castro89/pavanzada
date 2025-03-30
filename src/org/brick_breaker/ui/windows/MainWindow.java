package org.brick_breaker.ui.windows;

import org.brick_breaker.ui.buttons.BaseButton;
import org.brick_breaker.ui.buttons.events.InGameAction;
import org.brick_breaker.ui.panels.GamePanel;

import javax.swing.*;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel actionPanel;
    private JButton startButton;
    private JButton stopButton;

    public MainWindow() {

        super("Brick Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        addActions();
    }

    private void addActions() {

        startButton.addActionListener(new InGameAction(this));
        stopButton.addActionListener(new InGameAction(this));
    }

    private void createUIComponents() {

        gamePanel = new GamePanel();
        startButton = new BaseButton("Reanudar");
        stopButton = new BaseButton("Pausar");
    }

    public JButton getStartButton() {

        return startButton;
    }

    public JButton getStopButton() {

        return stopButton;
    }
}
