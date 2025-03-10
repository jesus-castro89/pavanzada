# ¿Qué son las clases abstractas en Java?

Una clase abstracta es una clase que no se puede instanciar directamente, pero que puede tener métodos abstractos y
métodos concretos. Los métodos abstractos son métodos que no tienen una implementación y deben ser implementados por las
subclases. Los métodos concretos son métodos que tienen una implementación y pueden ser heredados por las subclases.

## Sintaxis

La sintaxis para definir una clase abstracta en Java es la siguiente:

```java
public abstract class ClaseAbstracta {
    // Métodos abstractos
    public abstract void metodoAbstracto();

    // Métodos concretos
    public void metodoConcreto() {
        // Implementación del método
    }
}
```

En el ejemplo anterior, `ClaseAbstracta` es una clase abstracta que tiene un método abstracto `metodoAbstracto` y un
método concreto `metodoConcreto`.

## Reglas para las clases abstractas

Algunas reglas para las clases abstractas en Java son las siguientes:

* Una clase abstracta no se puede instanciar directamente.
* Una clase abstracta puede tener métodos abstractos y métodos concretos.
* Una clase abstracta puede tener constructores.
* Una clase abstracta puede heredar de otra clase abstracta.
    * En este caso, la subclase debe implementar todos los métodos abstractos de las superclases abstractas.
* Una clase abstracta puede tener variables de instancia y métodos estáticos.
* Una clase abstracta puede implementar interfaces.
* Una clase abstracta puede tener métodos finales.
    * Estos métodos no pueden ser sobreescritos por las subclases. Por tanto, no pueden ser abstractos.
* Una clase abstracta puede tener métodos privados.
    * Estos métodos no pueden ser sobreescritos por las subclases, dado que no son visibles para ellas. Por tanto, no
      pueden ser abstractos.
* Una clase abstracta puede tener métodos estáticos.

## Ejemplo

A continuación, se muestra un ejemplo de una clase abstracta en Java:

```java
public abstract class Figura {
    private String color;

    public Figura(String color) {
        this.color = color;
    }

    public abstract double area();
}
```

En el ejemplo anterior, `Figura` es una clase abstracta que tiene un constructor y un método abstracto `area`. Las
subclases de `Figura` deben implementar el método `area` para calcular el área de la figura.

## Conclusiones

Las clases abstractas en Java son clases que no se pueden instanciar directamente y que pueden tener métodos abstractos
y métodos concretos. Las clases abstractas se utilizan para definir una interfaz común para las subclases y para
proporcionar una implementación base para los métodos comunes.