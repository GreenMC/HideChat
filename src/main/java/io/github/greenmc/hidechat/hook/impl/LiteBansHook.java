package io.github.greenmc.hidechat.hook.impl;

import io.github.greenmc.hidechat.HideChat;
import io.github.greenmc.hidechat.hook.HideChatHook;
import litebans.api.Database;
import org.bukkit.entity.Player;

public class LiteBansHook extends HideChatHook {

    private final Database liteBansDB;

    public LiteBansHook(HideChat plugin) {
        super(plugin);
        this.liteBansDB = Database.get();
    }

    @Override
    public boolean isMuted(Player player) {
        return liteBansDB.isPlayerMuted(player.getUniqueId(), null);
    }

}
