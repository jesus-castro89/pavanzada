package org.brick_breaker.ui.windows;

import javax.swing.*;

public class MainWindow extends JFrame {

    private JPanel panel1;

    public MainWindow() {
        this.setTitle("Brick Breaker");
        this.setContentPane(panel1);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MainWindow();
    }
}
