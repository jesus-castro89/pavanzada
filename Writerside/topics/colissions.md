# Actividad 7: Las colisiones

## Objetivo

En esta actividad desarrollaremos e implementaremos la lógica de colisiones entre objetos en un juego. Aprenderemos a
detectar colisiones entre objetos y a manejar las interacciones resultantes. Esto es fundamental para crear una
experiencia de juego fluida y realista.

## Creando el enumerado `EdgeType`

Para representar los diferentes tipos de colisiones que pueden ocurrir entre objetos, crearemos un enumerado llamado
`EdgeType`. Este enumerado estará en el paquete `org.brick_breaker.utils.collisions` y contendrá los siguientes valores:

* `TOP_EDGE`: Representa una colisión en la parte superior de un objeto.
* `BOTTOM_EDGE`: Representa una colisión en la parte inferior de un objeto.
* `LEFT_EDGE`: Representa una colisión en el lado izquierdo de un objeto.
* `RIGHT_EDGE`: Representa una colisión en el lado derecho de un objeto.

## Creando el `CollisionListener`

Para detectar colisiones entre objetos, crearemos una interfaz llamada `CollisionListener`. Esta interfaz se encargará
de
detectar colisiones entre los objetos del juego y de manejar las interacciones resultantes. La interfaz
`CollisionListener`
tendrá un método llamado `onCollisionDetected` que se llamará cada vez que se detecte una colisión entre dos objetos.
Este método recibirá dos parámetros: el objeto que ha colisionado y el objeto con el que ha colisionado. En este método
podremos implementar la lógica de colisiones y las interacciones resultantes.

Esta clase deberá estar en el paquete `org.brick_breaker.utils.collisions` y se verá de la siguiente manera:

```java
package org.brick_breaker.utils.collisions;

import org.brick_breaker.sprites.Sprite;

public interface CollisionListener {

    void onCollisionDetected(Sprite collider, Sprite collidedWith, EdgeType edgeType);
}
```

## Creando la clase `CollisionManager`

La clase `CollisionManager` se encargará de gestionar las colisiones entre los objetos del juego. Esta clase
implementará la lógica de detección de colisiones y llamará al método `onCollisionDetected` de la interfaz
`CollisionListener` cada vez que se detecte una colisión entre dos objetos. La clase `CollisionManager` deberá
estar en el paquete `org.brick_breaker.utils.collisions` y se verá de la siguiente manera:

```java
package org.brick_breaker.utils.collisions;

import org.brick_breaker.sprites.Borders;
import org.brick_breaker.sprites.Sprite;
import org.brick_breaker.ui.panels.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CollisionManager {
    private static CollisionManager instance;
    private final CopyOnWriteArrayList<CollisionListener> listeners = new CopyOnWriteArrayList<>();
    private final CopyOnWriteArrayList<Sprite> collidableObjects = new CopyOnWriteArrayList<>();

    private CollisionManager() {
    }

    public static CollisionManager getInstance() {
        if (instance == null) {
            instance = new CollisionManager();
        }
        return instance;
    }

    public void registerCollidable(Sprite object) {
        collidableObjects.add(object);
    }

    public void unregisterCollidable(Sprite object) {
        collidableObjects.remove(object);
    }

    public void addListener(CollisionListener listener) {
        listeners.add(listener);
    }

    public void removeListener(CollisionListener listener) {
        listeners.remove(listener);
    }

    public void checkCollisions() {

        for (int i = 0; i < collidableObjects.size(); i++) {
            Sprite obj1 = collidableObjects.get(i);

            // Verificar colisión con bordes
            checkBorderCollisions(obj1);

            // Verificar colisión con otros objetos
            for (int j = i + 1; j < collidableObjects.size(); j++) {
                Sprite obj2 = collidableObjects.get(j);

                if (obj1.getBounds().intersects(obj2.getBounds())) {

                    EdgeType collisionSide = determineCollisionSide(obj1.getBounds(), obj2.getBounds());
                    notifyListeners(obj1, obj2, collisionSide);
                    notifyListeners(obj2, obj1, inverseCollisionSide(collisionSide));
                }
            }
        }
    }

    private void checkBorderCollisions(Sprite obj) {

        Rectangle bounds = obj.getBounds();
        if (bounds.x <= 0)
            notifyListeners(obj, null, EdgeType.LEFT_EDGE);
        if (bounds.y <= 0)
            notifyListeners(obj, null, EdgeType.TOP_EDGE);
        if (bounds.x + bounds.width >= GamePanel.GAME_WIDTH)
            notifyListeners(obj, null, EdgeType.RIGHT_EDGE);
        if (bounds.y + bounds.height >= GamePanel.HEIGHT - Borders.BOTTOM_BAR.getBounds().height)
            notifyListeners(obj, null, EdgeType.BOTTOM_EDGE);
    }

    private void notifyListeners(Sprite collider, Sprite collidedWith, EdgeType side) {

        // Crear una copia de la lista de listeners para evitar ConcurrentModificationException
        List<CollisionListener> listenersCopy = new ArrayList<>(listeners);
        for (CollisionListener listener : listenersCopy) {
            listener.onCollisionDetected(collider, collidedWith, side);
        }
    }

    private EdgeType determineCollisionSide(Rectangle obj1, Rectangle obj2) {

        int leftImpact = obj1.x + obj1.width - obj2.x;
        int rightImpact = obj2.x + obj2.width - obj1.x;
        int topImpact = obj1.y + obj1.height - obj2.y;
        int bottomImpact = obj2.y + obj2.height - obj1.y;
        int[] impacts = {leftImpact, rightImpact, topImpact, bottomImpact};
        int minImpact = Integer.MAX_VALUE;
        EdgeType edgeType = EdgeType.LEFT_EDGE;
        for (int i = 0; i < impacts.length; i++) {
            if (impacts[i] < minImpact) {
                minImpact = impacts[i];
                edgeType = EdgeType.values()[i];
            }
        }
        return edgeType;
    }

    private EdgeType inverseCollisionSide(EdgeType side) {

        return switch (side) {
            case LEFT_EDGE -> EdgeType.RIGHT_EDGE;
            case RIGHT_EDGE -> EdgeType.LEFT_EDGE;
            case TOP_EDGE -> EdgeType.BOTTOM_EDGE;
            case BOTTOM_EDGE -> EdgeType.TOP_EDGE;
        };
    }
}
```

