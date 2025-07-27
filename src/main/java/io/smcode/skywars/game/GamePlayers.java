package io.smcode.skywars.game;

import org.bukkit.entity.Player;

public class GamePlayers {
    private final Player player;

    public GamePlayers(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
