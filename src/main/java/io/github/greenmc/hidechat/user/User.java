package io.github.greenmc.hidechat.user;

import io.github.greenmc.hidechat.HideChat;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public class User {

	private static final HideChat plugin = JavaPlugin.getPlugin(HideChat.class);

	private final UUID uuid;
	private boolean muted;

	public User(UUID uuid) {
		this.uuid = uuid;
	}

	public UUID getUniqueId() {
		return uuid;
	}

	public Player getPlayer() {
		return plugin.getServer().getPlayer(this.uuid);
	}

	public boolean isMuted() {
		return muted;
	}

	public void setMuted(boolean muted) {
		this.muted = muted;
	}
}