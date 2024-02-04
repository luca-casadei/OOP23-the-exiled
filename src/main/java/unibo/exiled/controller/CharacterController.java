package unibo.exiled.controller;

import java.util.List;

import unibo.exiled.model.utilities.Direction;
import unibo.exiled.model.utilities.ElementalType;
import unibo.exiled.model.utilities.Position;

/**
 * Controller for managing the characters.
 */
public interface CharacterController {
    /**
     * Gets the image paths for a character.
     *
     * @param folderPath The folder path where the character images are stored.
     * @param name       The name of the character.
     * @return A list containing the paths of the images for the character.
     */
    List<String> getImagePathOfCharacter(String folderPath, String name);

    /**
     * Moves the player in the specified direction.
     *
     * @param direction The direction in which the player should move.
     */
    void movePlayer(Direction direction);

    /**
     * Gets the health of the player.
     *
     * @return A double representing the health of the player.
     */
    double getPlayerHealth();

    /**
     * Gets the level of the player.
     *
     * @return A integer representing the level of the player.
     */
    int getPlayerLevel();

    /**
     * Gets the class name of the player.
     *
     * @return A string representing the class name of the player.
     */
    String getPlayerClassName();

    /**
     * Gets the position of the player.
     *
     * @return The position of the player.
     */
    Position getPlayerPosition();

    /**
     * Gets the names of every magic move.
     *
     * @return A list of every magic move name.
     */
    List<String> getMagicMoveNames();

    /**
     * Gets the move set of the player.
     * 
     * @return A list of the player moves.
     */
    List<String> getPlayerMoveSet();

    /**
     * Moves the enemies in the game.
     */
    void moveEnemies();

    /**
     * Performs an attack routine.
     *
     * @param isPlayerAttacking True if the attacker is the player, false otherwise.
     */
    void attack(boolean isPlayerAttacking);

    /**
     * Sets the elemental class of the player.
     *
     * @param playerClass The ElementalType representing the new elemental class of the player.
     */
    void setPlayerClass(ElementalType playerClass);
}