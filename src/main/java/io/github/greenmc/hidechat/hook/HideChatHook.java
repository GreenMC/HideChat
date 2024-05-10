package io.github.greenmc.hidechat.hook;

import com.earth2me.essentials.Essentials;
import io.github.greenmc.hidechat.HideChat;
import litebans.api.Database;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import space.arim.libertybans.api.LibertyBans;
import space.arim.libertybans.api.PunishmentType;
import space.arim.omnibus.Omnibus;
import space.arim.omnibus.OmnibusProvider;

/**
 * @author Despical
 * <p>
 * Created at 10.05.2024
 */
public enum HideChatHook {

	ESSENTIALS("Essentials") {

		private final Essentials essentials;

		{
			essentials = JavaPlugin.getPlugin(Essentials.class);
		}

		@Override
		public boolean isMuted(Player player) {
			return essentials.getUser(player).isMuted();
		}
	},

	LIBERTY_BANS("LibertyBans") {

		private final LibertyBans libertyBans;

		{
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
	},

	LITE_BANS("LiteBans") {

		private final Database liteBansDB;

		{
			this.liteBansDB = Database.get();
		}

		@Override
		public boolean isMuted(Player player) {
			return liteBansDB.isPlayerMuted(player.getUniqueId(), null);
		}
	},

	DEFAULT("Default") {

		@Override
		public boolean isMuted(Player player) {
			return HideChat.getInstance().getUserManager().getUser(player).isMuted();
		}
	};

	final String name;

	HideChatHook(String name) {
		this.name = name;
	}

	public abstract boolean isMuted(Player player);

	public String getName() {
		return name;
	}
}