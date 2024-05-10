package io.github.greenmc.hidechat.hook;

import io.github.greenmc.hidechat.HideChat;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public enum Hooks {

	ESSENTIALS("Essentials"),
	LIBERTY_BANS("LibertyBans"),
	LITE_BANS("LiteBans");

	final String name;

	Hooks(String name) {
		this.name = name;
	}

	public HideChatHook getImplementation(final HideChat plugin) {
		try {
			final var hookClas = Class.forName(name + "Hook");
			return (HideChatHook) hookClas.getDeclaredConstructor(HideChat.class).newInstance(plugin);
		} catch (Exception exception) {
			exception.printStackTrace();
			return null;
		}
	}
}