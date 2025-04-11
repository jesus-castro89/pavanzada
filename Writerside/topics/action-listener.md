# La interfaz `ActionListener`

Esta interfaz es parte de la biblioteca `java.awt.event` y se utiliza para manejar eventos de acción, como clics de
botones. Un objeto que implementa esta interfaz puede ser registrado como un escuchador de eventos de acción en un
componente de la interfaz gráfica de usuario (GUI), como un botón. Cuando se produce un evento de acción, se llama al
método `actionPerformed()` del objeto escuchador, lo que permite ejecutar el código correspondiente para manejar el
evento.

## Ejemplo de uso de ActionListener

```java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ActionListenerEjemplo {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de ActionListener");
        JButton button = new JButton("Haz clic aquí");

        // Agregar un ActionListener al botón
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "¡Botón clicado!");
            }
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
```

En este ejemplo, se crea una ventana con un botón. Cuando el usuario hace clic en el botón, se genera un evento de
acción
y se muestra un cuadro de diálogo con un mensaje. El botón está registrado como escuchador del evento de acción
utilizando
el método `addActionListener()`, que toma un objeto que implementa la interfaz `ActionListener`. Cuando se genera el
evento, se llama al método `actionPerformed()` del escuchador, que contiene el código para manejar el evento.

Sin embargo, podemos desacoplar el código del evento de acción utilizando una clase anónima o una expresión lambda (en
Java 8 y versiones posteriores). Aquí hay un ejemplo utilizando una expresión lambda:

```java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ActionListenerEjemploLambda {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de ActionListener con Lambda");
        JButton button = new JButton("Haz clic aquí");

        // Agregar un ActionListener al botón utilizando una expresión lambda
        button.addActionListener(e -> JOptionPane.showMessageDialog(frame, "¡Botón clicado!"));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
```

En este caso, la expresión lambda simplifica el código al eliminar la necesidad de crear una clase anónima y
definir el método `actionPerformed()` por separado. La expresión lambda se utiliza directamente como el manejador del
evento de acción.

Ahora veamos como implementar un ActionListener en una clase separada:

```java
import javax.swing.*;
import java.awt.event.*;

public class MiActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("¡Botón clicado desde una clase separada!");
    }
}
````

```java
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ActionListenerEjemploClaseSeparada {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de ActionListener en Clase Separada");
        JButton button = new JButton("Haz clic aquí");

        // Agregar un ActionListener al botón utilizando una clase separada
        button.addActionListener(new MiActionListener());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(button);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
```

En este ejemplo, hemos creado una clase `MiActionListener` que implementa la interfaz `ActionListener`. Luego, al
agregar el `ActionListener` al botón, simplemente creamos una instancia de `MiActionListener`. Esto permite una mejor
organización del código y la posibilidad de reutilizar el `ActionListener` en diferentes componentes o clases.

## Conclusión

La interfaz `ActionListener` es una parte fundamental del modelo de eventos en Java y se utiliza para manejar eventos de
acción en componentes de la interfaz gráfica de usuario. Permite a los desarrolladores crear aplicaciones interactivas y
responder a las acciones del usuario de manera eficiente. Al implementar `ActionListener`, los desarrolladores pueden
definir el comportamiento de los componentes de la GUI y crear aplicaciones más dinámicas y atractivas.
