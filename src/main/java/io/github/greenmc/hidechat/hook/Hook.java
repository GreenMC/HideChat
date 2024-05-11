package io.github.greenmc.hidechat.hook;

import org.bukkit.entity.Player;

/**
 * @author Despical
 * <p>
 * Created at 11.05.2024
 */
public abstract class Hook {

	protected final String name;

	public Hook(String name) {
		this.name = name;
	}

	public abstract boolean isMuted(Player player);

	public String getName() {
		return name;
	}
}