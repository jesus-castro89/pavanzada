# La clase UIManager

La clase `UIManager` es una clase de utilidad que proporciona métodos estáticos para personalizar la apariencia de los
componentes de la interfaz de usuario de Swing. Permite cambiar la apariencia de los componentes de la interfaz de
usuario, como los botones, las etiquetas, los cuadros de texto, etc.

## Personalizando la apariencia de JOptionPane

Uno de los usos más comunes de la clase `UIManager` es personalizar la apariencia de los mensajes emergentes de tipo
`JOptionPane`. Por ejemplo, se puede cambiar el tamaño y la fuente del texto de los mensajes, el tamaño y la fuente de
los botones de los mensajes, y el color del texto de los mensajes.

A continuación se muestra la lista de opciones que se pueden personalizar en un `JOptionPane`:

- `OptionPane.background`: Color de fondo de los mensajes.
- `OptionPane.border`: Borde de los mensajes.
- `OptionPane.buttonAreaBorder`: Borde del área de los botones de los mensajes.
- `OptionPane.buttonFont`: Fuente de los botones de los mensajes.
- `OptionPane.cancelButtonText`: Texto del botón de cancelar.
- `OptionPane.errorIcon`: Icono de error.
- `OptionPane.font`: Fuente de los mensajes.
- `OptionPane.foreground`: Color del texto de los mensajes.
- `OptionPane.informationIcon`: Icono de información.
- `OptionPane.inputDialogTitle`: Título de la ventana de entrada.
- `OptionPane.messageAreaBorder`: Borde del área de los mensajes.
- `OptionPane.messageDialogTitle`: Título de la ventana de mensaje.
- `OptionPane.messageFont`: Fuente del texto de los mensajes.
- `OptionPane.messageForeground`: Color del texto de los mensajes.
- `OptionPane.minimumSize`: Tamaño mínimo de los mensajes.
- `OptionPane.noButtonText`: Texto del botón de no.
- `OptionPane.okButtonText`: Texto del botón de aceptar.
- `OptionPane.questionIcon`: Icono de pregunta.
- `OptionPane.titleText`: Texto del título de los mensajes.
- `OptionPane.warningIcon`: Icono de advertencia.
- `OptionPane.windowBindings`: Enlaces de teclas de los mensajes.
- `OptionPane.yesButtonText`: Texto del botón de sí.

### Ejemplo

El siguiente ejemplo muestra cómo personalizar la apariencia de los mensajes emergentes de tipo `JOptionPane`:

```java
import javax.swing.*;

public class UIManagerExample {

    public static void main(String[] args) {
        UIManager.put("OptionPane.messageFont", 
                new Font("Arial", Font.BOLD, 24));
        UIManager.put("OptionPane.buttonFont", 
                new Font("Arial", Font.BOLD, 24));
        UIManager.put("TextField.font",
                new Font("Arial", Font.PLAIN, 24));
        UIManager.put("OptionPane.messageForeground", Color.RED);

        JOptionPane.showMessageDialog(null, "Hello, World!");
    }
}
```
