package org.brick_breaker.ui.buttons;

import javax.swing.*;

public enum ButtonState {

    NORMAL,
    ROLLOVER,
    PRESSED,
    DISABLED;

    public static ButtonState getButtonState(JButton button) {

        if (button == null) {
            throw new IllegalArgumentException("Button cannot be null");
        }
        if (button.isEnabled()) {
            if (button.getModel().isPressed()) {
                return ButtonState.PRESSED;
            } else if (button.getModel().isRollover()) {
                return ButtonState.ROLLOVER;
            } else {
                return ButtonState.NORMAL;
            }
        } else {
            return ButtonState.DISABLED;
        }
    }
}
