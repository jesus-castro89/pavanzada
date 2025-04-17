package org.brick_breaker.ui.windows;

import org.brick_breaker.ui.buttons.ThreePartButtonUI;
import org.brick_breaker.ui.events.StartButtonAction;
import org.brick_breaker.ui.events.StopButtonAction;
import org.brick_breaker.ui.labels.LifeLabelUI;
import org.brick_breaker.ui.labels.ScoreLabelUI;
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
    private JLabel lifeLabel;
    private JLabel scoreLabel;

    private MainWindow() {

        super("Brick Breaker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        addActions();
        lifeLabel.addMouseListener(new MouseAdapter() {
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
        scoreLabel = new JLabel("0");
        lifeLabel = new JLabel("3");
        ThreePartButtonUI.configureButton(startButton);
        ThreePartButtonUI.configureButton(stopButton);
        ScoreLabelUI.configureLabel(scoreLabel);
        LifeLabelUI.configureLabel(lifeLabel);
    }

    public void startGame() {
        GamePanel.getInstance().startGame();
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }

    public JButton getStartButton() {

        return startButton;
    }

    public JButton getStopButton() {

        return stopButton;
    }

    public JLabel getLifeLabel() {

        return lifeLabel;
    }

    public JLabel getScoreLabel() {

        return scoreLabel;
    }
}
