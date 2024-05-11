package io.github.greenmc.hidechat;

import io.github.bilektugrul.butils.BUtilsLib;
import io.github.greenmc.hidechat.commands.Commands;
import io.github.greenmc.hidechat.events.Events;
import io.github.greenmc.hidechat.hook.HookManager;
import io.github.greenmc.hidechat.user.UserManager;
import me.despical.commandframework.CommandFramework;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class HideChat extends JavaPlugin implements Listener {

	private static HideChat instance;

	private UserManager userManager;
	private HookManager hookManager;
	private CommandFramework commandFramework;

	@NotNull
	public static HideChat getInstance() {
		return instance;
	}

	@Override
	public void onEnable() {
		instance = this;
		BUtilsLib.setUsingPlugin(instance);
		getServer().getPluginManager().registerEvents(this, this);

		this.saveDefaultConfig();
		this.userManager = new UserManager();
		this.hookManager = new HookManager(this);
		this.commandFramework = new CommandFramework(this);

		new Commands(this);
		new Events(this);

		final var hook = this.hookManager.getHook();
		final var message = "Initialization finished, " + (hook != null && hook.getName() == null ?
			"no punishment plugin found. Using default provider." : "hooked into %s.".formatted(""));

		getLogger().info(message);

		initializeChatTask();
	}

	private void initializeChatTask() {
		getServer().getScheduler().runTaskTimerAsynchronously(this, () -> {
			for (Player player : getServer().getOnlinePlayers()) {
				Bukkit.broadcastMessage(player.getOpenInventory().getType().name());
			}
		},  0, getConfig().getLong("timer-interval", 1));
	}



	@NotNull
	public UserManager getUserManager() {
		return userManager;
	}

	@NotNull
	public CommandFramework getCommandFramework() {
		return commandFramework;
	}
}