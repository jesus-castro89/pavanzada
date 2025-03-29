# Dibujando imágenes con Graphics2D en Java

La clase `Graphics2D` en Java es una extensión de la clase `Graphics` que proporciona un conjunto más avanzado de
herramientas para dibujar gráficos en 2D. Permite realizar operaciones como rotación, escalado, y transformación de
imágenes, así como aplicar efectos de color y antialiasing.

La función `paintComponent` es el lugar donde se realiza el dibujo en un componente Swing. Aquí es donde se debe
definir cómo se verá el componente cuando se renderice. Es importante llamar al método `super.paintComponent(g)` para
asegurarse de que el componente se dibuje correctamente antes de aplicar cualquier dibujo personalizado.

## Ejemplo de uso de Graphics2D

```java
import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

public class Graphics2DExample extends JPanel {
    private BufferedImage image;

    public Graphics2DExample() {
        // Crear una imagen en blanco
        image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = image.createGraphics();

        // Dibujar un rectángulo
        g2d.setColor(Color.RED);
        g2d.fillRect(50, 50, 100, 100);

        // Dibujar un círculo
        g2d.setColor(Color.BLUE);
        g2d.fillOval(200, 50, 100, 100);

        // Aplicar transformaciones
        g2d.rotate(Math.toRadians(45), 200, 200);
        g2d.setColor(Color.GREEN);
        g2d.fillRect(150, 150, 100, 100);

        // Liberar recursos
        g2d.dispose();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Graphics2D Example");
        Graphics2DExample panel = new Graphics2DExample();
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

En este ejemplo, se crea una imagen en blanco y se dibujan un rectángulo rojo, un círculo azul y un rectángulo verde
rotado. La clase `BufferedImage` se utiliza para crear una imagen en memoria, y el método `createGraphics()` se
utiliza para obtener un objeto `Graphics2D` que se puede usar para dibujar en la imagen. Luego, en el método
`paintComponent`, se dibuja la imagen en el panel. Esto permite realizar un dibujo más complejo y luego renderizarlo
en el componente Swing.