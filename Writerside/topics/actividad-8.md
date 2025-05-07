# Actividad 8: Interacción entre objetos

## Objetivo

Hacer que los sprites interactúen entre sí. En este caso, dependiendo de si la pelota golpea al jugador, los bordes o
un bloque, se realizará una acción diferente. Aunque también hay interacción de los bonús, etc.

Por loq ue es importante seguir los pasos de la actividad anterior, ya que se va a utilizar el mismo código, además de
añadir las funcionalidades mencionadas en este punto.

## Instrucciones

1. Abre el proyecto de la actividad anterior.
2. Haz que las clases:
    - `Ball`
    - `Bonus`
    - `Missile`

   Implementen la interfaz `CollisionListener` y por consiguiente se agregue la lógica de colisión en el método
   `onCollisionDetected` de cada una de ellas. Además de registrar los objetos en el `CollisionManager` para que se
   detecten las colisiones.

## Actualizando `Ball`

En primera instancia, deberemos de asegurar que la clase contengan los siguientes atributos:

```java
    public static final int BALL_WIDTH = 20;
public static final int INITIAL_BALL_X = 224;
public static final int INITIAL_BALL_Y = 570;
public static final Point INITIAL_BALL_POSITION = new Point(INITIAL_BALL_X, INITIAL_BALL_Y);
public static final Dimension BALL_SIZE = new Dimension(BALL_WIDTH, BALL_WIDTH);
private int speed;
private boolean stop;
```

Actualiza el constructor de la clase `Ball` para que contenga los siguientes parámetros:

```java
    public Ball() {
    super(INITIAL_BALL_POSITION, "ball", BALL_SIZE, 1, -1);
    speed = 4;
    stop = true;
    CollisionManager.getInstance().addListener(this);
}

public Ball(Point startPosition) {
    super(startPosition, "ball", BALL_SIZE, 1, -1);
    speed = 4;
    stop = true;
    CollisionManager.getInstance().addListener(this);
}
```

Esto nos asegurará que los objetos de la clase `Ball` se registren en el `CollisionManager` y se detecten las
colisiones.

De igual manerá, es necesario asegurarnos que las siguientes funciones estén implementadas:

```java

@Override
public void draw(Graphics2D g2d) {

    Graphics2D g2 = (Graphics2D) g2d.create();
    g2.drawImage(getImageIcon().getImage(), position.x, position.y, null);
    g2.dispose();
}

@Override
public void move() {

    if (!stop) {
        position.x += dx * speed;
        position.y += dy * speed;
    } else {
        // Si la pelota está detenida, se ajusta su posición a la posición de la paleta.
        Paddle paddle = GamePanel.getInstance().getPaddle();
        position.x = paddle.getPosition().x + (paddle.getSize().width / 2) - (getSize().width / 2);
        position.y = paddle.getPosition().y - getSize().height;
    }
}

@Override
public void resetPosition() {
    // Se reinicia la posición de la pelota a la posición inicial.
    position.x = INITIAL_BALL_X;
    position.y = INITIAL_BALL_Y;
    // Se reinicia la velocidad de la pelota.
    speed = 3;
    // Se reinicia la dirección de la pelota.
    dx = 1;
    dy = -1;
    // Se reinicia el estado de la pelota.
    stop = true;
}

@Override
public void addImageToCache() {

    SpriteCache.getInstance().addImage(imageName, SpriteLoader.loadGif("ball.gif"));
}
```

Por último, es necesario implementar el método `onCollisionDetected` para que la pelota colisione con los objetos
dentro del juego. Por lo que es necesario asegurarse que la clase contenga el siguiente método:

```java

@Override
public void onCollisionDetected(Sprite collider, Sprite collidedWith, EdgeType edgeType) {
    // Se verifica si la pelota colisiona con otro objeto.
    if (collider == this) {
        if (collidedWith instanceof Paddle || collidedWith instanceof Brick || collidedWith instanceof Borders) {
            // Se ajusta la posición de la pelota para que no se quede pegada al borde del objeto con el que colisionó.
            switch (edgeType) {

                case LEFT_EDGE -> getPosition().x = collidedWith.getPosition().x - getImageIcon().getIconWidth();
                case RIGHT_EDGE -> getPosition().x = collidedWith.getPosition().x + collidedWith.getSize().width;
                case TOP_EDGE -> getPosition().y = collidedWith.getPosition().y - getImageIcon().getIconHeight();
                case BOTTOM_EDGE -> getPosition().y = collidedWith.getPosition().y + collidedWith.getSize().height;
            }
            // Se invierte la dirección de la pelota al colisionar con un borde o un ladrillo.
            switch (edgeType) {
                case LEFT_EDGE, RIGHT_EDGE -> setDx(-getDx());
                case TOP_EDGE, BOTTOM_EDGE -> setDy(-getDy());
            }
        }
        // Se determina el tipo de objeto con el que colisiona la pelota.
        // Si es un ladrillo, se indicará al panel que lo elimine.
        if (collidedWith instanceof Brick brick) {
            brick.hit();
            if (brick.isDestroyed()) {
                GamePanel.removeBrick(brick);
            }
        }
        // Si es un borde y además es el borde inferior, se eliminará la pelota.
        if (collidedWith instanceof Borders) {
            if (collidedWith == Borders.BOTTOM_BAR) {
                GamePanel panel = GamePanel.getInstance();
                panel.removeBall(this);
                panel.getPaddle().resetPosition();
            }
        }
    }
}
```

