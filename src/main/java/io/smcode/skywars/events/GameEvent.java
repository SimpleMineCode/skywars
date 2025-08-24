package io.smcode.skywars.events;

import io.smcode.skywars.game.Game;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;
import org.jetbrains.annotations.NotNull;


public abstract class GameEvent extends PlayerEvent {
    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Getter
    private final Game game;

    public GameEvent(@NotNull Player player, Game game) {
        super(player);
        this.game = game;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLER_LIST;
    }
}
