package unibo.exiled.model.player;

import unibo.exiled.config.Constants;
import unibo.exiled.model.GameModelImpl;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unibo.exiled.model.character.attributes.AttributeIdentifier;
import unibo.exiled.model.character.player.Player;

import java.util.NoSuchElementException;

public class TestPlayer {
    private double defaultHealth;
    private double defaultAttack;
    private double defaultDefense;
    private double defaultExperience;

    private final Player player = new GameModelImpl().getPlayer();

    @BeforeEach
    public void testInitialize(){
        Constants.loadConfiguration(Constants.DEF_CONFIG_PATH);
        defaultHealth = Double.parseDouble(Constants.getConstantOf("PLAYER_DEFAULT_HEALTH"));
        defaultAttack = Double.parseDouble(Constants.getConstantOf("PLAYER_DEFAULT_ATTACK"));
        defaultDefense = Double.parseDouble(Constants.getConstantOf("PLAYER_DEFAULT_DEFENSE"));
        defaultExperience = Double.parseDouble(Constants.getConstantOf("PLAYER_DEFAULT_EXPERIENCE"));
    }

    @Test
    public void testDefaultField(){
        assertEquals(player.getAttributes().get(AttributeIdentifier.HEALTH).getValue().get(), defaultHealth);
        assertEquals(player.getAttributes().get(AttributeIdentifier.ATTACK).getModifier().get(), defaultAttack);
        assertEquals(player.getAttributes().get(AttributeIdentifier.DEFENSE).getModifier().get(), defaultDefense);
        assertThrows(NoSuchElementException.class, ()->{
            player.getAttributes().get(AttributeIdentifier.ATTACK).getValue().get();
        });
        assertEquals(player.getExperience(), defaultExperience);
    }
}