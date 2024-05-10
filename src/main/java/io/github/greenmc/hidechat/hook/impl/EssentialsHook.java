package io.github.greenmc.hidechat.hook.impl;

import com.earth2me.essentials.Essentials;
import io.github.greenmc.hidechat.HideChat;
import io.github.greenmc.hidechat.hook.HideChatHook;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EssentialsHook extends HideChatHook {

    private final Essentials essentials;

    public EssentialsHook(HideChat plugin) {
        super(plugin);
        this.essentials = JavaPlugin.getPlugin(Essentials.class);
    }

    @Override
    public boolean isMuted(Player player) {
        return essentials.getUser(player).isMuted();
    }

}