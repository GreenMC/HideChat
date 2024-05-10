package io.github.greenmc.hidechat.hook;

import io.github.greenmc.hidechat.HideChat;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public class HookManager {

	private final HideChatHook hook;

	public HookManager(HideChat plugin) {
		var pluginManager = plugin.getServer().getPluginManager();
		var foundHook = HideChatHook.DEFAULT;

		for (var hook : HideChatHook.values()) {
			if (!pluginManager.isPluginEnabled(hook.name)) continue;

			foundHook = hook;
			break;
		}

		this.hook = foundHook;
	}

	public boolean isMuted(Player player) {
		return this.hook.isMuted(player);
	}

	@NotNull
	public HideChatHook getHook() {
		return hook;
	}
}