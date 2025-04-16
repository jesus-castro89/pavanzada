package org.brick_breaker.ui.labels;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Clase que representa la interfaz de usuario para la etiqueta de puntuación.
 * Esta clase extiende BasicLabelUI y se encarga de personalizar la apariencia
 * de la etiqueta de puntuación en el juego.
 */
public class ScoreLabelUI extends BasicLabelUI {

    protected BufferedImage background;

    static {
        SpriteCache cache = SpriteCache.getInstance();
        cache.addImage("scoreBackground", SpriteLoader.loadImage("labels/score-label.png"));
    }

    /**
     * Constructor de la clase ScoreLabelUI.
     * Carga la imagen de fondo para la etiqueta de puntuación.
     */
    public ScoreLabelUI() {

        background = SpriteCache.getInstance().getImage("scoreBackground");
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
        int textWidth = fm.stringWidth(label.getText());
        int textHeight = fm.getHeight();
        int x = (background.getWidth() - textWidth) / 2;
        int y = (background.getHeight() + textHeight) / 2;
        g2.setColor(label.getForeground());
        g2.drawString(label.getText(), x, y);
        g2.dispose();
    }

    public static void configureRenderingHints(Graphics2D g2) {

        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR));
        g2.setRenderingHints(new RenderingHints(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON));
    }

    public static void configureLabel(JLabel label) {

        label.setUI(new ScoreLabelUI());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 20));
    }

    /**
     * Función que se encarga de obtener el tamaño preferido de la etiqueta.
     *
     * @param c El componente JComponent que representa la etiqueta.
     * @return El tamaño preferido de la etiqueta.
     */
    @Override
    public Dimension getPreferredSize(JComponent c) {

        return new Dimension(background.getWidth(), background.getHeight());
    }
}
