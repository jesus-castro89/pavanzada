package org.brick_breaker.ui.panels;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.Ball;
import org.brick_breaker.sprites.Borders;
import org.brick_breaker.sprites.MovingSprite;
import org.brick_breaker.sprites.Sprite;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.sprites.paddles.Paddle;
import org.brick_breaker.sprites.paddles.PaddleType;
import org.brick_breaker.ui.events.KeyboardAction;
import org.brick_breaker.utils.FileManager;
import org.brick_breaker.utils.GameCycle;
import org.brick_breaker.utils.colissions.CollisionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que representa el panel del juego.
 * Se encarga de inicializar el tamaño del panel, registrar los objetos del juego,
 * mover la pelota y actualizar la posición de los objetos.
 * También se encarga de dibujar los objetos en el panel y manejar las colisiones.
 */
public class GamePanel extends JPanel {

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
    private static boolean gameRunning = true;
    private boolean bricksDestroyed = false;
    private static int lives = INITIAL_LIVES;
    private int score = INITIAL_SCORE;
    private int levelNumber = INITIAL_LEVEL;
    private static ArrayList<Sprite> gameObjects = new ArrayList<>();

    private GamePanel() {

        initPanelSize();
        level = FileManager.readLevel(Level.levelNumber);
        paddle = new Paddle(PaddleType.MEDIUM);
        balls.add(new Ball());
        timer = new Timer(10, new GameCycle(this));
        playGame();
        registerObjects();
        registerCollidableObjects();
        addKeyListener(new KeyboardAction(this));
        setFocusable(true);
        requestFocus();
    }

    public static GamePanel getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new GamePanel();
        }
        return INSTANCE;
    }

    private void registerCollidableObjects() {

        CollisionManager collisionManager = CollisionManager.getInstance();
        for (Sprite sprite : gameObjects) {
            if (sprite instanceof Brick) {
                ((Brick) sprite).addImageToCache();
                collisionManager.registerCollidable(sprite);
            }
        }
    }

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

    /**
     * Función que permite inicializar el tamaño del panel con la siguiente lógica:
     * 1. Se obtiene el ancho y alto de la imagen del borde izquierdo.
     * 2. Se obtiene el ancho y alto de la imagen del borde derecho.
     * 3. Se obtiene el ancho y alto de la imagen del borde superior.
     * 4. Se toma el alto del borde derecho como el alto del panel.
     * 5. Se suma el ancho de los bordes izquierdo, derecho y superior para obtener el ancho del panel.
     * 6. Se establece el tamaño, tamaño preferido, tamaño mínimo y tamaño máximo del panel.
     *
     * @see SpriteCache
     * @see Borders
     */
    private void initPanelSize() {

        setSize(WIDTH, HEIGHT);
        setPreferredSize(getSize());
        setMinimumSize(getSize());
        setMaximumSize(getSize());
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Se activa el antializado de la imagen para mejorar la calidad de la imagen.
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        // Se activa el renderizado de calidad para mejorar la calidad de la imagen.
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        // Se activa la interpolación bilineal para mejorar la calidad de la imagen.
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        // Se activa el antializado de texto para mejorar la calidad del texto.
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        if (gameRunning) {

            BufferedImage background = SpriteLoader.loadImage(level.getBackgroundName() + ".png");
            g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
            for (Sprite sprite : gameObjects) {

                sprite.draw(g2d);
            }
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public static void removeBrick(Brick brick) {

        if (brick != null) {

            gameObjects.remove(brick);
        }
    }

    public void removeBall(Ball ball) {

        if (ball != null) {

            if (balls.size() > 1) {
                balls.remove(ball);
                gameObjects.remove(ball);
            } else {
                ball.resetPosition();
                lives--;
                if (lives == 0) {
                    gameRunning = false;
                }
            }
        }
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

        CollisionManager.getInstance().checkCollisions();
        for (Sprite sprite : gameObjects) {

            if (sprite instanceof MovingSprite) {
                ((MovingSprite) sprite).move();
            }
        }
    }

    public Paddle getPaddle() {
        return paddle;
    }
}
