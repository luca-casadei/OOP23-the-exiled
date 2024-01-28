package unibo.exiled.model;

import unibo.exiled.model.character.enemy.Enemy;
import unibo.exiled.model.character.player.Player;
import unibo.exiled.model.map.GameMap;
import unibo.exiled.model.utilities.Position;

import java.util.Map;
import java.util.Set;

public interface GameModel {
    Player getPlayer();
    GameMap getMap();
    Map<Position,Enemy> getEnemies();
    Set<Enemy> getExistentEnemies();
    void killEnemy(final Position position, final Enemy enemy);
}
