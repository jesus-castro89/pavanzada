package org.brick_breaker.ui.panel;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.sprites.Borders;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel {

    private final Borders leftBar = Borders.LEFT_BAR;
    private final Borders rightBar = Borders.RIGHT_BAR;
    private final Borders topBar = Borders.TOP_BAR;

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        leftBar.drawObject((Graphics2D) g);
        rightBar.drawObject((Graphics2D) g);
        topBar.drawObject((Graphics2D) g);
    }
}
