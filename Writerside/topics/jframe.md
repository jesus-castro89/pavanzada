# La clase `JFrame`

## Descripción

La clase `JFrame` es una clase de la biblioteca de Java que permite crear ventanas gráficas. Esta clase es parte del
paquete `javax.swing` y es una subclase de la clase `java.awt.Frame`. La clase `JFrame` es una clase de nivel superior
que se utiliza para crear ventanas con un borde, un título y botones de cierre, minimizar y maximizar.

## Sintaxis

La sintaxis para crear un objeto de la clase `JFrame` es la siguiente:

```java
JFrame frame = new JFrame();
```

## Métodos

Algunos de los métodos más comunes de la clase `JFrame` son los siguientes:

| Método                             | Descripción                                                     |
|------------------------------------|-----------------------------------------------------------------|
| `setTitle(String)`                 | Establece el título de la ventana.                              |
| `setSize(int, int)`                | Establece el tamaño de la ventana en píxeles.                   |
| `setLocation(int, int)`            | Establece la posición de la ventana en la pantalla.             |
| `setResizable(boolean)`            | Permite o impide que la ventana sea redimensionable.            |
| `setLocationRelativeTo(Component)` | Establece la posición de la ventana relativa a otro componente. |
| `setDefaultCloseOperation(int)`    | Establece la operación que se realiza al cerrar la ventana.     |
| `setVisible(boolean)`              | Muestra u oculta la ventana.                                    |
| `add(Component)`                   | Agrega un componente a la ventana.                              |
| `paint(Graphics)`                  | Dibuja el contenido de la ventana.                              |
| `repaint()`                        | Vuelve a dibujar el contenido de la ventana.                    |
| `pack()`                           | Ajusta el tamaño de la ventana automáticamente.                 |

## Creando una ventana con `JFrame` con IntelliJ IDEA

Para crear una ventana con la clase `JFrame` en IntelliJ IDEA, sigue los siguientes pasos:

1. Abre IntelliJ IDEA y crea un nuevo proyecto.
2. Haz clic con el botón derecho en la carpeta `src` y selecciona `New` > `Swing UI Designer` > `New GUI Form`.
3. En la ventana que se abre, coloca el nombre del archivo que contendrá la ventana y haz clic en `OK`.
    * Podrás ver que se crea un tipo de componente que contiene dos archivos: uno con extensión `.form` y otro con
      extensión `.java`. El archivo `.java` es el que contiene el código de la ventana. Puedes abrirlo y modificarlo
      para agregar componentes y funcionalidades a la ventana. Mientras el archivo `.form` es el que contiene la vista
      de la ventana y puedes modificarla visualmente.
4. Haz que la clase principal del proyecto extienda de `JFrame` y crea un constructor para la ventana con el
   siguiente
   código:
    * ```java
         public class MiVentana extends JFrame {
             public MiVentana() {
                 setTitle("Mi Ventana");
                 setSize(400, 300);
                 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 setLocationRelativeTo(null);
                 setVisible(true);
             }
         }
       ```
5. En el método `main` de la clase principal, crea un objeto de la clase `Ventana` y ejecuta el programa.
    * ```java
         public class Main {
             public static void main(String[] args) {
                 Ventana ventana = new Ventana();
             }
         }
      ```
6. Ejecuta el programa y verás la ventana que has creado.

> **Nota:** La clase `JFrame` es una clase muy versátil y te permite crear ventanas con diferentes componentes y
> funcionalidades. Puedes personalizar la ventana a tu gusto y agregar botones, etiquetas, campos de texto, entre otros
> componentes.

> **Nota:** En caso de no encontrar la opción `Swing UI Designer` en IntelliJ IDEA, puedes instalar el plugin
`Swing UI Designer` desde el menú `File` > `Settings` > `Plugins` y buscar el plugin en el Marketplace.