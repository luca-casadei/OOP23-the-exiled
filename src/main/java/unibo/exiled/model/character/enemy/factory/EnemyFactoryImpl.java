package unibo.exiled.model.character.enemy.factory;

import unibo.exiled.model.character.attributes.Attribute;
import unibo.exiled.model.character.attributes.AttributeFactory;
import unibo.exiled.model.character.attributes.AttributeFactoryImpl;
import unibo.exiled.model.character.attributes.AttributeIdentifier;
import unibo.exiled.model.character.enemy.Enemy;
import unibo.exiled.model.character.enemy.GenericEnemyImpl;
import unibo.exiled.model.character.enemy.boss.GrassBossEnemy;
import unibo.exiled.model.character.enemy.boss.BoltBossEnemy;
import unibo.exiled.model.character.enemy.boss.FireBossEnemy;
import unibo.exiled.model.character.enemy.boss.WaterBossEnemy;
import unibo.exiled.model.move.MoveSet;
import unibo.exiled.model.move.factory.MoveSetFactory;
import unibo.exiled.model.move.factory.MoveSetFactoryImpl;
import unibo.exiled.utilities.ElementalType;

import java.util.Map;
import java.util.Random;

/**
 * The implementation of the enemy factory.
 */
public final class EnemyFactoryImpl implements EnemyFactory {
    private static final Random RANDOM = new Random();
    private static final int DROPPED_EXPERIENCE_BASE = 10;
    private final MoveSetFactory moveSetFactory;
    private final AttributeFactory attributeFactory;

    /**
     * The constructor of the enemy factory.
     */
    public EnemyFactoryImpl() {
        this.moveSetFactory = new MoveSetFactoryImpl();
        this.attributeFactory = new AttributeFactoryImpl();
    }

    private Enemy createFromValues(final String name,
                                   final MoveSet moveSet,
                                   final Map<AttributeIdentifier, Attribute> attributes,
                                   final ElementalType type,
                                   final int droppedExperience) {
        return new GenericEnemyImpl(name, moveSet, attributes, type, droppedExperience);
    }

    @Override
    public Enemy createGoblin() {
        return createFromValues(SelectableEnemies.GOBLIN.name,
                moveSetFactory.defaultGrassMoveSet(),
                attributeFactory.createGoblinAttributes(),
                ElementalType.GRASS,
                SelectableEnemies.GOBLIN.droppedExperience);
    }

    @Override
    public Enemy createBrutus() {
        return this.createFromValues(
                SelectableEnemies.BRUTUS.name,
                moveSetFactory.defaultFireMoveSet(),
                attributeFactory.createBrutusAttributes(),
                ElementalType.FIRE,
                SelectableEnemies.BRUTUS.droppedExperience
        );
    }

    @Override
    public Enemy createWaterBoss() {
        return new WaterBossEnemy("Umidamiano");
    }

    @Override
    public Enemy createFireBoss() {
        return new FireBossEnemy("Piercalore");
    }

    @Override
    public Enemy createBoltBoss() {
        return new BoltBossEnemy("Carlaccesa");
    }

    @Override
    public Enemy createGrassBoss() {
        return new GrassBossEnemy("Lucionerba");
    }

    @Override
    public Enemy createRandom() {
        final int rand = RANDOM.nextInt(SelectableEnemies.values().length);
        final SelectableEnemies selected = SelectableEnemies.values()[rand];
        switch (selected) {
            case BRUTUS -> {
                return this.createBrutus();
            }
            case GOBLIN -> {
                return this.createGoblin();
            }
            case WHIRLER -> {
                return this.createWhirler();
            }
            case WAVE_BREAKER -> {
                return this.createWaveBreaker();
            }
            case AQUA_SHADE -> {
                return this.createAquaShade();
            }
            default -> throw new IllegalStateException("Enemy generation failed.");
        }
    }

    @Override
    public Enemy createWhirler() {
        return createFromValues(SelectableEnemies.WHIRLER.name,
                moveSetFactory.whirlerMoveset(),
                attributeFactory.createWhirlerAttributes(),
                ElementalType.FIRE, SelectableEnemies.WHIRLER.droppedExperience);
    }

    @Override
    public Enemy createWaveBreaker() {
        return createFromValues(SelectableEnemies.WAVE_BREAKER.name,
                moveSetFactory.defaultWaterMoveSet(),
                attributeFactory.createWaveBreakerAttributes(),
                ElementalType.WATER, SelectableEnemies.WAVE_BREAKER.droppedExperience);
    }

    @Override
    public Enemy createAquaShade() {
        return createFromValues(SelectableEnemies.AQUA_SHADE.name,
                moveSetFactory.defaultWaterMoveSet(), attributeFactory.createAquaShadeAttributes(),
                ElementalType.WATER, SelectableEnemies.AQUA_SHADE.droppedExperience);
    }

    private enum SelectableEnemies {
        GOBLIN("Goblin", DROPPED_EXPERIENCE_BASE),
        BRUTUS("Brutus", DROPPED_EXPERIENCE_BASE * 2),
        WHIRLER("Whirler", DROPPED_EXPERIENCE_BASE * 2),
        AQUA_SHADE("Aquashade", DROPPED_EXPERIENCE_BASE * 2),
        WAVE_BREAKER("Wavebreaker", DROPPED_EXPERIENCE_BASE);

        private final int droppedExperience;
        private final String name;

        SelectableEnemies(final String name, final int droppedExperience) {
            this.droppedExperience = droppedExperience;
            this.name = name;
        }
    }
}
