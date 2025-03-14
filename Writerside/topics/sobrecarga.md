# ¿Qué es la sobrecarga?

La sobrecarga es un concepto de la programación orientada a objetos que permite a una clase tener múltiples métodos con
el mismo nombre pero diferentes parámetros. Esto permite a los objetos de la clase ser tratados de manera diferente
según el tipo de parámetros que se les pase.

## Ejemplo de sobrecarga en Java

```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public String add(String a, String b) {
        return a + b;
    }
}
```

```java
public class Main {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        int sumInt = calculator.add(1, 2); // 3
        double sumDouble = calculator.add(1.5, 2.5); // 4.0
        String sumString = calculator.add("Hello, ", "world!"); // Hello, world!
    }
}
```

En el ejemplo anterior, la clase `Calculator` tiene un método `add` que recibe dos enteros, un método `add` que recibe
dos decimales y un método `add` que recibe dos cadenas. Cada uno de estos métodos realiza una operación de suma
diferente, pero comparten el mismo nombre. Al llamar al método `add` con diferentes tipos de parámetros, se invocará
el método correspondiente según el tipo de parámetros que se le pase.

## Reglas de la sobrecarga

Para que dos métodos sean considerados sobrecargados, deben cumplir con las siguientes reglas:

1. Los métodos deben tener el mismo nombre.
2. Los métodos deben tener diferente número de parámetros.
3. Los métodos deben tener diferente tipo de parámetros.
4. Los métodos pueden tener diferente orden y tipo de parámetros.
5. Los métodos pueden tener diferente tipo de retorno.
6. Los métodos pueden lanzar diferentes excepciones.
7. Los métodos pueden tener diferente modificador de acceso.
8. Los métodos no pueden ser sobrecargados solo cambiando el tipo de retorno.
9. Los métodos no pueden ser sobrecargados solo cambiando el modificador de acceso.
10. Los métodos no pueden ser sobrecargados solo cambiando el modificador `static`.
11. Los métodos no pueden ser sobrecargados solo cambiando el modificador `final`.
12. Los métodos no pueden ser sobrecargados solo cambiando el modificador `abstract`.

## Ventajas de la sobrecarga

La sobrecarga tiene varias ventajas en la programación orientada a objetos:

1. **Legibilidad**: Permite a los desarrolladores utilizar nombres de métodos más descriptivos sin preocuparse por
   colisiones de nombres.
2. **Reutilización de código**: Permite a los desarrolladores reutilizar métodos con el mismo nombre para realizar
   operaciones similares con diferentes tipos de datos.
3. **Flexibilidad**: Permite a los desarrolladores crear métodos que acepten diferentes tipos de parámetros sin tener
   que preocuparse por la ambigüedad en la llamada de los métodos.
4. **Mantenimiento**: Facilita el mantenimiento del código al agrupar métodos relacionados bajo el mismo nombre.
5. **Polimorfismo**: Permite a los objetos de una clase comportarse de manera diferente según el tipo de parámetros que
   se les pase.

En resumen, la sobrecarga es una técnica poderosa que permite a los desarrolladores crear métodos más flexibles y
reutilizables al permitirles definir múltiples versiones de un método con el mismo nombre pero diferentes parámetros.