package org.brick_breaker.ui.windows;

import org.brick_breaker.ui.panels.GamePanel;

import javax.swing.*;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel actionPanel;
    private JButton button1;

    public MainWindow() {
        super("Brick Breaker");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void createUIComponents() {

        gamePanel = new GamePanel();
    }
}
