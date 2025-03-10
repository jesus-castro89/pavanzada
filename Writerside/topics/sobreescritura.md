# Sobre escritura y el uso de la palabra clave `super` en Java

La sobrescritura es un mecanismo que permite que una subclase reemplace un método de la superclase con una
implementación diferente. La sobrescritura se utiliza para modificar el comportamiento de un método en la subclase sin
cambiar la definición del método en la superclase.

## Sintaxis de la sobrescritura en Java

La sintaxis para sobrescribir un método en Java es la siguiente:

```java
public class Subclase extends Superclase {
    @Override
    public void metodo() {
        // Implementación del método en la subclase
    }
}
```

En el ejemplo anterior, `Subclase` es la subclase y `Superclase` es la superclase. La subclase sobrescribe el método
`metodo` de la superclase con una implementación diferente. La anotación `@Override` se utiliza para indicar que el
método está sobrescribiendo un método de la superclase.

> **Nota**: Es importante tener en cuenta que el método en la subclase debe tener la misma firma (nombre, tipo de
> retorno y parámetros) que el método en la superclase para que la sobrescritura funcione correctamente.

## Ventajas de la sobrescritura

La sobrescritura es útil cuando se desea modificar el comportamiento de un método en la subclase sin cambiar la
definición del método en la superclase. La sobrescritura permite que las subclases tengan su propia implementación de un
método heredado de la superclase. La sobrescritura también permite que las subclases agreguen funcionalidad adicional a
los métodos heredados de la superclase.

## Ejemplo de sobrescritura en Java

A continuación, se muestra un ejemplo de sobrescritura en Java:

```java
public class Animal {
    public void emitirSonido() {
        System.out.println("El animal emite un sonido");
    }
}
```

```java
public class Perro extends Animal {
    @Override
    public void emitirSonido() {
        System.out.println("El perro ladra");
    }
}
```

En el ejemplo anterior, la clase `Perro` hereda de la clase `Animal` y sobrescribe el método `emitirSonido` para que el
perro ladre en lugar de emitir un sonido genérico.

## Uso de la palabra clave `super`

En Java, la palabra clave `super` se utiliza para llamar a un método de la superclase desde la subclase. La palabra
clave `super` se utiliza para acceder a los métodos y atributos de la superclase desde la subclase. La palabra clave
`super` se utiliza en la subclase para llamar al constructor de la superclase y acceder a los métodos y atributos de la
superclase.

## Ejemplo de sobrescritura y uso de la palabra clave `super`

A continuación, se muestra un ejemplo de sobrescritura y uso de la palabra clave `super` en Java:

```java
public class Animal {
    public void emitirSonido() {
        System.out.println("El animal emite un sonido");
    }
}
```

```java
public class Perro extends Animal {
    @Override
    public void emitirSonido() {
        super.emitirSonido();
        System.out.println("El perro ladra");
    }
}
```

En el ejemplo anterior, la clase `Perro` hereda de la clase `Animal` y sobrescribe el método `emitirSonido` para que el
perro ladre. La palabra clave `super` se utiliza en la subclase `Perro` para llamar al método `emitirSonido` de la
superclase `Animal` y luego imprimir un mensaje adicional.

## Super en el constructor de la subclase

La palabra clave `super` también se puede utilizar en el constructor de la subclase para llamar al constructor de la
superclase. La palabra clave `super` se utiliza en el constructor de la subclase para llamar al constructor de la
superclase y pasarle los parámetros necesarios. La palabra clave `super` se utiliza para inicializar los atributos de la
superclase en el constructor de la subclase.

## Ejemplo de uso de `super` en el constructor de la subclase

A continuación, se muestra un ejemplo de uso de `super` en el constructor de la subclase en Java:

```java
public class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }
}
```

```java
public class Perro extends Animal {
    private String raza;

    public Perro(String nombre, String raza) {
        super(nombre);
        this.raza = raza;
    }
}
```

En el ejemplo anterior, la clase `Perro` hereda de la clase `Animal` y utiliza la palabra clave `super` en el
constructor para llamar al constructor de la superclase y pasarle el nombre del perro. La subclase `Perro` también
inicializa su propio atributo `raza` en el constructor.

## Conclusiones

La sobrescritura es un mecanismo que permite que una subclase reemplace un método de la superclase con una
implementación diferente. La sobrescritura se utiliza para modificar el comportamiento de un método en la subclase sin
cambiar la definición del método en la superclase. La palabra clave `super` se utiliza en la subclase para llamar a un
método de la superclase y acceder a los métodos y atributos de la superclase. La palabra clave `super` también se puede
utilizar en el constructor de la subclase para llamar al constructor de la superclase y pasarle los parámetros
necesarios.
