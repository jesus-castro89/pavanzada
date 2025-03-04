# Estructura de un programa en Java

Un programa en Java desde el punto de vista estructurado se compone de las siguientes partes:

1. **Paquete (package)**: Un paquete es un contenedor de clases y subpaquetes. Los paquetes ayudan a organizar y
   controlar el acceso a las clases y subpaquetes. Los paquetes se declaran con la palabra clave `package` seguida del
   nombre del paquete.
2. **Importaciones (imports)**: Las importaciones permiten acceder a clases y paquetes de otros paquetes. Las
   importaciones se declaran con la palabra clave `import` seguida del nombre de la clase o paquete.
3. **Clase (class)**: Una clase es un plano para crear objetos. Las clases se declaran con la palabra clave `class`
   seguida del nombre de la clase.
4. **Métodos (methods)**: Los métodos son bloques de código que realizan una tarea específica. Los métodos se declaran
   dentro de una clase.
5. **Variables (variables)**: Las variables son contenedores para almacenar datos. Las variables se declaran con el tipo
   de dato seguido del nombre de la variable.
6. **Comentarios (comments)**: Los comentarios son texto que se utiliza para explicar el código. Los comentarios se
   declaran con `//` para comentarios de una línea y `/* */` para comentarios de varias líneas.
7. **Sentencias (statements)**: Las sentencias son instrucciones que se ejecutan en un programa. Las sentencias se
   terminan con un punto y coma `;`.
8. **Bloques (blocks)**: Los bloques son secciones de código que agrupan sentencias. Los bloques se declaran con llaves
   `{}`.
9. **Expresiones (expressions)**: Las expresiones son combinaciones de variables, operadores y valores que producen un
   resultado. Las expresiones se utilizan para realizar cálculos y comparaciones.
10. **Función principal (main function)**: La función principal es el punto de entrada de un programa en Java. La
    función principal se declara con la palabra clave `public static void main(String[] args)`.

## Ejemplo de un programa en Java

A continuación se muestra un ejemplo de un programa en Java que imprime `¡Hola, Mundo!` en la consola:

```java
class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hola, Mundo!");
    }
}
```

En este ejemplo:

- La clase `HelloWorld` contiene el método `main` que imprime `¡Hola, Mundo!` en la consola.
- El método `main` es el punto de entrada del programa y se ejecuta cuando se inicia el programa.
- La instrucción `System.out.println("Hola, Mundo!");` imprime `¡Hola, Mundo!` en la consola.
- La palabra clave `public` indica que el método `main` es accesible desde cualquier clase.
- La palabra clave `static` indica que el método `main` pertenece a la clase en lugar de una instancia de la clase.
- La palabra clave `void` indica que el método `main` no devuelve ningún valor.
- El parámetro `String[] args` es un arreglo de cadenas que se utiliza para pasar argumentos al método `main`.