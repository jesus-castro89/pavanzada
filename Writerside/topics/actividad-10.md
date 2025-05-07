# Actividad 10: Definiendo etiquetas y funciones

## Objetivo

Crear clases que permitan personalizar el look and feel de las etiquetas y botones de la aplicación.

## Instrucciones

1. Crea dentro del paquete `org.brick_breaker.ui` un nuevo paquete llamado `buttons`.
2. Crear un tipo enumerado llamado `ButtonState` que contenga los siguientes estados: `NORMAL`, `ROLLOVER`, `PRESSED` y
   `DISABLED`.
3. Crea una clase llamada `ThreePartButtonUI` que extienda de `BasicButtonUI`.
4. Crear dentro del paraque `org.brick_breaker.ui` un nuevo paquete llamado `labels`.
5. Crea una clase llamada `ScoreLabelUI` que extienda de `BasicLabelUI`.
6. Crea una clase llamada `LifeLabelUI` que extienda de `ScoreLabel`.
7. Crea una clase llamada `TitleLabel` que extienda de `JLabel`.

## Desarrollo

### El tipo enumerado `ButtonState`

```java
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
```

### La clase `ThreePartButtonUI`

```java
package org.brick_breaker.ui.buttons;

import org.brick_breaker.cache.FontCache;
import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.ui.labels.ScoreLabelUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ThreePartButtonUI extends BasicButtonUI {

    private final BufferedImage[] images = new BufferedImage[3];
    private final int[] imageWidths = new int[3];
    private final int imageHeight;

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
        FontCache.addFont("diffusion", "fonts/diffusion.ttf");
    }

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
        ScoreLabelUI.configureRenderingHints(g2);
        // Determinar qué imágenes usar según el estado del botón
        setButtonImages(button);
        // Calcular dimensiones
        FontMetrics fm = g2.getFontMetrics();
        int textWidth = fm.stringWidth(button.getText());
        int centerWidth = textWidth + 40; // 20px de padding a cada lado
        // Dibujar las tres partes del botón
        // Parte izquierda
        g2.drawImage(images[0], 0, 0, imageWidths[0], imageHeight, null);
        // Parte central (se estira según el texto)
        g2.drawImage(images[1], imageWidths[0], 0, imageWidths[0] + centerWidth, imageHeight,
                0, 0, imageWidths[1], imageHeight, null);
        // Parte derecha
        g2.drawImage(images[2], imageWidths[0] + centerWidth, 0, imageWidths[2], imageHeight, null);
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
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setFont(FontCache.getFont("diffusion").deriveFont(Font.PLAIN, 20));
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {

        JButton button = (JButton) c;
        FontMetrics fm = button.getFontMetrics(button.getFont());
        int textWidth = fm.stringWidth(button.getText());
        int centerWidth = textWidth + 18; // 9px de padding a cada lado
        int width = imageWidths[0] + centerWidth + images[1].getWidth();
        return new Dimension(width, imageHeight);
    }

    private void setButtonImages(JButton button) {

        String stateName = switch (ButtonState.getButtonState(button)) {
            case NORMAL -> stateName = "Normal";
            case ROLLOVER -> stateName = "Hover";
            case PRESSED -> stateName = "Pressed";
            case DISABLED -> stateName = "Disabled";
        };
        images[0] = SpriteCache.getInstance().getImage("leftSide" + stateName);
        images[1] = SpriteCache.getInstance().getImage("middle" + stateName);
        images[2] = SpriteCache.getInstance().getImage("rightSide" + stateName);
    }
}
```

### La clase `ScoreLabelUI`

```java
package org.brick_breaker.ui.labels;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLabelUI;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ScoreLabelUI extends BasicLabelUI {

    protected BufferedImage background;

    static {
        SpriteCache cache = SpriteCache.getInstance();
        cache.addImage("scoreBackground", SpriteLoader.loadImage("labels/score-label.png"));
    }

    public ScoreLabelUI() {

        background = SpriteCache.getInstance().getImage("scoreBackground");
    }

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

    @Override
    public Dimension getPreferredSize(JComponent c) {

        return new Dimension(background.getWidth(), background.getHeight());
    }
}
```

### La clase `LifeLabelUI`

```java
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

    public LifeLabelUI() {

        background = SpriteCache.getInstance().getImage("lifeBackground");
    }

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
```

### La clase `TitleLabel`

```java
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
```

## Actualizando el `MainWindow`

Una vez hecho lo anterior, deberemos nombrar las etiquetas y botones de la barra izquierda de la siguiente manera:

- scoreLabel: Para la etiqueta de puntuación.
- lifeLabel: Para la etiqueta de vidas.
- startButton: Para el botón de iniciar.
- stopButton: Para el botón de detener.

Una vez hecho lo anterior, deberemos de marcar en dichos componentes la opción de `Custom Create` para que se creen con
el nuevo look and feel.

```java
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
```

En este caso se actualiza el método `createUIComponents` para que se creen los componentes con el nuevo look and
feel. Podrás notar que en los botones y etiquetas se crean como ua nuevo objeto con el texto correspondiente. Esto para
que los botones se configuren a sus nuevos looks and feel mediante la función `configureButton` y `configureLabel`
respectivamente.

## Entregable

El entregable de esta actividad es el proyecto completo, con los cambios realizados en las clases `Ball`, `Bonus`,
`Missile`, `GamePanel`, y `KeyboardAction`. Además de asegurarse que el juego funcione correctamente.

En el caso de la clase `MainWindow`, es necesario agregar dos etiquetas con los nombres: `scoreLabel` y `lifeLabel` para
que el juego muestre la puntuación y las vidas restantes, estas etiquetas deben ir en el panel derecho de la ventana
del juego.

## Criterios de evaluación

| Criterio      | Descripción                                                                   | Puntaje  |
|---------------|-------------------------------------------------------------------------------|----------|
| Portada       | Contiene los datos de identificación del equipo                               | 5%       |
| Funcionalidad | El juego funciona correctamente y no tiene errores de ejecución               | 10%      |
| Botones       | Los botones tienen el look and feel correcto y funcionan correctamente        | 10%      |
| Etiquetas     | Las etiquetas tienen el look and feel correcto y funcionan correctamente      | 10%      |
| Código        | El código está bien estructurado y sigue las buenas prácticas de programación | 25%      |
| Evidencias    | Se entregan las evidencias de la actividad (video captura de pantalla)        | 30%      |
| Documentación | El código está documentado y se entiende su funcionamiento                    | 10%      |
| **Total**     |                                                                               | **100%** |

## Fecha de entrega

- **Fecha límite de entrega:** martes 13 de mayo de 2025 a las 11:59 p.m.

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos como máximo.**
> {style="warning"}

> **Integrante que no aparezca en la portada del documento no será calificado.**
> {style="warning"}

> **Trabajo entregado en formato de texto plano no será calificado.**
> {style="warning"}