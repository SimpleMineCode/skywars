package io.smcode.skywars.events;

import io.smcode.skywars.game.Game;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlayerLeaveGameEvent extends GameEvent {
    public PlayerLeaveGameEvent(@NotNull Player player, Game game) {
        super(player, game);
    }
}
