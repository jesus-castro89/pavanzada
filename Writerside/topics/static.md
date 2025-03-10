# La palabra reservada `static`

En Java, la palabra reservada `static` se utiliza para declarar miembros de una clase que pertenecen a la clase en sí
misma, en lugar de a una instancia específica de la clase. Esto significa que los miembros estáticos se comparten entre
todas las instancias de la clase y se pueden acceder directamente a través del nombre de la clase, sin necesidad de
crear una instancia de la clase.

## Uso de la palabra reservada `static`

La palabra reservada `static` se puede aplicar a los siguientes miembros de una clase:

* **Variables estáticas**: Las variables estáticas se declaran con la palabra reservada `static` y se inicializan una
  sola vez en el momento en que se carga la clase en la memoria. Estas variables se comparten entre todas las instancias
  de la clase y se pueden acceder directamente a través del nombre de la clase.
* **Métodos estáticos**: Los métodos estáticos se declaran con la palabra reservada `static` y se pueden invocar a
  través del nombre de la clase, sin necesidad de crear una instancia de la clase. Estos métodos no pueden acceder a
  variables de instancia no estáticas ni llamar a métodos no estáticos directamente.
* **Bloques estáticos**: Los bloques estáticos se utilizan para inicializar variables estáticas y se ejecutan una sola
  vez cuando se carga la clase en la memoria. Estos bloques se ejecutan antes de que se cree cualquier instancia de la
  clase.

## Variables estáticas en Java

Las variables estáticas se declaran con la palabra reservada `static` y se inicializan una sola vez en el momento en que
se carga la clase en la memoria. Estas variables se comparten entre todas las instancias de la clase y se pueden acceder
directamente a través del nombre de la clase.

```java
public class Example {
    public static int count = 0;

    public Example() {
        count++;
    }

    public static void main(String[] args) {
        Example e1 = new Example();
        Example e2 = new Example();

        System.out.println("Número de instancias creadas: " + Example.count);
    }
}
```

En el ejemplo anterior, la variable estática `count` se incrementa cada vez que se crea una nueva instancia de la clase
`Example`. La variable `count` se comparte entre todas las instancias de la clase y se puede acceder directamente a
través del nombre de la clase.

## Métodos estáticos en Java

Los métodos estáticos se declaran con la palabra reservada `static` y se pueden invocar a través del nombre de la clase,
sin necesidad de crear una instancia de la clase. Estos métodos no pueden acceder a variables de instancia no estáticas
ni llamar a métodos no estáticos directamente.

```java
public class MathUtils {
    public static int sum(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        int result1 = MathUtils.sum(5, 3);
        int result2 = MathUtils.multiply(5, 3);

        System.out.println("Suma: " + result1);
        System.out.println("Multiplicación: " + result2);
    }
}
```

En el ejemplo anterior, los métodos `sum` y `multiply` son métodos estáticos que se pueden invocar directamente a través
del nombre de la clase `MathUtils`. Estos métodos no requieren la creación de una instancia de la clase para ser
llamados.

## Bloques estáticos en Java

Los bloques estáticos se utilizan para inicializar variables estáticas y se ejecutan una sola vez cuando se carga la
clase en la memoria. Estos bloques se ejecutan antes de que se cree cualquier instancia de la clase.

```java
public class StaticBlockExample {
    public static int number;

    static {
        number = 10;
        System.out.println("Bloque estático ejecutado.");
    }

    public static void main(String[] args) {
        System.out.println("Número estático: " + StaticBlockExample.number);
    }
}
```

En el ejemplo anterior, el bloque estático se ejecuta cuando se carga la clase `StaticBlockExample` en la memoria y
asigna el valor `10` a la variable estática `number`. El bloque estático se ejecuta antes de que se cree cualquier
instancia de la clase y se imprime un mensaje en la consola.

## Ventajas de los miembros estáticos

Los miembros estáticos, como variables estáticas, métodos estáticos y bloques estáticos, tienen varias ventajas en Java:

* **Compartir datos entre instancias**: Las variables estáticas permiten compartir datos entre todas las instancias de
  la clase y mantener un estado común.
* **Acceso directo**: Los miembros estáticos se pueden acceder directamente a través del nombre de la clase, sin
  necesidad de crear una instancia de la clase.
* **Funcionalidades comunes**: Los métodos estáticos son útiles para definir funcionalidades comunes que no dependen de
  una instancia particular de la clase y se pueden invocar directamente a través del nombre de la clase.
* **Inicialización única**: Los bloques estáticos se ejecutan una sola vez cuando se carga la clase en la memoria y se
  utilizan para inicializar variables estáticas de manera segura.
* **Eficiencia**: Los miembros estáticos pueden mejorar la eficiencia y el rendimiento de una aplicación al evitar la
  creación de múltiples instancias de la clase.
* **Utilidades**: Los miembros estáticos son útiles para definir utilidades y métodos de ayuda que se pueden utilizar en
  toda la aplicación sin necesidad de crear instancias de la clase.

## Desventajas de los miembros estáticos

A pesar de las ventajas de los miembros estáticos, también existen algunas desventajas que deben tenerse en cuenta:

* **Acoplamiento**: El uso excesivo de miembros estáticos puede aumentar el acoplamiento entre las clases y dificultar
  la prueba y el mantenimiento del código.
* **Estado compartido**: Compartir datos a través de variables estáticas puede llevar a problemas de concurrencia y
  estado compartido entre diferentes partes de la aplicación.
* **Dificultad para probar**: Los métodos estáticos pueden ser difíciles de probar, ya que no se pueden reemplazar con
  implementaciones de prueba.
* **Inflexibilidad**: Los miembros estáticos pueden limitar la flexibilidad y la extensibilidad de una clase al
  acoplarla a un estado y comportamiento específicos.
* **Memoria estática**: Los miembros estáticos se almacenan en la memoria de la aplicación durante toda la vida útil del
  programa, lo que puede consumir recursos innecesarios si no se gestionan adecuadamente.

## Conclusión

La palabra reservada `static` en Java se utiliza para declarar miembros de una clase que pertenecen a la clase en sí
misma y se comparten entre todas las instancias de la clase. Los miembros estáticos, como variables estáticas, métodos
estáticos y bloques estáticos, son útiles para definir funcionalidades comunes que no dependen de una instancia
particular de la clase y se pueden acceder directamente a través del nombre de la clase.