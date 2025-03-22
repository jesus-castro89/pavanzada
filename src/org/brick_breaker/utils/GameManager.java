package org.brick_breaker.utils;

import org.brick_breaker.game.Level;
import org.brick_breaker.sprites.Ball;
import org.brick_breaker.sprites.paddles.Paddle;
import org.brick_breaker.sprites.paddles.PaddleType;

import java.util.ArrayList;

public class GameManager {

    public static final int INITIAL_LIVES = 3;
    public static final int INITIAL_SCORE = 0;
    public static final int INITIAL_LEVEL = 1;
    public static final int MAX_LEVEL = 5;
    private Level level;
    private boolean gameRunning = true;
    private boolean bricksDestroyed = false;
    private int lives = INITIAL_LIVES;
    private int score = INITIAL_SCORE;
    private int levelNumber = INITIAL_LEVEL;
    private final ArrayList<Ball> balls = new ArrayList<>();
    private final Paddle paddle;

    public GameManager() {

        this.level = FileManager.readLevel(levelNumber);
        this.paddle = new Paddle(PaddleType.MEDIUM);
        this.balls.add(new Ball());
    }

    private void loadNextLevel() {

        levelNumber++;
        if (levelNumber > MAX_LEVEL) {

            gameRunning = false;
        } else {
            level = FileManager.readLevel(levelNumber);
        }
    }

    public void update() {

        if (gameRunning) {

            if (bricksDestroyed) {

                loadNextLevel();
            }
            if (balls.isEmpty()) {

                lives--;
                if (lives > 0) {

                    balls.add(new Ball());
                    paddle.changeType(PaddleType.MEDIUM);
                    paddle.resetPosition();
                } else {
                    gameRunning = false;
                }
            }
            for (Ball ball : balls) {

                ball.move();
                if (ball.getBounds().intersects(paddle.getBounds())) {

                    Collision.bounceBall(ball, paddle);
                }
                for (int row = 0; row < level.getBricks().length; row++) {

                    for (int col = 0; col < level.getBricks()[row].length; col++) {

                        if (!level.getBricks()[row][col].isDestroyed()) {

                            if (ball.getBounds().intersects(level.getBricks()[row][col].getBounds())) {

                                Collision.bounceBall(ball, level.getBricks()[row][col]);
                                level.getBricks()[row][col].hit();
                            }
                        }
                    }
                }
            }
        }
    }
}
