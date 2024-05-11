package io.github.greenmc.hidechat.hook.impl;

import io.github.greenmc.hidechat.HideChat;
import io.github.greenmc.hidechat.hook.Hook;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Despical
 * <p>
 * Created at 11.05.2024
 */
public class DefaultHook extends Hook {

	private final HideChat plugin;

	public DefaultHook() {
		super(null);
		this.plugin = JavaPlugin.getPlugin(HideChat.class);
	}

	@Override
	public boolean isMuted(Player player) {
		return plugin.getUserManager().getUser(player).isMuted();
	}
}
