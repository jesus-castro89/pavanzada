package org.brick_breaker.ui.windows;

import org.brick_breaker.ui.panel.GamePanel;

import javax.swing.*;

public class MainWindow extends JFrame {

    private JPanel panel1;
    private JPanel gamePanel;
    private JPanel menuPanel;
    private JButton reanudarButton;
    private JButton pausarButton;

    public MainWindow() {
        this.setTitle("Brick Breaker");
        this.setContentPane(panel1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }

    private void createUIComponents() {
        gamePanel = new GamePanel();
    }
}
