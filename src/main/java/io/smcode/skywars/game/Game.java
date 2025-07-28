package io.smcode.skywars.game;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Game implements ConfigurationSerializable {
    private final UUID id;
    private final GameSettings settings;
    private final Set<GamePlayers> players = new HashSet<>();
    private GameLocations locations;

    Game(UUID id, GameSettings settings) {
        this.id = id;
        this.settings = settings;
        this.locations = new GameLocations();
        System.out.println(1);
        System.out.println(getLocations());
    }

    public void setLocations(GameLocations locations) {
        this.locations = locations;
    }

    public GameLocations getLocations() {
        return this.locations;
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
        System.out.println("calling deserialize");
        final Game game =  new Game(
                UUID.fromString((String) data.get("id")),
                (GameSettings) data.get("Game-Settings")
        );

        game.setLocations((GameLocations) data.get("Locations"));

        return game;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        System.out.println(getLocations());
        return Map.of(
                "id", getId().toString(),
                "Game-Settings", getSettings(),
                "Locations", getLocations()
        );
    }
}