## Implementando la lógica de colisiones

Para implementar la lógica de colisiones, crearemos una clase llamada `GameCycle` que implementará `ActionListener`,
que se encargará de gestionar el ciclo del juego y de actualizar la lógica de colisiones. Esta clase deberá estar en el
paquete `org.brick_breaker.utils` y se verá de la siguiente manera:

```java
package org.brick_breaker.utils;

import org.brick_breaker.ui.panels.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameCycle implements ActionListener {

    private final GamePanel panel;

    public GameCycle(GamePanel panel) {

        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        doGameCycle();
    }

    private void doGameCycle() {

        panel.update();
        panel.repaint();
    }
}
```

## Actualizando el `GamePanel`

Para actualizar el `GamePanel`, debemos hacer lo siguiente:

1. Crear una instancia de `GameCycle` y asignarla al `Timer`.
2. Registrar los objetos colisionables en el `CollisionManager`.
3. Registrar el `CollisionListener` en el `CollisionManager`.
4. Llamar al método `checkCollisions` del `CollisionManager` en el ciclo del juego.
5. Implementar la lógica de colisiones en el método `onCollisionDetected` del `CollisionListener`.
6. Actualizar la lógica de movimiento y colisiones de los objetos en el `GamePanel`.

Para ello tendremos que modificar el `GamePanel` de la siguiente manera:

### Importar las clases necesarias

```java

```

### Atributos de la clase

```java
private static final Borders LEFT_BORDER = Borders.LEFT_BAR;
private static final Borders RIGHT_BORDER = Borders.RIGHT_BAR;
private static final Borders TOP_BORDER = Borders.TOP_BAR;
private static final Borders BOTTOM_BORDER = Borders.BOTTOM_BAR;
public static GamePanel INSTANCE;
public static final int INITIAL_LIVES = 15;
public static final int INITIAL_SCORE = 0;
public static final int INITIAL_LEVEL = 1;
public static final int MAX_LEVEL = 5;
public static final int WIDTH = (int) (2 * LEFT_BORDER.getSize().getWidth() + TOP_BORDER.getSize().getWidth());
public static final int HEIGHT = (int) (LEFT_BORDER.getSize().getHeight());
public static final int GAME_WIDTH = WIDTH - RIGHT_BORDER.getSize().width;
private static Level level;
private static final ArrayList<Ball> balls = new ArrayList<>();
private Paddle paddle;
public static Timer timer;
private static boolean gameRunning = false;
private boolean bricksDestroyed = false;
private static int lives = INITIAL_LIVES;
private static int score = INITIAL_SCORE;
private int levelNumber = INITIAL_LEVEL;
private static final CopyOnWriteArrayList<Sprite> gameObjects = new CopyOnWriteArrayList<>();
private static final CopyOnWriteArrayList<Missile> missiles = new CopyOnWriteArrayList<>();
```

### Constructor

```java
private GamePanel() {

    initPanelSize();
    level = FileManager.readLevel(Level.levelNumber);
}
```

Recuerda agregar como atributo el `Timer` y el `CopyOnWriteArrayList` de `Sprite` y `Missile`:

