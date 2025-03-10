# La Palabra reservada final en Java

La palabra reservada `final` en Java se utiliza para definir constantes, métodos finales y clases finales. En este
tutorial, exploraremos cómo se utiliza la palabra reservada `final` en diferentes contextos en Java.

## Variables finales

En Java, una variable final es una variable cuyo valor no puede ser modificado una vez que se ha inicializado. Las
variables finales se declaran con la palabra reservada `final` y se pueden inicializar en la declaración o en el
constructor de la clase.

```java
public class Example {
    public final int MAX_VALUE = 100;
    public final double PI;

    public Example() {
        PI = 3.14159;
    }

    public static void main(String[] args) {
        Example e = new Example();
        System.out.println("Valor máximo: " + e.MAX_VALUE);
        System.out.println("Valor de PI: " + e.PI);
    }
}
```

En el ejemplo anterior, `MAX_VALUE` y `PI` son variables finales que se inicializan en la declaración y en el
constructor, respectivamente. Una vez que se han inicializado, no se pueden modificar sus valores.

## Métodos finales

En Java, un método final es un método que no puede ser sobrescrito por las subclases. Los métodos finales se declaran
con la palabra reservada `final` y no pueden ser modificados en las subclases.

```java
public class Animal {
    public final void eat() {
        System.out.println("El animal está comiendo");
    }
}
```

```java
public class Dog extends Animal {
    // Este método no se puede sobrescribir
    // public void eat() {
    //     System.out.println("El perro está comiendo");
    // }
}
```

En el ejemplo anterior, el método `eat` en la clase `Animal` es un método final que no se puede sobrescribir en la clase
`Dog`. Si se intenta sobrescribir el método `eat` en la clase `Dog`, se generará un error en tiempo de compilación.

## Clases finales

En Java, una clase final es una clase que no puede ser subclaseada. Las clases finales se declaran con la palabra
reservada `final` y no pueden tener subclases.

```java
public final class Animal {
    // Implementación de la clase
}
```

```java
// Esta clase no se puede heredarse
// public class Dog extends Animal {
//     // Implementación de la subclase
// }
```

En el ejemplo anterior, la clase `Animal` es una clase final que no puede ser heredada por otras clases. Si se intenta
crear una subclase de la clase `Animal`, se generará un error en tiempo de compilación.

## Variables finales estáticas

En Java, una variable final estática es una variable que es constante y se comparte entre todas las instancias de la
clase. Las variables finales estáticas se declaran con las palabras reservadas `final` y `static`.

```java
public class Example {
    public static final int MAX_VALUE = 100;
    public static final double PI = 3.14159;

    public static void main(String[] args) {
        System.out.println("Valor máximo: " + Example.MAX_VALUE);
        System.out.println("Valor de PI: " + Example.PI);
    }
}
```

En el ejemplo anterior, `MAX_VALUE` y `PI` son variables finales estáticas que se pueden acceder directamente a través
del nombre de la clase `Example`. Estas variables son constantes y no pueden ser modificadas una vez que se han
inicializado.

## Funciones finales estáticas

En Java, un método final estático es un método que no puede ser sobrescrito por las subclases y se puede acceder
directamente a través del nombre de la clase. Los métodos finales estáticos se declaran con las palabras reservadas
`final` y `static`.

```java
public class MathUtils {
    public static final int sum(int a, int b) {
        return a + b;
    }

    public static final double multiply(double a, double b) {
        return a * b;
    }

    public static void main(String[] args) {
        System.out.println("Suma: " + MathUtils.sum(5, 3));
        System.out.println("Multiplicación: " + MathUtils.multiply(5, 3));
    }
}
```

Toma en cuenta que si la clase es declaráda como final, no se puede heredar de ella, por lo que no se puede sobrescribir
ningún método, por lo que no es necesario declarar los métodos como finales.

## Resumen

En este tutorial, hemos explorado cómo se utiliza la palabra reservada `final` en Java para definir variables finales,
métodos finales y clases finales. Las variables finales no pueden ser modificadas una vez que se han inicializado, los
métodos finales no pueden ser sobrescritos por las subclases y las clases finales no pueden ser heredadas por otras

Es importante tener en cuenta que el uso de la palabra reservada `final` puede mejorar la seguridad y la eficiencia de
un programa al prevenir modificaciones no deseadas y garantizar la integridad de las clases y métodos definidos en Java.