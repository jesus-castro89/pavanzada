package org.brick_breaker.ui.windows;

import org.brick_breaker.ui.buttons.ThreePartButtonUI;
import org.brick_breaker.ui.events.StartButtonAction;
import org.brick_breaker.ui.events.StopButtonAction;
import org.brick_breaker.ui.panels.GamePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class MainWindow extends JFrame {

    public static MainWindow INSTANCE;
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel actionPanel;
    private JButton startButton;
    private JButton stopButton;
    private JLabel lbl1;

    private MainWindow() {

        super("Brick Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addActions();
        lbl1.addMouseListener(new MouseAdapter() {
        });
    }

    public static MainWindow getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new MainWindow();
        }
        return INSTANCE;
    }

    private void addActions() {

        startButton.addActionListener(new StartButtonAction());
        stopButton.addActionListener(new StopButtonAction());
    }

    private void createUIComponents() {

        gamePanel = GamePanel.getInstance();
        startButton = new JButton("Reanudar");
        stopButton = new JButton("Pausar");
        ThreePartButtonUI.configureButton(startButton);
        ThreePartButtonUI.configureButton(stopButton);
    }

    public JButton getStartButton() {

        return startButton;
    }

    public JButton getStopButton() {

        return stopButton;
    }
}
