# Entendiendo mejor JOptionPane

Otra forma de leer datos es utilizando la clase `JOptionPane` que se encuentra en el paquete `javax.swing`. Para poder
utilizar esta clase se debe importar al inicio del archivo.

```java
import javax.swing.JOptionPane;
```

La clase nos ofrece varios métodos para mostrar mensajes y leer datos de los usuarios de una forma más amigable.

## Mostrar un mensaje

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

## Leer datos

Para leer datos utilizando `JOptionPane`, se puede utilizar el método `showInputDialog()` de la clase `JOptionPane`:

```java
String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
```

En este ejemplo, se muestra un mensaje con el texto `Ingrese su nombre:` en una ventana de diálogo y se guarda el valor
ingresado por el usuario en la variable `nombre`.

Si se desea leer un número entero, se puede utilizar el método `parseInt()` de la clase `Integer` para convertir el
valor devuelto por `showInputDialog()` a un entero:

```java
int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
```

> **Nota:** Si el usuario ingresa un valor que no puede ser convertido a un número entero, se lanzará una excepción de
> tipo `NumberFormatException`.

Existen otras alternativas para showInputDialog, como:

```java
String[] opciones = { "Opción 1", "Opción 2", "Opción 3" };
String opcion = (String) JOptionPane.showInputDialog(null, "Seleccione una opción:", "Título",
        JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
```

En este caso, se muestra un cuadro de diálogo con un mensaje, un título, un icono de pregunta y una lista de opciones
para que el usuario seleccione una de ellas.

### Ejemplo completo

A continuación se muestra un ejemplo completo que lee el nombre y la edad de una persona utilizando `JOptionPane` y
muestra un mensaje con estos datos:

```java
import javax.swing.JOptionPane;

class Main {
    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));

        JOptionPane.showMessageDialog(null, "Hola " + nombre + ", tienes " + edad + " años.");
    }
}
```

En este ejemplo, se lee el nombre y la edad de una persona utilizando `JOptionPane` y se muestra un mensaje con estos
datos en una ventana de diálogo.

Es importante tener en cuenta que `JOptionPane` es una forma sencilla y práctica de interactuar con el usuario en
aplicaciones de escritorio en Java, ya que proporciona una interfaz gráfica amigable para mostrar mensajes y leer datos.

## Ventana de Confirmación

Otra funcionalidad que nos ofrece `JOptionPane` es la posibilidad de mostrar una ventana de confirmación al usuario.
Esta ventana permite al usuario confirmar una acción antes de que se realice.

Para mostrar una ventana de confirmación, se puede utilizar el método `showConfirmDialog()` de la clase `JOptionPane`:

```java
int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea continuar?", "Confirmación",
        JOptionPane.YES_NO_OPTION);
```

En este ejemplo, se muestra una ventana de confirmación con un mensaje, un título y dos botones de opción (`Sí` y `No`).
El método `showConfirmDialog()` devuelve un valor entero que representa la opción seleccionada por el usuario:

- `JOptionPane.YES_OPTION` si el usuario selecciona `Sí`.
- `JOptionPane.NO_OPTION` si el usuario selecciona `No`.
- `JOptionPane.CLOSED_OPTION` si el usuario cierra la ventana sin seleccionar ninguna opción.
- `JOptionPane.CANCEL_OPTION` si el usuario cancela la operación.
- `JOptionPane.OK_OPTION` si el usuario selecciona `Aceptar`.
- `JOptionPane.CANCEL_OPTION` si el usuario selecciona `Cancelar`.

Este valor puede ser utilizado para realizar diferentes acciones en función de la respuesta del usuario.

Las alternativas de showConfirmDialog son:

| Constante              | Descripción                                  |
|------------------------|----------------------------------------------|
| `YES_NO_OPTION`        | Muestra los botones `Sí` y `No`.             |
| `YES_NO_CANCEL_OPTION` | Muestra los botones `Sí`, `No` y `Cancelar`. |
| `OK_CANCEL_OPTION`     | Muestra los botones `Aceptar` y `Cancelar`.  |

### Ejemplo completo de ventana de confirmación

A continuación se muestra un ejemplo completo que muestra una ventana de confirmación al usuario y realiza una acción
en función de la respuesta:

```java
import javax.swing.JOptionPane;

class Main {
    public static void main(String[] args) {
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea continuar?", "Confirmación",
                JOptionPane.YES_NO_OPTION);

        if (respuesta == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "La operación se realizó con éxito.");
        } else {
            JOptionPane.showMessageDialog(null, "La operación fue cancelada.");
        }
    }
}
```

En este ejemplo, se muestra una ventana de confirmación al usuario y se muestra un mensaje diferente en función de la
respuesta seleccionada por el usuario.

La ventana de confirmación es una herramienta útil para solicitar la confirmación del usuario antes de realizar una
acción importante en una aplicación de escritorio en Java.

## Conclusión

`JOptionPane` es una clase que nos permite interactuar con el usuario de una forma sencilla y amigable en aplicaciones
de escritorio en Java. Con `JOptionPane`, podemos mostrar mensajes, leer datos y solicitar confirmaciones de forma
rápida y eficiente. Esta clase es especialmente útil para aplicaciones que requieren una interfaz gráfica simple y
directa para interactuar con el usuario.