package io.github.greenmc.hidechat.hook;

import io.github.greenmc.hidechat.HideChat;
import org.bukkit.entity.Player;

public abstract class HideChatHook {

    public HideChatHook(HideChat plugin) {}

    public abstract boolean isMuted(Player player);

}