# La clase `Point`

En Java, la clase `Point` se utiliza para representar un punto en un espacio bidimensional. La clase `Point` tiene dos
atributos, `x` y `y`, que representan las coordenadas del punto en el eje horizontal y vertical, respectivamente.

## Métodos de la clase `Point`

Algunos de los métodos más comunes de la clase `Point` son:

| Método                      | Descripción                                                                                                              |
|-----------------------------|--------------------------------------------------------------------------------------------------------------------------|
| `Point(int x, int y)`       | Crea un nuevo objeto `Point` con las coordenadas especificadas.                                                          |
| `getX()`                    | Devuelve la coordenada `x` del punto.                                                                                    |
| `getY()`                    | Devuelve la coordenada `y` del punto.                                                                                    |
| `setLocation(int x, int y)` | Establece las coordenadas del punto.                                                                                     |
| `translate(int dx, int dy)` | Desplaza el punto en la dirección especificada. <br/>Es decir, suma `dx` a la coordenada `x` y `dy` a la coordenada `y`. |
| `distance(Point p)`         | Calcula la distancia entre este punto y otro punto especificado.                                                         |
| `equals(Object obj)`        | Comprueba si este punto es igual a otro objeto especificado.                                                             |

## Ejemplo de uso de la clase `Point`

A continuación se muestra un ejemplo de cómo crear un objeto `Point` y utilizar algunos de sus métodos en Java:

```java
import java.awt.Point;

public class Main {
    public static void main(String[] args) {
        // Crear un nuevo punto en las coordenadas (10, 20)
        Point point = new Point(10, 20);

        // Obtener las coordenadas del punto
        int x = point.getX();
        int y = point.getY();

        System.out.println("Coordenadas del punto: (" + x + ", " + y + ")");
        // La salida será: Coordenadas del punto: (10, 20)

        // Desplazar el punto en la dirección (5, 5)
        point.translate(5, 5);

        // Obtener las nuevas coordenadas del punto
        x = point.getX();
        y = point.getY();

        System.out.println("Nuevas coordenadas del punto: (" + x + ", " + y + ")");
        // La salida será: Nuevas coordenadas del punto: (15, 25)
    }
}
```

En el ejemplo anterior, se crea un objeto `Point` con las coordenadas `(10, 20)`, se obtienen las coordenadas del punto,
se desplaza el punto en la dirección `(5, 5)` y se obtienen las nuevas coordenadas del punto.

Es importante tener en cuenta que la clase `Point` se utiliza comúnmente en aplicaciones gráficas y de interfaz de
usuario para representar posiciones en la pantalla y realizar operaciones geométricas.

## Conclusión

En Java, la clase `Point` se utiliza para representar un punto en un espacio bidimensional con coordenadas `x` e `y`.