# El casting en Java

El casting en Java es un proceso que consiste en convertir un valor de un tipo de dato a otro. En Java, existen dos
tipos de casting: el *casting implícito* y el *casting explícito*. En esta sección, aprenderemos cómo realizar casting
en Java y cuándo es necesario utilizarlo.

## Casting implícito

El *casting implícito* es un proceso automático en el que Java convierte un valor de un tipo de dato a otro sin que el
programador tenga que hacer nada. El casting implícito se produce cuando se asigna un valor de un tipo de dato más
pequeño a un tipo de dato más grande. Por ejemplo:

```java
int numeroEntero = 10;
double numeroDecimal = numeroEntero; // Casting implícito
```

En este ejemplo, el valor de la variable `numeroEntero` de tipo `int` se asigna a la variable `numeroDecimal` de tipo
`double` sin necesidad de realizar un casting explícito. Esto se debe a que un `double` puede almacenar valores más
grandes que un `int`.

## Casting explícito

El *casting explícito* es un proceso en el que el programador convierte un valor de un tipo de dato a otro de forma
manual. El casting explícito se produce cuando se asigna un valor de un tipo de dato más grande a un tipo de dato más
pequeño. Por ejemplo:

```java
double numeroDecimal = 10.5;
int numeroEntero = (int) numeroDecimal; // Casting explícito
```

En este ejemplo, el valor de la variable `numeroDecimal` de tipo `double` se asigna a la variable `numeroEntero` de tipo
`int` utilizando un casting explícito. Esto se debe a que un `int` no puede almacenar valores decimales, por lo que es
necesario realizar la conversión de forma explícita.

## Conclusiones

El casting en Java es un proceso que permite convertir valores de un tipo de dato a otro. El casting implícito se
produce de forma automática cuando se asigna un valor de un tipo de dato más pequeño a uno más grande, mientras que el
casting explícito se realiza de forma manual cuando se asigna un valor de un tipo de dato más grande a uno más
pequeño. Es importante tener en cuenta que el casting puede provocar la pérdida de precisión o la truncación de
datos, por lo que es necesario utilizarlo con precaución.