# Los arreglos dinámicos

En Java, los arreglos son una estructura de datos que nos permite almacenar una colección de elementos del mismo tipo.
Sin embargo, los arreglos en Java tienen una limitación importante: una vez que se crean, su tamaño no puede cambiar.
Esto significa que si necesitamos agregar o eliminar elementos de un arreglo, debemos crear un nuevo arreglo con el
tamaño adecuado y copiar los elementos del arreglo original al nuevo arreglo.

Para evitar esta limitación, Java proporciona la clase `ArrayList`, que es una implementación de un arreglo dinámico.
Un arreglo dinámico es una estructura de datos que puede cambiar de tamaño dinámicamente, es decir, podemos agregar o
eliminar elementos de un arreglo dinámico en tiempo de ejecución sin tener que crear un nuevo arreglo.

En este artículo, veremos cómo utilizar la clase `ArrayList` en Java para crear arreglos dinámicos y cómo agregar,
eliminar y acceder a elementos en un arreglo dinámico.

## Creación de un `ArrayList`

Para crear un arreglo dinámico en Java, utilizamos la clase `ArrayList`. La clase `ArrayList` se encuentra en el paquete
`java.util` y nos permite crear arreglos dinámicos de cualquier tipo de datos.

```java
import java.util.ArrayList;

// Crear un ArrayList de enteros
ArrayList<Integer> numeros = new ArrayList<>();
```

En el ejemplo anterior, creamos un arreglo dinámico de enteros utilizando la clase `ArrayList`. Para crear un
`ArrayList`, utilizamos el operador `new` seguido del nombre de la clase `ArrayList` y el tipo de datos que queremos
almacenar en el arreglo dinámico. En este caso, queremos almacenar enteros, por lo que utilizamos `Integer`.

## Agregar elementos a un `ArrayList`

Para agregar elementos a un arreglo dinámico en Java, utilizamos el método `add` de la clase `ArrayList`. Este método
recibe como parámetro el elemento que queremos agregar al arreglo dinámico.

```java
// Agregar elementos al ArrayList
numeros.add(1);

// Agregar varios elementos al ArrayList
numeros.addAll(Arrays.asList(2, 3, 4, 5));
```

En el ejemplo anterior, agregamos elementos al arreglo dinámico `numeros` utilizando el método `add`. También podemos
agregar varios elementos al arreglo dinámico utilizando el método `addAll` y pasando una lista de elementos como
parámetro.

De igual manera la clase `ArrayList` nos permite agregar elementos en una posición específica del arreglo dinámico
utilizando el método `add` con dos parámetros: el índice en el que queremos agregar el elemento y el elemento que
queremos agregar.

```java
// Agregar un elemento en la posición 0 del ArrayList
numeros.add(0, 0);
```

En el ejemplo anterior, agregamos el elemento `0` en la posición `0` del arreglo dinámico `numeros`.

Toma en cuenta que al agregar un elemento en una posición específica del arreglo dinámico, los elementos existentes en
posiciones posteriores se desplazarán hacia la derecha. Por ejemplo, si agregamos un elemento en la posición `0`, el
elemento que estaba en la posición `0` pasará a la posición `1`, el elemento que estaba en la posición `1` pasará a la
posición `2`, y así sucesivamente. De igual manera esto solo será posible siempre y cuando la posición que se desea
agregar sea menor o igual al tamaño del arreglo dinámico.

## Agregando al inicio y al final de un `ArrayList`

Para agregar elementos al inicio y al final de un arreglo dinámico en Java, podemos utilizar los métodos `addFirst` y
`addLast` de la clase `ArrayList`.

```java
// Agregar un elemento al inicio del ArrayList
numeros.addFirst(-1);// Es equivalente a numeros.add(0, -1);

// Agregar un elemento al final del ArrayList
numeros.addLast(6);// Es equivalente a numeros.add(6);
```

En el ejemplo anterior, agregamos un elemento al inicio y al final del arreglo dinámico `numeros` utilizando los métodos
`addFirst` y `addLast`.

