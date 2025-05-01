package org.brick_breaker.ui.windows;

import org.brick_breaker.ui.buttons.ThreePartButtonUI;
import org.brick_breaker.ui.labels.TitleLabel;

import javax.swing.*;

public class GameOverWindow extends JFrame {
    private JButton restartButton;
    private JButton exitButton;
    private JLabel titleLabel;
    private JPanel mainPanel;

    public GameOverWindow() {
        setContentPane(mainPanel);
        setTitle("Game Over");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        restartButton.addActionListener(e -> {
            this.dispose();
            MainWindow mainWindow = MainWindow.getInstance();
            mainWindow.restartGame();
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    private void createUIComponents() {
        titleLabel = new TitleLabel();
        titleLabel.setText("Game Over");
        restartButton = new JButton("Reiniciar");
        exitButton = new JButton("Salir");
        ThreePartButtonUI.configureButton(restartButton);
        ThreePartButtonUI.configureButton(exitButton);
    }
}
