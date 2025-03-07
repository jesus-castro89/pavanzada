# La clase `HashMap`

En Java, la clase `HashMap` es una implementación de la interfaz `Map` que se utiliza para almacenar pares clave-valor.
Un `HashMap` permite almacenar y recuperar elementos de forma eficiente mediante una clave única.

## Declarar un `HashMap`

Para declarar un `HashMap`, utilizamos la siguiente sintaxis:

```java
// Declarar un HashMap con claves de tipo String y valores de tipo Integer
HashMap<String, Integer> hashMap = new HashMap<>();
```

En el ejemplo anterior, declaramos un `HashMap` con claves de tipo `String` y valores de tipo `Integer`. Es decir, cada
elemento del `HashMap` tendrá una clave de tipo `String` y un valor de tipo `Integer`.

## Agregar elementos a un `HashMap`

Para agregar elementos a un `HashMap`, utilizamos el método `put` de la siguiente manera:

```java
// Agregar elementos al HashMap
hashMap.put("uno", 1);
hashMap.put("dos", 2);

// Imprimir el HashMap
System.out.println(hashMap);
```

En el ejemplo anterior, agregamos dos elementos al `HashMap` con las claves `"uno"` y `"dos"` y los valores `1` y `2`
respectivamente. Luego, imprimimos el `HashMap` en la consola.

**Sin embargo, hay que ser cuidadoso al agregar elementos a un `HashMap`, ya que si se agrega una clave que ya existe,
el valor asociado a esa clave se sobrescribirá con el nuevo valor.**

## Recuperar elementos de un `HashMap`

Para recuperar elementos de un `HashMap`, utilizamos el método `get` de la siguiente manera:

```java
// Recuperar un elemento del HashMap
int valor = hashMap.get("uno");

// Imprimir el valor recuperado
System.out.println("El valor de la clave 'uno' es: " + valor);
```

En el ejemplo anterior, recuperamos el valor asociado a la clave `"uno"` del `HashMap` y lo almacenamos en la variable
`valor`.

## Verificar si un `HashMap` contiene una clave

Para verificar si un `HashMap` contiene una clave específica, utilizamos el método `containsKey` de la siguiente manera:

```java
// Verificar si el HashMap contiene la clave "dos"
boolean contieneClave = hashMap.containsKey("dos");

// Imprimir el resultado
System.out.println("El HashMap contiene la clave 'dos': " + contieneClave);
```

En el ejemplo anterior, verificamos si el `HashMap` contiene la clave `"dos"` y almacenamos el resultado en la variable
`contieneClave`.

## Conclusión

En resumen, la clase `HashMap` de Java es una implementación de la interfaz `Map` que se utiliza para almacenar pares
clave-valor de forma eficiente. Permite agregar, recuperar y verificar elementos de manera sencilla y eficaz. Es una
estructura de datos muy útil para almacenar y manipular datos en forma de pares clave-valor.