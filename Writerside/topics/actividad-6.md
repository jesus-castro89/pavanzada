# Actividad 6: Definiendo la primera ventana

## Objetivo

Definir la primera ventana de la aplicación, incluyendo el título de la aplicación. Y los primeros componentes de la
interfaz de usuario.

## Instrucciones

### Crear la ventana principal

1. Crea el paquete `ui.windows` dentro del paquete `org.brick_breaker`.
2. Crea una nueva ventana mediante `Swing UI Designer`.
    * Haz clic derecho en el paquete `ui` y selecciona `New > Swing UI Designer > GUI Form`.
    * En caso de que no aparezca la opción `Swing UI Designer`, asegúrate de que el plugin `Swing UI Designer` está
      habilitado o en su defecto descárgalo.
3. En la ventana de diseño, nombra el panel inicial como `mainPanel`.
    * Para hacer esto puedes seleccionar el panel y en la parte derecha izquierda de la ventana, en el panel de
      propiedades cambiar el nombre del panel a `mainPanel`.
4. Agrega dos paneles, uno para el área de juego y el otro para el área de controles.
5. Nombra el primero de estos paneles como `gamePanel` y el segundo como `controlPanel`.
6. En la parte de la clase, haz que la misma herede de `JFrame`.
7. Define el constructor de la clase y dentro de este:
    * Llama al constructor de la clase padre.
    * Define el título de la ventana como `Brick Breaker`.
    * Define el tamaño de la ventana con la función `pack()`
    * Define el comportamiento de cierre de la ventana como `EXIT_ON_CLOSE`.
    * Agrega el panel principal a la ventana.
    * Haz que la ventana se centre en la pantalla con `setLocationRelativeTo(null)`.
    * Haz visible la ventana.

### Creando el panel de juego

1. Crea el paquete `ui.panels` dentro del paquete `org.brick_breaker`.
2. Crea la clase `GamePanel` dentro del paquete `ui.game`.
3. Haz que la clase `GamePanel` herede de `JPanel` y define lo siguiente:
   ```java
    public static final int INITIAL_LIVES = 15;
    public static final int INITIAL_SCORE = 0;
    public static final int INITIAL_LEVEL = 1;
    public static final int MAX_LEVEL = 5;
    private static final Borders LEFT_BORDER = Borders.LEFT_BAR;
    private static final Borders RIGHT_BORDER = Borders.RIGHT_BAR;
    private static final Borders TOP_BORDER = Borders.TOP_BAR;
    private static final Borders BOTTOM_BORDER = Borders.BOTTOM_BAR;
    private static Level level;
    private static final ArrayList<Ball> balls = new ArrayList<>();
    private final Paddle paddle;
    public static Timer timer;
    private static boolean gameRunning = true;
    private boolean bricksDestroyed = false;
    private static int lives = INITIAL_LIVES;
    private int score = INITIAL_SCORE;
    private int levelNumber = INITIAL_LEVEL;
   ```
4. Define la función `initPanelSize()` que inicializa el tamaño del panel de juego de la siguiente manera:
   * El ancho de la ventana es igual a la suma del ancho de la barra superior y las barras laterales.
   * El alto de la ventana es igual al alto de alguna de las barras laterales.
   * Haz que el tamaño preferido, mínimo y máximo del panel de juego sea igual al tamaño del panel.
