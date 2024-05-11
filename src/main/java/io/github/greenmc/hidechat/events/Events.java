package io.github.greenmc.hidechat.events;

import io.github.greenmc.hidechat.HideChat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public class Events implements Listener {

	private final HideChat plugin;

	public Events(HideChat plugin) {
		this.plugin = plugin;
		this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		plugin.getUserManager().addUser(event.getPlayer());
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		plugin.getUserManager().removeUser(event.getPlayer());
	}

	@EventHandler
	public void onKick(PlayerKickEvent event) {
		plugin.getUserManager().removeUser(event.getPlayer());
	}

}