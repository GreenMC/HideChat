package io.github.greenmc.hidechat.hook.impl;

import com.earth2me.essentials.Essentials;
import io.github.greenmc.hidechat.hook.Hook;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Despical
 * <p>
 * Created at 11.05.2024
 */
public class EssentialsHook extends Hook {

	private final Essentials essentials;

	public EssentialsHook() {
		super("EssentialsX");
		this.essentials = JavaPlugin.getPlugin(Essentials.class);
	}

	@Override
	public boolean isMuted(Player player) {
		return essentials.getUser(player).isMuted();
	}
}