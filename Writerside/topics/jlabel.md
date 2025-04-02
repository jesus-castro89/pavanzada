# La etiqueta `JLabel` en Java Swing

`JLabel` es una clase de Java Swing que se utiliza para mostrar texto o imágenes en una interfaz gráfica de usuario
(GUI). Es un componente ligero que no es interactivo, lo que significa que no puede recibir eventos de usuario como
clics o teclado. Sin embargo, se puede utilizar para mostrar información estática o etiquetas para otros componentes
gráficos, como botones o campos de texto.

## Creación de un JLabel

Para crear un `JLabel`, se puede utilizar el constructor de la clase `JLabel` y pasarle el texto o la imagen que se
desea mostrar. Aquí hay un ejemplo básico de cómo crear un `JLabel` y agregarlo a un panel:

```java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class JLabelExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JLabel");
        JPanel panel = new JPanel();

        // Crear un JLabel con texto
        JLabel label = new JLabel("Hola, mundo!");
        label.setForeground(Color.BLUE); // Cambiar el color del texto

        // Agregar el JLabel al panel
        panel.add(label);
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

En este ejemplo, se crea un `JLabel` con el texto "Hola, mundo!" y se establece el color del texto a azul. Luego, se
agrega el `JLabel` al panel y se muestra en la ventana.

## Personalización del JLabel

Puedes personalizar la apariencia del `JLabel` utilizando métodos como `setText()`, `setIcon()`, `setBackground()`,
`setForeground()`, entre otros. Aquí hay un ejemplo de cómo cambiar el texto y el color de fondo del `JLabel`:

```java
label.setText("Nuevo Texto");
label.

setBackground(Color.YELLOW); // Cambiar el color de fondo
label.

setOpaque(true); // Hacer que el fondo sea visible
```

En este caso, se cambia el texto del `JLabel` a "Nuevo Texto" y se establece el color de fondo a amarillo. También
se establece la propiedad `setOpaque(true)` para que el color de fondo sea visible, ya que por defecto los `JLabel` son
transparentes.

## Uso de imágenes en JLabel

Puedes utilizar imágenes en un `JLabel` utilizando el método `setIcon()`. Aquí hay un ejemplo de cómo mostrar una
imagen en un `JLabel`:

```java
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Image;

public class JLabelImageExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JLabel con Imagen");
        JPanel panel = new JPanel();

        // Crear un JLabel con una imagen
        ImageIcon icon = new ImageIcon("ruta/a/la/imagen.png");
        JLabel label = new JLabel(icon);
        label.setBackground(Color.YELLOW); // Cambiar el color de fondo
        label.setOpaque(true); // Hacer que el fondo sea visible

        // Agregar el JLabel al panel
        panel.add(label);
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

En este ejemplo, se crea un `JLabel` con una imagen utilizando `ImageIcon`. Asegúrate de proporcionar la ruta correcta
a la imagen en el constructor de `ImageIcon`. También se establece un color de fondo amarillo y se hace que el fondo
sea visible.

## Manejo de eventos

Aunque `JLabel` no es interactivo, puedes agregar un `MouseListener` para manejar eventos de mouse, como clics o
desplazamientos. Aquí hay un ejemplo de cómo agregar un `MouseListener` a un `JLabel`:

```java
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseMotionAdapter;

public class JLabelMouseListenerExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JLabel con MouseListener");
        JPanel panel = new JPanel();

        // Crear un JLabel
        JLabel label = new JLabel("Haz clic aquí");
        label.setForeground(Color.BLUE); // Cambiar el color del texto

        // Agregar un MouseListener al JLabel
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("¡JLabel clicado!");
            }
        });

        // Agregar el JLabel al panel
        panel.add(label);
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

En este ejemplo, se agrega un `MouseListener` al `JLabel` para manejar el evento de clic. Cuando el `JLabel` es
clicado, se imprime un mensaje en la consola. Puedes personalizar el comportamiento del `MouseListener` según tus
necesidades.

## Conclusión

`JLabel` es un componente útil en Java Swing para mostrar texto o imágenes en una interfaz gráfica de usuario. Puedes
personalizar su apariencia y comportamiento utilizando diferentes métodos y eventos. Es una herramienta valiosa para
crear interfaces gráficas efectivas y atractivas en aplicaciones Java.