package io.smcode.skywars.commands.arguments;

import io.smcode.skywars.commands.ArgumentExecutor;
import io.smcode.skywars.config.Message;
import io.smcode.skywars.config.Messages;
import io.smcode.skywars.game.Game;
import io.smcode.skywars.game.GameManager;
import lombok.RequiredArgsConstructor;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.entity.Player;

import java.util.Optional;

@RequiredArgsConstructor
public class JoinGameArgument implements ArgumentExecutor {
    private final GameManager manager;
    private final Messages messages;

    @Override
    public void execute(Player player, String[] args) {
        // /skywars join <game>
        if (args.length < 2) {
            player.sendMessage(messages.getPrefix().append(Component.text("Usage: /skywars join <game>", NamedTextColor.RED)));
            return;
        }

        final Optional<Game> optionalGame = this.manager.getGame(args[1]);

        if (optionalGame.isEmpty()) {
            player.sendMessage(messages.getMessage(Message.ENTITY_NOT_FOUND,
                    Placeholder.unparsed("name", args[1]), Placeholder.unparsed("entity", "Game")));
            return;
        }

        final Game game = optionalGame.get();
        this.manager.joinGame(game, player);
    }

    @Override
    public String getUsage() {
        return "join <game>";
    }

    @Override
    public String getDescription() {
        return "Join a game of SkyWars";
    }
}
