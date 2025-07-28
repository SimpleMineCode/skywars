package io.smcode.skywars.game;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Game implements ConfigurationSerializable {
    private UUID id;
    private final String name;
    private final GameSettings settings;
    private final Set<GamePlayers> players = new HashSet<>();
    private GameLocations locations = new GameLocations();

    Game(String name, GameSettings settings) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.settings = settings;
    }

    public String getName() {
        return name;
    }

    public void setLocations(GameLocations locations) {
        this.locations = locations;
    }

    public GameLocations getLocations() {
        return this.locations;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public GameSettings getSettings() {
        return settings;
    }

    public Set<GamePlayers> getPlayers() {
        return players;
    }

    public static Game deserialize(Map<String, Object> data) {
        final Game game =  new Game(
                (String) data.get("Name"),
                (GameSettings) data.get("Game-Settings")
        );

        game.setId(UUID.fromString((String) data.get("Id")));
        game.setLocations((GameLocations) data.get("Locations"));

        return game;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of(
                "Id", getId().toString(),
                "Name", getName(),
                "Game-Settings", getSettings(),
                "Locations", getLocations()
        );
    }
}
