package io.smcode.skywars.game;

import io.smcode.skywars.SkyWarsPlugin;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class GameManager {
    private final Set<Game> games = new HashSet<>();
    private final SkyWarsPlugin plugin;

    public GameManager(SkyWarsPlugin plugin) {
        this.plugin = plugin;
    }

    public Game createNewGame(GameSettings settings) {
        final Game game = new Game(settings);
        saveGameToConfig(game);
        return game;
    }

    public Game createNewGame() {
        final Game game = new Game(GameSettings.DEFAULT_SETTINGS);
        saveGameToConfig(game);
        return game;
    }
    private void saveGameToConfig(Game game) {
        plugin.getConfig().set("games." + game.getId(), game);
        plugin.saveConfig();
    }
}
