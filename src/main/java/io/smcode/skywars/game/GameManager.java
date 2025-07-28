package io.smcode.skywars.game;

import io.smcode.skywars.SkyWarsPlugin;

import java.util.UUID;

public class GameManager {
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
        plugin.getConfig().set("games." + UUID.randomUUID(), game);
        plugin.saveConfig();
    }
}
