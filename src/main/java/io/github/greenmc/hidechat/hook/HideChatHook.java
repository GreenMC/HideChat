package io.github.greenmc.hidechat.hook;

import io.github.greenmc.hidechat.HideChat;
import org.bukkit.entity.Player;

public abstract class HideChatHook {

    protected final HideChat plugin;

    public HideChatHook(HideChat plugin) {
        this.plugin = plugin;
    }

    public abstract boolean isMuted(Player player);
}