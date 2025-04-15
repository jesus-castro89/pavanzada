package org.brick_breaker.ui.buttons;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ThreePartButtonUI extends BasicButtonUI {

    static {
        SpriteCache cache = SpriteCache.getInstance();
        cache.addImage("leftSideNormal", SpriteLoader.loadImage("buttons/normal/leftSide.png"));
        cache.addImage("leftSideHover", SpriteLoader.loadImage("buttons/hover/leftSide.png"));
        cache.addImage("leftSidePressed", SpriteLoader.loadImage("buttons/pressed/leftSide.png"));
        cache.addImage("leftSideDisabled", SpriteLoader.loadImage("buttons/disabled/leftSide.png"));
        cache.addImage("middleNormal", SpriteLoader.loadImage("buttons/normal/middleSide.png"));
        cache.addImage("middleHover", SpriteLoader.loadImage("buttons/hover/middleSide.png"));
        cache.addImage("middlePressed", SpriteLoader.loadImage("buttons/pressed/middleSide.png"));
        cache.addImage("middleDisabled", SpriteLoader.loadImage("buttons/disabled/middleSide.png"));
        cache.addImage("rightSideNormal", SpriteLoader.loadImage("buttons/normal/rightSide.png"));
        cache.addImage("rightSideHover", SpriteLoader.loadImage("buttons/hover/rightSide.png"));
        cache.addImage("rightSidePressed", SpriteLoader.loadImage("buttons/pressed/rightSide.png"));
        cache.addImage("rightSideDisabled", SpriteLoader.loadImage("buttons/disabled/rightSide.png"));
    }

    private final BufferedImage[] images = new BufferedImage[3];
    private final int[] imageWidths = new int[3];
    private final int imageHeight;

    public ThreePartButtonUI() {
        images[0] = SpriteCache.getInstance().getImage("leftSideNormal");
        images[1] = SpriteCache.getInstance().getImage("middleNormal");
        images[2] = SpriteCache.getInstance().getImage("rightSideNormal");
        imageWidths[0] = images[0].getWidth(null);
        imageWidths[1] = images[1].getWidth(null);
        imageWidths[2] = images[2].getWidth(null);
        imageHeight = images[0].getHeight(null);
    }

    @Override
    public void paint(Graphics g, JComponent c) {

        JButton button = (JButton) c;
        Graphics2D g2 = (Graphics2D) g.create();
        // Determinar qué imágenes usar según el estado del botón
        setButtonImages(button);
        // Calcular dimensiones
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(button.getText());
        int centerWidth = textWidth + 40; // 20px de padding a cada lado
        // Dibujar las tres partes del botón
        // Parte izquierda
        g2.drawImage(images[0], 0, 0,
                imageWidths[0], imageHeight,
                null);
        // Parte central (se estira según el texto)
        g2.drawImage(images[1], imageWidths[0],
                0, imageWidths[0] + centerWidth, imageHeight,
                0, 0,
                imageWidths[1], imageHeight,
                null);
        // Parte derecha
        g2.drawImage(images[2], imageWidths[0] + centerWidth, 0,
                imageWidths[2],
                imageHeight,
                null);
        // Dibujar el texto
        int textX = imageWidths[0] + (centerWidth - textWidth) / 2;
        int textY = (imageHeight - fm.getHeight()) / 2 + fm.getAscent();
        if (button.getModel().isPressed()) {
            textX += 1;
            textY += 1;
        }
        g2.setColor(button.getModel().isEnabled() ? button.getForeground() : Color.GRAY);
        g2.drawString(button.getText(), textX, textY);
        g2.dispose();
    }

    public static void configureButton(JButton button) {

        button.setUI(new ThreePartButtonUI());
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {

        JButton button = (JButton) c;
        FontMetrics fm = button.getFontMetrics(button.getFont());
        int textWidth = fm.stringWidth(button.getText());
        int width = imageWidths[0] + textWidth + 40 + images[1].getWidth();
        return new Dimension(width, imageHeight);
    }

    private void setButtonImages(JButton button) {

        switch (ButtonState.getButtonState(button)) {

            case NORMAL -> {
                images[0] = SpriteCache.getInstance().getImage("leftSideNormal");
                images[1] = SpriteCache.getInstance().getImage("middleNormal");
                images[2] = SpriteCache.getInstance().getImage("rightSideNormal");
            }
            case ROLLOVER -> {
                images[0] = SpriteCache.getInstance().getImage("leftSideHover");
                images[1] = SpriteCache.getInstance().getImage("middleHover");
                images[2] = SpriteCache.getInstance().getImage("rightSideHover");
            }
            case PRESSED -> {
                images[0] = SpriteCache.getInstance().getImage("leftSidePressed");
                images[1] = SpriteCache.getInstance().getImage("middlePressed");
                images[2] = SpriteCache.getInstance().getImage("rightSidePressed");
            }
            case DISABLED -> {
                images[0] = SpriteCache.getInstance().getImage("leftSideDisabled");
                images[1] = SpriteCache.getInstance().getImage("middleDisabled");
                images[2] = SpriteCache.getInstance().getImage("rightSideDisabled");
            }
        }
    }
}