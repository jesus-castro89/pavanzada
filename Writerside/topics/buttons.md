# El componente `JButton`

El componente `JButton` es una de las clases más utilizadas en la biblioteca Swing de Java para crear botones en
aplicaciones gráficas. A continuación, se presentan algunos aspectos clave sobre el uso de `JButton`:

## Creación de un botón

Para crear un botón en Java Swing, se utiliza la clase `JButton`. Aquí hay un ejemplo básico de cómo crear un botón y
agregarlo a un panel:

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JButton");
        JPanel panel = new JPanel();

        JButton button = new JButton("Haz clic aquí");

        // Agregar un ActionListener al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("¡Botón clicado!");
            }
        });

        panel.add(button);
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

En este ejemplo, se crea un botón con el texto "Haz clic aquí". Se agrega un `ActionListener` al botón para manejar el
evento de clic. Cuando el botón es clicado, se imprime un mensaje en la consola.

## Personalización del botón

Puedes personalizar la apariencia del botón utilizando métodos como `setText()`, `setIcon()`, `setBackground()`,
`setForeground()`, entre otros. Aquí hay un ejemplo de cómo cambiar el texto y el color de fondo del botón:

```java
button.setText("Nuevo Texto");
button.

setBackground(Color.BLUE);
button.

setForeground(Color.WHITE);
```

En el caso del editor visual de IntelliJ, puedes personalizar el botón utilizando las propiedades del componente en el
panel de propiedades. Puedes cambiar el texto, el color de fondo, el color del texto y otras propiedades visuales
directamente desde la interfaz gráfica.

## Manejo de eventos

El manejo de eventos en `JButton` se realiza a través de `ActionListener`. Puedes agregar múltiples `ActionListener` a
un botón si es necesario. También puedes utilizar expresiones lambda para simplificar el código:

```java
button.addActionListener(e ->System.out.

println("¡Botón clicado!"));
```

## Deshabilitar un botón

Puedes deshabilitar un botón utilizando el método `setEnabled(false)`. Esto hará que el botón no sea clicable y
aparezca atenuado. Para habilitarlo nuevamente, utiliza `setEnabled(true)`.

```java
button.setEnabled(false); // Deshabilitar el botón
button.

setEnabled(true);  // Habilitar el botón
```

## Ejemplo completo

Aquí tienes un ejemplo completo que combina todo lo anterior:

```java
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class ButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JButton");
        JPanel panel = new JPanel();

        JButton button = new JButton("Haz clic aquí");
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);

        // Agregar un ActionListener al botón
        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "¡Botón clicado!");
        });

        panel.add(button);
        frame.add(panel);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
```

En este ejemplo, se crea un botón con un fondo azul y texto blanco. Al hacer clic en el botón, se muestra un cuadro de
diálogo con un mensaje. Puedes personalizar aún más el botón y su comportamiento según tus necesidades.

## Conclusión

El componente `JButton` es una herramienta poderosa para crear botones en aplicaciones gráficas de Java. Puedes
personalizar tanto su apariencia como su comportamiento utilizando `ActionListener` y otros métodos de la clase
`JButton`. Con estos conceptos, puedes crear interfaces de usuario interactivas y atractivas en tus aplicaciones Java.
