package io.smcode.skywars.commands;

import io.smcode.skywars.config.Message;
import io.smcode.skywars.config.Messages;
import io.smcode.skywars.game.GameManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SkyWarsCommand implements TabExecutor {
    private final GameManager manager;
    private final Messages messages;

    public SkyWarsCommand(GameManager manager, Messages messages) {
        this.manager = manager;
        this.messages = messages;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (!(sender instanceof final Player player)) {
            sender.sendMessage(messages.getMessage(Message.COMMAND_ONLY_FOR_PLAYERS));
            return true;
        }

        manager.createNewGame();
        player.sendMessage(Component.text("New game successfully created", NamedTextColor.GREEN));

        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        return List.of();
    }
}
