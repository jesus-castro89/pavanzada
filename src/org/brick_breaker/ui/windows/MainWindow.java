package org.brick_breaker.ui.windows;

import org.brick_breaker.ui.buttons.BaseButton;
import org.brick_breaker.ui.buttons.events.InGameAction;
import org.brick_breaker.ui.panels.GamePanel;

import javax.swing.*;
import java.awt.event.MouseAdapter;

public class MainWindow extends JFrame {
    private JPanel mainPanel;
    private JPanel gamePanel;
    private JPanel actionPanel;
    private JButton startButton;
    private JButton stopButton;
    private JLabel lbl1;

    public MainWindow() {

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
