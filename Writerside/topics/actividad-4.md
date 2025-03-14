# El Nivel

En esta ocasión trabajaremos para poder crear niveles de forma dinámica. Para ello, necesitaremos una clase que nos
permita generar los niveles y su matriz de ladrillos.

## Instrucciones

1. Crea el paquete `org.brick_breaker.game` y dentro de él la clase `Level`.
2. La clase `Level` debe tener las siguientes constantes:
    - `ROW_MARGIN`: Margen entre filas de ladrillos. Debe ser de 18 píxeles.
    - `COLUMN_MARGIN`: Margen entre columnas de ladrillos. Debe ser de 19 píxeles.
    - `LEVEL_WIDTH`: Ancho del nivel en bloques. Debe ser de 10 bloques.
    - `LEVEL_HEIGHT`: Alto del nivel en bloques. Debe ser de 10 bloques.
3. La clase `Level` debe tener la siguiente variable estática:
    - `levelNumber`: Número de nivel actual. Debe ser de tipo `int` e inicializarse en 1.
4. La clase `Level` debe tener los siguientes atributos:
    - `bricks`: Matriz de ladrillos del nivel. Debe ser de tipo `Brick[][]`.
    - `backGroundName`: Nombre de la imagen de fondo del nivel. Debe ser de tipo `String`.
    - `musicName`: Nombre de la música de fondo del nivel. Debe ser de tipo `String`.
    - `currentLevel`: Número de nivel actual. Debe ser de tipo `int`.
5. Su constructor debe recibir ambos valores de tipo `String` y asignarlos a los atributos correspondientes.
6. Se debe inicializar la matriz de ladrillos como un arreglo de `Brick` de tamaño `LEVEL_WIDTH` por `LEVEL_HEIGHT`.
7. Se debera asignar a `currentLevel` el valor de `levelNumber`. Y sumarle 1 a `levelNumber`.
8. Se deberá generar la función `populateLevel` que no reciba parámetros y que genere los ladrillos del nivel. Misma que
   deberá ser llamada en el constructor.

> Recuerda que las constantes de las clases deben ser `public static final` y que los atributos de las clases deben ser
> `private`. Y que las constantes locales de una clase deben ser `private static final`.

## `populateLevel`

La función `populateLevel` deberá generar los ladrillos del nivel. Para ello, deberá seguir los siguientes pasos:

1. Crear una variable de tipo `BrickType` llamada `brickType`.
2. Crear una variable de tipo `Point` llamada `brickPosition`.
3. Crear un ciclo `for` que recorra las filas del nivel.
4. Dentro del ciclo `for` crear otro ciclo `for` que recorra las columnas del nivel.
5. Dentro del ciclo `for`:
    - Asignar a `brickType` un valor aleatorio de `BrickType`. Mediante la siguiente fórmula:
        ```java
        brickType = BrickType.values()[Randomized.randomInt(0, BrickType.values().length - 1)];
        ```
    - Asignar a `brickPosition` la posición del ladrillo en la matriz. Mediante la siguiente fórmula:
        ```java
        position = new Point(column * Brick.BRICK_WIDTH + ROW_MARGIN,
                        row * Brick.BRICK_HEIGHT + COLUMN_MARGIN);
        ```
    - Crear un nuevo ladrillo con los valores de `brickType` y `brickPosition`.
    - Asignar el ladrillo a la matriz de ladrillos.
6. Al finalizar la función, se deberá llamar desde el constructor.

Con esto, ya tendrás la capacidad de generar niveles de forma dinámica. ¡A por ello!

## La clase `Randomized`

Para poder generar números aleatorios, necesitaremos una clase que nos permita hacerlo. Para ello, crearemos la clase
`Randomized` en el paquete `org.brick_breaker.utils` y con el siguiente contenido:

```java
package org.brick_breaker.utils;

import java.util.Random;

/**
 * Clase que se encarga de generar valores aleatorios.
 */
public class Randomized {

    /**
     * Constructor privado para evitar instanciación.
     */
    private Randomized() {

    }

    /**
     * Función que se encarga de generar un número aleatorio dentro un rango.
     *
     * @param min Valor mínimo del rango de números.
     * @param max Valor máximo del rango de números.
     * @return Número aleatorio generado.
     */
    public static int randomInt(int min, int max) {

        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        return random.nextInt(max - min + 1) + min;
    }
}
```

Con esta clase, podrás generar números aleatorios en el rango que desees. ¡A por ello!

## Actividad

Para esta actividad, deberás implementar la clase `Level` siguiendo las instrucciones dadas. Además, deberás implementar
la clase `Randomized` para poder generar números aleatorios. ¡Mucho éxito!

## Entrega

Para entregar la actividad, deberás crear un archivo `.zip` con el siguiente contenido:

* Archivos `.zip` del proyecto.
* Portada con datos de identificación.
* Evidencias de ejecución de la creación de al menos un nivel.
    * Para ello, deberás crear una clase `Main` que cree un nivel y muestre los ladrillos generados.

## Criterios de evaluación

| Criterio      | Descripción                                                | Puntaje  |
|---------------|------------------------------------------------------------|----------|
| Portada       | Contiene los datos de identificación del equipo            | 5%       |
| Funcionalidad | La clase `Level` cumple con los requerimientos solicitados | 60%      |
| Evidencias    | Muestra evidencias de la creación de al menos un nivel     | 35%      |
| **Total**     | **Cumple con lo establecido en la actividad**              | **100%** |

## Fecha de entrega

- **Fecha límite de entrega:** Viernes 21 de marzo de 2025 a las 11:59 p.m.

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos como máximo.**
> {style="warning"}

> **Integrante que no aparezca en la portada del documento no será calificado.**
> {style="warning"}