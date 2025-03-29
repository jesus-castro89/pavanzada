package org.brick_breaker.ui.panels;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.cache.SpriteLoader;
import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.Ball;
import org.brick_breaker.sprites.Borders;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.sprites.paddles.Paddle;
import org.brick_breaker.sprites.paddles.PaddleType;
import org.brick_breaker.utils.Collision;
import org.brick_breaker.utils.FileManager;
import org.brick_breaker.utils.GameCycle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel {

    public static final int INITIAL_LIVES = 3;
    public static final int INITIAL_SCORE = 0;
    public static final int INITIAL_LEVEL = 1;
    public static final int MAX_LEVEL = 5;
    private static final Borders LEFT_BORDER = Borders.LEFT_BAR;
    private static final Borders RIGHT_BORDER = Borders.RIGHT_BAR;
    private static final Borders TOP_BORDER = Borders.TOP_BAR;
    private static final Borders BOTTOM_BORDER = Borders.BOTTOM_BAR;
    private Level level;
    private final ArrayList<Ball> balls = new ArrayList<>();
    private final Paddle paddle;
    public static Timer timer;
    private boolean gameRunning = true;
    private boolean bricksDestroyed = false;
    private int lives = INITIAL_LIVES;
    private int score = INITIAL_SCORE;
    private int levelNumber = INITIAL_LEVEL;

    public GamePanel() {

        initPanelSize();
        this.level = FileManager.readLevel(Level.levelNumber);
        this.paddle = new Paddle(PaddleType.MEDIUM);
        this.balls.add(new Ball());
        timer = new Timer(10, new GameCycle(this));
        playGame();
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

        SpriteCache spriteCache = SpriteCache.getInstance();
        int width;
        int height;
        BufferedImage image = spriteCache.getImage(LEFT_BORDER.getImageName());
        width = image.getWidth();
        height = image.getHeight();
        image = spriteCache.getImage(RIGHT_BORDER.getImageName());
        width += image.getWidth();
        image = spriteCache.getImage(TOP_BORDER.getImageName());
        width += image.getWidth();
        this.setSize(width, height);
        this.setPreferredSize(this.getSize());
        this.setMinimumSize(this.getSize());
        this.setMaximumSize(this.getSize());
    }

    /**
     * Función que se ejecuta cada vez que se actualiza el panel.
     * Se encarga de mover la pelota y actualizar su posición.
     * Así como de actualizar el paddle, los bonus y misiles en el juego.
     */
    public void move() {

        for (Ball ball : this.balls)
            ball.move();
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

            BufferedImage background=SpriteLoader.loadImage(level.getBackgroundName()+".png");
            g2d.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), null);
            LEFT_BORDER.draw(g2d);
            RIGHT_BORDER.draw(g2d);
            TOP_BORDER.draw(g2d);
            BOTTOM_BORDER.draw(g2d);
            for (Brick[] row : level.getBricks())
                for (Brick brick : row)
                    if (!brick.isDestroyed())
                        brick.draw(g2d);
            for (Ball ball : balls)
                ball.draw(g2d);
            paddle.draw(g2d);
        }
        Toolkit.getDefaultToolkit().sync();
    }

    public void stopGame() {

        this.gameRunning = false;
        timer.stop();
    }

    public void playGame() {

        this.gameRunning = true;
        timer.start();
        this.requestFocus();
    }

    public void update() {

        if (bricksDestroyed) {

            levelNumber++;
            if (levelNumber > MAX_LEVEL) {
                stopGame();
            } else {
                level = FileManager.readLevel(levelNumber);
                bricksDestroyed = false;
            }
        } else {
            for (Ball ball : balls) {

                if (ball.getBounds().intersects(paddle.getBounds()))
                    Collision.bounceBall(ball, paddle);
                if (ball.getBounds().intersects(LEFT_BORDER.getBounds()))
                    Collision.bounceBall(ball, LEFT_BORDER);
                if (ball.getBounds().intersects(RIGHT_BORDER.getBounds()))
                    Collision.bounceBall(ball, RIGHT_BORDER);
                if (ball.getBounds().intersects(TOP_BORDER.getBounds()))
                    Collision.bounceBall(ball, TOP_BORDER);
                if (ball.getBounds().intersects(BOTTOM_BORDER.getBounds())) {

                    if (balls.size() == 1) {
                        ball.resetPosition();
                        lives--;
                        if (lives == 0)
                            stopGame();
                    } else {
                        balls.remove(ball);
                    }
                    break;
                }
                for (Brick[] row : level.getBricks())
                    for (Brick brick : row)
                        if (!brick.isDestroyed() &&
                                ball.getBounds().intersects(brick.getBounds())) {

                            brick.hit();
                            Collision.bounceBall(ball, brick);
                        }
            }
        }
    }
}
