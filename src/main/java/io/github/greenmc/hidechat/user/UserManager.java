package io.github.greenmc.hidechat.user;

import io.github.greenmc.hidechat.HideChat;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public class UserManager {

	private final HideChat plugin;
	private final Set<User> users;

	public UserManager(HideChat plugin) {
		this.plugin = plugin;
		this.users = new HashSet<>();

	}

	public void addUser(Player player) {
		this.users.add(new User(player.getUniqueId()));
	}

	public void removeUser(Player player) {
		this.users.remove(this.getUser(player));
	}

	public User getUser(Player player) {
		var uuid = player.getUniqueId();
		return this.users.stream().filter(user -> user.getUniqueId().equals(uuid)).findFirst().orElse(null);
	}
}
