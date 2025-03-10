# La clase `Object` en Java

La clase `Object` es la clase base de todas las clases en Java. Todas las clases en Java heredan directa o
indirectamente de la clase `Object`. La clase `Object` define los métodos básicos que todas las clases en Java deben
implementar. Algunos de los métodos más comunes de la clase `Object` son los siguientes:

- `equals(Object obj)`: Compara el objeto actual con otro objeto y devuelve `true` si son iguales, o `false` en caso
  contrario.
- `hashCode()`: Devuelve un valor entero que representa el hash code del objeto.
- `toString()`: Devuelve una representación en forma de cadena del objeto.
- `getClass()`: Devuelve el objeto `Class` que representa la clase del objeto.
- `clone()`: Crea y devuelve una copia superficial del objeto.
- `finalize()`: Se invoca antes de que el objeto sea eliminado por el recolector de basura.
- `notify()`: Despierta un hilo que esté esperando en el objeto.
- `notifyAll()`: Despierta todos los hilos que estén esperando en el objeto.
- `wait()`: Hace que el hilo actual espere en el objeto.
- `wait(long timeout)`: Hace que el hilo actual espere en el objeto durante un tiempo determinado.
- `wait(long timeout, int nanos)`: Hace que el hilo actual espere en el objeto durante un tiempo determinado y con una
  precisión de nanosegundos.

La clase `Object` es una clase abstracta, lo que significa que no se puede instanciar directamente. Sin embargo, todos
los objetos en Java tienen un tipo `Object`, lo que significa que se pueden tratar como objetos de la clase `Object`.

## Conclusiones

La clase `Object` es la clase base de todas las clases en Java y define los métodos básicos que todas las clases deben
implementar. Al comprender la clase `Object`, se puede tener una mejor comprensión de cómo funcionan las clases y los
objetos en Java.