package io.github.greenmc.hidechat.hook.impl;

import io.github.greenmc.hidechat.HideChat;
import io.github.greenmc.hidechat.hook.HideChatHook;
import org.bukkit.entity.Player;

public class DefaultHook extends HideChatHook {

    public DefaultHook(HideChat plugin) {
        super(plugin);
    }

    @Override
    public boolean isMuted(Player player) {
        final var user = plugin.getUserManager().getUser(player);
        return user != null && user.isMuted();
    }
}