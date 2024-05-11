package io.github.greenmc.hidechat.hook.impl;

import io.github.greenmc.hidechat.hook.Hook;
import org.bukkit.entity.Player;
import space.arim.libertybans.api.LibertyBans;
import space.arim.libertybans.api.PunishmentType;
import space.arim.omnibus.Omnibus;
import space.arim.omnibus.OmnibusProvider;

/**
 * @author Despical
 * <p>
 * Created at 11.05.2024
 */
public class LibertyBansHook extends Hook {

	private final LibertyBans libertyBans;

	public LibertyBansHook() {
		super("LibertyBans");
		final Omnibus omnibus = OmnibusProvider.getOmnibus();
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