# Declarando una clase en Java

Una clase en Java es un plano para crear objetos. Las clases en Java se declaran con la palabra clave `class` seguida
del nombre de la clase. Por ejemplo:

```java
public class [NombreClase] {
    // Cuerpo de la clase
}
```

En este ejemplo, `[NombreClase]` es el nombre de la clase que se está declarando. El cuerpo de la clase contiene los
métodos, variables y bloques de código que definen el comportamiento de la clase.

## Los atributos de una clase

Los atributos de una clase son variables que almacenan datos relacionados con la clase. Los atributos se declaran dentro
de la clase y pueden ser de diferentes tipos de datos, como `int`, `double`, `String`, etc. Por ejemplo:

```java
public class Persona {
    // Atributos de la clase Persona
    private String nombre;
    private int edad;
    private double altura;
}
```

En este ejemplo, la clase `Persona` tiene tres atributos: `nombre`, `edad` y `altura`. Estos atributos son variables que
almacenan información relacionada con una persona.

## Los métodos de una clase

Los métodos de una clase son bloques de código que definen el comportamiento de la clase. Los métodos se declaran dentro
de la clase y pueden realizar diferentes tareas, como calcular un valor, modificar un atributo, etc. Por ejemplo:

```java
public class Persona {
    // Atributos de la clase Persona
    private String nombre;
    private int edad;
    private double altura;

    // Método para imprimir los datos de la persona
    public void imprimirDatos() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura);
    }
}
```

En este ejemplo, la clase `Persona` tiene un método `imprimirDatos` que imprime los atributos `nombre`, `edad` y
`altura` de la persona.

## El bloque de ejecución `main`

El bloque de ejecución `main` es el punto de entrada de un programa en Java. Este bloque de código se ejecuta cuando se
inicia el programa y se declara dentro de una clase. Por ejemplo:

```java
public class Main {
    public static void main(String[] args) {
        // Cuerpo del bloque main
    }
}
```

> **Nota:** El bloque de ejecución `main` debe declararse dentro de una clase en Java y debe tener la siguiente firma:
> `public static void main(String[] args)`. Este bloque de código es el punto de entrada de un programa en Java y se
> ejecuta cuando se inicia el programa. Pueden existir múltiples bloques `main` en un programa, pero solo uno se ejecuta
> cuando se inicia el programa. Así mismo, el bloque `main` debe ser `public` para que el programa pueda ser ejecutado
> desde la línea de comandos.

> **Nota:** Cada clase puede contar con un bloque `main`, pero solo uno de ellos será el punto de entrada del programa.

> **No es posible tener dos bloques `main` en una misma clase, ya que el compilador de Java no permitirá la compilación
> del código.**
> {style="warning"}

## Creando objetos de una clase

Para utilizar una clase en Java, es necesario crear un objeto de esa clase. Un objeto es una instancia de una clase que
almacena los datos y el comportamiento definidos en la clase. Por ejemplo:

```java
public class Main {
    public static void main(String[] args) {
        // Crear un objeto de la clase Persona
        Persona persona = new Persona();

        // Asignar valores a los atributos del objeto
        persona.nombre = "Juan";
        persona.edad = 30;
        persona.altura = 1.75;

        // Llamar al método imprimirDatos del objeto
        persona.imprimirDatos();
    }
}
```

En este ejemplo, se crea un objeto de la clase `Persona` y se asignan valores a los atributos `nombre`, `edad` y
`altura` del objeto. Luego, se llama al método `imprimirDatos` del objeto para imprimir los datos de la persona.

> **Nota:** Para crear un objeto de una clase en Java, se utiliza la palabra clave `new` seguida del nombre de la clase
> y los paréntesis `()`. Por ejemplo, `Persona persona = new Persona();` crea un objeto de la clase `Persona` y lo
> asigna a la variable `persona` de tipo `Persona`.

## Conclusión

En resumen, una clase en Java es un plano para crear objetos que almacenan datos y comportamiento relacionados. Las
clases en Java se declaran con la palabra clave `class` seguida del nombre de la clase y pueden contener atributos,
métodos y bloques de ejecución `main`. Para utilizar una clase en Java, es necesario crear un objeto de esa clase y
asignar valores a los atributos del objeto. Las clases en Java son una parte fundamental de la programación orientada a
objetos y permiten organizar y reutilizar el código de manera eficiente.