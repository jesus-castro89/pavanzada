# Tipos de Interfaces en Java

En Java, las interfaces pueden ser:

1. **Interfaces de marcador**: Son interfaces que no contienen métodos, sino que simplemente marcan una clase como
   perteneciente a una categoría específica. Por ejemplo, la interfaz `Serializable` en Java es un marcador que indica
   que una clase puede ser serializada.
2. **Interfaces funcionales**: Son interfaces que contienen un solo método abstracto. A partir de Java 8, las interfaces
   funcionales pueden tener métodos predeterminados y métodos estáticos.
3. **Interfaces normales**: Son interfaces que contienen uno o más métodos abstractos. A partir de Java 8, las
   interfaces pueden contener métodos predeterminados y métodos estáticos.

## Interfaces de marcador

Las interfaces de marcador son interfaces que no contienen métodos. En su lugar, simplemente marcan una clase como
perteneciente a una categoría específica. Por ejemplo, la interfaz `Serializable` en Java es un marcador que indica que
una clase puede ser serializada.

```java
public interface Serializable {
}
```

## Interfaces funcionales

Las interfaces funcionales son interfaces que contienen un solo método abstracto. A partir de Java 8, las interfaces
funcionales pueden tener métodos predeterminados y métodos estáticos.

```java
@FunctionalInterface
public interface Shape {

    double getArea();

    double getPerimeter();
}
```

## Interfaces normales

Las interfaces normales son interfaces que contienen uno o más métodos abstractos. A partir de Java 8, las interfaces
pueden contener métodos predeterminados y métodos estáticos.

```java
public interface Shape {

    double getArea();

    double getPerimeter();
    
    default void printInfo() {
        System.out.println("This is a shape.");
    }
    
    static void printMessage() {
        System.out.println("Hello from the Shape interface!");
    }
}
```

En este ejemplo, la interfaz `Shape` es una interfaz normal que define dos métodos abstractos (`getArea` y
`getPerimeter`), un método predeterminado (`printInfo`) y un método estático (`printMessage`).

## Conclusión

En resumen, en Java existen tres tipos de interfaces: interfaces de marcador, interfaces funcionales e interfaces
normales.

Las interfaces de marcador son interfaces que no contienen métodos y simplemente marcan una clase como perteneciente a
una categoría específica.

Las interfaces funcionales son interfaces que contienen un solo método abstracto. A partir de Java 8, las interfaces
funcionales pueden tener métodos predeterminados y métodos estáticos.

Las interfaces normales son interfaces que contienen uno o más métodos abstractos. A partir de Java 8, las interfaces
pueden contener métodos predeterminados y métodos estáticos.