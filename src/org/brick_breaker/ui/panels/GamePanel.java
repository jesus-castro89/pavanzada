package org.brick_breaker.ui.panels;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.*;
import org.brick_breaker.sprites.bonus.Bonus;
import org.brick_breaker.sprites.bonus.BonusType;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.sprites.paddles.Paddle;
import org.brick_breaker.sprites.paddles.PaddleType;
import org.brick_breaker.ui.events.KeyboardAction;
import org.brick_breaker.ui.windows.GameOverWindow;
import org.brick_breaker.ui.windows.MainWindow;
import org.brick_breaker.utils.FileManager;
import org.brick_breaker.utils.GameCycle;
import org.brick_breaker.utils.Randomized;
import org.brick_breaker.utils.colissions.CollisionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

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
    public static final int INITIAL_LIVES = 3;
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

    private GamePanel() {
        initPanelSize();
        level = FileManager.readLevel(Level.levelNumber);
    }

    public void restartGame() {
        levelNumber = INITIAL_LEVEL;
        lives = INITIAL_LIVES;
        score = INITIAL_SCORE;
        gameRunning = false;
        bricksDestroyed = false;
        gameObjects.clear();
        CollisionManager.getInstance().clearCollidableObjects();
        CollisionManager.getInstance().clearListeners();
        CollisionManager.getInstance().addListener(balls.getFirst());
        missiles.clear();
        level = FileManager.readLevel(levelNumber);
        paddle.resetPosition();
        balls.getFirst().resetPosition();
        registerObjects();
        playGame();
    }

    public void addMissile() {
        if (missiles.size() <= 5) {
            // Si no existe un misil en la posición de la barra, se crea uno nuevo.
            if (missiles.isEmpty()) {
                createMissile();
            } else {
                // Verificamos la posición del último misil
                Missile lastMissile = missiles.getLast();
                // Si el último misil esta al menos a 50px de la barra, se crea uno nuevo
                if (lastMissile.getPosition().y < paddle.getPosition().y - 150) {
                    createMissile();
                }
            }
        }
    }

    private void createMissile() {
        Missile m = new Missile(new Point(paddle.getPosition().x + paddle.getSize().width / 2 - Missile.MISSILE_WIDTH / 2,
                paddle.getPosition().y - Missile.MISSILE_HEIGHT));
        missiles.add(m);
        gameObjects.add(m);
        CollisionManager.getInstance().registerCollidable(m);
    }

    public void addLife() {
        lives++;
    }

    public void addScore(int score) {
        GamePanel.score += score;
    }

    public void duplicateBall() {
        ArrayList<Ball> addedBalls = new ArrayList<>();
        for (Ball ball : balls) {
            if (ball.getPosition().y < paddle.getPosition().y) {
                // Se ajusta la posición de la nueva pelota para que esté justo al lado de la original.
                Point newBallPosition = new Point(ball.getPosition().x + ball.getSize().width, ball.getPosition().y);
                // Se crea una nueva pelota con la posición ajustada.
                Ball newBall = new Ball(ball.getPosition());
                // Se ajusta la dirección de la nueva pelota para que se mueva en la dirección opuesta a la original.
                newBall.setDx(-ball.getDx());
                newBall.setDy(-ball.getDy());
                // Se agrega la nueva pelota a la lista de pelotas y a la lista de objetos del juego.
                addedBalls.add(newBall);
                gameObjects.add(newBall);
                CollisionManager.getInstance().registerCollidable(newBall);
            }
        }
        balls.addAll(addedBalls);
    }

    public void startGame() {
        paddle = new Paddle(PaddleType.MEDIUM);
        balls.add(new Ball());
        timer = new Timer(10, new GameCycle(this));
        playGame();
        registerObjects();
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
        BufferedImage background = SpriteLoader.loadImage(level.getBackgroundName() + ".png");
        g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
        for (Sprite sprite : gameObjects)
            sprite.draw(g2d);
        Toolkit.getDefaultToolkit().sync();
    }

    private static void createBonus(Brick brick) {
        if (brick != null && Randomized.getRandomBoolean(35)) {
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
                    MainWindow mainWindow = MainWindow.getInstance();
                    mainWindow.setVisible(false);
                    mainWindow.dispose();
                    GameOverWindow gameOverWindow = new GameOverWindow();
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

    private void updateLabels() {
        MainWindow mainWindow = MainWindow.getInstance();
        mainWindow.getScoreLabel().setText(String.valueOf(score));
        mainWindow.getLifeLabel().setText(String.valueOf(lives));
    }

    public void destroyAllBricks() {
        for (Sprite sprite : gameObjects) {
            if (sprite instanceof Brick brick) {
                brick.setDestroyed(true);
                CollisionManager.getInstance().unregisterCollidable(brick);
                gameObjects.remove(brick);
            }
        }
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

    public Paddle getPaddle() {
        return paddle;
    }

    public boolean isGameRunning() {

        return gameRunning;
    }

    public ArrayList<Ball> getBalls() {

        return balls;
    }

    public boolean isBricksDestroyed() {
        return bricksDestroyed;
    }

    public void setBricksDestroyed(boolean bricksDestroyed) {
        this.bricksDestroyed = bricksDestroyed;
    }

    public int getLevelNumber() {
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        this.levelNumber = levelNumber;
    }
}
