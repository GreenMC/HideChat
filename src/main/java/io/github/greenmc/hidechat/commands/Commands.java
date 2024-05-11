package io.github.greenmc.hidechat.commands;

import io.github.bilektugrul.butils.Utils;
import io.github.greenmc.hidechat.HideChat;
import me.despical.commandframework.Command;
import me.despical.commandframework.CommandArguments;
import org.bukkit.command.CommandSender;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public class Commands {

	private final HideChat plugin;

	public Commands(HideChat plugin) {
		this.plugin = plugin;
		this.plugin.getCommandFramework().registerCommands(this);
	}

	@Command(
		name = "hidechat",
		permission = "hidechat",
		usage = "/hidechat <player> <true/false>",
		desc = "Toggles player's chat.",
		max = 1
	)
	public void mainCommand(CommandArguments arguments) {
		if (arguments.isArgumentsEmpty() || arguments.getArgument(0).equalsIgnoreCase("help")) {
			Utils.sendMessage("help-message", arguments.getSender());
			return;
		}

		this.toggleMuteState(arguments);
	}

	@Command(
		name = "hidechat.reload",
		permission = "hidechat.reload",
		usage = "/hidechat reload",
		desc = "Reloads the config."
	)
	public void hideChat(CommandArguments arguments) {
		this.plugin.reloadConfig();
		Utils.sendMessage("reloaded", arguments.getSender());
	}

	private void toggleMuteState(CommandArguments arguments) {
		arguments.getPlayer(0).ifPresentOrElse(player -> {
			final var user = plugin.getUserManager().getUser(arguments.getSender());
			final var newMuted = !user.isMuted();
			user.setMuted(newMuted);
			Utils.sendMessage("toggled." + newMuted, arguments.getSender());
			Utils.sendMessage("toggled.to-player" + newMuted, player);

		}, () -> Utils.sendMessage("not-found", arguments.getSender()));
	}

}