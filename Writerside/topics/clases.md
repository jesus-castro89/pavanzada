# ¿Qué son las clases y objetos en programación orientada a objetos?

## Introducción

En la programación orientada a objetos, las clases y objetos son elementos fundamentales que permiten modelar entidades
del mundo real como objetos de software. Las clases son plantillas que definen la estructura y el comportamiento de los
objetos, mientras que los objetos son instancias concretas de esas clases que representan entidades específicas.

## Clases

Una clase es una plantilla que define la estructura y el comportamiento de un tipo de objeto. En una clase se definen
los atributos (variables) y métodos (funciones) que tienen los objetos de ese tipo. Por ejemplo, si queremos modelar un
coche, podríamos definir una clase `Coche` con atributos como `marca`, `modelo`, `color`, `velocidad`, etc., y métodos
como `acelerar`, `frenar`, `girar`, etc.

## Objetos

Un objeto es una instancia concreta de una clase que representa una entidad específica. Por ejemplo, si creamos un
objeto `coche1` a partir de la clase `Coche`, este objeto tendría sus propios valores para los atributos `marca`,
`modelo`, `color`, `velocidad`, etc., y podría llamar a los métodos `acelerar`, `frenar`, `girar`, etc.

## Relación entre clases y objetos

En la programación orientada a objetos, las clases y objetos están estrechamente relacionados. Las clases definen la
estructura y el comportamiento de los objetos, mientras que los objetos son instancias concretas de esas clases que
representan entidades específicas. Por lo tanto, las clases son como los planos de una casa, y los objetos son como las
casas construidas a partir de esos planos.

## Ejemplo de clases y objetos en Java

A continuación se muestra un ejemplo de cómo se definen clases y objetos en Java:

```java
// Definición de la clase Coche
class Coche {
    String marca;
    String modelo;
    String color;
    int velocidad;

    void acelerar() {
        velocidad += 10;
    }

    void frenar() {
        velocidad -= 10;
    }

    void girar(String direccion) {
        System.out.println("Girando hacia " + direccion);
    }
}
```

```java
// Creación de un objeto Coche
Coche coche1 = new Coche();
coche1.marca = "Toyota";
coche1.modelo = "Corolla";
coche1.color = "Rojo";
coche1.velocidad = 0;

coche1.acelerar();
coche1.girar("izquierda");
```

En este ejemplo, se define una clase `Coche` con atributos como `marca`, `modelo`, `color`, `velocidad`, etc., y métodos
como `acelerar`, `frenar`, `girar`, etc. Luego, se crea un objeto `coche1` a partir de la clase `Coche` y se le asignan
valores a sus atributos. Finalmente, se llama a los métodos `acelerar` y `girar` del objeto `coche1.

## Conclusión

Las clases y objetos son elementos fundamentales de la programación orientada a objetos que permiten modelar entidades
del mundo real como objetos de software. Las clases definen la estructura y el comportamiento de los objetos, mientras
que los objetos son instancias concretas de esas clases que representan entidades específicas. Al comprender la relación
entre clases y objetos, los programadores pueden diseñar sistemas más estructurados y fáciles de mantener.