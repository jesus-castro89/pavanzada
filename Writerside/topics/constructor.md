# Constructores, Destructores y Accesores en Java

Los constructores, destructores y accesores son elementos fundamentales en la programación orientada a objetos en Java.
Estos elementos permiten inicializar objetos, liberar recursos y acceder a los atributos de una clase de forma segura y
controlada.

## Constructores en Java

Un constructor en Java es un método especial que se utiliza para inicializar un objeto de una clase. Los constructores
se definen con el mismo nombre que la clase y no tienen tipo de retorno. Por ejemplo:

```java
public class Persona {
    private String nombre;
    private int edad;

    // Constructor de la clase Persona
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
```

En este ejemplo, la clase `Persona` tiene un constructor que inicializa los atributos `nombre` y `edad` de la persona.
Los constructores se utilizan para asignar valores iniciales a los atributos de un objeto cuando se crea una instancia
de la clase.

## Tipos de constructores en Java

En Java, existen varios tipos de constructores que se pueden utilizar para inicializar objetos de una clase:

- **Constructor sin argumentos:** Un constructor que no recibe ningún argumento. Por ejemplo:

  ```java
  public Persona() {
      // Cuerpo del constructor
  }
  ```
- **Constructor con argumentos:** Un constructor que recibe uno o más argumentos. Por ejemplo:

  ```java
  public Persona(String nombre, int edad) {
      // Cuerpo del constructor
  }
  ```
- **Constructor por defecto:** Un constructor que se genera automáticamente si no se define ningún constructor en la
  clase. Este constructor inicializa los atributos de la clase con sus valores por defecto.
- **Constructor copia:** Un constructor que crea una copia de un objeto existente. Por ejemplo:

  ```java
  public Persona(Persona persona) {
      this.nombre = persona.nombre;
      this.edad = persona.edad;
  }
  ```
- **Constructor privado:** Un constructor que se declara como `private` y se utiliza para restringir la creación de
  instancias de la clase. Por ejemplo:

  ```java
  private Persona() {
      // Cuerpo del constructor
  }
  ```
- **Constructor protegido:** Un constructor que se declara como `protected` y se utiliza para permitir la creación de
  instancias solo desde la misma clase o subclases. Por ejemplo:

  ```java
  protected Persona(String nombre, int edad) {
      // Cuerpo del constructor
  }
  ```

> Es importante destacar que el constructor por defecto se genera automáticamente si no se define ningún constructor en
> la clase. Sin embargo, si se define un constructor con argumentos, el constructor por defecto no se generará de forma
> automática. Por lo tanto, es recomendable definir un constructor por defecto si se necesita inicializar los atributos
> de la clase con valores por defecto.
> {style="warning"}

## Llamada a constructores desde otros constructores

En Java, es posible llamar a un constructor desde otro constructor de la misma clase utilizando la palabra clave `this`.
Esto se conoce como sobrecarga de constructores y permite reutilizar código y simplificar la inicialización de objetos.
Por ejemplo:

```java
public class Persona {
    private String nombre;
    private int edad;

    // Constructor sin argumentos
    public Persona() {
        this("Juan", 30); // Llamada al constructor con argumentos
    }

    // Constructor con argumentos
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}
```

En este ejemplo, el constructor sin argumentos de la clase `Persona` llama al constructor con argumentos utilizando la
palabra clave `this`. Esto permite inicializar los atributos de la persona con valores por defecto cuando se crea una
instancia de la clase.

## Destructores en Java

En Java, no existe un destructor como tal, ya que el recolector de basura (`Garbage Collector`) se encarga de liberar
la memoria de los objetos que ya no son utilizados. Sin embargo, es posible implementar métodos que realicen tareas de
limpieza antes de que un objeto sea eliminado. Estos métodos se conocen como métodos de limpieza o métodos de
finalización.

## Accesores en Java

Los accesores, también conocidos como métodos *getter* y *setter*, son métodos que se utilizan para acceder y modificar
los atributos de una clase de forma segura y controlada. Los métodos *getter* se utilizan para obtener el valor de un
atributo, mientras que los métodos *setter* se utilizan para asignar un valor a un atributo. Por ejemplo:

```java
public class Persona {
    private String nombre;
    private int edad;

    // Método getter para el atributo nombre
    public String getNombre() {
        return nombre;
    }

    // Método setter para el atributo nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método getter para el atributo edad
    public int getEdad() {
        return edad;
    }

    // Método setter para el atributo edad
    public void setEdad(int edad) {
        this.edad = edad;
    }
}
```

En este ejemplo, la clase `Persona` tiene métodos *getter* y *setter* para los atributos `nombre` y `edad`. Estos
métodos permiten acceder y modificar los atributos de la persona de forma segura y controlada.

> En IntelliJ IDEA, es posible generar automáticamente los métodos *getter* y *setter* para los atributos de una clase
> utilizando la función `Generate...` del menú contextual. Esto facilita la creación de los accesores y evita errores
> de escritura. Para generar los métodos *getter* y *setter*, se debe hacer clic con el botón derecho en el editor de
> código y seleccionar la opción `Generate...` en el menú contextual.

## Conclusión

Los constructores, destructores y accesores son elementos esenciales en la programación orientada a objetos en Java, ya
que permiten inicializar objetos, liberar recursos y acceder a los atributos de una clase de forma segura y controlada.

Es importante comprender cómo funcionan los constructores, los tipos de constructores que se pueden utilizar, cómo
llamar a constructores desde otros constructores, cómo implementar métodos de limpieza y cómo utilizar los accesores
para acceder y modificar los atributos de una clase.

Al dominar estos conceptos, se podrá desarrollar código más limpio, mantenible y seguro en Java, lo que facilitará la
creación de aplicaciones robustas y escalables.