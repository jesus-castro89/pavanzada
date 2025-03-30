package org.brick_breaker.ui.buttons;

import javax.swing.*;

public class BaseButton extends JButton {

    public BaseButton(String text) {

        setText(text);
        // Establecemos el manager de UI.
        setUI(new HoverButtonUI());
    }
}