```java
private static final CopyOnWriteArrayList<Sprite> gameObjects = new CopyOnWriteArrayList<>();
private static final CopyOnWriteArrayList<Missile> missiles = new CopyOnWriteArrayList<>();
public static Timer timer;
```

### Método `registerBricks`

```java
private void registerBricks() {
    if (level != null) {
        for (Brick[] row : level.getBricks()) {
            Collections.addAll(gameObjects, row);
        }
    }
    if (isGameRunning()) {
        for (Sprite sprite : gameObjects) {
            if (sprite instanceof Brick brick) {
                CollisionManager.getInstance().registerCollidable(brick);
            }
        }
    }
}
```

### Método `registerObjects`

```java
private void registerObjects() {

    registerBricks();
    gameObjects.add(LEFT_BORDER);
    gameObjects.add(RIGHT_BORDER);
    gameObjects.add(TOP_BORDER);
    gameObjects.add(BOTTOM_BORDER);
    gameObjects.add(paddle);
    gameObjects.addAll(balls);
    for (Sprite sprite : gameObjects) {
        if (sprite instanceof Brick) {
            ((Brick) sprite).addImageToCache();
        }
        CollisionManager.getInstance().registerCollidable(sprite);
    }
}
```

### Métodos `playGame`, `startGame`, `stopGame`, `updateLabels`, `checkBricksDestroy`, `loadLevel` y `update`

```java
public void startGame() {
    paddle = new Paddle(PaddleType.SHOOTER);
    balls.add(new Ball());
    timer = new Timer(10, new GameCycle(this));
    playGame();
    registerObjects();
    addKeyListener(new KeyboardAction(this));
    setFocusable(true);
    requestFocus();
}

public void stopGame() {

    gameRunning = false;
    timer.stop();
}

public void playGame() {

    gameRunning = true;
    timer.start();
    this.requestFocus();
}

public void update() {

    if (gameRunning) {
        updateLabels();
        checkBricksDestroy();
        // Se verifica si se ha llegado al final del nivel.
        if (bricksDestroyed) {
            loadLevel();
        }
        // Se verifica si se ha colisionado con algún objeto.
        CollisionManager.getInstance().checkCollisions();
        // Se actualiza la posición de los objetos del juego.
        for (Sprite sprite : gameObjects) {

            if (sprite instanceof MovingSprite) {
                ((MovingSprite) sprite).move();
            }
        }
    }
}

private void updateLabels() {

    MainWindow mainWindow = MainWindow.getInstance();
    mainWindow.getScoreLabel().setText(String.valueOf(score));
    mainWindow.getLifeLabel().setText(String.valueOf(lives));
}

private void checkBricksDestroy() {
    // Se verifica si se han destruido todos los ladrillos.
    if (level != null && level.getBricks() != null) {
        bricksDestroyed = true;
        for (Brick[] row : level.getBricks()) {
            for (Brick brick : row) {
                if (!brick.isDestroyed()) {
                    bricksDestroyed = false;
                    break;
                }
            }
        }
    }
}

private void loadLevel() {
    levelNumber++;
    if (levelNumber <= MAX_LEVEL) {
        level = FileManager.readLevel(levelNumber);
        if (level != null) {
            paddle.resetPosition();
            int size = balls.size();
            for (int i = 1; i < size; i++) {
                balls.removeLast();
            }
            balls.getFirst().resetPosition();
            registerBricks();
        }
    } else {
        stopGame();
    }
}
```

Para verificar que la lógica de colisiones funciona correctamente, puedes hacer que la pelota no esté detenida por el
paddle y que se mueva hacia la parte superior de la pantalla.

## Conclusión

En esta actividad hemos implementado la lógica de colisiones entre objetos en un juego. Hemos creado un enumerado
`EdgeType` para representar los diferentes tipos de colisiones, una interfaz `CollisionListener` para manejar las
interacciones resultantes de las colisiones y una clase `CollisionManager` para gestionar las colisiones entre los
objetos del juego. También hemos actualizado el `GamePanel` para registrar los objetos colisionables y gestionar el
ciclo del juego. Con esto, hemos dado un paso importante hacia la creación de un juego más dinámico y realista.
Hemos aprendido a detectar colisiones entre objetos y a manejar las interacciones resultantes, lo que es fundamental
para crear una experiencia de juego fluida y realista.

## Actividad

Para esta actividad, deberás implementar lo mencionado anteriormente. Deberás importar las imágenes de los objetos
del juego y crear los objetos necesarios para el juego. Además, deberás implementar la lógica de colisiones y
manejar las interacciones resultantes, para ello recuerda que los objetos que colisionan deben implementar la
interfaz `CollisionListener`. Y por ahora no te preocupes por las funciones de reacción de los componentes.

En este caso la actividad no cuenta con entrega, pero es importante realizarla para el resto de pasos del proyecto.