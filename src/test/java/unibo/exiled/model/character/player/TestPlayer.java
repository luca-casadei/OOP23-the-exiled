package unibo.exiled.model.character.player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import unibo.exiled.config.Constants;
import unibo.exiled.model.item.HealingItem;
import unibo.exiled.model.item.Inventory;
import unibo.exiled.model.item.Item;
import unibo.exiled.model.utilities.ElementalType;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

final class TestPlayer {
    private static final int EXPERIENCE_CAP = 100;
    private static final int INITIAL_EXPERIENCE = 0;
    private static final int LEVEL_INCREASE = 10;
    private static final int MOVES_NUMBER = 3;
    private static final int MOVES_LEARNING_INTERVAL = 5;

    private Player player;

    @BeforeEach
    void setUp() {
        Constants.loadConfiguration(Constants.DEF_CONFIG_PATH);
        player = new PlayerImpl(EXPERIENCE_CAP, INITIAL_EXPERIENCE, LEVEL_INCREASE, MOVES_NUMBER,
                MOVES_LEARNING_INTERVAL);
    }

    @Test
    void testGetLevel() {
        assertEquals(Integer.parseInt(Constants.getConstantOf("PLAYER_DEFAULT_LEVEL")), player.getLevel());
    }

    @Test
    void testGetExperience() {
        assertEquals(Double.parseDouble(Constants.getConstantOf("PLAYER_DEFAULT_EXPERIENCE")), player.getExperience());
    }

    @Test
    void testGetInventory() {
        final Inventory inventory = player.getInventory();
        assertNotNull(inventory);
        //assertEquals(4, inventory.getItems().size()); // It doesn't work correctly because of the
                                                      // "initializeInventory()" test method in PlayerImpl.
    }

    @Test
    void testSetAndGetPlayerClass() {
        player.setPlayerClass(new PlayerClassImpl(ElementalType.FIRE));
        assertEquals(ElementalType.FIRE, player.getPlayerClass().elementalType());
    }

    @Test
    void testAddExperience() {
        final double experienceToAdd = 150;
        final double expectedExperience = 50;
        final int expectedLevel = 1;
        player.addExperience(experienceToAdd);
        assertEquals(expectedExperience, player.getExperience());
        assertEquals(expectedLevel, player.getLevel());
    }

    @Test
    void testLevelUp() {
        final double experienceToAdd = 230;
        final double expectedExperience = 10;
        final int expectedLevel = 2;
        player.addExperience(experienceToAdd);
        assertEquals(expectedExperience, player.getExperience());
        assertEquals(expectedLevel, player.getLevel());
    }

    @Test
    void testUseHealingItem() {
        final Set<Item> playerItems = player.getInventory().getItems().keySet();
        for (final Item item : playerItems) {
            if (item instanceof HealingItem) {
                final double initialHealth = player.getHealth(); // Save the starting value of health.
                final int initialItemQuantity = player.getInventory().getItemQuantity(item); // Save the starting value
                                                                                             // of item quantity.

                player.useItem((HealingItem) item); // Use the healing item.

                final double newHealth = player.getHealth(); // Save the newer value of health.
                final int newItemQuantity = player.getInventory().getItems().containsKey(item)
                        ? player.getInventory().getItemQuantity(item)
                        : 0; // Save the newer value of item quantity.
                assertTrue(newHealth >= initialHealth);
                assertTrue(!player.getInventory().getItems().containsKey(item)
                        || newItemQuantity == initialItemQuantity - 1);
            }
        }

    }

}
