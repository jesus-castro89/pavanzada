package org.brick_breaker.ui.panels;

import org.brick_breaker.cache.SpriteCache;
import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.Ball;
import org.brick_breaker.sprites.Borders;
import org.brick_breaker.sprites.bricks.Brick;
import org.brick_breaker.sprites.paddles.Paddle;
import org.brick_breaker.sprites.paddles.PaddleType;
import org.brick_breaker.utils.Collision;
import org.brick_breaker.utils.EdgeType;
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
    private static final Borders BOTOOM_BORDER = Borders.BOTTOM_BAR;
    private Level level;
    private final ArrayList<Ball> balls = new ArrayList<>();
    private Paddle paddle;
    public static Timer timer;
    private boolean gameRunning = true;
    private boolean bricksDestroyed = false;
    private int lives = INITIAL_LIVES;
    private int score = INITIAL_SCORE;
    private int levelNumber = INITIAL_LEVEL;

    public GamePanel() {

        this.level = FileManager.readLevel(Level.levelNumber);
        this.paddle = new Paddle(PaddleType.MEDIUM);
        this.balls.add(new Ball());
        this.balls.getFirst().setStop(false);
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
        timer = new Timer(10, new GameCycle(this));
        playGame();
    }

    public void move() {

        for (Ball ball : this.balls) {

            ball.move();
        }
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        if (gameRunning) {
            LEFT_BORDER.draw(g2d);
            RIGHT_BORDER.draw(g2d);
            TOP_BORDER.draw(g2d);
            BOTOOM_BORDER.draw(g2d);
            for (Brick[] row : level.getBricks()) {

                for (Brick brick : row) {

                    if (!brick.isDestroyed())
                        brick.draw(g2d);
                }
            }
            for (Ball ball : balls) {

                ball.draw(g2d, this);
            }
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

        Brick[][] bricks = this.level.getBricks();
        for (Ball ball : balls) {

            if (ball.getBounds().intersects(paddle.getBounds())) {

                Collision.bounceBall(ball, paddle);
            }
            if (ball.getBounds().intersects(LEFT_BORDER.getBounds())) {

                borderCollision(ball, LEFT_BORDER);
            }
            if (ball.getBounds().intersects(RIGHT_BORDER.getBounds())) {

                borderCollision(ball, RIGHT_BORDER);
            }
            if (ball.getBounds().intersects(TOP_BORDER.getBounds())) {

                borderCollision(ball, TOP_BORDER);
            }
            if (ball.getBounds().intersects(BOTOOM_BORDER.getBounds())) {

                ball.setStop(true);
                ball.setDx(0);
                ball.setDy(0);
                ball.resetPosition();
                lives--;
                if (lives == 0) {

                    stopGame();
                }
                break;
            }
            for (int row = 0; row < level.getBricks().length; row++) {

                for (int col = 0; col < level.getBricks()[row].length; col++) {

                    if (!level.getBricks()[row][col].isDestroyed() &&
                            ball.getBounds().intersects(level.getBricks()[row][col].getBounds())) {

                        level.getBricks()[row][col].hit();
                        Collision.bounceBall(ball, level.getBricks()[row][col]);
                    }
                }
            }
        }
    }

    private void borderCollision(Ball ball, Borders border) {

        Collision.bounceBall(ball, border);
    }
}
