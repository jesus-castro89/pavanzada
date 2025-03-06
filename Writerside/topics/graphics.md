# La clase `Graphics`

En Java, la clase `Graphics` se utiliza para dibujar elementos en la pantalla. La clase `Graphics` es una clase
abstracta que proporciona métodos para dibujar líneas, rectángulos, círculos, texto, imágenes, etc.

## Métodos de la clase `Graphics`

Algunos de los métodos más comunes de la clase `Graphics` son:

| Método                                                                       | Descripción                                                                                                                            |
|------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------|
| `drawLine(int x1, int y1, int x2, int y2)`                                   | Dibuja una línea desde el punto `(x1, y1)` hasta el punto `(x2, y2)`.                                                                  |
| `drawRect(int x, int y, int width, int height)`                              | Dibuja un rectángulo con la esquina superior izquierda en el punto `(x, y)` y con el ancho y alto especificados.                       |
| `drawOval(int x, int y, int width, int height)`                              | Dibuja un óvalo inscrito en un rectángulo con la esquina superior izquierda en el punto `(x, y)` y con el ancho y alto especificados.  |
| `drawString(String str, int x, int y)`                                       | Dibuja el texto especificado en el punto `(x, y)`.                                                                                     |
| `drawImage(Image img, int x, int y, ImageObserver observer)`                 | Dibuja la imagen especificada en el punto `(x, y)`.                                                                                    |
| `setColor(Color c)`                                                          | Establece el color de dibujo.                                                                                                          |
| `setFont(Font font)`                                                         | Establece la fuente de texto.                                                                                                          |
| `fillRect(int x, int y, int width, int height)`                              | Rellena un rectángulo con la esquina superior izquierda en el punto `(x, y)` y con el ancho y alto especificados.                      |
| `fillOval(int x, int y, int width, int height)`                              | Rellena un óvalo inscrito en un rectángulo con la esquina superior izquierda en el punto `(x, y)` y con el ancho y alto especificados. |
| `fillPolygon(int[] xPoints, int[] yPoints, int nPoints)`                     | Rellena un polígono con los puntos especificados.                                                                                      |
| `fillArc(int x, int y, int width, int height, int startAngle, int arcAngle)` | Rellena un arco inscrito en un rectángulo con la esquina superior izquierda en el punto `(x, y)` y con el ancho y alto especificados.  |
| `drawPolygon(int[] xPoints, int[] yPoints, int nPoints)`                     | Dibuja un polígono con los puntos especificados.                                                                                       |
| `drawArc(int x, int y, int width, int height, int startAngle, int arcAngle)` | Dibuja un arco inscrito en un rectángulo con la esquina superior izquierda en el punto `(x, y)` y con el ancho y alto especificados.   |

## Ejemplo de uso de la clase `Graphics`

A continuación se muestra un ejemplo de cómo dibujar un rectángulo y un óvalo en un componente visual en Java:

```java
import javax.swing.*;

public class MyPanel extends JPanel {
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar un rectángulo
        g.drawRect(50, 50, 100, 100);

        // Dibujar un óvalo
        g.drawOval(200, 50, 100, 100);
    }
}
```

En el ejemplo anterior, la clase `MyPanel` hereda de `JPanel` y sobrescribe el método `paintComponent`. Dentro de este
método se llama al método `paintComponent` de la clase padre y luego se dibujan un rectángulo y un óvalo en el panel.

Es importante llamar al método `paintComponent` de la clase padre para que se dibujen los elementos del panel
correctamente. Si no se llama al método `paintComponent` de la clase padre, los elementos del panel no se dibujarán
correctamente.