package org.brick_breaker.ui.labels;

import org.brick_breaker.cache.FontCache;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class TitleLabel extends JLabel {

    static {
        FontCache.addFont("diffusion", "fonts/diffusion.ttf");
    }

    public TitleLabel() {
        Font font = FontCache.getFont("diffusion").deriveFont(Font.BOLD, 42);
        setText("Brick Breaker");
        setFont(font);
        setHorizontalAlignment(SwingConstants.CENTER);
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setVerticalTextPosition(SwingConstants.CENTER);
    }

    public void setTitle(String title) {
        setText(title);
    }
}
