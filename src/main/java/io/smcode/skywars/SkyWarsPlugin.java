package io.smcode.skywars;

import io.smcode.skywars.commands.SkyWarsCommand;
import io.smcode.skywars.game.Game;
import io.smcode.skywars.game.GameManager;
import io.smcode.skywars.game.GameSettings;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyWarsPlugin extends JavaPlugin {
    @Override
    public void onLoad() {
        ConfigurationSerialization.registerClass(GameSettings.class);
        ConfigurationSerialization.registerClass(Game.class);
    }

    @Override
    public void onEnable() {
        final GameManager manager = new GameManager(this);
        getCommand("skywars").setExecutor(new SkyWarsCommand(manager));
    }
}
