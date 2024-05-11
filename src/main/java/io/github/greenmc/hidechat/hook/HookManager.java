package io.github.greenmc.hidechat.hook;

import io.github.greenmc.hidechat.HideChat;
import io.github.greenmc.hidechat.hook.impl.DefaultHook;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public class HookManager {

	private Hook hook;
	private final Hook defaultHook;

	public HookManager(HideChat plugin) {
		var pluginManager = plugin.getServer().getPluginManager();

		this.defaultHook = new DefaultHook();

		for (var hook : List.of("LiteBans", "Essentials", "LibertyBans")) {
			if (!pluginManager.isPluginEnabled(hook)) continue;

			try {
				this.hook = (Hook) Class.forName(hook + "Hook")
					.getDeclaredConstructor(String.class)
					.newInstance(hook);
				break;
			} catch (Exception ignored) {}
		}
	}

	public boolean isMuted(Player player) {
		return this.hook.isMuted(player) || defaultHook.isMuted(player);
	}

	@Nullable
	public Hook getHook() {
		return hook;
	}
}