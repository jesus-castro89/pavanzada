# Llamada a funciones

En Java, una función es un bloque de código que realiza una tarea específica y puede ser invocada desde otras partes del
programa. Las funciones pueden ser definidas dentro de una clase (métodos) o fuera de una clase (funciones estáticas).
En este artículo, se explicará cómo llamar a funciones de clases y tipos enumerados en Java.

## Llamada a Funciones de Clases

Para llamar a una función de una clase en Java, se debe utilizar la siguiente sintaxis:

```java
nombreClase.nombreFuncion(parametros);
```

Por ejemplo, para llamar a una función `saludar` de la clase `Persona` con un parámetro `nombre`:

```java
Persona.saludar("Juan");
```

En este caso, se llama a la función `saludar` de la clase `Persona` con el parámetro `"Juan"`. La función `saludar` debe
ser estática para poder ser llamada de esta forma.

## Llamada a Funciones de Tipos Enumerados

Para llamar a una función de un tipo enumerado en Java, se debe utilizar la siguiente sintaxis:

```java
nombreTipoEnum.constante.nombreFuncion(parametros);
```

Por ejemplo, para llamar a una función `obtenerNumero` de la constante `LUNES` del tipo enumerado `DiaSemana`:

```java
DiaSemana.LUNES.obtenerNumero();
```

En este caso, se llama a la función `obtenerNumero` de la constante `LUNES` del tipo enumerado `DiaSemana`. La función
`obtenerNumero` debe ser definida en el tipo enumerado y puede ser llamada a través de una constante específica.

## Conclusión

En resumen, las funciones en Java son bloques de código que realizan tareas específicas y pueden ser invocadas desde
otras partes del programa. Para llamar a una función de una clase en Java, se utiliza la sintaxis
`nombreClase.nombreFuncion(parametros)` y para llamar a una función de un tipo enumerado se utiliza la sintaxis
`nombreTipoEnum.constante.nombreFuncion(parametros)`.