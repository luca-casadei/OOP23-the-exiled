package unibo.exiled.view;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import unibo.exiled.controller.GameController;
import unibo.exiled.model.utilities.Direction;

/**
 * A KeyListener implementation that handles player movement in the game.
 */
public final class MovementKeyListener implements KeyListener {
    private final GameController gameController;
    private final GameView gameView;

    /**
     * Constructs a MovementKeyListener with the specified game controller and game
     * view.
     *
     * @param gameController The game controller responsible for managing game
     *                       logic.
     * @param gameView       The game view responsible for rendering the game.
     */
    public MovementKeyListener(final GameController gameController, final GameView gameView) {
        this.gameController = gameController;
        this.gameView = gameView;
    }

    /**
     * Determines the direction corresponding to the pressed key.
     *
     * @param e The KeyEvent corresponding to the pressed key.
     * @return The Direction corresponding to the pressed key.
     * @throws IllegalStateException If an illegal key is pressed.
     */
    private static Direction getDirection(final KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> {
                return Direction.NORTH;
            }
            case KeyEvent.VK_A -> {
                return Direction.WEST;
            }
            case KeyEvent.VK_S -> {
                return Direction.SOUTH;
            }
            case KeyEvent.VK_D -> {
                return Direction.EAST;
            }
            default -> throw new IllegalStateException("Illegal pressed key.");
        }
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if (gameView.isInGame()) {
            if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                gameView.showMenu();
            } else if (isValidMovementKey(e) && !gameView.isInCombat()) {
                final Direction directionPressed = getDirection(e);
                movePlayerAndEnemies(directionPressed);
                updatePlayerView(directionPressed);
                gameView.draw();
            }
        }
    }

    /**
     * Checks if the pressed key is a valid movement key.
     *
     * @param e The KeyEvent corresponding to the pressed key.
     * @return True if the pressed key is a valid movement key, false otherwise.
     */
    private boolean isValidMovementKey(final KeyEvent e) {
        final int keyCode = e.getKeyCode();
        return keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_S
                || keyCode == KeyEvent.VK_D;
    }

    /**
     * Moves the player and enemies in the specified direction.
     *
     * @param direction The direction in which to move the player and enemies.
     */
    private void movePlayerAndEnemies(final Direction direction) {
        gameController.getCharacterController().movePlayer(direction);
        gameController.getCharacterController().moveEnemies();
    }

    /**
     * Updates the player view based on the movement direction.
     *
     * @param direction The direction in which the player is moving.
     */
    private void updatePlayerView(final Direction direction) {
        if (gameController.getMapController()
                .isEnemyInCell(gameController.getCharacterController().getPlayerPosition())) {
            gameView.initializeCombat();
        } else {
            gameView.getPlayerView().changeImage(direction,
                    gameController.getCharacterController().getIfCharacterInPositionIsMoving(
                            gameController.getCharacterController().getPlayerPosition()));
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
    }
}
