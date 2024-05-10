package io.github.greenmc.hidechat.user;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public class UserManager {

	private final Set<User> users;

	public UserManager() {
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

		return this.users.stream().filter(user -> user.getUniqueId().equals(uuid)).findFirst().orElseGet(() -> {
			final var user = new User(uuid);
			this.users.add(user);
			return user;
		});
	}
}
