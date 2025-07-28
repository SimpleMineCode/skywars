package io.smcode.skywars.game;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class GameLocations implements ConfigurationSerializable {
    private Location lobby;
    private Map<GameTeam, Location> spawns = new HashMap<>();

    public void setLobby(Location lobby) {
        this.lobby = lobby;
    }

    public Location getLobby() {
        return lobby;
    }

    public void setSpawn(GameTeam team, Location location) {
        this.spawns.put(team, location);
    }

    public Map<GameTeam, Location> getSpawns() {
        return spawns;
    }

    public static GameLocations deserialize(Map<String, Object> data) {
        final GameLocations locations = new GameLocations();
        locations.setLobby((Location) data.get("Lobby"));
        final Map<GameTeam, Location> spawns = (Map<GameTeam, Location>) data.get("Spawns");

        for (GameTeam team : spawns.keySet()) {
            locations.setSpawn(team, spawns.get(team));
        }

        return locations;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        return Map.of(
                "Lobby", getLobby(),
                "Spawns", getSpawns()
        );
    }
}
