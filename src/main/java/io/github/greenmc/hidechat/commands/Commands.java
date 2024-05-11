package io.github.greenmc.hidechat.commands;

import io.github.greenmc.hidechat.HideChat;
import me.despical.commandframework.Command;
import me.despical.commandframework.CommandArguments;

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

	// TODO - refactor commands.
	@Command(
		name = "hidechat",
		permission = "hidechat",
		usage = "/hidechat <player> <true/false>",
		desc = "Toggles player's chat.",
		min = 2
	)
	public void mainCommand(CommandArguments arguments) {
		if (arguments.isArgumentsEmpty()) {
			arguments.sendMessage(""); // TODO - send help message.
			return;
		}

		this.setMuteState(arguments, arguments.getArgumentAsBoolean(2));
	}

	@Command(
		name = "hidechat.hide",
		permission = "hidechat.hide",
		usage = "/hidechat <player>",
		desc = "Hides player's chat."
	)
	public void hideChat(CommandArguments arguments) {
		this.setMuteState(arguments, true);
	}

	@Command(
		name = "hidechat.show",
		permission = "hidechat.show",
		usage = "/hidechat show <player>",
		desc = "Shows player's chat."
	)
	public void showChat(CommandArguments arguments) {
		this.setMuteState(arguments, false);
	}

	private void setMuteState(CommandArguments arguments, boolean muted) {
		arguments.getPlayer(0).ifPresentOrElse(player -> {
			final var user = plugin.getUserManager().getUser(arguments.getSender());
			user.setMuted(muted);
		}, () -> arguments.sendMessage("No player found with that name.")); // TODO - messages.
	}

}