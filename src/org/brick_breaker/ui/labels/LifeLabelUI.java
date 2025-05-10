package org.brick_breaker.ui.labels;

import org.brick_breaker.cache.FontCache;
import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LifeLabelUI extends ScoreLabelUI {

    static {
        SpriteCache cache = SpriteCache.getInstance();
        cache.addImage("lifeBackground", SpriteLoader.loadImage("labels/life-label.png"));
        cache.addImage("lifeIcon", SpriteLoader.loadImage("labels/life-count.png"));
    }

    /**
     * Constructor de la clase ScoreLabelUI.
     * Carga la imagen de fondo para la etiqueta de puntuación.
     */
    public LifeLabelUI() {

        background = SpriteCache.getInstance().getImage("lifeBackground");
    }

    /**
     * FUnción que se encarga de pintar la etiqueta de puntuación.
     *
     * @param g El objeto Graphics utilizado para dibujar.
     * @param c El componente JComponent que representa la etiqueta.
     */
    @Override
    public void paint(Graphics g, JComponent c) {

        Graphics2D g2 = (Graphics2D) g.create();
        // Configura los hints de renderizado
        configureRenderingHints(g2);
        // Dibuja la imagen de fondo
        g2.drawImage(background, 0, 0, null);
        // Dibuja el texto de la etiqueta
        JLabel label = (JLabel) c;
        FontMetrics fm = g2.getFontMetrics(label.getFont());
        BufferedImage lifeIcon = SpriteCache.getInstance().getImage("lifeIcon");
        int textWidth = fm.stringWidth(label.getText());
        int textHeight = fm.getHeight();
        int iconWidth = lifeIcon.getWidth();
        int iconHeight = lifeIcon.getHeight();
        int x = (background.getWidth() - textWidth) / 2;
        int y = (background.getHeight() + textHeight) / 2;
        int iconX = 2 + iconWidth / 2;
        int iconY = ((background.getHeight() - iconHeight) / 2) + 3;
        g2.drawImage(lifeIcon, iconX, iconY, null);
        g2.setColor(label.getForeground());
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
        g2.drawString(label.getText(), x, y);
        g2.dispose();
    }

    public static void configureLabel(JLabel label) {

        label.setUI(new LifeLabelUI());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 20));
    }
}
