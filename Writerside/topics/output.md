# Salida de datos

Para mostrar mensajes en la consola de Java, se utiliza el método `print()` de la clase `System.out`. Este método
permite mostrar mensajes en la consola sin saltar de línea. Si se desea mostrar un mensaje y saltar de línea, se puede
utilizar el método `println()`.

## Ejemplo de salida de datos por consola

A continuación se muestra un ejemplo de cómo mostrar mensajes en la consola utilizando los métodos `print()` y
`println()`:

```java
class Main {
    public static void main(String[] args) {
        System.out.print("Hola, ");
        System.out.println("mundo!");
        System.out.println("¡Bienvenidos a Writerside!");
    }
}
```

En este ejemplo, se muestra el mensaje `Hola, ` en la consola sin saltar de línea, luego se muestra el mensaje `mundo!`
en la misma línea y finalmente se muestra el mensaje `¡Bienvenidos a Writerside!` en una nueva línea.

## Salida de datos usando JOptionPane

Otra forma de mostrar mensajes es utilizando la clase `JOptionPane` que se encuentra en el paquete `javax.swing`. Para
poder utilizar esta clase se debe importar al inicio del archivo.

```java
import javax.swing.JOptionPane;
``` 

La clase nos ofrece varios métodos para mostrar mensajes de una forma más amigable.

### Mostrar un mensaje

Para mostrar un mensaje en una ventana de diálogo, se puede utilizar el método `showMessageDialog()` de la clase
`JOptionPane`:

```java
JOptionPane.showMessageDialog(null, "Hola, mundo!");
```

En este ejemplo, se muestra un mensaje con el texto `Hola, mundo!` en una ventana de diálogo. El primer argumento del
método `showMessageDialog()` es el componente padre de la ventana de diálogo, que en este caso es `null`.

Aunque tenemos otras alternativas para showMessageDialog, como:

```java
JOptionPane.showMessageDialog(null, "Hola, mundo!", "Título", JOptionPane.INFORMATION_MESSAGE);
```

En este caso, se muestra un mensaje con el texto `Hola, mundo!`, un título `Título` y un icono de información en una
ventana de diálogo.

Siendo los iconos de los mensajes los siguientes:

| Icono       | Constante                         |
|-------------|-----------------------------------|
| Información | `JOptionPane.INFORMATION_MESSAGE` |
| Advertencia | `JOptionPane.WARNING_MESSAGE`     |
| Error       | `JOptionPane.ERROR_MESSAGE`       |
| Pregunta    | `JOptionPane.QUESTION_MESSAGE`    |
| Sin icono   | `JOptionPane.PLAIN_MESSAGE`       |
