# Cadenas con formato y bloques de texto

En Java, las cadenas con formato permiten combinar texto con valores de variables de una manera más legible y flexible.
Además, los bloques de texto permiten incluir cadenas de varias líneas en el código fuente.

## Cadenas con formato

Las cadenas con formato en Java se crean utilizando el método `String.format()`, que permite combinar texto con valores
de variables de una manera más legible y flexible. La sintaxis para crear una cadena con formato es la siguiente:

```java
String mensaje = String.format("Hola, %s. Tu edad es %d años.", nombre, edad);
```

En este ejemplo, se crea una cadena con formato que incluye el texto `"Hola, "` seguido del valor de la variable
`nombre`, y luego el texto `"Tu edad es "` seguido del valor de la variable `edad`.

Las cadenas con formato utilizan especificadores de formato para indicar cómo se deben formatear los valores de las
variables. Algunos de los especificadores de formato más comunes son:

| Especificador | Tipo de dato | Descripción                  |
|---------------|--------------|------------------------------|
| `%s`          | String       | Cadena de texto              |
| `%d`          | int          | Número entero                |
| `%f`          | double       | Número decimal               |
| `%b`          | boolean      | Valor booleano               |
| `%c`          | char         | Carácter                     |
| `%n`          | -            | Salto de línea               |
| `%%`          | -            | Carácter de porcentaje (%)   |
| `%t`          | Date         | Fecha y hora                 |
| `%x`          | int          | Número entero en hexadecimal |
| `%o`          | int          | Número entero en octal       |

### Ejemplo de cadenas con formato en Java

A continuación se muestra un ejemplo de cómo se utilizan las cadenas con formato en Java:

```java
String nombre = "Juan";
int edad = 30;
double altura = 1.75;

String mensaje = String.format("Hola, %s. Tu edad es %d años y mides %.2f metros.", nombre, edad, altura);
System.out.println(mensaje);
```

En este ejemplo, se crea una cadena con formato que incluye el nombre, la edad y la altura de una persona, y se imprime
el mensaje por consola.

## Especificadores de formato

Los especificadores de formato en Java permiten controlar cómo se formatean los valores que se insertan en una cadena
con formato. Los especificadores de formato se especifican utilizando el carácter `%` seguido de un número opcional que
indica la anchura mínima del campo y un carácter que indica el tipo de dato que se va a insertar. Por ejemplo, `%10d`
indica que el valor entero se debe formatear con una anchura mínima de 10 caracteres.

Algunos de los especificadores de formato más comunes son:

| Especificador | Descripción                                                                   |
|---------------|-------------------------------------------------------------------------------|
| `%nd`         | Formatea un valor entero con una anchura mínima de `n` caracteres.            |
| `%n.mf`       | Formatea un valor de punto flotante con `m` dígitos decimales y `n` de ancho. |
| `%.nf`        | Formatea un valor de punto flotante con `n` dígitos decimales.                |

Los especificadores de formato son útiles para controlar cómo se formatean los valores que se insertan en una cadena con
formato y se utilizan para alinear los valores, especificar la precisión de los números decimales y controlar el ancho
de los campos.

## Bloques de texto

Los bloques de texto en Java permiten incluir cadenas de varias líneas en el código fuente de una manera más legible y
mantenible. Para crear un bloque de texto, se utiliza la notación `"""` seguida de la cadena de texto y luego `"""`.

```java
String texto = """
    Este es un bloque de texto
    que incluye varias líneas
    y se puede utilizar para
    documentar el código fuente.
    """;
```

En este ejemplo, se crea un bloque de texto que incluye varias líneas de texto y se asigna a la variable `texto`.

Los bloques de texto son útiles para incluir comentarios largos, documentación o mensajes en el código fuente de una
manera más legible y mantenible.

> **Nota:** Los bloques de texto se introdujeron en Java 13 como una característica del lenguaje para mejorar la
> legibilidad y mantenibilidad del código fuente.

## Bloques de texto con formato

Los bloques de texto con formato en Java permiten combinar texto con valores de variables de una manera más legible y
flexible. Para crear un bloque de texto con formato, se utiliza la notación `"""` seguida de la cadena de texto y luego
`"""` y se pueden incluir especificadores de formato dentro del bloque de texto.

```java
String texto = """
    Hola, %s.
    Tu edad es %d años
    y mides %.2f metros.
    """;

String mensaje = String.format(texto, nombre, edad, altura);
System.out.println(mensaje);
```

En este ejemplo, se crea un bloque de texto con formato que incluye especificadores de formato para combinar texto con
valores de variables, y luego se utiliza el método `String.format()` para reemplazar los especificadores de formato con
los valores de las variables.

Los bloques de texto con formato son útiles para incluir mensajes con formato en el código fuente de una manera más
legible y mantenible.

> **Nota:** Los bloques de texto con formato se introdujeron en Java 15 como una característica del lenguaje para
> mejorar la legibilidad y mantenibilidad del código fuente.

## Conclusión

Las cadenas con formato y los bloques de texto en Java son características del lenguaje que permiten combinar texto con
valores de variables de una manera más legible y flexible, y se utilizan para incluir cadenas de varias líneas en el
código fuente de una manera más legible y mantenible.