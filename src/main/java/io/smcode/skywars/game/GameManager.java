package io.smcode.skywars.game;

import io.smcode.skywars.SkyWarsPlugin;
import org.bukkit.configuration.ConfigurationSection;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class GameManager {
    private final Set<Game> games = new HashSet<>();
    private final SkyWarsPlugin plugin;

    public GameManager(SkyWarsPlugin plugin) {
        this.plugin = plugin;
    }

    public Game createNewGame(GameSettings settings) {
        final Game game =  new Game(settings);
        saveGameToConfig(game);
        return game;
    }

    public Game createNewGame() {
        final Game game =  new Game(GameSettings.DEFAULT_SETTINGS);
        saveGameToConfig(game);
        return game;
    }

    private void saveGameToConfig(Game game) {
        plugin.getConfig().set("games." + UUID.randomUUID(), game);
        plugin.saveConfig();
    }

    public void loadGames() {
        final ConfigurationSection gameSection = plugin.getConfig().getConfigurationSection("games");

        if (gameSection == null)
            return;

        for (String gameId : gameSection.getKeys(false)) {
            final Game game = (Game) plugin.getConfig().get("games." + gameId);
            this.games.add(game);
        }

        plugin.getLogger().info("Loaded %d games.".formatted(games.size()));
    }
}
