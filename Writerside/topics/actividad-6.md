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

### Actualizando el constructor del borde

1. Abre la clase `Borders` y agrega el siguiente código al constructor:
   ```java
    public Borders(String imageName, Point location) {
        super(location, imageName, new Dimension(0, 0));
        addImageToCache();
    }
   ```

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
    private static ArrayList<Sprite> gameObjects = new ArrayList<>();
   ```
4. Define la función `initPanelSize()` que inicializa el tamaño del panel de juego de la siguiente manera:
    * El ancho de la ventana es igual a la suma del ancho de la barra superior y las barras laterales.
    * El alto de la ventana es igual al alto de alguna de las barras laterales.
    * Haz que el tamaño preferido, mínimo y máximo del panel de juego sea igual al tamaño del panel.
    * Asegúrate de que el panel de juego no se pueda redimensionar.
   ```java
    private void initPanelSize() {
        int width = (int) (2 * LEFT_BORDER.getSize().getWidth() + TOP_BORDER.getSize().getWidth());
        int height = (int) (LEFT_BORDER.getSize().getHeight());
        setSize(width, height);
        setPreferredSize(getSize());
        setMinimumSize(getSize());
        setMaximumSize(getSize());
    }
   ```
5. Define la función `registerObjects` de la siguiente manera:
   ```java
    private void registerObjects() {
        if (level != null) {
            for (Brick[] row : level.getBricks()) {
                Collections.addAll(gameObjects, row);
            }
        }
        gameObjects.add(LEFT_BORDER);
        gameObjects.add(RIGHT_BORDER);
        gameObjects.add(TOP_BORDER);
        gameObjects.add(BOTTOM_BORDER);
        gameObjects.add(paddle);
        gameObjects.addAll(balls);
    }
   ```
6. Define el constructor de la clase de la siguiente manea:
   ```java
    public GamePanel() {
   
        initPanelSize();
        level = FileManager.readLevel(Level.levelNumber);
        this.paddle = new Paddle(PaddleType.MEDIUM);
        balls.add(new Ball());
        registerObjects();
    }
   ```
7. Define la función `paintComponent` de la siguiente manera:
   ```java
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        BufferedImage background = SpriteLoader.loadImage(level.getBackgroundName() + ".png");
        g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
        for (Sprite sprite : gameObjects) {
            sprite.draw(g2d);
        }
    }
   ```
8. Define la función `update` de la siguiente manera:
   ```java
    public void update() {
        if (gameRunning) {
            for (Sprite sprite : gameObjects) {
                sprite.update();
            }
            repaint();
        }
    }
   ```

### Implementando el panel en la ventana

1. Abre el editor visual de la ventana principal, y selecciona el panel de la izquierda.
2. En la lista de propiedades selecciona la opción `Custom Create`.
3. En la clase `MainWindow` notarás que se ha creado un método `createUIComponents()`.
4. Agrega la siguiente línea de código al método `createUIComponents()`:
   ```java
    gamePanel = new GamePanel();
   ```
5. En la parte superior de la clase `MainWindow` agrega el siguiente import:
   ```java
    import org.brick_breaker.ui.panels.GamePanel;
   ```
6. Ejecuta la aplicación y verifica que la ventana se abra correctamente.
7. Verifica que el panel de juego se muestre correctamente.

## Actividad

Para esta actividad, deberás implementar la tanto el panel de juego como la ventana principal. Asegúrate de que la
ventana principal tenga el título `Brick Breaker` y que el panel de juego se muestre correctamente.
Además, asegúrate de que el panel de juego tenga el tamaño correcto y que los objetos se dibujen correctamente.

## Entrega

Para entregar la actividad, deberás crear un archivo `.zip` con el siguiente contenido:

* Archivos `.zip` del proyecto.
* Portada con datos de identificación.
* Evidencias de ejecución de la creación de la ventana principal y el panel de juego.
    * Para ello, deberás crear una clase `Main` que cree la ventana principal y muestre el panel de juego.

## Criterios de evaluación

| Criterio      | Descripción                                                     | Puntaje  |
|---------------|-----------------------------------------------------------------|----------|
| Portada       | Contiene los datos de identificación del equipo                 | 5%       |
| Funcionalidad | La clase `MainWindow` cumple con los requerimientos solicitados | 20%      |
| Funcionalidad | La clase `GamePanel` cumple con los requerimientos solicitados  | 20%      |
| Funcionalidad | La clase `Borders` cumple con los requerimientos solicitados    | 20%      |
| Evidencias    | Muestra evidencias de la creación de al menos un nivel          | 35%      |
| **Total**     | **Cumple con lo establecido en la actividad**                   | **100%** |

## Fecha de entrega

- **Fecha límite de entrega:** viernes 11 de abril de 2025 a las 11:59 p.m.

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos como máximo.**
> {style="warning"}

> **Integrante que no aparezca en la portada del documento no será calificado.**
> {style="warning"}

> **Trabajo entregado en formato de texto plano no será calificado.**
> {style="warning"}