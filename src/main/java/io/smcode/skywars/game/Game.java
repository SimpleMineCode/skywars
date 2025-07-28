package io.smcode.skywars.game;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Game implements ConfigurationSerializable {
    private final GameSettings settings;
    private final Set<GamePlayers> players = new HashSet<>();

    Game(GameSettings settings) {
        this.settings = settings;
    }

    public GameSettings getSettings() {
        return settings;
    }

    public Set<GamePlayers> getPlayers() {
        return players;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of(
                "Game-Settings", getSettings()
        );
    }
}
