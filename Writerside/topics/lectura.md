# Lectura de Datos

En java existen diversas formas de leer datos, en este caso se explicará la lectura de datos por consola.

## Lectura de datos por consola

Para leer datos por consola se utiliza la clase `Scanner` que se encuentra en el paquete `java.util`. Para poder
utilizar esta clase se debe importar al inicio del archivo.

```java
import java.util.Scanner;
```

Para leer datos por consola se debe seguir los siguientes pasos:

1. Crear un objeto de la clase `Scanner` y pasar como argumento el objeto `System.in` que representa la entrada
   estándar.
    ```java
    Scanner scanner = new Scanner(System.in);
    ```

Una vez hecho esto puedes usar los métodos de la clase `Scanner` para leer datos. Algunos de los métodos más comunes
son:

| Método          | Descripción              |
|-----------------|--------------------------|
| `next()`        | Lee una cadena de texto. |
| `nextInt()`     | Lee un número entero.    |
| `nextDouble()`  | Lee un número decimal.   |
| `nextBoolean()` | Lee un valor booleano.   |

A continuación se muestra un ejemplo de lectura de datos por consola:

```java
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.next();

        System.out.print("Ingrese su edad: ");
        int edad = scanner.nextInt();

        System.out.println("Hola " + nombre + ", tienes " + edad + " años.");
    }
}
```

En este ejemplo se lee el nombre y la edad de una persona por consola y se imprime un mensaje con estos datos.

Es importante cerrar el objeto `Scanner` una vez que ya no se necesite leer más datos. Para cerrar el objeto `Scanner`
se utiliza el método `close()`.

```java
scanner.close();
```

Es importante cerrar el objeto `Scanner` para liberar los recursos que utiliza.

## Lectura usando BufferedReader

Otra forma de leer datos por consola es utilizando la clase `BufferedReader` que se encuentra en el paquete `java.io`.
Para poder utilizar esta clase se debe importar al inicio del archivo.

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
```

Para leer datos por consola se debe seguir los siguientes pasos:

1. Crear un objeto de la clase `BufferedReader` y pasar como argumento un objeto de la clase `InputStreamReader` que
   representa la entrada estándar.
    ```java
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ```
2. Leer una línea de texto utilizando el método `readLine()` de la clase `BufferedReader`.
    ```java
    String linea = br.readLine();
    ```
3. Convertir la línea de texto a un tipo de dato específico si es necesario.
4. Cerrar el objeto `BufferedReader` una vez que ya no se necesite leer más datos.
    ```java
    br.close();
    ```

A continuación se muestra un ejemplo de lectura de datos por consola utilizando la clase `BufferedReader`:

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Ingrese su nombre: ");
        String nombre = br.readLine();

        System.out.print("Ingrese su edad: ");
        int edad = Integer.parseInt(br.readLine());

        System.out.println("Hola " + nombre + ", tienes " + edad + " años.");

        br.close();
    }
}
```

En este ejemplo se lee el nombre y la edad de una persona por consola y se imprime un mensaje con estos datos.

Es importante cerrar el objeto `BufferedReader` una vez que ya no se necesite leer más datos. Para cerrar el objeto
`BufferedReader` se utiliza el método `close()`.

## Lectura de datos usando JOptionPane

Otra forma de leer datos es utilizando la clase `JOptionPane` que se encuentra en el paquete `javax.swing`. Para poder
utilizar esta clase se debe importar al inicio del archivo.

```java
import javax.swing.JOptionPane;
```

Para leer datos utilizando `JOptionPane` se debe seguir los siguientes pasos:

1. Llamar al método `showInputDialog()` de la clase `JOptionPane` y pasar como argumento un mensaje que se mostrará en
   la ventana de diálogo.
    ```java
    String nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
    ```
2. Convertir el valor devuelto por el método `showInputDialog()` a un tipo de dato específico si es necesario.

A continuación se muestra un ejemplo de lectura de datos utilizando la clase `JOptionPane`:

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

En este ejemplo se lee el nombre y la edad de una persona utilizando ventanas de diálogo y se imprime un mensaje con
estos datos.