## Acceder a elementos de un `ArrayList`

Para acceder a elementos de un arreglo dinámico en Java, utilizamos el método `get` de la clase `ArrayList`. Este método
recibe como parámetro el índice del elemento al que queremos acceder y devuelve el elemento en esa posición.

```java
// Acceder al primer elemento del ArrayList
int primerNumero = numeros.get(0);
```

En el ejemplo anterior, accedemos al primer elemento del arreglo dinámico `numeros` utilizando el método `get`.

## Eliminar elementos de un `ArrayList`

Para eliminar elementos de un arreglo dinámico en Java, utilizamos el método `remove` de la clase `ArrayList`. Este
método recibe como parámetro el índice del elemento que queremos eliminar y elimina el elemento en esa posición.

```java
// Eliminar el primer elemento del ArrayList
numeros.remove(0);
```

En el ejemplo anterior, eliminamos el primer elemento del arreglo dinámico `numeros` utilizando el método `remove`.

También podemos eliminar un elemento específico del arreglo dinámico utilizando el método `remove` con un parámetro de
tipo `Object`. Este método eliminará la **primera ocurrencia** del elemento en el arreglo dinámico.

```java
// Creamos un arreglos de cadenas
ArrayList<String> nombres = new ArrayList<>();

// Agregamos elementos al arreglo
nombres.addAll(Arrays.asList("Juan", "María", "Pedro", "Juan"));

// Eliminar la primera ocurrencia de "Juan" en el ArrayList
nombres.remove("Juan");
```

En el ejemplo anterior, eliminamos la primera ocurrencia del elemento `"Juan"` del arreglo dinámico `nombres` utilizando
el método `remove`. Por lo que el arreglo `nombres` quedaría con los elementos `"María"`, `"Pedro"` y `"Juan"`.

## Eliminar elementos al inicio y al final de un `ArrayList`

Para eliminar elementos al inicio y al final de un arreglo dinámico en Java, podemos utilizar los métodos `removeFirst`
y `removeLast` de la clase `ArrayList`.

```java
// Eliminar el primer elemento del ArrayList
numeros.removeFirst();// Es equivalente a numeros.remove(0);

// Eliminar el último elemento del ArrayList
numeros.removeLast();// Es equivalente a numeros.remove(numeros.size() - 1);
```

En el ejemplo anterior, eliminamos el primer y el último elemento del arreglo dinámico `numeros` utilizando los métodos
`removeFirst` y `removeLast`.

## Actualizar elementos de un `ArrayList`

Para actualizar elementos de un arreglo dinámico en Java, utilizamos el método `set` de la clase `ArrayList`. Este
método recibe como parámetro el índice del elemento que queremos actualizar y el nuevo valor que queremos asignar al
elemento en esa posición.

```java
// Actualizar el primer elemento del ArrayList
numeros.set(0, -1);
```

En el ejemplo anterior, actualizamos el primer elemento del arreglo dinámico `numeros` asignándole el valor `-1`
utilizando el método `set`.

## Verificar si un `ArrayList` contiene un elemento

Para verificar si un arreglo dinámico en Java contiene un elemento específico, utilizamos el método `contains` de la
clase `ArrayList`. Este método recibe como parámetro el elemento que queremos verificar y devuelve `true` si el arreglo
dinámico contiene el elemento, o `false` en caso contrario.

```java
// Verificar si el ArrayList contiene el elemento 1
boolean contieneUno = numeros.contains(1);
```

En el ejemplo anterior, verificamos si el arreglo dinámico `numeros` contiene el elemento `1` utilizando el método
`contains`.

## Obtener el índice de la primera y última ocurrencia de un elemento

Para obtener el índice de la primera y última ocurrencia de un elemento en un arreglo dinámico en Java, utilizamos los
métodos `indexOf` y `lastIndexOf` de la clase `ArrayList`. Estos métodos reciben como parámetro el elemento que queremos
buscar y devuelven el índice de la primera y última ocurrencia del elemento en el arreglo dinámico, respectivamente.

