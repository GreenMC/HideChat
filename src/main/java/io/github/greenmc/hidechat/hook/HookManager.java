package io.github.greenmc.hidechat.hook;

import io.github.greenmc.hidechat.HideChat;
import org.bukkit.entity.Player;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public class HookManager {

	private final HideChat plugin;
	private final HideChatHook hook;

	public HookManager(HideChat plugin) {
		this.plugin = plugin;

		var pluginManager = plugin.getServer().getPluginManager();
		HideChatHook foundHook = null;

		for (var hook : Hooks.values()) {
			if (!pluginManager.isPluginEnabled(hook.name)) continue;

			foundHook = hook.getImplementation(plugin);
		}

		this.hook = foundHook;
	}

	public boolean isMuted(Player player) {
		if (this.hook == null) {
			final var user = plugin.getUserManager().getUser(player);
			return user.isMuted();
		}

		return this.hook.isMuted(player);
	}
}