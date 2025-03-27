# La clase `JPanel`

Un `JPanel` es un contenedor que puede contener otros componentes. Es una clase que hereda de `JComponent` y que se
utiliza para agrupar componentes en una interfaz gráfica.

## Personalizando un JPanel

Para poder personalizar o trabajar con un `JPanel` es necesario crear una clase que herede de `JPanel` y sobreescribir
el método `paintComponent(Graphics g)`.

```java
import javax.swing.*;
import java.awt.*;

public class MiPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Aquí se dibuja el contenido del panel
    }
}
```

En este caso la clase `MiPanel` hereda de `JPanel` y sobreescribe el método `paintComponent(Graphics g)` para poder
dibujar el contenido del panel. En otras palabras, cuando agreguemos un componente de tipo `MiPanel` a un contenedor,
como un `JFrame`, el método `paintComponent(Graphics g)` se ejecutará y se dibujará el contenido del panel.

## Funciones útiles

Las funciones más comunes que se utilizan con un `JPanel` son:

| Método                                      | Descripción                              |
|---------------------------------------------|------------------------------------------|
| `setBackground(Color c)`                    | Establece el color de fondo del panel.   |
| `setBorder(Border b)`                       | Establece el borde del panel.            |
| `setLayout(LayoutManager layout)`           | Establece el layout del panel.           |
| `add(Component comp)`                       | Agrega un componente al panel.           |
| `remove(Component comp)`                    | Elimina un componente del panel.         |
| `repaint()`                                 | Vuelve a pintar el panel.                |
| `revalidate()`                              | Vuelve a validar el panel.               |
| `setOpaque(boolean isOpaque)`               | Establece si el panel es opaco.          |
| `setPreferredSize(Dimension preferredSize)` | Establece el tamaño preferido del panel. |
| `setMinimumSize(Dimension minimumSize)`     | Establece el tamaño mínimo del panel.    |
| `setMaximumSize(Dimension maximumSize)`     | Establece el tamaño máximo del panel.    |
| `setVisible(boolean aFlag)`                 | Establece si el panel es visible.        |

## Ejemplo

```java
import javax.swing.*;
import java.awt.*;

public class MiPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.fillRect(10, 10, 100, 100);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        MiPanel panel = new MiPanel();
        panel.setBackground(Color.WHITE);

        frame.add(panel);
        frame.setVisible(true);
    }
}
```

En este ejemplo se crea una clase `MiPanel` que hereda de `JPanel` y se sobreescribe el método
`paintComponent(Graphics g)` para dibujar un rectángulo rojo en el panel. Luego se crea un `JFrame` y se agrega un
componente de tipo `MiPanel` al `JFrame`.