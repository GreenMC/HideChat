package io.github.greenmc.hidechat.hook.impl;

import io.github.greenmc.hidechat.HideChat;
import io.github.greenmc.hidechat.hook.HideChatHook;
import litebans.api.Database;
import org.bukkit.entity.Player;
import space.arim.libertybans.api.LibertyBans;
import space.arim.libertybans.api.PlayerOperator;
import space.arim.libertybans.api.PunishmentType;
import space.arim.omnibus.Omnibus;
import space.arim.omnibus.OmnibusProvider;

import java.net.InetAddress;

public class LibertyBansHook extends HideChatHook {

    private final LibertyBans libertyBans;

    public LibertyBansHook(HideChat plugin) {
        super(plugin);
        Omnibus omnibus = OmnibusProvider.getOmnibus();
        this.libertyBans = omnibus.getRegistry().getProvider(LibertyBans.class).orElseThrow();
    }

    @Override
    public boolean isMuted(Player player) {
        return libertyBans.getSelector()
                .selectionByApplicabilityBuilder(player.getUniqueId(), player.getAddress().getAddress())
                .type(PunishmentType.MUTE)
                .build()
                .getFirstSpecificPunishment() != null;
    }

}