**Para las pruebas, cambiar el valor de `stop` a `false` para que la pelota se mueva, esto tanto en el constructor como en
el método `resetPosition`.**

## Actualizando `Bonus`

La clase `Bonus` es la encargada de gestionar los bonús que aparecen en el juego. Por lo que es necesario asegurarse
que la clase contenga los siguientes atributos:

```java
   private boolean active;
private BonusType type;
```

Además de asegurarse que el constructor contenga los siguientes parámetros:

```java
   public Bonus(Point startPosition, BonusType type) {

    super(startPosition, type.getImageName(), Brick.BRICK_SIZE, 0, 1);
    this.type = type;
    this.active = false;
    CollisionManager.getInstance().addListener(this);
}
```

Esto nos asegurará que los objetos de la clase `Bonus` se registren en el `CollisionManager` y se detecten las
colisiones. Por otro lado, es necesario desarrollar el resto de funcionalidades de la clase, como son los
métodos `draw`, `move`, y `addImageToCache`. Por lo que es necesario asegurarse que la clase
`Bonus` contenga los siguientes métodos:

```java
   public ImageIcon getImageIcon() {
    return SpriteCache.getInstance().getImageIcon(getImageName());
}

@Override
public void move() {
    position.y += dy;
}

@Override
public void draw(Graphics2D g2d) {
    Graphics2D g2 = (Graphics2D) g2d.create();
    g2.drawImage(getImageIcon().getImage(), position.x, position.y, null);
    g2.dispose();
}

@Override
public void onCollisionDetected(Sprite collider, Sprite collidedWith, EdgeType edgeType) {
    if (collider == this) {
        if (collidedWith == null) {
            GamePanel.removeBonus(this);
        }
        if (collidedWith instanceof Paddle) {
            GamePanel.removeBonus(this);
            this.type.activateBonus();
        }
    }
}

@Override
public void addImageToCache() {
    SpriteCache cache = SpriteCache.getInstance();
    if (type != null) {
        switch (type) {

            case L -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/L.gif"));
            case S -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/S.gif"));
            case M -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/M.gif"));
            case R -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/R.gif"));
            case E -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/E.gif"));
            case B -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/B.gif"));
            case C -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/C.gif"));
            case D -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/D.gif"));
            case P -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/P.gif"));
            case T -> cache.addImage(imageName, SpriteLoader.loadGif("bonus/T.gif"));
        }
    }
}
```

## Actualizando `Missile`

La clase `Missile` es la encargada de gestionar los misiles que aparecen en el juego. Por lo que es necesario asegurarse
que la clase contenga los siguientes atributos:

```java
   public static final int MISSILE_WIDTH = 16;
public static final int MISSILE_HEIGHT = 37;
public static final int MISSILE_SPEED = 5;
public static final Dimension MISSILE_SIZE = new Dimension(MISSILE_WIDTH, MISSILE_HEIGHT);
```

Además de asegurarse que el constructor contenga los siguientes parámetros:

```java
   public Missile(Point position) {

    super(position, "missile", MISSILE_SIZE, 0, MISSILE_SPEED);
    // Se registra el misil en el gestor de colisiones.
    CollisionManager.getInstance().addListener(this);
}
```

Esto nos asegurará que los objetos de la clase `Missile` se registren en el `CollisionManager` y se detecten las
colisiones. Por otro lado, es necesario desarrollar el resto de funcionalidades de la clase, como son los
métodos `draw`, `move`, y `addImageToCache`. Por lo que es necesario asegurarse que la clase contenga los siguientes
métodos:

```java

@Override
public void onCollisionDetected(Sprite collider, Sprite collidedWith, EdgeType edgeType) {
    // Se verifica si el misil colisiona con otro objeto.
    if (collider == this) {
        if (collidedWith instanceof Brick brick) {
            brick.hit();
            if (brick.isDestroyed()) {
                GamePanel.removeBrick(brick);
            }
            // Se destruye el misil al colisionar con un ladrillo.
            GamePanel.removeMissile(this);
        }
        if (collidedWith instanceof Borders) {
            // Se destruye el misil al colisionar con un borde.
            GamePanel.removeMissile(this);
        }
    }
}

@Override
public void move() {

    position.y -= dy;
}

@Override
public void addImageToCache() {
    // Se agrega la imagen del misil al caché de sprites.
    SpriteCache spriteCache = SpriteCache.getInstance();
    spriteCache.addImage("missile", SpriteLoader.loadImage("missile.png"));
}
```

## Actualizando `GamePanel`

