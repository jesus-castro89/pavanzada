# Tipos de datos en Java

Los tipos de datos en Java son utilizados para definir el tipo de valores que pueden ser almacenados en una variable.
Java es un lenguaje de programación fuertemente tipado, lo que significa que las variables deben ser declaradas con un
tipo de dato específico antes de ser utilizadas. Los tipos de datos en Java se dividen en dos categorías principales:
tipos de datos primitivos y tipos de datos de referencia.

## Tipos de datos primitivos

Los tipos de datos primitivos en Java son tipos de datos básicos que representan valores simples como números enteros,
números de punto flotante, caracteres y valores booleanos. Los tipos de datos primitivos en Java se dividen en ocho
categorías:

| Tipo de dato | Descripción                                  | Tamaño  | Rango                                                  |
|--------------|----------------------------------------------|---------|--------------------------------------------------------|
| `byte`       | Número entero de 8 bits con signo            | 8 bits  | -128 a 127                                             |
| `short`      | Número entero de 16 bits con signo           | 16 bits | -32,768 a 32,767                                       |
| `int`        | Número entero de 32 bits con signo           | 32 bits | -2,147,483,648 a 2,147,483,647                         |
| `long`       | Número entero de 64 bits con signo           | 64 bits | -9,223,372,036,854,775,808 a 9,223,372,036,854,775,807 |
| `float`      | Número de punto flotante de precisión simple | 32 bits | 1.4e-45 a 3.4e38                                       |
| `double`     | Número de punto flotante de precisión doble  | 64 bits | 4.9e-324 a 1.8e308                                     |
| `char`       | Valor de carácter Unicode de 16 bits         | 16 bits | '\u0000' a '\uffff'                                    |
| `boolean`    | Valor booleano verdadero o falso             | 1 bit   | `true` o `false`                                       |

Los tipos de datos primitivos en Java se utilizan para almacenar valores simples en variables y se pueden inicializar
con valores literales. Por ejemplo:

```java
int edad = 25;
double precio = 19.99;
char genero = 'M';
boolean activo = true;
```

## Tipos de datos de referencia

Los tipos de datos de referencia en Java son tipos de datos que representan objetos complejos y estructuras de datos.

Algunos ejemplos de tipos de datos de referencia en Java son:

| Tipo de dato                        | Descripción                         |
|-------------------------------------|-------------------------------------|
| `String`                            | Cadena de caracteres                |
| `Array`                             | Arreglo de elementos                |
| `Class`                             | Clase de un objeto                  |
| `Interface`                         | Interfaz de un objeto               |
| `Enum`                              | Enumeración de constantes           |
| `Object`                            | Objeto genérico                     |
| `Clases creadas por el programador` | Clases definidas por el programador |

Los tipos de datos de referencia en Java se utilizan para representar objetos y estructuras de datos más complejas
que los tipos de datos primitivos. Además de que incluyen las clases creadas por el programador. Por ejemplo:

```java
String nombre = "Juan";
int[] numeros = {1, 2, 3, 4, 5};
Persona persona = new Persona("Juan", 25);
```

## Conclusiones

Los tipos de datos en Java son fundamentales para la programación en Java, ya que permiten definir el tipo de valores
que pueden ser almacenados en variables y objetos. Los tipos de datos primitivos representan valores simples como
números enteros, números de punto flotante, caracteres y valores booleanos, mientras que los tipos de datos de
referencia representan objetos y estructuras de datos más complejas. Es importante comprender los diferentes tipos de
datos en Java y cómo se utilizan en la programación para desarrollar aplicaciones eficientes y robustas.