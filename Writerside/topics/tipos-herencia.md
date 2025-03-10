# Tipos de herencia en Java

La herencia es un mecanismo que permite que una clase herede los atributos y métodos de otra clase. En Java, existen
varios tipos de herencia que se pueden utilizar para modelar diferentes relaciones entre clases. Algunos de los tipos de
herencia más comunes en Java son:

- **Herencia simple**: La herencia simple es un tipo de herencia en la que una clase hereda de una sola clase. En Java,
  una clase solo puede heredar de una clase a la vez.
- **Herencia múltinivel**: La herencia múltinivel es un tipo de herencia en la que una clase hereda de otra clase que a
  su vez hereda de otra clase.
- **Herencia jerárquica**: La herencia jerárquica es un tipo de herencia en la que una clase tiene múltiples subclases.

## Ejemplos

### Herencia simple en Java:

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

### Herencia jerárquica en Java:

```java
public class Figura {
    public void dibujar() {
        System.out.println("Dibujando una figura");
    }
}
```

```java
public class Circulo extends Figura {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}
```

```java
public class Rectangulo extends Figura {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectángulo");
    }
}
```

En el ejemplo anterior, las clases `Circulo` y `Rectangulo` heredan de la clase `Figura`. Cada clase sobrescribe el
método `dibujar` para dibujar un círculo o un rectángulo, respectivamente.

### Herencia múltinivel en Java:

```java
public class Animal {
    public void comer() {
        System.out.println("El animal está comiendo");
    }
}
```

```java
public class Mamifero extends Animal {
    public void amamantar() {
        System.out.println("El mamífero está amamantando");
    }
}
```

```java
public class Perro extends Mamifero {
    public void ladrar() {
        System.out.println("El perro está ladrando");
    }
}
```

En el ejemplo anterior, la clase `Mamifero` hereda de la clase `Animal`, y la clase `Perro` hereda de la clase
`Mamifero`. La clase `Perro` hereda los métodos `comer` y `amamantar` de las clases `Animal` y `Mamifero`,
respectivamente, y agrega el método `ladrar`.

## Conclusiones

La herencia es un concepto poderoso en la programación orientada a objetos que permite reutilizar código y modelar
relaciones entre clases. En Java, se pueden utilizar diferentes tipos de herencia para modelar diferentes relaciones
entre clases y crear jerarquías de clases más complejas.