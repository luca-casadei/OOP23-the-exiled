package unibo.exiled.model.move;

import java.util.Locale;

import unibo.exiled.utilities.ConstantsAndResourceLoader;
import unibo.exiled.utilities.ElementalType;

/**
 * An enum containing all the moves in the game.
 */
public enum MagicMove {
    /**
     * A normal basic move.
     */
    COLPACCIO("Colpaccio", "Hits the enemy without much enthusiasm.",
            ConstantsAndResourceLoader.LEVEL_BASE_MOVE, 5.0d, ElementalType.NORMAL),
    /**
     * A normal basic move.
     */
    COLPONE("Colpone", "Hits the enemy with a bit more enthusiasm.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_FIRST_MOVE, 8.0d, ElementalType.NORMAL),
    /**
     * A fire basic move.
     */
    FIREBALL("Fireball", "Throws a really sad fireball at the enemy.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_FIRST_MOVE, 5.0d, ElementalType.FIRE),
    /**
     * A grass basic move.
     */
    LEAFBLADE("Leaf Blade", "Summons a blunted blade made of leaves.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_FIRST_MOVE, 5.0d, ElementalType.GRASS),
    /**
     * A bolt basic move.
     */
    LIGHTBULB("Light bulb", "Lit oneself body to blind the enemy, not very effective.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_FIRST_MOVE, 5.0d, ElementalType.BOLT),
    /**
     * A water basic move.
     */
    WATERPISTOL("Water Pistol", "Spits water from the mouth, pretty disgusting but nothing more.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_FIRST_MOVE, 5.0d, ElementalType.WATER),
    /**
     * A flame move.
     */
    FLAMEWHIRL("Flaming Whirl", "Creates a roundel of flaming braces to throw",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_SECOND_MOVE, 10.0d, ElementalType.FIRE),
    /**
     * A swift slashing move.
     */
    QUICKSLASH("Quick Slash", "Swiftly slashes through the enemy with precision.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_SECOND_MOVE, 10.0d, ElementalType.NORMAL),
    /**
     * A storm of sharp petals.
     */
    PETALSTORM("Petal Storm", "Summons a storm of sharp petals to damage the enemy.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_SECOND_MOVE, 10.0d, ElementalType.GRASS),
    /**
     * A powerful lightning strike.
     */
    THUNDERSTRIKE("Thunder Strike", "Summons a powerful lightning strike to hit the enemy.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_SECOND_MOVE, 10.0d, ElementalType.BOLT),
    /**
     * A sphere of water attack.
     */
    AQUAORB("Water Orb", "Forms a sphere of water and hurls it at the enemy.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_SECOND_MOVE, 10.0d, ElementalType.WATER),
    /**
     * A raging inferno.
     */
    INFERNO("Inferno", "Unleashes a raging inferno to engulf the enemy.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_BOSS_MOVE, 100.0d, ElementalType.FIRE),
    /**
     * Generates a great storm with lots of thunders and shocks.
     */
    THUNDERSTORM("Thunder Storm", "Summons a storm right over the opponent.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_BOSS_MOVE, 100.0d, ElementalType.BOLT),
    /**
     * Covers the body in electricity and charges the opponent.
     */
    LOCOMOVOLT("Locomovolt", "Covers the body in electricity and charges the opponent.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_BOSS_MOVE, 50.0d, ElementalType.BOLT),
    /**
     * A simple low-voltage zap.
     */
    ZAP("Zap", "A simple low-voltage zap.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_FIRST_MOVE, 8.0d, ElementalType.BOLT),
    /**
     * Some grassy tentacles that leech life out of the opponent.
     */
    LEECHERS("Leechers", "Some grassy tentacles that leech life out of the opponent.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_BOSS_MOVE, 50.0d, ElementalType.GRASS),
    /**
     * A humongous water wave thrown at the opponent, breathing is almost
     * impossible!
     */
    TSUNAMI("Tsunami",
            "A humongous water wave thrown at the opponent, breathing is almost impossible!",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_BOSS_MOVE, 60.0d, ElementalType.WATER),
    /**
     * Tries to strangle the opponent with a grass latch.
     */
    LEAFLATCH("Leaf Latch", "Tries to strangle the opponent with a grass latch.",
            ConstantsAndResourceLoader.MIN_LEARNING_LEVEL_SECOND_MOVE, 10.0d, ElementalType.GRASS);

    private final String name;
    private final String description;
    private final int minimumLevelToLearn;
    private final double power;
    private final ElementalType type;

    /**
     * The constructor of the move names.
     *
     * @param name                The name of the move.
     * @param description         The description of the move.
     * @param minimumLevelToLearn the minimum level needed to learn the magic move.
     * @param power               The power of the move.
     * @param type                The ElementalType of the move.
     */
    MagicMove(final String name, final String description,
              final int minimumLevelToLearn, final double power, final ElementalType type) {
        this.name = name;
        this.description = description;
        this.minimumLevelToLearn = minimumLevelToLearn;
        this.power = power;
        this.type = type;
    }

    /**
     * Gets the literal name of the move.
     *
     * @return The name of the move.
     */
    public String getUppercaseStringName() {
        return this.name.toUpperCase(Locale.ROOT);
    }

    /**
     * Gets the description of the move.
     *
     * @return A string describing the move.
     */

    public String getDescription() {
        return this.description;
    }

    /**
     * Gets the type of the move.
     *
     * @return The ElementalType of the move.
     */
    public ElementalType getType() {
        return this.type;
    }

    /**
     * Gets the minimum level needed to be able to learn the move.
     *
     * @return An integer.
     */
    public int getMinimumLevelToLearn() {
        return this.minimumLevelToLearn;
    }

    /**
     * Gets the power of the move.
     *
     * @return A double representing the power value of the move.
     */
    public double getPower() {
        return this.power;
    }
}
