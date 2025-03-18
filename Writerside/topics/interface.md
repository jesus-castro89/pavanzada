# ¿Qué son las interfaces en Java?

Una interfaz en Java es una colección de métodos abstractos y constantes que se pueden implementar en una clase. Las
interfaces permiten definir un contrato que las clases deben cumplir, especificando qué métodos deben implementar y cómo
deben comportarse. Esto permite a las clases compartir un comportamiento común sin necesidad de heredar de una clase
base.

## Características de las interfaces

Algunas características importantes de las interfaces en Java son:

1. **Métodos abstractos**: Las interfaces solo pueden contener métodos abstractos, es decir, métodos sin cuerpo. Las
   clases que implementan una interfaz deben proporcionar una implementación concreta para cada método abstracto.
2. **Constantes**: Las interfaces pueden contener constantes, que son variables cuyos valores no pueden cambiar. Estas
   constantes se definen con la palabra clave `final`. Por convención, los nombres de las constantes en una interfaz se
   escriben en mayúsculas.
3. **Implementación múltiple**: Una clase en Java puede implementar múltiples interfaces, lo que permite compartir
   comportamientos comunes entre diferentes clases sin necesidad de heredar de una clase base. Esto es útil cuando se
   desea definir un comportamiento común para clases que no tienen una relación de herencia.
4. **Contratos**: Las interfaces permiten definir contratos que las clases deben cumplir. Esto facilita la creación de
   clases que implementan un comportamiento específico sin preocuparse por la implementación concreta de los métodos.
5. **Extensión de interfaces**: Una interfaz puede extender otra interfaz, lo que permite heredar métodos y constantes
   de una interfaz base. Esto es útil para definir interfaces más específicas que heredan comportamientos de interfaces
   más generales. Además de permitir la herencia múltiple y simplificar la implementación de comportamientos comunes.
6. **Interfaz funcional**: Una interfaz funcional es una interfaz que contiene un solo método abstracto. Estas
   interfaces se utilizan en programación funcional y permiten definir comportamientos específicos de forma concisa y
   flexible.
7. **Predeterminado**: A partir de Java 8, las interfaces pueden contener métodos predeterminados, que son métodos con
   una implementación por defecto. Esto permite agregar nuevos métodos a una interfaz sin romper la compatibilidad con
   las clases que la implementan.
8. **Estáticos**: A partir de Java 8, las interfaces pueden contener métodos estáticos, que son métodos asociados a la
   interfaz y no a una instancia de la clase. Estos métodos se pueden invocar sin necesidad de crear una instancia de la
   interfaz.

## Ejemplo de interfaz en Java

### Shape.java

```java
public interface Shape {

    double getArea();

    double getPerimeter();
}
```

### Circle.java

```java
public class Circle implements Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
```

### Rectangle.java

```java
public class Rectangle implements Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }
}
```

### Main.java

```java
public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(3, 4);

        System.out.println("Área del círculo: " + circle.getArea());
        System.out.println("Perímetro del círculo: " + circle.getPerimeter());

        System.out.println("Área del rectángulo: " + rectangle.getArea());
        System.out.println("Perímetro del rectángulo: " + rectangle.getPerimeter());
    }
}
```

En este ejemplo, la interfaz `Shape` define dos métodos abstractos `getArea` y `getPerimeter` que deben ser
implementados por las clases `Circle` y `Rectangle`. Al implementar la interfaz `Shape`, las clases `Circle` y
`Rectangle` deben proporcionar una implementación concreta para estos métodos, lo que permite calcular el área y el
perímetro de un círculo y un rectángulo de manera específica.

Al crear objetos de las clases `Circle` y `Rectangle` y asignarlos a una referencia de la interfaz `Shape`, podemos
invocar los métodos `getArea` y `getPerimeter` de manera polimórfica, lo que nos permite calcular el área y el
perímetro de un círculo y un rectángulo de manera genérica.

## Conclusión

Las interfaces en Java son una poderosa herramienta que permite definir contratos entre clases y compartir
comportamientos comunes de manera flexible y reutilizable. Al utilizar interfaces, podemos crear clases que implementan
un comportamiento específico sin preocuparnos por la implementación concreta de los métodos, lo que facilita la
creación de aplicaciones modulares y extensibles.