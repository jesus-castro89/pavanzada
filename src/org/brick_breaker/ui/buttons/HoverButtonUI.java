package org.brick_breaker.ui.buttons;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class HoverButtonUI extends BasicButtonUI {

    static {
        SpriteCache cache = SpriteCache.getInstance();
        cache.addImage("leftSideIdle", SpriteLoader.loadImage("buttons/idle/leftSide.png"));
        cache.addImage("centerSideIdle", SpriteLoader.loadImage("buttons/idle/centerSide.png"));
        cache.addImage("rightSideIdle", SpriteLoader.loadImage("buttons/idle/rightSide.png"));
        cache.addImage("leftSideHover", SpriteLoader.loadImage("buttons/hover/leftSide.png"));
        cache.addImage("centerSideHover", SpriteLoader.loadImage("buttons/hover/centerSide.png"));
        cache.addImage("rightSideHover", SpriteLoader.loadImage("buttons/hover/rightSide.png"));
    }

    protected int width;
    protected int height;
    protected BufferedImage[] parts;
    protected BufferedImage[] partsHover;

    @Override
    protected void installDefaults(AbstractButton b) {

        initParts();
        b.setForeground(Color.BLACK);
        b.setDoubleBuffered(true);
        b.setOpaque(false);
        b.setBorderPainted(false);
        b.setFocusPainted(false);
        b.setContentAreaFilled(false);
        b.setIconTextGap(5);
        b.setCursor(new Cursor(Cursor.HAND_CURSOR));
        String text = b.getText();
        this.width = b.getFontMetrics(b.getFont()).stringWidth(text) + (15);
        this.height = 48;
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {

        return new Dimension(Math.max(width + 54, 84), 48);
    }

    @Override
    public Dimension getMaximumSize(JComponent c) {
        return getPreferredSize(c);
    }

    @Override
    public Dimension getMinimumSize(JComponent c) {
        return getPreferredSize(c);
    }

    /**
     * Inicializa las partes del botón.
     * En sus estados normal y hover.
     */
    protected void initParts() {

        // Obtenemos la caché de sprites.
        SpriteCache cache = SpriteCache.getInstance();
        //Inicializamos los arreglos de imágenes.
        parts = new BufferedImage[3];
        partsHover = new BufferedImage[3];
        // Obtenemos las imágenes de la caché y las almacenamos en los arreglos correspondientes.
        parts[0] = cache.getImage("leftSideIdle");
        parts[1] = cache.getImage("centerSideIdle");
        parts[2] = cache.getImage("rightSideIdle");
        partsHover[0] = cache.getImage("leftSideHover");
        partsHover[1] = cache.getImage("centerSideHover");
        partsHover[2] = cache.getImage("rightSideHover");
    }

    @Override
    public void paint(Graphics g, JComponent c) {

        super.paint(g, c);
        Graphics2D g2d = (Graphics2D) g;
        AbstractButton button = (AbstractButton) c;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BufferedImage[] images = button.getModel().isRollover() ? partsHover : parts;
        drawButtonParts(g2d, images);
        g2d.setColor(Color.WHITE);
        super.paint(g2d, c);
    }

    protected void drawButtonParts(Graphics2D g2d, BufferedImage[] parts) {

        g2d.drawImage(parts[0], 0, 0, null);
        g2d.translate(27, 0);
        g2d.drawImage(parts[1], 0, 0, width, height, null);
        g2d.translate(width, 0);
        g2d.drawImage(parts[2], 0, 0, null);
        g2d.translate(-width - 27, 0);
    }
}
