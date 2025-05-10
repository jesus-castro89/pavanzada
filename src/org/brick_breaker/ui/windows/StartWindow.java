package org.brick_breaker.ui.windows;

import org.brick_breaker.ui.buttons.ThreePartButtonUI;
import org.brick_breaker.ui.labels.TitleLabel;

import javax.swing.*;

public class StartWindow extends JFrame {
    private JButton startButton;
    private JButton exitButton;
    private JPanel mainPanel;
    private JLabel titleLabel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StartWindow::new);
    }

    public StartWindow() {
        setContentPane(mainPanel);
        setTitle("Brick Breaker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
        setResizable(false);
        // Add action listeners to buttons
        startButton.addActionListener(e -> {
            this.dispose(); // Close the start window
            MainWindow.getInstance().startGame();
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });
    }

    private void createUIComponents() {
        titleLabel = new TitleLabel();
        startButton = new JButton("Iniciar");
        exitButton = new JButton("Salir");
        ThreePartButtonUI.configureButton(startButton);
        ThreePartButtonUI.configureButton(exitButton);
        System.out.println(startButton.getFont());
    }
}