```java
// Obtener el índice de la primera ocurrencia de 1 en el ArrayList
int indiceUno = numeros.indexOf(1);

// Obtener el índice de la última ocurrencia de 1 en el ArrayList
int ultimoIndiceUno = numeros.lastIndexOf(1);
```

En el ejemplo anterior, obtenemos el índice de la primera y última ocurrencia del elemento `1` en el arreglo dinámico
`numeros` utilizando los métodos `indexOf` y `lastIndexOf`. Lo que nos devolvería el índice `0` en ambos casos. Los que
indica que de hecho solo existe una ocurrencia del elemento `1` en el arreglo `numeros`.

## Tamaño de un `ArrayList`

Para obtener el tamaño de un arreglo dinámico en Java, utilizamos el método `size` de la clase `ArrayList`. Este método
no recibe parámetros y devuelve el número de elementos en el arreglo dinámico.

```java
// Obtener el tamaño del ArrayList
int tamano = numeros.size();
```

En el ejemplo anterior, obtenemos el tamaño del arreglo dinámico `numeros` utilizando el método `size`.

## Redimensionar un `ArrayList`

Para redimensionar un arreglo dinámico en Java, utilizamos el método `ensureCapacity` de la clase `ArrayList`. Este
método recibe como parámetro el nuevo tamaño que queremos asignar al arreglo dinámico.

```java
// Redimensionar el ArrayList a un tamaño de 10
numeros.ensureCapacity(10);
```

En el ejemplo anterior, redimensionamos el arreglo dinámico `numeros` a un tamaño de `10` utilizando el método
`ensureCapacity`. Sin embargo, esto no garantiza que el tamaño del arreglo dinámico sea exactamente `10`, sino que
garantiza que el arreglo dinámico tendrá al menos la capacidad de almacenar `10` elementos sin tener que redimensionarse
internamente.

Por otro lado, podemos hacer que la capacidad actual del arreglo dinámico sea igual al número de elementos que contiene
el arreglo dinámico utilizando el método `trimToSize`.

```java
// Redimensionar el ArrayList a su tamaño actual
numeros.trimToSize();
```

En el ejemplo anterior, redimensionamos el arreglo dinámico `numeros` a su tamaño actual utilizando el método
`trimToSize`. Lo cual asegura que el arreglo dinámico tenga la menor capacidad posible para almacenar sus elementos.

Esta función es muy valiosa al momento de liberar memoria, ya que si el arreglo dinámico tiene una capacidad mayor a la
necesaria, estaríamos desperdiciando memoria.

## Iterar sobre un `ArrayList`

Para iterar sobre un arreglo dinámico en Java, podemos utilizar un bucle `for` que itere sobre los elementos del arreglo
dinámico.

```java
// Recorrer el ArrayList numeros
for (int i = 0; i < numeros.size(); i++) {
    System.out.println(numeros.get(i));
}
```

En el ejemplo anterior, recorremos el arreglo dinámico `numeros` e imprimimos cada elemento en la consola.

Sin embargo, Java proporciona una forma más sencilla de recorrer un arreglo dinámico utilizando un bucle `for-each`.

```java
// Recorrer el ArrayList numeros con un bucle for-each
for (int numero : numeros) {
    System.out.println(numero);
}
```

En este caso, el bucle `for-each` itera sobre cada elemento del arreglo dinámico y asigna el valor del elemento a la
variable `numero`.

## Conclusión

En resumen, la clase `ArrayList` en Java nos permite crear arreglos dinámicos que pueden cambiar de tamaño
dinámicamente. Podemos agregar, eliminar, acceder, actualizar y verificar elementos en un arreglo dinámico utilizando
los métodos proporcionados por la clase `ArrayList`. Además, podemos redimensionar un arreglo dinámico, obtener su
tamaño, y recorrerlo utilizando bucles `for` y `for-each`.