package unibo.exiled.model.move.factory;

import unibo.exiled.model.move.MoveSet;

/**
 * The MoveSetFactory interface defines methods to create default MoveSets
 * for different types of moves such as Normal, Fire, Grass, Bolt, and Water.
 */
public interface MoveSetFactory {

    /**
     * Creates a default MoveSet for Normal moves.
     *
     * @return A MoveSet for Normal moves.
     */
    MoveSet defaultNormalMoveSet();

    /**
     * Creates a default MoveSet for Fire moves.
     *
     * @return A MoveSet for Fire moves.
     */
    MoveSet defaultFireMoveSet();

    /**
     * Creates a default MoveSet for Grass moves.
     *
     * @return A MoveSet for Grass moves.
     */
    MoveSet defaultGrassMoveSet();

    /**
     * Creates a default MoveSet for Bolt moves.
     *
     * @return A MoveSet for Bolt moves.
     */
    MoveSet defaultBoltMoveSet();

    /**
     * Creates a default MoveSet for Water moves.
     *
     * @return A MoveSet for Water moves.
     */
    MoveSet defaultWaterMoveSet();

    /**
     * Creates the moveSet of the Whirler.
     *
     * @return A MoveSet for the Whirler.
     */
    MoveSet whirlerMoveset();

    /**
     * Creates the moveSet of the Bolt Boss.
     *
     * @return A MoveSet for the Bolt Boss.
     */
    MoveSet boltBossMoves();
}