package io.smcode.skywars.commands.arguments;

import io.smcode.skywars.commands.ArgumentExecutor;
import io.smcode.skywars.config.Message;
import io.smcode.skywars.config.Messages;
import io.smcode.skywars.game.Game;
import io.smcode.skywars.game.GameManager;
import io.smcode.skywars.game.GameTeam;
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import org.bukkit.entity.Player;

import java.util.Optional;

public class SetTeamLocationArgument implements ArgumentExecutor {
    private final GameManager manager;
    private final Messages messages;

    public SetTeamLocationArgument(GameManager manager, Messages message) {
        this.manager = manager;
        this.messages = message;
    }

    @Override
    public void execute(Player player, String[] args) {
        // /skywars spawn <team>
        if (args.length < 3) {
            player.sendRichMessage("<red>Usage: /skywars spawn <team> <game>");
            return;
        }

        final Optional<Game> optionalGame = manager.getGame(args[2]);

        if (optionalGame.isEmpty()) {
            player.sendMessage(messages.getMessage(Message.ENTITY_NOT_FOUND,
                    Placeholder.unparsed("name", args[2]), Placeholder.unparsed("entity", "Game")));
            return;
        }

        final Game game = optionalGame.get();
        final String teamArgument = args[1];

        try {
            final GameTeam team = GameTeam.valueOf(teamArgument.toUpperCase());
            game.getLocations().setSpawn(team, player.getLocation());
            player.sendMessage(messages.getMessage(Message.ENTITY_UPDATED,
                    Placeholder.unparsed("entity", "Team spawn")));
        } catch (IllegalArgumentException e) {
            player.sendMessage(messages.getMessage(Message.ENTITY_NOT_FOUND,
                    Placeholder.unparsed("name", teamArgument),
                    Placeholder.unparsed("entity", "Team")));
        }
    }

    @Override
    public String getUsage() {
        return "spawn <team>";
    }

    @Override
    public String getDescription() {
        return "Set spawn location for a team.";
    }
}