Como te habrás dado cuenta, es necesario actualizar la clase `GamePanel` para que contenga los métodos
`removeBonus`, `removeMissile`, y `removeBrick`. Por lo que es necesario asegurarse que la clase use el patrón
Singleton, además de que contenga los siguientes métodos:

```java
public static GamePanel getInstance() {
    if (INSTANCE == null) {
        INSTANCE = new GamePanel();
    }
    return INSTANCE;
}

private static void createBonus(Brick brick) {
   if (brick != null && Randomized.getRandomBoolean()) {
      BonusType bonusType = Randomized.getRandomBonusType();
      Bonus bonus = new Bonus(brick.getPosition(), bonusType);
      bonus.addImageToCache();
      gameObjects.add(bonus);
      CollisionManager.getInstance().registerCollidable(bonus);
   }
}

public static void removeBonus(Bonus bonus) {
    if (bonus != null) {
        gameObjects.remove(bonus);
        CollisionManager.getInstance().unregisterCollidable(bonus);
    }
}

public static void removeMissile(Missile missile) {
    if (missile != null) {
        gameObjects.remove(missile);
        CollisionManager.getInstance().unregisterCollidable(missile);
        missiles.remove(missile);
    }
}

public static void removeBrick(Brick brick) {

    if (brick != null) {

        score += brick.getScore();
        gameObjects.remove(brick);
        CollisionManager.getInstance().unregisterCollidable(brick);
        createBonus(brick);
    }
}

public void removeBall(Ball ball) {

    if (ball != null) {

        if (balls.size() > 1) {

            balls.remove(ball);
            gameObjects.remove(ball);
            CollisionManager.getInstance().unregisterCollidable(ball);
        } else {
            ball.resetPosition();
            lives--;
            if (lives == 0) {
                gameRunning = false;
            }
        }
    }
}
```

## Agregando eventos de colisión y de teclado

Para que el juego funcione correctamente, es necesario agregar los eventos de colisión y de teclado. Por lo que es
necesario crear la clase `KeyboardAction`:

```java
package org.brick_breaker.ui.events;

import org.brick_breaker.sprites.Missile;
import org.brick_breaker.sprites.paddles.PaddleType;
import org.brick_breaker.ui.panels.GamePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardAction extends KeyAdapter {

    GamePanel gamePanel;

    public KeyboardAction(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                gamePanel.getPaddle().setDx(-1);
                break;
            case KeyEvent.VK_RIGHT:
                gamePanel.getPaddle().setDx(1);
                break;
            case KeyEvent.VK_SPACE:
                if (gamePanel.isGameRunning()) {
                    if (!gamePanel.getBalls().isEmpty() && gamePanel.getBalls().getFirst().isStop())
                        gamePanel.getBalls().getFirst().setStop(false);
                    if (gamePanel.getPaddle().getType() == PaddleType.SHOOTER)
                        gamePanel.addMissile();
                }
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                gamePanel.getPaddle().setDx(0);
                break;
            default:
                break;
        }
    }

}
```

Con todos los cambios realiazados, el juego debería de funcionar correctamente. Por lo que es necesario asegurarse que
el juego funcione correctamente.

## Entregable

El entregable de esta actividad es el proyecto completo, con los cambios realizados en las clases `Ball`, `Bonus`,
`Missile`, `GamePanel`, y `KeyboardAction`. Además de asegurarse que el juego funcione correctamente.

En el caso de la clase `MainWindow`, es necesario agregar dos etiquetas con los nombres: `scoreLabel` y `lifeLabel` para
que el juego muestre la puntuación y las vidas restantes, estas etiquetas deben ir en el panel derecho de la ventana
del juego.

## Criterios de evaluación

| Criterio      | Descripción                                                         | Puntaje  |
|---------------|---------------------------------------------------------------------|----------|
| Portada       | Contiene los datos de identificación del equipo                     | 5%       |
| Funcionalidad | La clase `Ball` cumple con los requerimientos solicitados           | 20%      |
| Funcionalidad | La clase `Bonus` cumple con los requerimientos solicitados          | 20%      |
| Funcionalidad | La clase `Missile` cumple con los requerimientos solicitados        | 10%      |
| Funcionalidad | La clase `GamePanel` cumple con los requerimientos solicitados      | 10%      |
| Funcionalidad | La clase `KeyboardAction` cumple con los requerimientos solicitados | 5%       |
| Pruebas       | Se anexa video de pruebas de la actividad                           | 30%      |
| **Total**     | **Cumple con lo establecido en la actividad**                       | **100%** |

## Fecha de entrega

- **Fecha límite de entrega:** martes 6 de mayo de 2025 a las 11:59 p.m.

> **Trabajos entregados después de la fecha y hora límite serán calificados sobre 70 puntos como máximo.**
> {style="warning"}

> **Integrante que no aparezca en la portada del documento no será calificado.**
> {style="warning"}

> **Trabajo entregado en formato de texto plano no será calificado.**
> {style="warning"}