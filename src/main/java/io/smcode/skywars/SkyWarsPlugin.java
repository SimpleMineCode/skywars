package io.smcode.skywars;

import io.smcode.skywars.commands.SkyWarsCommand;
import io.smcode.skywars.config.Messages;
import io.smcode.skywars.game.Game;
import io.smcode.skywars.game.GameLocations;
import io.smcode.skywars.game.GameManager;
import io.smcode.skywars.game.GameSettings;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class SkyWarsPlugin extends JavaPlugin {
    private GameManager manager;

    @Override
    public void onLoad() {
        ConfigurationSerialization.registerClass(GameLocations.class);
        ConfigurationSerialization.registerClass(GameSettings.class);
        ConfigurationSerialization.registerClass(Game.class);

        saveResource("messages.yml", false);
    }

    @Override
    public void onEnable() {
        final Messages messages = new Messages(new File(getDataFolder(), "messages.yml"));
        this.manager = new GameManager(this);
        manager.loadGames();

        getCommand("skywars").setExecutor(new SkyWarsCommand(manager, messages));
    }

    @Override
    public void onDisable() {
        if (manager != null) {
            manager.saveGames();
        }
    }
}
