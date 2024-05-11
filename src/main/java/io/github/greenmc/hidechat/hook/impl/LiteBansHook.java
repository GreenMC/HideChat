package io.github.greenmc.hidechat.hook.impl;

import io.github.greenmc.hidechat.hook.Hook;
import litebans.api.Database;
import org.bukkit.entity.Player;

/**
 * @author Despical
 * <p>
 * Created at 11.05.2024
 */
public class LiteBansHook extends Hook {

	private final Database liteBansDB;

	public LiteBansHook() {
		super("LiteBans");
		this.liteBansDB = Database.get();
	}

	@Override
	public boolean isMuted(Player player) {
		return liteBansDB.isPlayerMuted(player.getUniqueId(), null);
	}
}