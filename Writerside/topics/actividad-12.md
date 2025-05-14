# Actividad 12: Ventanas e interacción con el usuario

Para esta actividad culminaremos el juego de la actividad 11, añadiendo ventanas y mejorando la interacción con el
usuario.

## Creando la ventana de Inicio

1. Crea una ventana mediante el editor visual en el paquete `org.brick_breaker.ui.windows`
   llamada `StartWindow`.
2. Lo que deberás hacer en este caso es agregar los siguientes componentes a tu gusto sobre
   la ventana:
    - Un `JLabel` que diga "Bienvenido a Brick Breaker"
    - Un `JButton` que diga "Iniciar Juego"
    - Un `JButton` que diga "Salir"
3. Haz que los tres componentes estén centrados en la ventana o si lo prefieres, puedes acomodarlos a tu gusto.
4. Marca los tres componentes como `CustomCreate`.
5. Modifica la función `createUIComponents` de la clase `StartWindow` de la siguiente manera:
    - ```java
      private void createUIComponents() {
        titleLabel = new TitleLabel();
        startButton = new JButton("Iniciar");
        exitButton = new JButton("Salir");
        ThreePartButtonUI.configureButton(startButton);
        ThreePartButtonUI.configureButton(exitButton);
      }
      ```
    - Como podrás notar, los textos de los botones se asignan desde la función y ambos se configuran
      mediante el método `configureButton` de la clase `ThreePartButtonUI`.
    - Mientas que el `JLabel` se asigna a la variable `titleLabel` que es de tipo `TitleLabel`, que es una
      clase que extiende de `JLabel` y que tiene un constructor que recibe un texto y lo configura
      con el estilo del juego.
6. Crea el constructor de la ventana para que tenga un tamaño a tu gusto, aúnque el sugerido es de 400 x 300 pixeles.
    - La ventana debe ser visible y centrada en la pantalla.
    - El título de la ventana debe ser "Brick Breaker".
    - La ventana debe cerrarse al hacer clic en la "X" de la ventana.
    - No debe poder cambiar de tamaño.
7. Agrega un `ActionListener` al botón "Iniciar Juego" que muestre la ventana del juego.
    - Para esto, primero deberás de cerrar la ventana de inicio mediante el método `dispose()`.
    - Luego, deberás recuperar la instancia de la ventana del juego mediante el método
      `MainWindow.getInstance()` y mostrarla mediante el método `startGame()`.
8. Agrega un `ActionListener` al botón "Salir" que cierre la aplicación.
    - Para esto, deberás de cerrar la ventana de inicio mediante el método `dispose()`.
    - Luego, deberás de cerrar la aplicación mediante el método `System.exit(0)`.

## Creando la ventana de Game Over

1. Crea una ventana mediante el editor visual en el paquete `org.brick_breaker.ui.windows`
   llamada `GameOverWindow`.
2. Lo que deberás hacer en este caso es agregar los siguientes componentes a tu gusto sobre
   la ventana:
    - Un `JLabel` que diga "Game Over"
    - Un `JButton` que diga "Reiniciar"
    - Un `JButton` que diga "Salir"
3. Haz que los tres componentes estén centrados en la ventana o si lo prefieres, puedes acomodarlos a tu gusto.
4. Marca los tres componentes como `CustomCreate`.
5. Modifica la función `createUIComponents` de la clase `GameOverWindow` de la siguiente manera:
    - ```java
      private void createUIComponents() {
        titleLabel = new TitleLabel();
        titleLabel.setText("Game Over");
        restartButton = new JButton("Reiniciar");
        exitButton = new JButton("Salir");
        ThreePartButtonUI.configureButton(restartButton);
        ThreePartButtonUI.configureButton(exitButton);
      }
      ```
    - Como podrás notar, los textos de los botones se asignan desde la función y ambos se configuran
      mediante el método `configureButton` de la clase `ThreePartButtonUI`.
    - Mientas que el `JLabel` se asigna a la variable `titleLabel` que es de tipo `TitleLabel`, que es una
      clase que extiende de `JLabel` y que tiene un constructor que recibe un texto y lo configura
      con el estilo del juego.
6. Crea el constructor de la ventana para que tenga un tamaño a tu gusto, aúnque el sugerido es de 400 x 300 pixeles.
    - La ventana debe ser visible y centrada en la pantalla.
    - El título de la ventana debe ser "Game Over".
    - La ventana debe cerrarse al hacer clic en la "X" de la ventana.
    - No debe poder cambiar de tamaño.
7. Agrega un `ActionListener` al botón "Reiniciar" que muestre la ventana del juego.
    - Para esto, primero deberás de cerrar la ventana de inicio mediante el método `dispose()`.
    - Luego, deberás de recuperar la instancia de la ventana del juego mediante el método
      `MainWindow.getInstance()` y mostrarla mediante el método `restartGame()`.
8. Agrega un `ActionListener` al botón "Salir" que cierre la aplicación.
    - Para esto, deberás de cerrar la ventana de inicio mediante el método `dispose()`.
    - Luego, deberás de cerrar la aplicación mediante el método `System.exit(0)`.

## Probando el juego

Una vez todos los cambios realizados, deberás de probar el juego para asegurarte que todo funciona correctamente.

## Entregando la actividad

1. Una vez que hayas terminado la actividad, deberás de subir el proyecto a la plataforma Moodle.
2. Asegúrate de que el proyecto esté completo y funcionando correctamente.
3. Asegúrate de que el proyecto esté bien documentado y que el código esté limpio y ordenado.
4. Asegúrate de que el proyecto esté bien estructurado y que siga las buenas prácticas de programación.

## Criterios de evaluación

| Criterios de evaluación    | Descripción                                                                             | Puntuación |
|----------------------------|-----------------------------------------------------------------------------------------|------------|
| Ventana de inicio          | La ventana de inicio debe tener los componentes correctos y funcionar correctamente.    | 20%        |
| Ventana de Game Over       | La ventana de Game Over debe tener los componentes correctos y funcionar correctamente. | 20%        |
| Interacción con el usuario | La interacción con el usuario debe ser correcta y funcionar correctamente.              | 20%        |
| Código limpio              | El código debe estar limpio y ordenado.                                                 | 20%        |
| Documentación              | El código debe estar bien documentado.                                                  | 20%        |
| **Total**                  |                                                                                         | **100%**   |

## Fecha de entrega

- **Fecha límite de entrega:** martes 27 de mayo de 2025 a las 11:59 p.m.

> **Trabajos entregados después de la fecha y hora límite no será calificado.**
> {style="warning"}

> **Integrante que no aparezca en la portada del documento no será calificado.**
> {style="warning"}

> **Trabajo entregado en formato de texto plano no será calificado.**
> {style="warning"}