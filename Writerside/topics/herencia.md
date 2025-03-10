# La Herencia en Java

La herencia es un concepto fundamental en la programación orientada a objetos. En Java, la herencia se logra mediante la
palabra clave `extends`. La herencia permite que una clase herede los atributos y métodos de otra clase. La clase que
hereda se conoce como subclase, mientras que la clase de la que se hereda se conoce como superclase.

## Definiciones

Antes de comenzar a hablar sobre la herencia en Java, es importante definir algunos conceptos clave:

- **Clase**: Una clase es un modelo que define los atributos y métodos de un objeto. En Java, las clases se definen con
  la palabra clave `class`.
- **Objeto**: Un objeto es una instancia de una clase. Los objetos tienen atributos y métodos que se definen en la
  clase.
- **Atributo**: Un atributo es una variable que se define en una clase. Los atributos representan las propiedades de un
  objeto.
- **Método**: Un método es una función que se define en una clase. Los métodos representan el comportamiento de un
  objeto.
- **Herencia**: La herencia es un mecanismo que permite que una clase herede los atributos y métodos de otra clase.
- **Superclase**: La superclase es la clase de la que se hereda. La superclase también se conoce como clase base o clase
  padre.
- **Subclase**: La subclase es la clase que hereda de otra clase. La subclase también se conoce como clase derivada o
  clase hija.
- **Sobrescritura**: La sobrescritura es un mecanismo que permite que una subclase reemplace un método de la superclase
  con una implementación diferente.

## Sintaxis

La sintaxis para definir una clase que hereda de otra clase en Java es la siguiente:

```java
public class Subclase extends Superclase {
    // Cuerpo de la subclase
}
```

En el ejemplo anterior, `Subclase` es la subclase y `Superclase` es la superclase. La subclase hereda todos los
atributos y métodos de la superclase. La subclase también puede agregar nuevos atributos y métodos, y sobrescribir los
métodos de la superclase.

## Ejemplo

A continuación, se muestra un ejemplo de herencia en Java:

```java
public class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public void emitirSonido() {
        System.out.println("El animal emite un sonido");
    }
}
```

```java
public class Perro extends Animal {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("El perro ladra");
    }
}
```

En el ejemplo anterior, la clase `Perro` hereda de la clase `Animal`. La clase `Perro` sobrescribe el método
`emitirSonido` para que el perro ladre en lugar de emitir un sonido genérico.

## Conclusiones

La herencia es un concepto poderoso en la programación orientada a objetos que permite reutilizar código y modelar
relaciones entre clases. En Java, la herencia se logra mediante la palabra clave `extends`. Al heredar de una clase, una
subclase obtiene todos los atributos y métodos de la superclase, lo que facilita la creación de jerarquías de clases
bien estructuradas.